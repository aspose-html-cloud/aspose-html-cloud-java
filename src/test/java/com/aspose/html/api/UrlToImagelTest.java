/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="UrlToImagelTest.java">
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

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;
import static java.lang.System.out;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.Imaging;

import com.aspose.html.api.ConversionApi;
import com.aspose.html.client.Configuration;

@RunWith(Parameterized.class)
public class UrlToImagelTest {
	
    private String sourceUrl;
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
    private ConversionApi api;
    
   //Constructor that takes test data.
    public UrlToImagelTest(
        String outFormat,
        Integer width,
        Integer height,
        Integer leftMargin,
        Integer rightMargin,
        Integer topMargin,
        Integer bottomMargin,
        Integer xResolution,
        Integer yResolution//,
    )
    {
		this.sourceUrl		=	"https://stallman.org/articles/anonymous-payments-thru-phones.html";			         
		this.outFormat		=	outFormat;   		   
		this.width			=	width;       		  
		this.height         =	height;              
		this.leftMargin     =	leftMargin;          
		this.rightMargin    =	rightMargin;         
		this.topMargin      =	topMargin;           
		this.bottomMargin   =	bottomMargin;        
		this.xResolution    =	xResolution;         
		this.yResolution    =	yResolution;         
		this.folder         =	Configuration.getStorage();
		
		String storage = "UrlToImg_"; 
		
		if(width != null && height != null) {
			storage += width + "x" + height +"_";
		}else {
			storage += "---------_";
		}
		
		if(xResolution != null && yResolution != null){
			storage += xResolution + "x" + yResolution;
		}else {
			storage += "------_";
		}
		
		this.storage = storage + "." + outFormat; 
    }
    
    @Before
	public void initialize() {
    	api = new ConversionApi();
    }
    
    @Parameterized.Parameters
    public static Collection testData() {
    	return Arrays.asList(new Object[][] 
    	{
    		{"jpeg", null, null, null, null, null, null, null, null},
    		{"jpeg", 500, 500, null, null, null, null, null, null},
    		{"jpeg", 600, 600, null, null, null, null, null, null},
    		{"jpeg", 700, 700, 0, 0, 0, 0, 100, 100},
    		{"jpeg", 800, 800, 0, 0, 0, 0, 150, 150},
    		{"jpeg", 800, 1000, 0, 0, 0, 0, 200, 200},
    		{"jpeg", 800, 1200, 0, 0, 0, 0, 50, 50},
    		{"jpeg", 800, 1400, 0, 0, 0, 0, 50, 50},
    		{"jpeg", 800, 1600, 0, 0, 0, 0, 50, 50},

    		{"png", null, null, null, null, null, null, null, null},
    		{"png", 500, 500, null, null, null, null, null, null},
    		{"png", 600, 600, null, null, null, null, null, null},
    		{"png", 700, 700, 50, 100, 150, 200, 100, 100},
    		{"png", 800, 800, 200, 150, 100, 50, 150, 150},
    		{"png", 800, 1000, 50, 50, 50, 50, 200, 200},
    		{"png", 800, 1200, 100, 100, 100, 100, 50, 50},
    		{"png", 800, 1400, 150, 150, 150, 150, 50, 50},
    		{"png", 800, 1600, 200, 200, 200, 200, 50, 50},
    		
    		{"bmp", null, null, null, null, null, null, null, null},
    		{"bmp", 500, 500, null, null, null, null, null, null},
    		{"bmp", 600, 600, null, null, null, null, null, null},
    		{"bmp", 700, 700, 200, 150, 10, 50, 100, 100},
    		{"bmp", 800, 800, 50, 100, 150, 200, 150, 150},
    		{"bmp", 800, 1000, 50, 50, 50, 50, 200, 200},
    		{"bmp", 800, 1200, 100, 100, 100, 100, 50, 50},
    		{"bmp", 800, 1400, 0, 0, 0, 0, 50, 50},
    		{"bmp", 800, 1600, 150, 150, 150, 150, 50, 50},

    		{"tiff", null, null, null, null, null, null, null, null},
    		{"tiff", 500, 500, null, null, null, null, null, null},
    		{"tiff", 600, 600, null, null, null, null, null, null},
    		{"tiff", 700, 700, 200, 150, 100, 50, 100, 100},
    		{"tiff", 800, 800, 50, 100, 150, 200, 150, 150},
    		{"tiff", 800, 1000, 50, 50, 50, 50, 200, 200},
    		{"tiff", 800, 1200, 100, 100, 100, 100, 50, 50},
    		{"tiff", 800, 1400, 150, 150, 150, 150, 50, 50},
    		{"tiff", 800, 1600, 200, 200, 200, 200, 50, 50}

    	});
    }
    
    @Test
    public void test() {
    	
    	try {
    		File answer = api.GetConvertDocumentToImageByUrl(
					sourceUrl, 
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
     		
    		//Save to test drectory
    		File copyFile = new File(folder + storage);
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
    		
    		//Test width, height delta 40%
//    		if (width != null && height != null) {
//    			assertEquals(width,new Integer(imageInfo.getWidth()),width/40);
//    			assertEquals(height,new Integer(imageInfo.getHeight()),height/40);
//    		}
    		
    		// Test xResolution yResolution with delta - 30 dpi
//    		if (xResolution != null && yResolution != null) {
//    			assertEquals(xResolution,imageInfo.getPhysicalWidthDpi(),30);
//        		assertEquals(yResolution,imageInfo.getPhysicalHeightDpi(),30);
//    		}
        }catch(Exception e) {
        	e.printStackTrace();
        	fail();
        }
    }
}