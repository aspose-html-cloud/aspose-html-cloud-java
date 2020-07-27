/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="PostConvertMarkdownTest.java">
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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.aspose.html.ApiClient;
import com.aspose.html.Configuration;
import com.aspose.html.api.ConversionApi;
import com.aspose.html.api.StorageApi;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

@RunWith(Parameterized.class)
public class PostConvertMarkdownTest extends BaseTest{

    private final Boolean useGit;
    private final String localName;
    private final String folder;
    private final String storage;
    private final String versionId;
    private ConversionApi api;
    private StorageApi storageApi;
    
   //Constructor that takes test data.
    public PostConvertMarkdownTest(Boolean useGit)
    {
		this.useGit			=	useGit;
		this.folder         =	"HtmlTestDoc";
		this.storage		=   null;
		this.versionId      =   null;
		

		String fileName = "PostConvertToMarkdownInResult_"; 
		if(useGit) {
			fileName += "usingGit";
		}else {
			fileName += "notUsingGit";
		}
		
		this.localName = fileName + ".md"; 
    }
    
    @Before
	public void initialize() {
		api = new ApiClient().createService(ConversionApi.class);
		storageApi = new ApiClient().createService(StorageApi.class);
    }
    
    @Parameterized.Parameters
    public static Collection testData() {
    	//Use Git Markdown flavor test1 - true, test2 - false
    	return Arrays.asList(new Object[][]	{ {true}, {false} });    
    	}
    
    @Test
    public void test() {
		File f = new File(Configuration.getTestSrcDir(), "test_md.html");
		if(!f.exists()){
			out.println("file not found");
			fail();
		}
		RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), f);
		MultipartBody.Part file = MultipartBody.Part.createFormData("file", f.getName(), requestBody);

    	try {

    		String outPath = folder + "/" + localName;

			Call<ResponseBody> call = api.PostConvertDocumentInRequestToMarkdown(file, outPath, useGit, storage);
			Response<ResponseBody> res = call.execute();
			assertTrue(res.isSuccessful());

			//Download result from storage
			call = storageApi.downloadFile(outPath, versionId, storage);

			//Save to test directory
			TestHelper.checkAndSave(call, localName);

    	}catch(Exception e) {
        	e.printStackTrace();
            fail();
        }
    }
}
