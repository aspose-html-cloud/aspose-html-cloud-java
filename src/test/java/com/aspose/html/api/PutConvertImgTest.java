/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="PutConvertImgTest.java">
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
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.aspose.html.client.Configuration;
import com.aspose.storage.api.StorageApi;

@RunWith(Parameterized.class)
public class PutConvertImgTest {

    private String name;
    private String outFormat;
    private Integer width;
    private Integer height;
    private Integer leftMargin;
    private Integer rightMargin;
    private Integer topMargin;
    private Integer bottomMargin;
    private Integer resolution;
    private String folder;
    private String storage;
    private String versionId;
    private String localName;
    private ConversionApi api;
    private StorageApi storageApi;

	private static String localFolder = Configuration.getStorage();

	   //Constructor that takes test data.
    public PutConvertImgTest(
        String outFormat,
        Integer width,
        Integer height,
        Integer leftMargin,
        Integer rightMargin,
        Integer topMargin,
        Integer bottomMargin,
        Integer resolution
    )
    {
		this.name			=	"test1.html";			         
		this.outFormat		=	outFormat;   		   
		this.width			=	width;       		  
		this.height         =	height;              
		this.leftMargin     =	leftMargin;          
		this.rightMargin    =	rightMargin;         
		this.topMargin      =	topMargin;           
		this.bottomMargin   =	bottomMargin;        
		this.resolution     =	resolution;         
		this.folder         =	"HtmlTestDoc";
		this.storage		=   null;
		this.versionId 		=   null;
		
		String fileName = "putConvertToImg_";

		if(width != null && height != null) {
			fileName += width + "x" + height +"_";
		}else {
			fileName += "--" + "_";
		}

		if(resolution != null){
			fileName += resolution + "x_";
		}else {
			fileName += "--_";
		}
		
		if(leftMargin != null) {
			fileName += "L"+ leftMargin + "_";
		}else {
			fileName += "L--" + "_";
		}
		
		if(rightMargin != null) {
			fileName += "R"+ rightMargin + "_";
		}else {
			fileName += "R--" + "_";
		}
		
		if(topMargin != null) {
			fileName += "T"+ topMargin + "_";
		}else {
			fileName += "T--" + "_";
		}

		if(bottomMargin != null) {
			fileName += "B"+ bottomMargin;
		}else {
			fileName += "B--";
		}
		
		this.localName = fileName + "." + outFormat;
    }

    @Before
	public void initialize() {
    	api = new ConversionApi();
    	storageApi = new StorageApi();
    }

    @Parameterized.Parameters
    public static Collection testData() {
    	return Arrays.asList(new Object[][] 
    	{
    		{"jpeg", null, null, null, null, null, null, null},
    		{"jpeg", 500, 500, null, null, null, null, null},
    		{"jpeg", 600, 600, null, null, null, null, null},
    		{"jpeg", 700, 700, 0, 0, 0, 0, 100},
    		{"jpeg", 800, 800, 100, 100, 100, 100, 150},
    		{"jpeg", 800, 1000, 150, 150, 150, 150, 200},
    		{"jpeg", 800, 1200, 100, 100, 150, 150, 50},
    		{"jpeg", 800, 1400, 100, 150, 200, 0, 50},
    		{"jpeg", 800, 1600, 0, 0, 0, 0, 50},

    		{"png", null, null, null, null, null, null, null},
    		{"png", 500, 500, null, null, null, null, null},
    		{"png", 600, 600, null, null, null, null, null},
    		{"png", 700, 700, 100, 100, 100, 100, 100},
    		{"png", 800, 800, 150, 150, 150, 150, 150},
    		{"png", 800, 1000, 50, 100, 150, 200, 200},
    		{"png", 800, 1200, 200, 150, 100, 50, 50},
    		{"png", 800, 1400, 50, 50, 50, 50, 50},
    		{"png", 800, 1600, 100, 100, 100, 100, 50},
    		
    		{"bmp", null, null, null, null, null, null, null},
    		{"bmp", 500, 500, null, null, null, null, null},
    		{"bmp", 600, 600, null, null, null, null, null},
    		{"bmp", 700, 700, 50, 100, 150, 200, 100},
    		{"bmp", 800, 800, 200, 150, 100, 50, 150},
    		{"bmp", 800, 1000, 50, 50, 50, 50, 200},
    		{"bmp", 800, 1200, 100, 100, 100, 100, 50},
    		{"bmp", 800, 1400, 150, 100, 50, 0, 50},
    		{"bmp", 800, 1600, 0, 0, 0, 0, 50},

    		{"tiff", null, null, null, null, null, null, null},
    		{"tiff", 500, 500, null, null, null, null, null},
    		{"tiff", 600, 600, null, null, null, null, null},
    		{"tiff", 700, 700, 50, 100, 150, 200, 100},
    		{"tiff", 800, 800, 200, 150, 100, 50, 150},
    		{"tiff", 800, 1000, 50, 50, 50, 50, 200},
    		{"tiff", 800, 1200, 100, 100, 100, 100, 50},
    		{"tiff", 800, 1400, 150, 150, 150, 150, 50},
    		{"tiff", 800, 1600, 0, 0, 0, 0, 50}

    	});
    }

    
    @Test
    public void test() {
    
    	File file = new File(Configuration.getTestDataDir(), name);
    	if(!file.exists())
    		out.println("file not found");
    	
    	try {
    		
    		api.PutConvertDocumentInRequestToImage(this.folder +"/" + localName, 
    				outFormat, file, width, height, leftMargin, rightMargin, topMargin, bottomMargin, resolution);
    		
    		//Download result from storage
    		File result = storageApi.GetDownload(this.folder +"/" + localName, versionId, storage);
    		
    		//Save to test directory
    		File copyFile = new File(localFolder + localName);
    		result.renameTo(copyFile);
 
    		//Assert - not exception
    		assertTrue(true);
    		
        }catch(Exception e) {
        	e.printStackTrace();
            fail();
        }
    }
    
}
