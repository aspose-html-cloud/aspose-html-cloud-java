/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="TemplateMergeApiTest.java">
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

import com.aspose.html.api.TemplateMergeApi;
import com.aspose.html.client.Configuration;
import com.aspose.storage.api.StorageApi;
import com.aspose.storage.model.FileExistResponse;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

public class TemplateMergeApiTest {

    private final TemplateMergeApi api = new TemplateMergeApi();
	private static String localFolder = Configuration.getStorage();
	private static StorageApi storageApi = new StorageApi();

    private String folder = "HtmlTestDoc";
    private String storage = null;
    private String templateName = "HtmlTemplate.html";
    private String templateData = "XmlSourceData.xml";
    private String options = "";
    private String versionId = null;

    /**
     * Populate HTML document template with data located as a file in the storage.
     *
     */
    @Test
    public void GetMergeHtmlTemplateTest() {


    	File templateNameFile = new File(Configuration.getTestDataDir(), templateName);
    	if(!templateNameFile.exists())
    		out.println("Template file not found");

    	File templateDataFile = new File(Configuration.getTestDataDir(), templateData);
    	if(!templateDataFile.exists())
    		out.println("Data file not found");

    	
        try {
        	
        	// Put template document to storage
        	storageApi.PutCreate(folder + "/" + templateName, templateNameFile, null, null);
        	
        	FileExistResponse res  = storageApi.GetIsExist(folder + "/" + templateName, null, null);
        	assertEquals(res.getCode(), 200);
        	
        	//Put data file to storage
        	storageApi.PutCreate(folder + "/" + templateData, templateDataFile, null, null);
        	
        	res  = storageApi.GetIsExist(folder + "/" + templateData, null, null);
        	assertEquals(res.getCode(), 200);
        	
        	File answer = api.GetMergeHtmlTemplate(templateName, folder + "/" + templateData, options,folder,storage);
        
    		File copyFile = new File(localFolder + "GetMergeHtmlTemplate.html");
    		answer.renameTo(copyFile);
        
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    /**
     * Populate HTML document template with data from the request body. Result document will be saved to storage.
     *
     */
    @Test
    public void PutMergeHtmlTemplateTest() {

    	String resultName = "PutMergeHtmlTemplate.html";
    	
        // Open xml file with data for template
        File f = new File(Configuration.getTestDataDir(), templateData);

        if(!f.exists())
            out.println("file not found");

        // Path to save result in the storage
        String outPath = folder +  "/" + resultName;

        try {
        	// TemplateName and templateData already in the storage
        	
            api.PutMergeHtmlTemplate(templateName, outPath, f, options, folder, storage);
    		//Download result from storage

            //Download result from storage
            File result = storageApi.GetDownload(outPath, versionId, storage);
    		
    		//Save to test directory
    		File copyFile = new File(localFolder + resultName);
    		result.renameTo(copyFile);
 
    		//Assert - not exception
    		assertTrue(true);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
