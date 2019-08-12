/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="TestHelper.java">
*   Copyright (c) 2019 Aspose.HTML for Cloud
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

package com.aspose.html.api;

import com.aspose.html.ApiClient;
import com.aspose.html.Configuration;
import com.aspose.storage.api.StorageApi;
import com.aspose.storage.model.FilesUploadResult;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Response;
import java.io.*;
import static org.junit.Assert.assertTrue;

public class TestHelper {

    private static StorageApi storageApi = new ApiClient().createService(StorageApi.class);;

    public static void checkAndSave(Call<ResponseBody> call, String fileName) throws IOException {

        Response<ResponseBody> res = call.execute();
        assertTrue(res.isSuccessful());

        ResponseBody answer = res.body();

        //Save to test directory
        boolean result = TestHelper.saveToDisc(answer, fileName);
        assertTrue(result);
    }

    public static boolean saveToDisc(ResponseBody body, String fileName) {

        File savedFile = new File(Configuration.getTestDstDir() + File.separator + fileName);

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
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean uploadFile(String fileName)  throws IOException {
        return uploadFile(fileName,"");
    }

    public static boolean uploadFile(String fileName, String uploadFolder)  throws IOException {

        File f = new File(Configuration.getTestSrcDir(), fileName);

        if(!f.exists()) {
            System.out.println("file not found");
            throw new RuntimeException("Test file not found");
        }

        RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), f);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", f.getName(), requestBody);

        // Put document to storage
        Call<FilesUploadResult> call = storageApi.uploadFile(uploadFolder + File.separator + fileName, fileToUpload, null);

        Response<FilesUploadResult> res = call.execute();

        assertTrue(res.isSuccessful());

        return true;
    }
}
