/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="SummarizationApi.java">
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

public interface SummarizationApi {
  /**
   * Get the HTML document keywords using the keyword detection service.
   * 
   * @param name Document name (required). Html file in the storage.
   * @param folder Document folder. (optional)
   * @param storage Document storage. (optional)
   * @return Call&lt;ResponseBody&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("html/{name}/summ/keywords")
  Call<ResponseBody> GetDetectHtmlKeywords(
    @Path("name") String name,
    @Query("folder") String folder,
    @Query("storage") String storage
  );

  /**
   * Get the keywords from HTML document from Web specified by its URL using the keyword detection service
   * 
   * @param sourceUrl Source document URL. (required)
   * @return Call&lt;ResponseBody&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("html/summ/keywords")
  Call<ResponseBody> GetDetectHtmlKeywordsByUrl(
    @Query("sourceUrl") String sourceUrl
  );

}
