/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="TemplateMergeApi.java">
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

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.*;
import okhttp3.ResponseBody;

public interface TemplateMergeApi {
  /**
   * Populate HTML document template with data located as a file in the storage.
   * 
   * @param templateName Template document name. Template document is HTML or zipped HTML. (required)
   * @param dataPath Data source file path in the storage. Supported data format: XML (required)
   * @param options Template merge options: reserved for further implementation. (optional)
   * @param folder The template document folder. (optional)
   * @param storage The template document and data source storage. (optional)
   * @return Call &lt;ResponseBody&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("html/{templateName}/merge")
  Call<ResponseBody> GetMergeHtmlTemplate(
    @Path("templateName") String templateName,
    @Query("dataPath") String dataPath,
    @Query("options") String options,
    @Query("folder") String folder,
    @Query("storage") String storage
  );

  /**
   * Populate HTML document template with data from the request body. Result document will be saved to storage.
   * 
   * @param templateName Template document name. Template document is HTML or zipped HTML. (required)
   * @param outPath Result document path. (required)
   * @param file A data file to populate template. (required)
   * @param options Template merge options: reserved for further implementation. (optional)
   * @param folder The template document folder. (optional)
   * @param storage The template document and data source storage. (optional)
   * @return Call &lt;ResponseBody&gt;
   */
  @Multipart
  @POST("html/{templateName}/merge")
  Call<ResponseBody> PostMergeHtmlTemplate(
    @Path("templateName") String templateName,
    @Query("outPath") String outPath,
    @Part MultipartBody.Part file,
    @Query("options") String options,
    @Query("folder") String folder,
    @Query("storage") String storage
  );
}
