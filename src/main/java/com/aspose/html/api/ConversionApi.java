/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="ConversionApi.java">
*   Copyright (c) 2022 Aspose.HTML for Cloud
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

import com.aspose.html.model.ConversionRequest;
import com.aspose.html.model.ConversionResult;
import retrofit2.Call;
import retrofit2.http.*;


public interface ConversionApi {

    /**
     * Creating a conversion task on the backend.
     *
     * @param request ConversionRequest object. (required)
     * @param from    Input format. (required)
     * @param to      Output format. (required)
     * @return Call	&lt;ConversionResult&gt;
     */
    @Headers({"Content-Type:application/json"})
    @POST("v4.0/html/conversion/{from}-{to}")
    public Call<ConversionResult> convert(
        @Body ConversionRequest request,
        @Path("from") String from,
        @Path("to") String to);

    /**
     * Get status of the conversion.
     *
     * @param id Conversion ID. (required)
     * @return Call	&lt;ConversionResult&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("v4.0/html/conversion/{id}")
    public Call<ConversionResult> getConversionStatus(@Path("id") String id);

}
