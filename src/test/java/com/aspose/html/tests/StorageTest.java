/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="StorageTest.java">
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
package com.aspose.html.tests;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.aspose.html.ApiClient;
import com.aspose.html.Configuration;
import com.aspose.html.api.StorageApi;
import com.aspose.html.model.DiscUsage;
import com.aspose.html.model.FileVersions;
import com.aspose.html.model.FilesList;
import com.aspose.html.model.FilesUploadResult;
import com.aspose.html.model.ObjectExist;
import com.aspose.html.model.StorageExist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import retrofit2.Call;
import retrofit2.Response;
import java.io.File;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class StorageTest extends BaseTest{

    public static StorageApi storageApi;

    public StorageTest(){
        storageApi = new ApiClient().createService(StorageApi.class);
    }

    //File API

    @Test
    public void uploadFile() {
        try {
            // Upload test file
            File f = new File(Configuration.getTestSrcDir(), "test.txt");
            RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), f);
            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", f.getName(), requestBody);

            Call<FilesUploadResult> call_create = storageApi.uploadFile(fileToUpload,"HtmlTestDoc", null);

            Response<FilesUploadResult> res = call_create.execute();
            Assertions.assertTrue(res.isSuccessful());

            FilesUploadResult result = res.body();
            // One file uploaded
            Assertions.assertEquals(1, result.getUploaded().size());
            // Error is zero
            Assertions.assertEquals(0, result.getErrors().size());

            // Check exists
            Call<ObjectExist> call_exist = storageApi.objectExists("HtmlTestDoc/test.txt",
                    null, null);

            Response<ObjectExist> res_exist = call_exist.execute();
            Assertions.assertTrue(res_exist.isSuccessful());

            ObjectExist res_exist_body = res_exist.body();
            Assertions.assertTrue(res_exist_body.isExists(), "File not exist");
            Assertions.assertFalse(res_exist_body.isFolder(), "Error, must be file, not folder" );

            Call<Void> call_response = storageApi.deleteFolder("HtmlTestDoc", null, true);

            Response<Void> res1 = call_response.execute();
            Assertions.assertTrue(res.isSuccessful());

            //Ensure is folder deleted
            call_exist = storageApi.objectExists("HtmlTestDoc",null, null);

            res_exist = call_exist.execute();
            Assertions.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assertions.assertFalse(res_exist_body.isExists(), "Error, must be not exist new folder after delete");
            Assertions.assertFalse(res_exist_body.isFolder(), "Error, must be false after delete" );
        } catch (Exception ex) {
            ex.printStackTrace();
            Assertions.fail();
        }

    }

    @Test
    public void downloadFile(){

        try {
            // Upload test file
            File f = new File(Configuration.getTestSrcDir(), "testDownload.jpg");
            RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), f);
            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", f.getName(), requestBody);

            Call<FilesUploadResult> call_create = storageApi.uploadFile(fileToUpload,"HtmlTestDoc", null);

            Response<FilesUploadResult> res = call_create.execute();
            Assertions.assertTrue(res.isSuccessful());

            FilesUploadResult result = res.body();
            Assertions.assertEquals(1, result.getUploaded().size());
            Assertions.assertEquals(0, result.getErrors().size());

            Call<ResponseBody> call_download = storageApi.downloadFile("HtmlTestDoc/testDownload.jpg", null, null);

            Response<ResponseBody> res1 = call_download.execute();
            Assertions.assertTrue(res1.isSuccessful());

            ResponseBody res_download = res1.body();
            Assertions.assertTrue(TestHelper.saveToDisc(res_download,"TestDownloadResult.jpg"));
        } catch (Exception ex) {
            ex.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void deleteFile(){

        try {
            String fileName = "test_delete.txt";
            //Create test file
            File f = new File(Configuration.getTestSrcDir(), fileName);
            RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), f);
            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", f.getName(), requestBody);

            Call<FilesUploadResult> call_create = storageApi.uploadFile(fileToUpload, "HtmlTestDoc",null);

            Response<FilesUploadResult> res = call_create.execute();
            Assertions.assertTrue(res.isSuccessful());

            FilesUploadResult result = res.body();
            Assertions.assertEquals(1, result.getUploaded().size());
            Assertions.assertEquals(0, result.getErrors().size());

            // Check if the file exists
            Call<ObjectExist> call = storageApi.objectExists("HtmlTestDoc/" + fileName,
                    null, null);

            Response<ObjectExist> res_exist = call.execute();
            Assertions.assertTrue(res_exist.isSuccessful());

            ObjectExist res_exist_body = res_exist.body();
            Assertions.assertTrue(res_exist_body.isExists(),"Error, must be exist, not exist");
            Assertions.assertFalse( res_exist_body.isFolder(),"Error, must be file, not folder");

            //Delete file
            Call<ResponseBody> call_response = storageApi.deleteFile("HtmlTestDoc/test_delete_file.txt", null,null);

            Response<ResponseBody> res2 = call_response.execute();
            Assertions.assertTrue(res2.isSuccessful());

            // Check if the file not exists
            call = storageApi.objectExists("HtmlTestDoc/test_delete_file.txt",
                    null, null);

            res_exist = call.execute();
            Assertions.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assertions.assertFalse(res_exist_body.isExists(),"Error, file exist after delete");
            Assertions.assertFalse( res_exist_body.isFolder(),"Error, must be false, file not exist");
        } catch (Exception ex) {
            ex.printStackTrace();
            Assertions.fail();
        }
    }

    //Folder API
    @Test
    public void getFilesList(){

        try {
            Call<FilesList> call = storageApi.getFilesList("HtmlTestDoc", null);
            Response<FilesList> res = call.execute();
            Assertions.assertTrue(res.isSuccessful());

            FilesList response = res.body();
            Assertions.assertTrue(TestHelper.saveToDisc(response.toString(),"FileList.json"));

        } catch (Exception ex) {
            ex.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void createFolder(){

        try {
            String folderName = "CreateTestFolder";
            Call<Void> call = storageApi.createFolder(folderName,null);

            Response<Void> res = call.execute();
            Assertions.assertTrue(res.isSuccessful());

            // Check is folder exist
            Call<ObjectExist> call_exist = storageApi.objectExists(folderName,
                    null, null);

            Response<ObjectExist> res_exist = call_exist.execute();
            Assertions.assertTrue(res_exist.isSuccessful());

            ObjectExist res_exist_body = res_exist.body();
            Assertions.assertTrue(res_exist_body.isExists(),"Error, must be exist folder after creating");
            Assertions.assertTrue( res_exist_body.isFolder(),"Error, must be folder, not folder");

            //Delete test folder
            Call<Void> call_response = storageApi.deleteFolder(folderName, null, false);
            Response<Void> res1 = call_response.execute();
            Assertions.assertTrue(res1.isSuccessful());

            //Check deleted folder
            call_exist = storageApi.objectExists(folderName,null, null);

            res_exist = call_exist.execute();
            Assertions.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assertions.assertFalse( res_exist_body.isExists(),"Error, must be  not exist folder after deleting");
            Assertions.assertFalse( res_exist_body.isFolder(),"Error, must be false after deleting folder");
        } catch (Exception ex) {
            ex.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void deleteFolder(){

        try {

            String folderName = "TestDeleteFolder";

            //Create remote folder
            Call<Void> call_create = storageApi.createFolder(folderName,null);

            Response<Void> res = call_create.execute();
            Assertions.assertTrue(res.isSuccessful());

            //Ensure is folder exist
            Call<ObjectExist> call_exist = storageApi.objectExists(folderName,
                    null, null);

            Response<ObjectExist> res_exist = call_exist.execute();
            Assertions.assertTrue(res_exist.isSuccessful());

            ObjectExist res_exist_body = res_exist.body();
            Assertions.assertTrue(res_exist_body.isExists(),"Error, must be exist new folder after create");
            Assertions.assertTrue(res_exist_body.isFolder(),"Error, must be folder after create");

            Call<Void> call_response = storageApi.deleteFolder(folderName, null, true);

            Response<Void> res1 = call_response.execute();
            Assertions.assertTrue(res1.isSuccessful());

            //Ensure is folder deleted
            call_exist = storageApi.objectExists(folderName,null, null);

            res_exist = call_exist.execute();
            Assertions.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assertions.assertFalse(res_exist_body.isExists(),"Error, must be not exist new folder after delete");
            Assertions.assertFalse(res_exist_body.isFolder(), "Error, must be false after delete");
        } catch (Exception ex) {
            ex.printStackTrace();
            Assertions.fail();
        }
    }

    //Storage API    
    @Test
    public void storageExists(){

        String storageNotExist = "NotExistStorage";

        try {
            Call<StorageExist> call = storageApi.storageExists(storageNotExist);
            Response<StorageExist> res = call.execute();
            Assertions.assertTrue(res.isSuccessful());

            StorageExist result = res.body();
            Assertions.assertFalse(result.isExists(),"Storage doesn't exist, but result is exist");

            //ToDo: Storage not defined
//            call = storageApi.storageExists(storageExist);
//            res = call.execute();
//            assertTrue(res.isSuccessful());

//            result = res.body();
//            assertTrue("Storage exist, but result is not exist", result.isExists());
        } catch (Exception ex) {
            ex.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void objectExists(){

        String existFile = "HtmlTestDoc/test.txt";
        String notExistFile = "HtmlTestDoc/fake.txt";
        String existFolder = "HtmlTestDoc";
        String notExistFolder = "FakeFolder";

        try {
            // Upload file
            File f = new File(Configuration.getTestSrcDir(), "test.txt");
            RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), f);
            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", f.getName(), requestBody);
            Call<FilesUploadResult> call_upload = storageApi.uploadFile(fileToUpload,"HtmlTestDoc", null);

            Response<FilesUploadResult> res = call_upload.execute();

            Assertions.assertTrue(res.isSuccessful());

            FilesUploadResult result = res.body();

            Assertions.assertEquals(1, result.getUploaded().size());
            Assertions.assertEquals(0, result.getErrors().size());

            // Exist file
            Call<ObjectExist> call = storageApi.objectExists(existFile, null, null);

            Response<ObjectExist> res_exist = call.execute();
            Assertions.assertTrue(res_exist.isSuccessful());

            ObjectExist res_exist_body = res_exist.body();
            Assertions.assertTrue(res_exist_body.isExists(), "Error, must be exist");
            Assertions.assertFalse(res_exist_body.isFolder(), "Error, must be file, not folder");

            // Not exist file
            call = storageApi.objectExists(notExistFile, null, null);

            res_exist = call.execute();
            Assertions.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assertions.assertFalse(res_exist_body.isExists(), "Error, must be not exist");
            Assertions.assertFalse(res_exist_body.isFolder(),"Error, must be false for not exist file");

            // Exist folder
            call = storageApi.objectExists(existFolder, null, null);

            res_exist = call.execute();
            Assertions.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assertions.assertTrue(res_exist_body.isExists(), "Error, must be exist");
            Assertions.assertTrue(res_exist_body.isFolder(),"Error, must be folder");

            // Not exist folder
            call = storageApi.objectExists(notExistFolder, null, null);

            res_exist = call.execute();
            Assertions.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assertions.assertFalse(res_exist_body.isExists(),"Error, must be not exist");
            Assertions.assertFalse(res_exist_body.isFolder(),"Error, must be false for not exist folder");

            // Delete test file
            Call<ResponseBody> call_response = storageApi.deleteFile("HtmlTestDoc/test.txt", null,null);

            Response<ResponseBody> res2 = call_response.execute();
            Assertions.assertTrue(res2.isSuccessful());
        } catch (Exception ex) {
            ex.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void getDiscUsage(){

        try {
            Call<DiscUsage> call = storageApi.getDiscUsage(null);

            Response<DiscUsage> res = call.execute();
            Assertions.assertTrue(res.isSuccessful());

            DiscUsage result = res.body();

            Assertions.assertTrue(result.getUsedSize() > 0);
            Assertions.assertTrue(result.getTotalSize() > 0);

        } catch (Exception ex) {
            ex.printStackTrace();
            Assertions.fail();
        }
    }

}
