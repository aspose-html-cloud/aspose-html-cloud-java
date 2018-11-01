/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="SummarizationApiTest.java">
*   Copyright (c) 2018 Aspose.HTML for Cloud
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

import com.aspose.html.api.SummarizationApi;
import com.aspose.html.client.ApiException;
import com.aspose.html.client.Configuration;
import com.aspose.storage.api.StorageApi;
import com.aspose.storage.model.FileExistResponse;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;
import org.junit.Ignore;

/**
 * API tests for SummarizationApi
 */
//@Ignore
public class SummarizationApiTest {

    private final SummarizationApi api = new SummarizationApi();
	private static String localFolder = Configuration.getStorage();
	private static StorageApi storageApi = new StorageApi();
    
    /**
     * Get the HTML document keywords using the keyword detection service.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void GetDetectHtmlKeywordsTest() throws ApiException {
        String name = "test_en.html";
        String folder = "HtmlTestDoc";
        String storage = null;

    	File f = new File(Configuration.getTestDataDir(), name);
    	if(!f.exists())
    		out.println("Local file not found");
    	
    	// Put document to storage
    	storageApi.PutCreate(folder + "/" + name, f, null, null);
    	
    	FileExistResponse res  = storageApi.GetIsExist(folder + "/" + name, null, null);
    	assertEquals(res.getCode(), 200);

    	try {
            File answer = api.GetDetectHtmlKeywords(name, folder, storage);

    		//Save to test directory
    		File copyFile = new File(localFolder + "KeywordUrl.json");
    		answer.renameTo(copyFile);
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    /**
     * Get the keywords from HTML document from Web specified by its URL using the keyword detection service
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void GetDetectHtmlKeywordsByUrlTest() throws ApiException {
        String sourceUrl = "https://www.le.ac.uk/oerresources/bdra/html/page_01.htm";
    
        try {
	        File answer = api.GetDetectHtmlKeywordsByUrl(sourceUrl);
	
	        assertTrue(answer.exists());
	        
			//Save to test directory
			File copyFile = new File(localFolder + "KeywordUrl.json");
			answer.renameTo(copyFile);
        } catch(Exception e) {
        	e.printStackTrace();
        	fail();
        }
    }
    
}
