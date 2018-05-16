/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="TranslateUrlTest.java">
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

package com.aspose.html.client.api;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.aspose.html.client.invoker.Configuration;

@RunWith(Parameterized.class)
public class TranslateUrlTest {
    String sourceUrl;
    String srcLang;
    String resLang;
    String localStorage;
    TranslationApi api;
    
	private static String localFolder = Configuration.getStorage();
    
    public TranslateUrlTest(
    		String sourceUrl, 
    		String srcLang, 
    		String resLang) 
    {
    	this.sourceUrl = sourceUrl;
    	this.srcLang = srcLang;
    	this.resLang = resLang;
		this.localStorage = "TranslateUrl_" + srcLang +"_" + resLang + ".zip"; 
    }
    
    @Before
	public void initialize() {
        api = new TranslationApi();
    }

    
    @Parameterized.Parameters
    public static Collection testData() {
    	return Arrays.asList(new Object[][] 
    	{
    		{"https://www.le.ac.uk/oerresources/bdra/html/page_01.htm","en","fr"},
    		{"https://www.le.ac.uk/oerresources/bdra/html/page_02.htm","en","de"},
    		{"https://www.le.ac.uk/oerresources/bdra/html/page_03.htm","en","ru"}
    	});
    }
    
    @Test   
    public void test() {
    	
    	try {
            File answer = 
            		api.GetTranslateDocumentByUrl(
            				sourceUrl, srcLang, resLang);

            assertTrue(answer.exists());
            
    		//Save to test directory
    		File copyFile = new File(localFolder + localStorage);
    		answer.renameTo(copyFile);
 
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
