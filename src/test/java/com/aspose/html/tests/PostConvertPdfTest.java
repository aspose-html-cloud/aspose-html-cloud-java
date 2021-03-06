/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="PostConvertPdfTest.java">
*   Copyright (c) 2020 Aspose.HTML for Cloud
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
package com.aspose.html.tests;

import static java.lang.System.out;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import java.io.File;
import com.aspose.html.ApiClient;
import com.aspose.html.Configuration;
import com.aspose.html.api.ConversionApi;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.aspose.html.api.StorageApi;
import retrofit2.Call;
import retrofit2.Response;

@RunWith(Parameterized.class)
public class PostConvertPdfTest extends BaseTest {

    private final String  name;
    private final Integer width;
    private final Integer height;
    private final Integer leftMargin;
    private final Integer rightMargin;
    private final Integer topMargin;
    private final Integer bottomMargin;
    private final String folder;
    private final String storage;
    private final String localName;
    private final String versionId;
    private ConversionApi api;
    private StorageApi storageApi;
    
   //Constructor that takes test data.
    public PostConvertPdfTest(
        Integer width,
        Integer height,
        Integer leftMargin,
        Integer rightMargin,
        Integer topMargin,
        Integer bottomMargin
    )
    {
		super();
		this.name		    =	"test1.html";
		this.width			=	width;       		  
		this.height         =	height;              
		this.leftMargin     =	leftMargin;          
		this.rightMargin    =	rightMargin;         
		this.topMargin      =	topMargin;           
		this.bottomMargin   =	bottomMargin;
		this.folder         =	"HtmlTestDoc";
		this.storage		=   null;
		this.versionId      =   null;
		

		String fileName = "postConvertToPdf_"; 
		
		if(width != null && height != null) {
			fileName += width + "x" + height +"_";
		}else {
			fileName += "---" + "_";
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
		
		this.localName = fileName + ".pdf"; 
    }
    
    @Before
	public void initialize() {
		api = new ApiClient().createService(ConversionApi.class);
		storageApi = new ApiClient().createService(StorageApi.class);
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

		File f = new File(Configuration.getTestSrcDir(), name);
		if(!f.exists()){
			out.println("file not found");
			fail();
		}
		RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), f);
		MultipartBody.Part file = MultipartBody.Part.createFormData("file", f.getName(), requestBody);
    	
    	try {

    		Call<ResponseBody> call = api.PostConvertDocumentInRequestToPdf(folder + "/" + localName, file, width, height, leftMargin, rightMargin, topMargin, bottomMargin);
			Response<ResponseBody> res = call.execute();
			assertTrue(res.isSuccessful());

    		//Download result from storage
			call = storageApi.downloadFile(folder +"/" + localName, versionId, storage);

			//Save to test directory
			TestHelper.checkAndSave(call, localName);

    	}catch(Exception e) {
        	e.printStackTrace();
        	fail();
        }
    }
}
