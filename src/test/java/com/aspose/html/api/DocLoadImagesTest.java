/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="DocLoadImagesTest.java">
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

import static org.junit.Assert.fail;
import java.util.Arrays;
import java.util.Collection;
import com.aspose.html.ApiClient;
import com.aspose.html.api.DocumentApi;
import okhttp3.ResponseBody;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import retrofit2.Call;

@RunWith(Parameterized.class)
public class DocLoadImagesTest extends BaseTest {
    private String name;
    private String storage;
    private String folder;

    private String localName;
    private DocumentApi api;

    public DocLoadImagesTest(String name) {
        super();
        this.name = name;
        this.folder = "HtmlTestDoc";
        this.storage = null;
        this.localName = "DocLoadImages_" + name;
    }

    @Before
    public void initialize() {
        api = new ApiClient().createService(DocumentApi.class);
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList("test1.html.zip",
                "test2.html.zip",
                "test3.html.zip",
                "test4.html.zip");
    }

    @Test
    public void test() {

        try {

            TestHelper.uploadFile(name, folder);

            Call<ResponseBody> call = api.GetDocumentImages(name, folder, storage);

            TestHelper.checkAndSave(call, localName);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
