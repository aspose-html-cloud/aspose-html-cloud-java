/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="OcrTranslateTest.java">
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
import com.aspose.html.api.OcrApi;
import okhttp3.ResponseBody;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.aspose.html.ApiClient;
import retrofit2.Call;

@RunWith(Parameterized.class)
public class OcrTranslateTest extends BaseTest {
    private String name;
    private String srcLang;
    private String resLang;
    private String folder;
    private String storage;
    private OcrApi api;
    private String localName;

    public OcrTranslateTest(String name, String srcLang, String resLang) {
        super();
        this.name = name;
        this.srcLang = srcLang;
        this.resLang = resLang;
        this.folder = "HtmlTestDoc";
        this.storage = null;
        this.localName = "OcrDoc_" + name + "_" + srcLang + "_" + resLang + ".html";
    }

    @Before
    public void initialize() {
        api = new ApiClient().createService(OcrApi.class);
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]
                {
                        {"test_ocr.png", "en", "fr"},
                        {"test_ocr.jpg", "en", "de"}
                });
    }

    @Test
    public void test() {

        try {
            TestHelper.uploadFile(name, folder);
            Call<ResponseBody> call = api.GetRecognizeAndTranslateToHtml(name, srcLang, resLang, folder, storage);
            TestHelper.checkAndSave(call, localName);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
