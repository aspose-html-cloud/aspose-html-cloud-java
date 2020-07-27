/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="SeoApi.java">
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
package com.aspose.html.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface SeoApi {

    /**
     * Page analysis and return of SEO warnings.
     *
     * @param addr    Source page URL for analyses. (required)
     * @return Call &lt;ResponseBody&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("html/seo")
    Call<ResponseBody> GetSeoWarning(@Query("addr") String addr);

    /**
     * Checks the markup validity of Web documents in HTML, XHTML, etc.
     *
     * @param url    Source page URL for analyses. (required)
     * @return Call &lt;ResponseBody&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("html/validator")
    Call<ResponseBody> GetHtmlWarning(@Query("url") String url);
}
