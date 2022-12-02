/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="HtmlApi.java">
*   Copyright (c) 2022 Aspose.HTML for Cloud
* </copyright>
* <summary>
*   Permission is hereby granted, free of charge, to any person obtaining a copy
*  of this software and associated documentation files (the "Software"), to deal
*  in the Software without restriction, including without limitation the rights
*  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
*  copies of the Software, and to permit persons to whom the Software is
*  furnished to do so, subject to the following conditions:
*
*  The above copyright notice and this permission notice shall be included in all
*  copies or substantial portions of the Software.
*
*  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
*  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
*  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
*  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
*  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
*  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
*  SOFTWARE.
* </summary>
* --------------------------------------------------------------------------------------------------------------------
*/


package com.aspose.html;

import com.aspose.html.api.ConversionApi;
import com.aspose.html.api.StorageApi;
import com.aspose.html.model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class HtmlApi {

    private ConversionApi conversionApi;
    private StorageApi storageApi;
    private String tempSource = null;
    private String tempTarget = null;
    private boolean clearSourceFile = false;
    private boolean clearTargetFile = false;
    private final String tempDir = "temp/";

    /**
     * .ctor HtmlApi. Registering key and SID for access to the cloud API.
     *
     * @param apiKey API key (see Readme.md file). (required)
     * @param apiSID API SID (see Readme.md file). (required)
     */

    public HtmlApi(String apiKey, String apiSID){
        Configuration.setAPI_KEY(apiKey);
        Configuration.setAPP_SID(apiSID);
        storageApi = new ApiClient().createService(StorageApi.class);
        conversionApi = new ApiClient().createService(ConversionApi.class);
    }

    
    /**
     * Starting a conversion task according to parameters in the ConversionBuilder.
     *
     * @param builder ConversionBuilder with conversion parameters. (required)
     * @return Call	&lt;OperationResult&gt;
     */
    public OperationResult convert(JobBuilder builder)
    {
        //Check parameters
        if(builder.source.inputFormat == null) {
            throw new IllegalArgumentException("The input format is absent");
        }

        if(builder.target.outputFormat == null) {
            throw new IllegalArgumentException("The output format is absent");
        }

        if(builder.source.filePath == null || builder.source.filePath.isEmpty()) {
            throw new IllegalArgumentException("The input file is absent");
        }

        if(builder.target.filePath == null || builder.target.filePath.isEmpty()) {
            throw new IllegalArgumentException("The output format is absent");
        }

        JobRequest req = new JobRequest();

        if(builder.source.isLocal != null && builder.source.isLocal) {
            File file = new File(builder.source.filePath);
            this.tempSource = this.tempDir + file.getName();
            boolean res = uploadFile(file, this.tempDir);

            if (!res) {
                throw new RuntimeException("Unable to upload the file to the storage");
            }

            req.setInputPath(this.tempSource);
            this.clearSourceFile = true;

        } else {
            req.setInputPath(builder.source.filePath);
            if(builder.source.storageName != null && !builder.source.storageName.isEmpty()) {
                req.setStorageName(builder.source.storageName);
            }
        }

        if(builder.source.resources != null && !builder.source.resources.isEmpty()) {
            req.setResources(builder.source.resources);
        }

        if(builder.options != null){
            req.setOptions(builder.options);
        }

        if(builder.target.isLocal) {
            File f = new File(builder.target.filePath);
            this.tempTarget = this.tempDir + f.getName();
            this.clearTargetFile = true;
            req.setOutputFile(this.tempTarget);
        } else {
            req.setOutputFile(builder.target.filePath);
        }

        Call<OperationResult> call_convert = conversionApi.convert(
                req,
                builder.source.inputFormat.toString(),
                builder.target.outputFormat.toString());

       Response<OperationResult> result = null;

        try {
            result = call_convert.execute();
        } catch (IOException e) {
            throw new RuntimeException("Unable to convert");
        }

        // Wait for result
        OperationResult resp = WaitForResult(result.body().id);

        if(resp == null || !resp.status.equals("completed")) {
            throw new RuntimeException("Conversion failed");
        }

        // Getting a result if save locally
        if(builder.target.isLocal == true) {
            String file = resp.getFile();
            String target = Paths.get(builder.target.filePath).getParent().toString()
                    + "/" + Paths.get(file).getFileName().toString();
            boolean res = downloadFile(file, target, builder.source.storageName);
            resp.setFile(target);
            if (!res) {
                throw new RuntimeException("Unable to get result");
            }
        }

        // Clear storage
        if(this.clearSourceFile) {
            Call<ResponseBody> call_delete = storageApi.deleteFile(this.tempSource, builder.source.storageName, null);
            try {
                Response<ResponseBody> res_del = call_delete.execute();
                this.clearSourceFile = false;
                this.tempSource = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(this.clearTargetFile) {
            Call<ResponseBody> call_delete = storageApi.deleteFile(this.tempTarget, builder.target.storageName, null);
            try {
                Response<ResponseBody> res_del = call_delete.execute();
                this.clearTargetFile = false;
                this.tempTarget = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return resp;
    }

    public OperationResult vectorize(JobBuilder builder)
    {
        if(builder.source.inputFormat == null || !isImage(builder.source.inputFormat)) {
            throw new IllegalArgumentException("The input file must be image");
        }

        if(builder.target.outputFormat == null || builder.target.outputFormat != OutputFormats.SVG) {
            throw new IllegalArgumentException("The output file must be SVG");
        }
        return convert(builder);
    }

    private boolean uploadFile(File file, String targetPath) {
        return uploadFile(file, targetPath, null);
    }

    private boolean uploadFile(File file, String targetPath, String storageName) {
        if(file.exists() && file.isFile()) {

            // Upload file to storage
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
            Call<FilesUploadResult> call_create = storageApi.uploadFile(fileToUpload, targetPath, storageName);

            try {
                Response<FilesUploadResult> res = call_create.execute();
            } catch (IOException ex) {
                return false;
                //throw new RuntimeException("Unable to upload the file to the storage");
            }
        } else {
            return  false;
            //throw new IllegalArgumentException("Source file is not exist");
        }
        return true;
    }

    private boolean downloadFile(String sourcePath, String targetPath, String storageName) {
        return downloadFile(sourcePath, targetPath, storageName, null);
    }

    private boolean downloadFile(String sourcePath, String targetPath, String storageName, String versionId) {

        Call<ResponseBody>
        call_download = storageApi.downloadFile(sourcePath, storageName, versionId);

        Response<ResponseBody> res_download = null;
        try {
            res_download = call_download.execute();
        } catch (IOException e) {
            return false;
            //throw new RuntimeException("Unable to get result");
        }

        ResponseBody body = res_download.body();
        File savedFile = new File(targetPath);

        try (InputStream inputStream = body.byteStream();
             OutputStream outputStream = new FileOutputStream(savedFile))
        {
            byte[] fileReader = new byte[4096];

            while (true) {
                int read = inputStream.read(fileReader);
                if (read == -1) break;

                outputStream.write(fileReader, 0, read);
            }
            outputStream.flush();
        } catch (Exception e) {
            return false;
            //throw new RuntimeException("Unable save file");
        }

        return true;
    }

    private OperationResult WaitForResult(String id) {
        try {
            for(;;) {
                Call<OperationResult> call = conversionApi.getConversionStatus(id);
                Response<OperationResult> res = call.execute();
                OperationResult result = res.body();
                if( result.code != 200
                    || result.status.equals("faulted")
                    || result.status.equals("canceled")
                    || result.status.equals("completed")) {
                    return result;
                }

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        } catch (IOException e) {
            return null;
        }
    }

    private boolean isImage(InputFormats format) {
        return format == InputFormats.BMP
                || format == InputFormats.GIF
                || format == InputFormats.JPEG
                || format == InputFormats.PNG
                || format == InputFormats.TIFF;
    }
}
