/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="PutMarkdownToHtmlTest.java">
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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.aspose.html.ApiClient;
import com.aspose.html.api.ImportApi;
import com.aspose.storage.api.StorageApi;
import com.aspose.storage.model.ObjectExist;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;



@RunWith(Parameterized.class)
public class PutMarkdownToHtmlTest extends BaseTest{
    private String  name;
    private String folder;
    private String storage;
    private String resultName;
    private ImportApi api;
    private StorageApi storageApi;


   //Constructor that takes test data.
    public PutMarkdownToHtmlTest(String name)
    {
		this.name		    =	name;
		this.folder         =	"HtmlTestDoc";
		this.storage		=   null;
		this.resultName = "PutMarkdownToHtml.html";
    }
    
    @Before
	public void initialize() {
        api = new ApiClient().createService(ImportApi.class);
        storageApi = new ApiClient().createService(StorageApi.class);
    }
    
    @Parameterized.Parameters
    public static Collection testData() {
    	return Arrays.asList(new Object[][]	{ {"testpage1.md"} });
    }
    
    @Test
    public void test() {

        try {
            TestHelper.uploadFile(name, folder);

            Call<ObjectExist> call = storageApi.objectExists(folder + "/" + name,	null, null);

            Response<ObjectExist> res = call.execute();
            assertTrue(res.isSuccessful());

        	//Result file in the storage
        	String outPath = folder + "/" + resultName;

            api.PutConvertMarkdownToHtml( name, outPath, folder, storage).execute();

            //Download result from storage
            Call<ResponseBody> call_res = storageApi.downloadFile(outPath, null, null);

            //Save to test directory
            TestHelper.checkAndSave(call_res, resultName);

            //Clear in the storage
            Call<Void> call_response = storageApi.deleteFile(folder + "/" + name, null, null);

            Response<Void> res2 = call_response.execute();
            assertTrue(res2.isSuccessful());
     		
        }catch(Exception e) {
        	e.printStackTrace();
            fail();
        }
    }
}
