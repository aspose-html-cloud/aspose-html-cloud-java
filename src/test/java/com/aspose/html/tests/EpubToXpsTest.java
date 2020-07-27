/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="EpubToXpsTest.java">
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

import com.aspose.html.ApiClient;
import com.aspose.html.api.ConversionApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import okhttp3.ResponseBody;
import retrofit2.Call;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class EpubToXpsTest extends BaseTest {

    private final String name;
    private final Integer width;
    private final Integer height;
    private final Integer leftMargin;
    private final Integer rightMargin;
    private final Integer topMargin;
    private final Integer bottomMargin;
    private final String folder;
    private final String storage;
    private final String localName;
    private ConversionApi api;

    
    //Constructor that takes test data.
    public EpubToXpsTest(
            Integer width,
            Integer height,
            Integer leftMargin,
            Integer rightMargin,
            Integer topMargin,
            Integer bottomMargin
    ) {
        super();
        this.name = "georgia.epub";
        this.width = width;
        this.height = height;
        this.leftMargin = leftMargin;
        this.rightMargin = rightMargin;
        this.topMargin = topMargin;
        this.bottomMargin = bottomMargin;
        this.folder = "HtmlTestDoc";
        this.storage = null;

        String savedName = "EpubToXps_";

        if (width != null && height != null) {
            savedName += width + "x" + height + "_";
        } else {
            savedName += "-------" + "_";
        }

        if (leftMargin != null) {
            savedName += "L" + leftMargin + "_";
        } else {
            savedName += "L---" + "_";
        }

        if (rightMargin != null) {
            savedName += "R" + rightMargin + "_";
        } else {
            savedName += "R---" + "_";
        }

        if (topMargin != null) {
            savedName += "T" + topMargin + "_";
        } else {
            savedName += "T---" + "_";
        }

        if (bottomMargin != null) {
            savedName += "B" + bottomMargin;
        } else {
            savedName += "B---";
        }

        this.localName = savedName + ".xps";
    }

    @Before
    public void initialize() {
        api = new ApiClient().createService(ConversionApi.class);
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]
                {
                        // Test width, height
                        {null, null, null, null, null, null},
                        {200, 500, null, null, null, null},
                        {300, 600, null, null, null, null},
                        {400, 700, null, null, null, null},
                        {500, 800, null, null, null, null},
                        {600, 900, null, null, null, null},
                        {700, 1000, null, null, null, null},
                        {800, 1100, null, null, null, null},

                        {null, null, 0, 0, 0, 0},

                        // Test margin left, right
                        {null, null, 40, 0, 0, 0},
                        {null, null, 80, 0, 0, 0},
                        {null, null, 120, 0, 0, 0},
                        {null, null, 160, 0, 0, 0},
                        {null, null, 0, 40, 0, 0},
                        {null, null, 0, 80, 0, 0},
                        {null, null, 0, 120, 0, 0},
                        {null, null, 0, 160, 0, 0},

                        // Test margin top, bottom
                        {null, null, 0, 0, 40, 0},
                        {null, null, 0, 0, 80, 0},
                        {null, null, 0, 0, 120, 0},
                        {null, null, 0, 0, 160, 0},
                        {null, null, 0, 0, 0, 40},
                        {null, null, 0, 0, 0, 80},
                        {null, null, 0, 0, 0, 120},
                        {null, null, 0, 0, 0, 160}
                });
    }

    @Test
    public void test() {

        try {

            TestHelper.uploadFile(name,folder);
            Call<ResponseBody> call = api.GetConvertDocumentToXps(name, width, height, leftMargin, rightMargin,
                    topMargin, bottomMargin, folder, storage);
            TestHelper.checkAndSave(call, localName);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
