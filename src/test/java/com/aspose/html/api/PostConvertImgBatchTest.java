/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="PostConvertImgTest.java">
*   Copyright (c) 2019 Aspose.HTML for Cloud
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
import com.aspose.storage.api.StorageApi;
import retrofit2.Call;
import retrofit2.Response;

@RunWith(Parameterized.class)
public class PostConvertImgBatchTest extends BaseTest {

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

	   //Constructor that takes test data.
    public PostConvertImgBatchTest(
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
		super();
		this.name			=	"test_batch_html.zip";
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
		
		String fileName = "postConvertToImgBatch_";

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
		
		this.localName = fileName + "." + outFormat + ".zip";
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
    		{"jpeg", null, null, null, null, null, null, null},
    		{"jpeg", 500, 500, null, null, null, null, null},
    		{"jpeg", 700, 700, 0, 0, 0, 0, 100},
    		{"jpeg", 800, 800, 100, 100, 100, 100, 150},
    		{"jpeg", 800, 1000, 150, 150, 150, 150, 200},
    		{"jpeg", 800, 1200, 100, 100, 150, 150, 100},
    		{"jpeg", 800, 1400, 100, 150, 200, 0, 100},

    		{"png", null, null, null, null, null, null, null},
    		{"png", 500, 500, null, null, null, null, null},
    		{"png", 700, 700, 100, 100, 100, 100, 100},
    		{"png", 800, 800, 150, 150, 150, 150, 150},
    		{"png", 800, 1000, 50, 100, 150, 200, 200},
    		{"png", 800, 1200, 200, 150, 100, 50, 100},
    		{"png", 800, 1400, 50, 50, 50, 50, 100},
    		
    		{"bmp", null, null, null, null, null, null, null},
    		{"bmp", 500, 500, null, null, null, null, null},
    		{"bmp", 700, 700, 50, 100, 150, 200, 100},
    		{"bmp", 800, 800, 200, 150, 100, 50, 150},
    		{"bmp", 800, 1000, 50, 50, 50, 50, 200},
    		{"bmp", 800, 1200, 100, 100, 100, 100, 100},
    		{"bmp", 800, 1400, 150, 100, 50, 0, 100},
  
    		{"tiff", null, null, null, null, null, null, null},
    		{"tiff", 500, 500, null, null, null, null, null},
    		{"tiff", 700, 700, 50, 100, 150, 200, 100},
    		{"tiff", 800, 800, 200, 150, 100, 50, 150},
    		{"tiff", 800, 1000, 50, 50, 50, 50, 200},
    		{"tiff", 800, 1200, 100, 100, 100, 100, 100},
    		{"tiff", 800, 1400, 150, 150, 150, 150, 100},
    		  
    		{"gif", null, null, null, null, null, null, null},
    		{"gif", 500, 500, null, null, null, null, null},
    		{"gif", 700, 700, 50, 100, 150, 200, 100},
    		{"gif", 800, 800, 200, 150, 100, 50, 150},
    		{"gif", 800, 1000, 50, 50, 50, 50, 200},
    		{"gif", 800, 1200, 100, 100, 100, 100, 100},
    		{"gif", 800, 1400, 150, 150, 150, 150, 100}
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

			Call<ResponseBody> call = api.PostConvertDocumentInRequestToImage(outFormat,file,this.folder +"/" + localName,
    				  width, height, leftMargin, rightMargin, topMargin, bottomMargin, resolution);

			Response<ResponseBody> res = call.execute();
			assertTrue(res.isSuccessful());

    		//Download result from storage
			call = storageApi.downloadFile(this.folder +"/" + localName, versionId, storage);

			//Save to test directory
			TestHelper.checkAndSave(call, localName);
    		
        }catch(Exception e) {
        	e.printStackTrace();
        	fail();
        }
    }
    
}
