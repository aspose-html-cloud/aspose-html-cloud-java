/**
 * --------------------------------------------------------------------------------------------------------------------
 * <copyright company="Aspose" file="FolderApiTest.java">
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

import static org.junit.Assert.*;

import java.io.File;

import com.aspose.storage.model.FileExistResponse;
import com.aspose.storage.model.MoveFolderResponse;
import com.aspose.storage.model.RemoveFolderResponse;
import com.aspose.storage.model.ResponseMessage;
import org.junit.Test;

/**
 * API tests for FolderApi
 */
//@Ignore
public class FolderApiTest {

    private final StorageApi api = new StorageApi();
	private static String localFolder = Configuration.getStorage();  

    /**
     * Create the folder 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void PutCreateFolderTest() throws ApiException {
        String path = "HtmlTestDoc/TestFolderr";
        String storage = null;
        String destStorage = null;
        Boolean recursive = true;

        // Create folder
        ResponseMessage response = api.PutCreateFolder(path, storage, destStorage);
        assertEquals(response.getCode(), 200);
        assertEquals(response.getStatus(), "OK");

        // Clear folder
        RemoveFolderResponse resp = api.DeleteFolder(path, storage, recursive);
        assertEquals(resp.getCode(), 200);
        assertEquals(resp.getStatus(), "OK");
    }
    
    /**
     * Remove a specific folder 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void DeleteFolderTest() throws ApiException {
        String path = "HtmlTestDoc/TestFolder";
        String storage = null;
        String destStorage = null;
        Boolean recursive = true;
        String versionId = null;

        // Create folder for test
        ResponseMessage response = api.PutCreateFolder(path, storage, destStorage);
        assertEquals(response.getCode(), 200);
        assertEquals(response.getStatus(), "OK");

        // Delete folder
        RemoveFolderResponse resp = api.DeleteFolder(path, storage, recursive);
        assertEquals(resp.getCode(), 200);
        assertEquals(resp.getStatus(), "OK");

        // Ensure folder not exist
        FileExistResponse exist = api.GetIsExist(path, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertFalse(exist.getFileExist().getIsExist());
        assertFalse(exist.getFileExist().getIsFolder());

    }
    
    /**
     * Move a specific folder 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
//    @Ignore
    @Test
    public void PostMoveFolderTest() throws ApiException {
        String src = "HtmlTestDoc/MoveFolder";
        String dest = "HtmlTestDoc/MovingFolder";
        String storage = null;
        String destStorage = null;
        Boolean recursive = true;
        String versionId = null;

        // Ensure source folder not exist
        FileExistResponse exist = api.GetIsExist(src, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertFalse(exist.getFileExist().getIsExist());
        assertFalse(exist.getFileExist().getIsFolder());

        // Ensure destination folder not exist
        exist = api.GetIsExist(src, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertFalse(exist.getFileExist().getIsExist());
        assertFalse(exist.getFileExist().getIsFolder());

        // Create folder for test
        ResponseMessage response = api.PutCreateFolder(src, storage, destStorage);
        assertEquals(response.getCode(), 200);
        assertEquals(response.getStatus(), "OK");

        // Ensure source folder exist
        exist = api.GetIsExist(src, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertTrue(exist.getFileExist().getIsExist());
        assertTrue(exist.getFileExist().getIsFolder());

        
    	//Move folder
        MoveFolderResponse resp = api.PostMoveFolder(src, dest, storage, destStorage);
        assertEquals(resp.getCode(), 200);
        assertEquals(resp.getStatus(), "OK");
 
        // Ensure source folder not exist
        exist = api.GetIsExist(src, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertFalse(exist.getFileExist().getIsExist());
        assertFalse(exist.getFileExist().getIsFolder());

        // Ensure destination folder exist
        exist = api.GetIsExist(dest, versionId, storage);
        assertEquals(exist.getCode(), 200);
        assertEquals(exist.getStatus(), "OK");
        assertTrue(exist.getFileExist().getIsExist());
        assertTrue(exist.getFileExist().getIsFolder());

        // Clear destination folder
        RemoveFolderResponse del = api.DeleteFolder(dest, storage, recursive);
        assertEquals(del.getCode(), 200);
        assertEquals(del.getStatus(), "OK");
        

    }
    
    /**
     * Get the file listing of a specific folder 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
//    @Ignore
    @Test
    public void GetListFilesTest() throws ApiException {
        String path = "HtmlTestDoc";
        String storage = null;

        File response = api.GetListFiles(path, storage);
        assertTrue(response.exists());
        
		//Save to test directory
		File copyFile = new File(localFolder + "FileList.json");
		response.renameTo(copyFile);
    }
}
