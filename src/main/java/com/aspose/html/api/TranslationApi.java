/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="TranslationApi.java">
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

public interface TranslationApi {
    /**
     * Translate the HTML document specified by the name from default or specified storage.
     * Allowed values for language pairs is en-de, en-fr, en-ru, de-en, ru-en, en-zh, zh-en.
     *
     * @param name    Document name (required). Html file in the storage.
     * @param srcLang Source language (required). Allowed values is "en" (alias "eng", "english"), "de" (alias "deu", "deutsch", "german"), "fr" (alias "fra", "french"), "ru" (alias "rus", "russian"), "zh", alias ("chinese").
     * @param resLang Result language (required). Allowed values is "en" (alias "eng", "english"), "de" (alias "deu", "deutsch", "german"), "fr" (alias "fra", "french"), "ru" (alias "rus", "russian"), "zh", alias ("chinese").
     * @param storage The source document storage. (optional)
     * @param folder  The source document folder. (optional)
     * @return Call&lt;ResponseBody&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/{name}/translate/{srcLang}/{resLang}")
    Call<ResponseBody> GetTranslateDocument(
            @Path("name") String name,
            @Path("srcLang") String srcLang,
            @Path("resLang") String resLang,
            @Query("storage") String storage,
            @Query("folder") String folder
    );

    /**
     * Translate the HTML document from Web specified by its URL.
     *
     * Allowed values for language pairs is en-de, en-fr, en-ru, de-en, ru-en, en-zh, zh-en.
     *
     * @param srcLang   Source language (required). Allowed values is "en" (alias "eng", "english"), "de" (alias "deu", "deutsch", "german"), "fr" (alias "fra", "french"), "ru" (alias "rus", "russian"), "zh", alias ("chinese").
     * @param resLang   Result language (required). Allowed values is "en" (alias "eng", "english"), "de" (alias "deu", "deutsch", "german"), "fr" (alias "fra", "french"), "ru" (alias "rus", "russian"), "zh", alias ("chinese").
     * @param sourceUrl Source document URL. (required)
     * @return Call&lt;ResponseBody&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/translate/{srcLang}/{resLang}")
    Call<ResponseBody> GetTranslateDocumentByUrl(
            @Path("srcLang") String srcLang,
            @Path("resLang") String resLang,
            @Query("sourceUrl") String sourceUrl
    );
}
