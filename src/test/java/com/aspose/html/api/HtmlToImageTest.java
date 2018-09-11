/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="HtmlToImageTest.java">
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

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.Imaging;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.aspose.html.api.ConversionApi;
import com.aspose.html.client.Configuration;
import com.aspose.storage.api.StorageApi;
import com.aspose.storage.model.FileExistResponse;

@RunWith(Parameterized.class)
public class HtmlToImageTest {
	
    private String name;
    private String outFormat;
    private Integer width;
    private Integer height;
    private Integer leftMargin;
    private Integer rightMargin;
    private Integer topMargin;
    private Integer bottomMargin;
    private Integer xResolution;
    private Integer yResolution;
    private String folder;
    private String storage;
    private String localStorage;
    private ConversionApi api;
    private StorageApi storageApi;

	private static String localFolder = Configuration.getStorage();

    
   //Constructor that takes test data.
    public HtmlToImageTest(
        String outFormat,
        Integer width,
        Integer height,
        Integer leftMargin,
        Integer rightMargin,
        Integer topMargin,
        Integer bottomMargin,
        Integer xResolution,
        Integer yResolution
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
		this.xResolution    =	xResolution;         
		this.yResolution    =	yResolution;         
		this.folder         =	"HtmlTestDoc";
		this.storage		=   null;
		
		String storage = "HtmlToImg_";

		if(width != null && height != null) {
			storage += width + "x" + height +"_";
		}else {
			storage += "-------" + "_";
		}

		if(xResolution != null && yResolution != null){
			storage += xResolution + "x" + yResolution + "_";
		}else {
			storage += "---x---_";
		}
		
		if(leftMargin != null) {
			storage += "L"+ leftMargin + "_";
		}else {
			storage += "L---" + "_";
		}
		
		if(rightMargin != null) {
			storage += "R"+ rightMargin + "_";
		}else {
			storage += "R---" + "_";
		}
		
		if(topMargin != null) {
			storage += "T"+ topMargin + "_";
		}else {
			storage += "T---" + "_";
		}

		if(bottomMargin != null) {
			storage += "B"+ bottomMargin;
		}else {
			storage += "B---";
		}
		
		this.localStorage = storage + "." + outFormat;
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
    		{"jpeg", null, null, null, null, null, null, null, null},
    		{"jpeg", 500, 500, null, null, null, null, null, null},
    		{"jpeg", 600, 600, null, null, null, null, null, null},
    		{"jpeg", 700, 700, 0, 0, 0, 0, 100, 100},
    		{"jpeg", 800, 800, 100, 100, 100, 100, 150, 150},
    		{"jpeg", 800, 1000, 150, 150, 150, 150, 200, 200},
    		{"jpeg", 800, 1200, 100, 100, 150, 150, 50, 50},
    		{"jpeg", 800, 1400, 100, 150, 200, 0, 50, 50},
    		{"jpeg", 800, 1600, 0, 0, 0, 0, 50, 50},

    		{"png", null, null, null, null, null, null, null, null},
    		{"png", 500, 500, null, null, null, null, null, null},
    		{"png", 600, 600, null, null, null, null, null, null},
    		{"png", 700, 700, 100, 100, 100, 100, 100, 100},
    		{"png", 800, 800, 150, 150, 150, 150, 150, 150},
    		{"png", 800, 1000, 50, 100, 150, 200, 200, 200},
    		{"png", 800, 1200, 200, 150, 100, 50, 50, 50},
    		{"png", 800, 1400, 50, 50, 50, 50, 50, 50},
    		{"png", 800, 1600, 100, 100, 100, 100, 50, 50},
    		
    		{"bmp", null, null, null, null, null, null, null, null},
    		{"bmp", 500, 500, null, null, null, null, null, null},
    		{"bmp", 600, 600, null, null, null, null, null, null},
    		{"bmp", 700, 700, 50, 100, 150, 200, 100, 100},
    		{"bmp", 800, 800, 200, 150, 100, 50, 150, 150},
    		{"bmp", 800, 1000, 50, 50, 50, 50, 200, 200},
    		{"bmp", 800, 1200, 100, 100, 100, 100, 50, 50},
    		{"bmp", 800, 1400, 150, 100, 50, 0, 50, 50},
    		{"bmp", 800, 1600, 0, 0, 0, 0, 50, 50},

    		{"tiff", null, null, null, null, null, null, null, null},
    		{"tiff", 500, 500, null, null, null, null, null, null},
    		{"tiff", 600, 600, null, null, null, null, null, null},
    		{"tiff", 700, 700, 50, 100, 150, 200, 100, 100},
    		{"tiff", 800, 800, 200, 150, 100, 50, 150, 150},
    		{"tiff", 800, 1000, 50, 50, 50, 50, 200, 200},
    		{"tiff", 800, 1200, 100, 100, 100, 100, 50, 50},
    		{"tiff", 800, 1400, 150, 150, 150, 150, 50, 50},
    		{"tiff", 800, 1600, 0, 0, 0, 0, 50, 50}

    	});
    }
    
    @Test
    public void test() {
    
    	File f = new File(Configuration.getTestDataDir(), name);
    	if(!f.exists())
    		out.println("file not found");
    	
    	try {
        	// Put document to storage
        	storageApi.PutCreate(folder + "/" + name, f, null, null);
        	
        	FileExistResponse res  = storageApi.GetIsExist(folder + "/" + name, null, null);
        	assertEquals(res.getCode(), 200);
        	
    		File answer = api.GetConvertDocumentToImage(
					name, 
					outFormat, 
					width, 
					height, 
					leftMargin,   
					rightMargin,  
					topMargin,    
					bottomMargin, 
					xResolution,  
					yResolution,  
					folder,       
					storage);
     		
    		//Save to test directory
    		File copyFile = new File(localFolder + localStorage);
    		answer.renameTo(copyFile);
 
    		//Assert contentType
    		assertEquals("image/" + outFormat, Files.probeContentType(copyFile.toPath()));
    		
      		//Assert image info
    		ImageInfo imageInfo = Imaging.getImageInfo(copyFile);
     		out.println("FormatName - " + imageInfo.getFormatName());
    		out.println("Height - " + imageInfo.getHeight());
    		out.println("Mime type - " + imageInfo.getMimeType());
    		out.println("Width - " + imageInfo.getWidth());
    		out.println("FormatDetails - " + imageInfo.getFormatDetails());
    		out.println("PhysicalHeightDpi - " + imageInfo.getPhysicalHeightDpi());
    		out.println("PhysicalWidthDpi - " + imageInfo.getPhysicalWidthDpi());
    		out.println();  		
    		
    		//Test width, height delta 30%
//    		if (width != null && height != null) {
//    			assertEquals(width,new Integer(imageInfo.getWidth()),width/30);
//    			assertEquals(height,new Integer(imageInfo.getHeight()),height/30);
//    		}
    		
    		// Test xResolution yResolution with delta - 30 dpi
//    		if (xResolution != null && yResolution != null) {
//    			assertEquals(xResolution,imageInfo.getPhysicalWidthDpi(),30);
//        		assertEquals(yResolution,imageInfo.getPhysicalHeightDpi(),30);
//    		}
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
