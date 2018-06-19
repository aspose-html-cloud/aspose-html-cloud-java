/**
 * --------------------------------------------------------------------------------------------------------------------
 * <copyright company="Aspose" file="StorageApiTest.java">
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
import com.aspose.storage.model.DiscUsageResponse;
import com.aspose.storage.model.FileExistResponse;
import com.aspose.storage.model.FileVersion;
import com.aspose.storage.model.FileVersionsResponse;
import com.aspose.storage.model.StorageExistResponse;
import org.junit.Test;

import static java.lang.System.out;
import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Ignore;

/**
 * API tests for StorageApi
 */
//@Ignore
public class StorageApiTest {

    private final StorageApi api = new StorageApi();

    
    /**
     * Check the disk usage of the current account 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void GetDiscUsageTest() throws ApiException {
        String storage = null;
        DiscUsageResponse response = api.GetDiscUsage(storage);
        assertEquals(response.getCode(), 200);
        assertEquals(response.getStatus(), "OK");
        assertTrue(response.getDiscUsage().getUsedSize()>0);
        assertTrue(response.getDiscUsage().getTotalSize()>0);
    }
    
    /**
     * Check if a specific file or folder exists
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void GetIsExistTest() throws ApiException {
        String path = "HtmlTestDoc";
        String versionId = null;
        String storage = null;
        FileExistResponse response = api.GetIsExist(path, versionId, storage);
        assertEquals(response.getCode(), 200);
        assertEquals(response.getStatus(), "OK");
        assertTrue(response.getFileExist().getIsExist());
        assertTrue(response.getFileExist().getIsFolder());

        path = "Non_Exist_Folder";
        response = api.GetIsExist(path, versionId, storage);
        assertEquals(response.getCode(), 200);
        assertEquals(response.getStatus(), "OK");
        assertFalse(response.getFileExist().getIsExist());
        assertFalse(response.getFileExist().getIsFolder());
    }
    
    /**
     * Check if storage exists 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void GetIsStorageExistTest() throws ApiException {
        String name = "/";
        StorageExistResponse response = api.GetIsStorageExist(name);
        assertEquals(response.getCode(), 200);
        assertEquals(response.getStatus(), "OK");
        assertTrue(response.getIsExist());
        
        name = "Non_Exist_Storage";
        response = api.GetIsStorageExist(name);
        assertEquals(response.getCode(), 200);
        assertEquals(response.getStatus(), "OK");
        assertFalse(response.getIsExist());
    }
    
    /**
     * Get the file&#39;s versions list 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void GetListFileVersionsTest() throws ApiException {
        
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
    	api.PutCreate(path, f, versionId, storage);
    
    	
        FileVersionsResponse response = api.GetListFileVersions(path, storage);
        assertEquals(response.getCode(), 200);
        assertEquals(response.getStatus(), "OK");
        
        List<FileVersion> list = response.getFileVersions();
        for(FileVersion fv : list)
        	out.println(fv);
        
    }
}
