/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="PutConvertMarkdownTest.java">
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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.aspose.html.api.ConversionApi;
import com.aspose.html.client.Configuration;
import com.aspose.storage.api.StorageApi;

@RunWith(Parameterized.class)
public class PutConvertMarkdownTest {
    private Boolean useGit;
    private String localName;
    private String folder;
    private String storage;
    private String versionId;
    
    private ConversionApi api;
    private StorageApi storageApi;
    
	private static String localFolder = Configuration.getStorage();

    
   //Constructor that takes test data.
    public PutConvertMarkdownTest(Boolean useGit)
    {
		this.useGit			=	useGit;
		this.folder         =	"HtmlTestDoc";
		this.storage		=   null;
		this.versionId      =   null;
		

		String fileName = "PutConvertToMarkdownInResult_"; 
		if(useGit) {
			fileName += "usingGit";
		}else {
			fileName += "notUsingGit";
		}
		
		this.localName = fileName + ".md"; 
    }
    
    @Before
	public void initialize() {
    	api = new ConversionApi();
    	storageApi = new StorageApi();
    }
    
    @Parameterized.Parameters
    public static Collection testData() {
    	//Use Git Markdown flavor test1 - true, test2 - false
    	return Arrays.asList(new Object[][]	{ {true}, {false} });    
    	}
    
    @Test
    public void test() {
    	
       	File f = new File(Configuration.getTestDataDir(), "test_md.html");
    	if(!f.exists())
    		out.println("Local file not found");
    	
    	try {

    		String outPath = folder + "/" + localName;
    		
    		File res = api.PutConvertDocumentInRequestToMarkdown(outPath, f, useGit);     		

    		//Download result from storage
    		File result = storageApi.GetDownload(outPath, versionId, storage);
    		
    		//Save to test directory
    		File copyFile = new File(localFolder + localName);
    		result.renameTo(copyFile);
 
    	}catch(Exception e) {
        	e.printStackTrace();
            fail();
        }
    }
}
