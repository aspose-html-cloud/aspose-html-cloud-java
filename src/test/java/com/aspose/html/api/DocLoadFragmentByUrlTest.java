/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="DocLoadFragmentByUrlTest.java">
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

import com.aspose.html.ApiClient;
import com.aspose.html.api.DocumentApi;
import okhttp3.ResponseBody;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import retrofit2.Call;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class DocLoadFragmentByUrlTest extends BaseTest{
    private String sourceUrl;
    private String xPath;
    private String outFormat;
    private String localName;
    private DocumentApi api;


    public DocLoadFragmentByUrlTest(Integer numTest, String sourceUrl, String xPath, String outFormat) {
        super();
        this.sourceUrl = sourceUrl;
        this.xPath = xPath;
        this.outFormat = outFormat;

        String ext = outFormat.equals("json") ? ".json" : ".html";
        this.localName = "DocXpathByUrl_" + numTest + ext;

    }

    @Before
    public void initialize()
    {
        api = new ApiClient().createService(DocumentApi.class);
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]
                {
                        {1, "https://stallman.org/articles/anonymous-payments-thru-phones.html",".//p", "plain"},
                        {2, "https://stallman.org/articles/anonymous-payments-thru-phones.html",".//p", "json"}
                });
    }

    @Test
    public void test() {

    	try {

            Call<ResponseBody> call = api.GetDocumentFragmentByXPathByUrl(outFormat, sourceUrl, xPath);

            TestHelper.checkAndSave(call, localName);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
