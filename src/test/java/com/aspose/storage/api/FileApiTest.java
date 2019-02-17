/**
 * --------------------------------------------------------------------------------------------------------------------
 * <copyright company="Aspose" file="FileApiTest.java">
 *  Copyright (c) 2018 Aspose.HTML for Cloud
 * </copyright>
 * <summary>
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
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


package com.aspose.storage.api;

import com.aspose.html.client.ApiException;
import com.aspose.html.client.Configuration;

import static java.lang.System.out;
import static org.junit.Assert.*;

import java.io.File;

import com.aspose.storage.model.FileExistResponse;
import com.aspose.storage.model.MoveFileResponse;
import com.aspose.storage.model.RemoveFileResponse;
import org.junit.Test;

/**
 * API tests for FileApi
 */
//@Ignore
public class FileApiTest {

    private final StorageApi api = new StorageApi();
	private static String localFolder = Configuration.getStorage();  

    
    /**
     * Remove a specific file 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
//    @Ignore
    @Test
    public void DeleteFileTest() throws ApiException {

    	String name = "test_en.html";
    	String folder = "HtmlDocTest";
    	String path = folder + "/" + name;
        String versionId = null;
        String storage = null;
        
    	File f = new File(Configuration.getTestDataDir(), name);
    	if(!f.exists())
    		out.println("Local file not found");
    	
    	// Put document to storage
    	api.PutCreate(path, f, versionId, storage);

        FileExistResponse exist = api.GetIsExist(path, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertTrue(exist.getFileExist().getIsExist());
        assertFalse(exist.getFileExist().getIsFolder());

    	
        RemoveFileResponse response = api.DeleteFile(path, versionId, storage);
        assertEquals(response.getCode(), 200);
        assertEquals(response.getStatus(), "OK");

        exist = api.GetIsExist(path, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertFalse(exist.getFileExist().getIsExist());
        assertFalse(exist.getFileExist().getIsFolder());
    }
    
    /**
     * Download a specific file 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
//    @Ignore
    @Test
    public void GetDownloadTest() throws ApiException {
    	String name = "test_ocr.jpg";
    	String folder = "HtmlDocTest";
    	String path = folder + "/" + name;
        String versionId = null;
        String storage = null;
        
    	File f = new File(Configuration.getTestDataDir(), name);
    	if(!f.exists())
    		out.println("Local file not found");
    	
    	long size = f.length();
    	// Put document to storage
    	api.PutCreate(path, f, versionId, storage);

        File response = api.GetDownload(path, versionId, storage);
        assertTrue(response.exists());
        assertEquals(size,response.length());
        
		//Save to test directory
		File copyFile = new File(localFolder + "DownloadFile.jpg");
		response.renameTo(copyFile);
    }
    
    /**
     * Move a specific file 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
//    @Ignore
    @Test
    public void PostMoveFileTest() throws ApiException {
    	String name = "move_file.html";
    	String name1 = "moved_file.html";
    	String folder = "HtmlDocTest";
    	String src = folder + "/" + name;
        String dest = folder + "/" + name1;
        String versionId = null;
        String storage = null;
        String destStorage = null;
        
    	File f = new File(Configuration.getTestDataDir(), name);
    	if(!f.exists())
    		out.println("Local file not found");
    	
    	// Put test_move_file.html to storage
    	api.PutCreate(src, f, versionId, storage);

    	//Ensure file exist
        FileExistResponse exist = api.GetIsExist(src, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertTrue(exist.getFileExist().getIsExist());
        assertFalse(exist.getFileExist().getIsFolder());
    	
    	//Ensure file not exist
        exist = api.GetIsExist(dest, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertFalse(exist.getFileExist().getIsExist());
        assertFalse(exist.getFileExist().getIsFolder());
        
        //Moving file
        MoveFileResponse response = api.PostMoveFile(src, dest, versionId, storage, destStorage);
        assertEquals(response.getCode(), 200);
        assertEquals(response.getStatus(), "OK");

    	//Ensure file exist
        exist = api.GetIsExist(dest, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertTrue(exist.getFileExist().getIsExist());
        assertFalse(exist.getFileExist().getIsFolder());
    	
    	//Ensure file not exist
        exist = api.GetIsExist(src, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertFalse(exist.getFileExist().getIsExist());
        assertFalse(exist.getFileExist().getIsFolder());
        
        //Clear moved file
        RemoveFileResponse resp = api.DeleteFile(dest, versionId, storage);
        assertEquals(resp.getCode(), 200);
        assertEquals(resp.getStatus(), "OK");

        exist = api.GetIsExist(dest, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertFalse(exist.getFileExist().getIsExist());
        assertFalse(exist.getFileExist().getIsFolder());
    }
    
    /**
     * Upload a specific file 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
//    @Ignore
    @Test
    public void PutCreateTest() throws ApiException {
    	String name = "test_for_create.html";
    	String folder = "HtmlDocTest";
    	String path = folder + "/" + name;
        String versionId = null;
        String storage = null;

    	File f = new File(Configuration.getTestDataDir(), name);
    	if(!f.exists())
    		out.println("Local file not found");
    	
    	//Ensure file not exist
    	FileExistResponse exist = api.GetIsExist(path, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertFalse(exist.getFileExist().getIsExist());
        assertFalse(exist.getFileExist().getIsFolder());
    	
    	// Put file to storage
    	api.PutCreate(path, f, versionId, storage);

    	//Ensure file exist
        exist = api.GetIsExist(path, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertTrue(exist.getFileExist().getIsExist());
        assertFalse(exist.getFileExist().getIsFolder());
        
        //Clear test file
        RemoveFileResponse resp = api.DeleteFile(path, versionId, storage);
        assertEquals(resp.getCode(), 200);
        assertEquals(resp.getStatus(), "OK");

        exist = api.GetIsExist(path, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertFalse(exist.getFileExist().getIsExist());
        assertFalse(exist.getFileExist().getIsFolder());
    }
}
