/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="UrlToImagelTest.java">
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

import java.util.Arrays;
import java.util.Collection;
import com.aspose.html.ApiClient;
import com.aspose.html.api.ConversionApi;
import okhttp3.ResponseBody;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import retrofit2.Call;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class UrlToImagelTest extends BaseTest {

    private final String sourceUrl;
    private final String outFormat;
    private final Integer width;
    private final Integer height;
    private final Integer leftMargin;
    private final Integer rightMargin;
    private final Integer topMargin;
    private final Integer bottomMargin;
    private final Integer resolution;
    private final String localName;
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
            Integer resolution
    ) {
        super();
        this.sourceUrl = "https://stallman.org/articles/anonymous-payments-thru-phones.html";
        this.outFormat = outFormat;
        this.width = width;
        this.height = height;
        this.leftMargin = leftMargin;
        this.rightMargin = rightMargin;
        this.topMargin = topMargin;
        this.bottomMargin = bottomMargin;
        this.resolution = resolution;

        String savedName = "UrlToImg_";

        if (width != null && height != null) {
            savedName += width + "x" + height + "_";
        } else {
            savedName += "---x---_";
        }

        if (resolution != null) {
            savedName += resolution + "_";
        } else {
            savedName += "---_";
        }

        this.localName = savedName + "." + outFormat + ".zip";
    }

    @Before
    public void initialize() {
        api = new ApiClient().createService(ConversionApi.class);
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]
            {
                {"jpeg", null, null, null, null, null, null, null},
                {"jpeg", 500, 500, null, null, null, null, null},
                {"jpeg", 700, 700, 0, 0, 0, 0, 100},
                {"jpeg", 800, 800, 0, 0, 0, 0, 150},
                {"jpeg", 800, 1000, 0, 0, 0, 0, 200},
                {"jpeg", 800, 1200, 0, 0, 0, 0, 100},
                {"jpeg", 800, 1400, 0, 0, 0, 0, 100},

                {"png", null, null, null, null, null, null, null},
                {"png", 500, 500, null, null, null, null, null},
                {"png", 700, 700, 50, 100, 150, 200, 100},
                {"png", 800, 800, 200, 150, 100, 50, 150},
                {"png", 800, 1000, 50, 50, 50, 50, 200},
                {"png", 800, 1200, 100, 100, 100, 100, 100},
                {"png", 800, 1400, 150, 150, 150, 150, 100},
          
                {"bmp", null, null, null, null, null, null, null},
                {"bmp", 500, 500, null, null, null, null, null},
                {"bmp", 700, 700, 200, 150, 10, 50, 100},
                {"bmp", 800, 800, 50, 100, 150, 200, 150},
                {"bmp", 800, 1000, 50, 50, 50, 50, 200},
                {"bmp", 800, 1200, 100, 100, 100, 100, 100},
                {"bmp", 800, 1400, 0, 0, 0, 0, 100},

                {"tiff", null, null, null, null, null, null, null},
                {"tiff", 500, 500, null, null, null, null, null},
                {"tiff", 700, 700, 200, 150, 100, 50, 100},
                {"tiff", 800, 800, 50, 100, 150, 200, 150},
                {"tiff", 800, 1000, 50, 50, 50, 50, 200},
                {"tiff", 800, 1200, 100, 100, 100, 100, 100},
                {"tiff", 800, 1400, 150, 150, 150, 150, 100},

                {"gif", null, null, null, null, null, null, null},
                {"gif", 500, 500, null, null, null, null, null},
                {"gif", 700, 700, 200, 150, 100, 50, 100},
                {"gif", 800, 800, 50, 100, 150, 200, 150},
                {"gif", 800, 1000, 50, 50, 50, 50, 200},
                {"gif", 800, 1200, 100, 100, 100, 100, 100},
                {"gif", 800, 1400, 150, 150, 150, 150, 100}
            });
    }

    @Test
    public void test() {

        try {
            Call<ResponseBody> call = api.GetConvertDocumentToImageByUrl(
					outFormat,
                    sourceUrl,
					width,
					height,
					leftMargin,
					rightMargin,
					topMargin,
					bottomMargin,
					resolution);

            TestHelper.checkAndSave(call, localName);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
