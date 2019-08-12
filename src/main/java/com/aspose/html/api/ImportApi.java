/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="ImportApi.java">
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

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.*;
import okhttp3.ResponseBody;

public interface ImportApi {
    /**
     * Converts the Markdown document (located on storage) to HTML and returns resulting file in response content.
     *
     * @param name Document name. (required)
     * @param folder Source document folder. (optional)
     * @param storage Source document storage. (optional)
     * @return Call<ResponseBody>
     */
    @GET("html/{name}/import/md")
    Call<ResponseBody> GetConvertMarkdownToHtml(
            @Path("name") String name,
            @Query("folder") String folder,
            @Query("storage") String storage
    );


    /**
     * Converts the Markdown document (located on storage) to HTML and uploads resulting file to storage by specified path.
     *
     * @param name Document name. (required)
     * @param outPath Full resulting file path in the storage (ex. /folder1/folder2/result.html) (required)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @return Call<ResponseBody>
     */
    @PUT("html/{name}/import/md")
    Call<ResponseBody> PutConvertMarkdownToHtml(
            @Path("name") String name,
            @Query("outPath") String outPath,
            @Query("folder") String folder,
            @Query("storage") String storage
    );


    /**
     * Converts the Markdown document (in request content) to HTML and uploads resulting file to storage by specified path.
     *
     * @param file A file to be converted. (required)
     * @param outPath Full resulting file path in the storage (ex. /folder1/folder2/result.html) (required)
     * @param storage The source and resulting document storage. (optional)
     * @return Call<ResponseBody>
     */
    @Multipart
    @POST("html/import/md")
    Call<ResponseBody> PostConvertMarkdownInRequestToHtml(
            @Part MultipartBody.Part file,
            @Query("outPath") String outPath,
            @Query("storage") String storage
    );

}
