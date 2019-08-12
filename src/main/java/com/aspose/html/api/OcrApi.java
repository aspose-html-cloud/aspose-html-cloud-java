/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="OcrApi.java">
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


public interface OcrApi {
    /**
     * Recognize text from the image file in the storage and import it to HTML format.
     *
     * @param name          The image file name(required). Acceptable image formats is jpg, gif, png, bmp, tiff.
     * @param ocrEngineLang OCR engine language - language  (optional, default to en). Allowed values is "en", "de", "fr", "ru".
     * @param folder        The source image folder. (optional)
     * @param storage       The source image storage. (optional)
     * @return Call&lt;ResponseBody&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/{name}/ocr/import")
    Call<ResponseBody> GetRecognizeAndImportToHtml(
            @Path("name") String name,
            @Query("ocrEngineLang") String ocrEngineLang,
            @Query("folder") String folder,
            @Query("storage") String storage
    );

    /**
     * Recognize text from the image file in the storage, import it to HTML format and translate to specified language.
     *
     * @param name    The image file name(required). Acceptable image formats is jpg, gif, png, bmp, tiff.
     * @param srcLang Source language - also supposed as the OCR engine language (required).  Allowed values is "en", "de", "fr", "ru".
     * @param resLang Result language (required). Allowed values is "en", "de", "fr", "ru".
     * @param folder  The source image folder. (optional)
     * @param storage The source image storage. (optional)
     * @return Call&lt;ResponseBody&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/{name}/ocr/translate/{srcLang}/{resLang}")
    Call<ResponseBody> GetRecognizeAndTranslateToHtml(
            @Path("name") String name,
            @Path("srcLang") String srcLang,
            @Path("resLang") String resLang,
            @Query("folder") String folder,
            @Query("storage") String storage
    );
}
