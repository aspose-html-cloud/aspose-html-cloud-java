/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="DocumentApi.java">
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

import retrofit2.Call;
import retrofit2.http.*;
import okhttp3.ResponseBody;

public interface DocumentApi {

    /**
     * Return all HTML page with linked resources packaged as a ZIP archive by the source page URL.
     *
     * @param sourceUrl Source page URL. (required)
     * @return Call&lt;ResponseBody&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("html/download")
    Call<ResponseBody> GetDocumentByUrl(
            @Query("sourceUrl") String sourceUrl
    );

    /**
     * Return list of HTML fragments matching the specified XPath query.
     *
     * @param name      The document name (required). Presented as zip archive with one html file in the root or html file.
     * @param outFormat Output format. Possible values: 'plain' and 'json'. (required)
     * @param xPath     XPath query string. (required)
     * @param storage   The document storage. (optional)
     * @param folder    The document folder. (optional)
     * @return Call&lt;ResponseBody&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/{name}/fragments/{outFormat}")
    Call<ResponseBody> GetDocumentFragmentByXPath(
            @Path("name") String name,
            @Path("outFormat") String outFormat,
            @Query("xPath") String xPath,
            @Query("storage") String storage,
            @Query("folder") String folder
    );

    /**
     * Return list of HTML fragments matching the specified XPath query by the source page URL.
     *
     * @param outFormat Output format. Possible values: 'plain' and 'json'. (required)
     * @param sourceUrl Source page URL. (required)
     * @param xPath XPath query string. (required)
     * @return Call&lt;ResponseBody&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/fragments/{outFormat}")
    Call<ResponseBody> GetDocumentFragmentByXPathByUrl(
            @Path("outFormat") String outFormat,
            @Query("sourceUrl") String sourceUrl,
            @Query("xPath") String xPath
    );

    /**
     * Return list of HTML fragments matching the specified CSS selector.
     *
     * @param name The document name(required). Presented as zip archive with one html file in the root or html file.
     * @param outFormat Output format. Possible values: 'plain' and 'json'. (required)
     * @param selector CSS selector string. (required)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return Call&lt;ResponseBody&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("html/{name}/fragments/css/{outFormat}")
    Call<ResponseBody> GetDocumentFragmentsByCSSSelector(
            @retrofit2.http.Path("name") String name,
            @retrofit2.http.Path("outFormat") String outFormat,
            @retrofit2.http.Query("selector") String selector,
            @retrofit2.http.Query("folder") String folder,
            @retrofit2.http.Query("storage") String storage
    );

    /**
     * Return list of HTML fragments matching the specified CSS selector by the source page URL.
     *
     * @param outFormat Output format. Possible values: 'plain' and 'json'. (required)
     * @param sourceUrl Source page URL. (required)
     * @param selector CSS selector string. (required)
     * @return Call&lt;ResponseBody&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("html/fragments/css/{outFormat}")
    Call<ResponseBody> GetDocumentFragmentsByCSSSelectorByUrl(
            @retrofit2.http.Path("outFormat") String outFormat,
            @retrofit2.http.Query("sourceUrl") String sourceUrl,
            @retrofit2.http.Query("selector") String selector
    );

    /**
     * Return all HTML document images packaged as a ZIP archive.
     *
     * @param name    The document name (required). Presented as zip archive with one html file in the root.
     * @param folder  The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return Call&lt;ResponseBody&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/{name}/images/all")
    Call<ResponseBody> GetDocumentImages(
            @Path("name") String name,
            @Query("folder") String folder,
            @Query("storage") String storage
    );

    /**
     * Return all HTML page images packaged as a ZIP archive by the source page URL.
     *
     * @param sourceUrl Source page URL. (required)
     * @return Call&lt;ResponseBody&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/images/all")
    Call<ResponseBody> GetDocumentImagesByUrl(
            @Query("sourceUrl") String sourceUrl
    );

}
