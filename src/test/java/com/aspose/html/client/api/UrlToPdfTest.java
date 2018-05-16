/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="UrlToPdfTest.java">
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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;
import static java.lang.System.out;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import org.apache.pdfbox.pdmodel.*;

import com.aspose.html.client.invoker.Configuration;


@RunWith(Parameterized.class)
public class UrlToPdfTest {
    private String sourceUrl;
    private Integer width;
    private Integer height;
    private Integer leftMargin;
    private Integer rightMargin;
    private Integer topMargin;
    private Integer bottomMargin;
    private String folder;
    private String storage;
    private ConversionApi api;
    
   //Constructor that takes test data.
    public UrlToPdfTest(
        Integer width,
        Integer height,
        Integer leftMargin,
        Integer rightMargin,
        Integer topMargin,
        Integer bottomMargin
    )
    {
		this.sourceUrl		=	"https://stallman.org/articles/anonymous-payments-thru-phones.html";			         
		this.width			=	width;       		  
		this.height         =	height;              
		this.leftMargin     =	leftMargin;          
		this.rightMargin    =	rightMargin;         
		this.topMargin      =	topMargin;           
		this.bottomMargin   =	bottomMargin;        
		this.folder         =	Configuration.getStorage();
		
		String storage = "UrlToPdf_"; 
		
		if(width != null && height != null) {
			storage += width + "x" + height +"_";
		}else {
			storage += "-------" + "_";
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
		
		this.storage = storage + ".pdf"; 
    }
    
    @Before
	public void initialize() {
    	api = new ConversionApi();
    }
    
    @Parameterized.Parameters
    public static Collection testData() {
    	return Arrays.asList(new Object[][] 
    	{
    		// Test width, height
    		{null, null, null, null, null, null},
    		{200,  500,  null, null, null, null},
    		{300,  600,  null, null, null, null},
    		{400,  700,  null, null, null, null},
    		{500,  800,  null, null, null, null},
    		{600,  900,  null, null, null, null},
    		{700,  1000, null, null, null, null},
    		{800,  1100, null, null, null, null},

      		{null, null, 0, 0, 0, 0},

      		// Test margin left, right
    		{null, null, 40,  0,   0, 0},
    		{null, null, 80,  0,   0, 0},
    		{null, null, 120, 0,   0, 0},
    		{null, null, 160, 0,   0, 0},
    		{null, null, 0,   40,  0, 0},
    		{null, null, 0,   80,  0, 0},
    		{null, null, 0,   120, 0, 0},
    		{null, null, 0,   160, 0, 0},

    		// Test margin top, bottom
      		{null, null, 0, 0, 40,  0  },
    		{null, null, 0, 0, 80,  0  },
    		{null, null, 0, 0, 120, 0  },
    		{null, null, 0, 0, 160, 0  },
    		{null, null, 0, 0, 0,   40 },
    		{null, null, 0, 0, 0,   80 },
    		{null, null, 0, 0, 0,   120},
    		{null, null, 0, 0, 0,   160}
    	});
    }
    
    @Test
    public void test() {
 
    	PDDocument pdf = null;
    	
    	try {
    		File answer = api.GetConvertDocumentToPdfByUrl(
					sourceUrl, 
					width, 
					height, 
					leftMargin,   
					rightMargin,  
					topMargin,    
					bottomMargin, 
					folder,       
					storage);
     		
    		//Save to test directory
    		File copyFile = new File(folder + storage);
    		answer.renameTo(copyFile);
 
    		//Assert contentType
    		assertEquals("application/pdf", Files.probeContentType(copyFile.toPath()));
    		
    		// PDF info
    		pdf = PDDocument.load(copyFile);
    		
    		//Test width, height delta 30%
    		if (width != null && height != null) {
    			assertEquals(width,new Integer((int)pdf.getPage(0).getMediaBox().getWidth()),width/30);
    			assertEquals(height,new Integer((int)pdf.getPage(0).getMediaBox().getHeight()),height/30);

    			out.println("width: expected - " + width 
    	    			+ " actual - " + (int)pdf.getPage(0).getMediaBox().getWidth());
    	    		
	    		out.println("height: expected - " + height 
	        			+ " actual - " + (int)pdf.getPage(0).getMediaBox().getHeight());

    		}
        }catch(Exception e) {
        	e.printStackTrace();
        }finally {
        	if(pdf != null)
				try {
					pdf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        }
    }
}
