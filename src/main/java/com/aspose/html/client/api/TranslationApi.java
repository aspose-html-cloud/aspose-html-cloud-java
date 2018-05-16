/**
 * --------------------------------------------------------------------------------------------------------------------
 * <copyright company="Aspose" file="TranslationApi.java">
 *  Copyright (c) 2018 Aspose.HTML for Cloud
 * </copyright>
 * <summary>
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
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


package com.aspose.html.client.api;

import com.aspose.html.client.invoker.ApiCallback;
import com.aspose.html.client.invoker.ApiClient;
import com.aspose.html.client.invoker.ApiException;
import com.aspose.html.client.invoker.ApiResponse;
import com.aspose.html.client.invoker.Configuration;
import com.aspose.html.client.invoker.Pair;
import com.aspose.html.client.invoker.ProgressRequestBody;
import com.aspose.html.client.invoker.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranslationApi {
    private ApiClient apiClient;

    public TranslationApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TranslationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for GetTranslateDocument
     * @param name Document name. (required)
     * @param srcLang Source language. (required)
     * @param resLang Result language. (required)
     * @param storage The document storage. (optional)
     * @param folder The document folder. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call GetTranslateDocumentCall(String name, String srcLang, String resLang, String storage, String folder, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/{name}/translate/{srcLang}/{resLang}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()))
            .replaceAll("\\{" + "srcLang" + "\\}", apiClient.escapeString(srcLang.toString()))
            .replaceAll("\\{" + "resLang" + "\\}", apiClient.escapeString(resLang.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (storage != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("storage", storage));
        if (folder != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("folder", folder));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "multipart/form-data"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call GetTranslateDocumentValidateBeforeCall(String name, String srcLang, String resLang, String storage, String folder, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling GetTranslateDocument(Async)");
        }
        
        // verify the required parameter 'srcLang' is set
        if (srcLang == null) {
            throw new ApiException("Missing the required parameter 'srcLang' when calling GetTranslateDocument(Async)");
        }
        
        // verify the required parameter 'resLang' is set
        if (resLang == null) {
            throw new ApiException("Missing the required parameter 'resLang' when calling GetTranslateDocument(Async)");
        }
        

        com.squareup.okhttp.Call call = GetTranslateDocumentCall(name, srcLang, resLang, storage, folder, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Translate the HTML document specified by the name from default or specified storage.
     * 
     * @param name Document name. (required)
     * @param srcLang Source language. (required)
     * @param resLang Result language. (required)
     * @param storage The document storage. (optional)
     * @param folder The document folder. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File GetTranslateDocument(String name, String srcLang, String resLang, String storage, String folder) throws ApiException {
        ApiResponse<File> resp = GetTranslateDocumentWithHttpInfo(name, srcLang, resLang, storage, folder);
        return resp.getData();
    }

    /**
     * Translate the HTML document specified by the name from default or specified storage.
     * 
     * @param name Document name. (required)
     * @param srcLang Source language. (required)
     * @param resLang Result language. (required)
     * @param storage The document storage. (optional)
     * @param folder The document folder. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<File> GetTranslateDocumentWithHttpInfo(String name, String srcLang, String resLang, String storage, String folder) throws ApiException {
        com.squareup.okhttp.Call call = GetTranslateDocumentValidateBeforeCall(name, srcLang, resLang, storage, folder, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Translate the HTML document specified by the name from default or specified storage. (asynchronously)
     * 
     * @param name Document name. (required)
     * @param srcLang Source language. (required)
     * @param resLang Result language. (required)
     * @param storage The document storage. (optional)
     * @param folder The document folder. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call GetTranslateDocumentAsync(String name, String srcLang, String resLang, String storage, String folder, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = GetTranslateDocumentValidateBeforeCall(name, srcLang, resLang, storage, folder, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for GetTranslateDocumentByUrl
     * @param sourceUrl Source document URL. (required)
     * @param srcLang Source language. (required)
     * @param resLang Result language. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call GetTranslateDocumentByUrlCall(String sourceUrl, String srcLang, String resLang, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/translate/{srcLang}/{resLang}"
            .replaceAll("\\{" + "srcLang" + "\\}", apiClient.escapeString(srcLang.toString()))
            .replaceAll("\\{" + "resLang" + "\\}", apiClient.escapeString(resLang.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (sourceUrl != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sourceUrl", sourceUrl));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "multipart/form-data"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call GetTranslateDocumentByUrlValidateBeforeCall(String sourceUrl, String srcLang, String resLang, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'sourceUrl' is set
        if (sourceUrl == null) {
            throw new ApiException("Missing the required parameter 'sourceUrl' when calling GetTranslateDocumentByUrl(Async)");
        }
        
        // verify the required parameter 'srcLang' is set
        if (srcLang == null) {
            throw new ApiException("Missing the required parameter 'srcLang' when calling GetTranslateDocumentByUrl(Async)");
        }
        
        // verify the required parameter 'resLang' is set
        if (resLang == null) {
            throw new ApiException("Missing the required parameter 'resLang' when calling GetTranslateDocumentByUrl(Async)");
        }
        

        com.squareup.okhttp.Call call = GetTranslateDocumentByUrlCall(sourceUrl, srcLang, resLang, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Translate the HTML document specified by its URL.
     * 
     * @param sourceUrl Source document URL. (required)
     * @param srcLang Source language. (required)
     * @param resLang Result language. (required)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File GetTranslateDocumentByUrl(String sourceUrl, String srcLang, String resLang) throws ApiException {
        ApiResponse<File> resp = GetTranslateDocumentByUrlWithHttpInfo(sourceUrl, srcLang, resLang);
        return resp.getData();
    }

    /**
     * Translate the HTML document specified by its URL.
     * 
     * @param sourceUrl Source document URL. (required)
     * @param srcLang Source language. (required)
     * @param resLang Result language. (required)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<File> GetTranslateDocumentByUrlWithHttpInfo(String sourceUrl, String srcLang, String resLang) throws ApiException {
        com.squareup.okhttp.Call call = GetTranslateDocumentByUrlValidateBeforeCall(sourceUrl, srcLang, resLang, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Translate the HTML document specified by its URL. (asynchronously)
     * 
     * @param sourceUrl Source document URL. (required)
     * @param srcLang Source language. (required)
     * @param resLang Result language. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call GetTranslateDocumentByUrlAsync(String sourceUrl, String srcLang, String resLang, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = GetTranslateDocumentByUrlValidateBeforeCall(sourceUrl, srcLang, resLang, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
