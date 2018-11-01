/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="OcrTest.java">
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

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.aspose.html.api.OcrApi;
import com.aspose.html.client.Configuration;
import com.aspose.storage.api.StorageApi;
import com.aspose.storage.model.FileExistResponse;

@RunWith(Parameterized.class)
public class OcrTest {
	private String name;
	private String ocrEngineLang;
	private String folder;
	private String storage;
    private String localStorage;
    private OcrApi api;
    private StorageApi storageApi;

    private static String localFolder = Configuration.getStorage();
    
	public OcrTest(String name, String ocrEngineLang) 
	{
		this.name = name;
		this.ocrEngineLang = ocrEngineLang;
		this.folder = "HtmlTestDoc";
		this.storage = null;
		this.localStorage = "OcrDoc_" + name +"_" + ocrEngineLang + ".html"; 
	}
	
    @Before
	public void initialize() {
        api = new OcrApi();
    	storageApi = new StorageApi();
    }
    
    @Parameterized.Parameters
    public static Collection testData() {
    	return Arrays.asList(new Object[][] 
    	{
    		{"test_ocr.png","en"},
    		{"test_ocr.jpg","en"}
    	});
    }
    
    @Test   
    public void test() {

    	File f = new File(Configuration.getTestDataDir(), name);
    	if(!f.exists())
    		out.println("Local file not found");
    	
    	
    	try {
        	// Put document to storage
        	storageApi.PutCreate(folder + "/" + name, f, null, null);
        	
        	FileExistResponse res  = storageApi.GetIsExist(folder + "/" + name, null, null);
        	assertEquals(res.getCode(), 200);

    		File answer =
            	api.GetRecognizeAndImportToHtml(
            			name, 
            			ocrEngineLang, 
            			folder, 
            			storage);

    		//Save to test directory
    		File copyFile = new File(localFolder + localStorage);
    		answer.renameTo(copyFile);
 
    		//Assert contentType
    		assertEquals("text/html", Files.probeContentType(copyFile.toPath()));
        }catch(Exception e) {
        	e.printStackTrace();
            fail();
        }
    }
}
