/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="DocLoadSiteTest.java">
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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.aspose.html.api.DocumentApi;
import com.aspose.html.client.Configuration;

@RunWith(Parameterized.class)
public class DocLoadSiteTest {
	private String sourceUrl;
    private String localStorage;
    private DocumentApi api;

    private static String localFolder = Configuration.getStorage();

	public DocLoadSiteTest(String sourceUrl) {
		this.sourceUrl = sourceUrl;
		this.localStorage = "DocLoadSite";
	}
	
    @Before
	public void initialize() {
        api = new DocumentApi();
    }

    @Parameterized.Parameters
    public static Collection testData() {
    	return Arrays.asList(new Object[] 
    	{
    		"https://lenta.ru/"
    	});
    }
    
    @Test   
    public void test() {

    	try {

    		File answer = api.GetDocumentByUrl(sourceUrl);
            
            assertTrue(answer.exists());
            assertTrue(answer.length() > 0);
            
    		//Save to test directory
    		File copyFile = new File(localFolder + localStorage + ".zip");
    		answer.renameTo(copyFile);

        	assertTrue(copyFile.exists());

        }catch(Exception e) {
        	e.printStackTrace();
            fail();
        }
    }
}
