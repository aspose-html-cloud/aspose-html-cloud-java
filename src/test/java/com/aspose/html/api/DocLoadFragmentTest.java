/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="DocLoadFragmentTest.java">
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

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.aspose.html.api.DocumentApi;
import com.aspose.html.client.Configuration;
import com.aspose.storage.api.StorageApi;
import com.aspose.storage.model.FileExistResponse;

@RunWith(Parameterized.class)
public class DocLoadFragmentTest {
    private String name;
    private String xPath;
    private String outFormat;
    private String storage;
    private String folder;
    private String localStorage;
    private DocumentApi api;
    private StorageApi storageApi;

    private static String localFolder = Configuration.getStorage();

    public DocLoadFragmentTest(String name, String xPath, String outFormat) {
        this.name = name;
        this.xPath = xPath;
        this.outFormat = outFormat;
        this.folder = "HtmlTestDoc";
        this.storage = null;

        String ext = outFormat.equals("json") ? ".json" : ".html";
        this.localStorage = "DocXpathLoad_" + name + ext;

    }
    
    @Before
    public void initialize() {
        api = new DocumentApi();
        storageApi = new StorageApi();
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][] 
        {
            {"test1.html.zip",".//p", "plain"}, 
            {"test2.html.zip",".//p", "plain"},
            {"test3.html.zip",".//p", "plain"},
            {"test4.html.zip",".//p", "plain"},
            {"test2.html",".//ol/li", "json"}
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
            
            assertTrue(res.getFileExist().getIsExist());

        	File answer = api.GetDocumentFragmentByXPath(name, xPath, outFormat, storage, folder);

            assertTrue(answer.exists());
            assertTrue(answer.length()>0);
            String ext = "";
            if(outFormat == "plain") {
                ext = ".html";
            }else if(outFormat == "json") {
                ext = ".json";
            }
            //Save to test directory
            File copyFile = new File(localFolder + localStorage + ext);
            answer.renameTo(copyFile);

            assertTrue(copyFile.exists());

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
