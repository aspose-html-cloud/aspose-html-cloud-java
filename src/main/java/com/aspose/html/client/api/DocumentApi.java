/**
 * --------------------------------------------------------------------------------------------------------------------
 * <copyright company="Aspose" file="DocumentApi.java">
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

public class DocumentApi {
    private ApiClient apiClient;

    public DocumentApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DocumentApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for GetDocument
     * @param name The document name. (required)
     * @param storage The document folder (optional)
     * @param folder The document folder. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call GetDocumentCall(String name, String storage, String folder, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/{name}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (storage != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("storage", storage));
        if (folder != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("folder", folder));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "multipart/form-data", "application/zip"
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
    private com.squareup.okhttp.Call GetDocumentValidateBeforeCall(String name, String storage, String folder, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling GetDocument(Async)");
        }
        

        com.squareup.okhttp.Call call = GetDocumentCall(name, storage, folder, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Return the HTML document by the name from default or specified storage.
     * 
     * @param name The document name. (required)
     * @param storage The document folder (optional)
     * @param folder The document folder. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File GetDocument(String name, String storage, String folder) throws ApiException {
    	ApiResponse<File> resp = GetDocumentWithHttpInfo(name, storage, folder);
        return resp.getData();
    }

    /**
     * Return the HTML document by the name from default or specified storage.
     * 
     * @param name The document name. (required)
     * @param storage The document folder (optional)
     * @param folder The document folder. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<File> GetDocumentWithHttpInfo(String name, String storage, String folder) throws ApiException {
        com.squareup.okhttp.Call call = GetDocumentValidateBeforeCall(name, storage, folder, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Return the HTML document by the name from default or specified storage. (asynchronously)
     * 
     * @param name The document name. (required)
     * @param storage The document folder (optional)
     * @param folder The document folder. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call GetDocumentAsync(String name, String storage, String folder, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = GetDocumentValidateBeforeCall(name, storage, folder, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for GetDocumentFragmentByXPath
     * @param name The document name. (required)
     * @param xPath XPath query string. (required)
     * @param outFormat Output format. Possible values: &#39;plain&#39; and &#39;json&#39;. (required)
     * @param storage The document storage. (optional)
     * @param folder The document folder. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call GetDocumentFragmentByXPathCall(String name, String xPath, String outFormat, String storage, String folder, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/{name}/fragments/{outFormat}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()))
            .replaceAll("\\{" + "outFormat" + "\\}", apiClient.escapeString(outFormat.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (xPath != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("xPath", xPath));
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
    private com.squareup.okhttp.Call GetDocumentFragmentByXPathValidateBeforeCall(String name, String xPath, String outFormat, String storage, String folder, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling GetDocumentFragmentByXPath(Async)");
        }
        
        // verify the required parameter 'xPath' is set
        if (xPath == null) {
            throw new ApiException("Missing the required parameter 'xPath' when calling GetDocumentFragmentByXPath(Async)");
        }
        
        // verify the required parameter 'outFormat' is set
        if (outFormat == null) {
            throw new ApiException("Missing the required parameter 'outFormat' when calling GetDocumentFragmentByXPath(Async)");
        }
        

        com.squareup.okhttp.Call call = GetDocumentFragmentByXPathCall(name, xPath, outFormat, storage, folder, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Return list of HTML fragments matching the specified XPath query. 
     * 
     * @param name The document name. (required)
     * @param xPath XPath query string. (required)
     * @param outFormat Output format. Possible values: &#39;plain&#39; and &#39;json&#39;. (required)
     * @param storage The document storage. (optional)
     * @param folder The document folder. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File GetDocumentFragmentByXPath(String name, String xPath, String outFormat, String storage, String folder) throws ApiException {
        ApiResponse<File> resp = GetDocumentFragmentByXPathWithHttpInfo(name, xPath, outFormat, storage, folder);
        return resp.getData();
    }

    /**
     * Return list of HTML fragments matching the specified XPath query. 
     * 
     * @param name The document name. (required)
     * @param xPath XPath query string. (required)
     * @param outFormat Output format. Possible values: &#39;plain&#39; and &#39;json&#39;. (required)
     * @param storage The document storage. (optional)
     * @param folder The document folder. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<File> GetDocumentFragmentByXPathWithHttpInfo(String name, String xPath, String outFormat, String storage, String folder) throws ApiException {
        com.squareup.okhttp.Call call = GetDocumentFragmentByXPathValidateBeforeCall(name, xPath, outFormat, storage, folder, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Return list of HTML fragments matching the specified XPath query.  (asynchronously)
     * 
     * @param name The document name. (required)
     * @param xPath XPath query string. (required)
     * @param outFormat Output format. Possible values: &#39;plain&#39; and &#39;json&#39;. (required)
     * @param storage The document storage. (optional)
     * @param folder The document folder. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call GetDocumentFragmentByXPathAsync(String name, String xPath, String outFormat, String storage, String folder, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = GetDocumentFragmentByXPathValidateBeforeCall(name, xPath, outFormat, storage, folder, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for GetDocumentImages
     * @param name The document name. (required)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call GetDocumentImagesCall(String name, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/{name}/images/all"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (folder != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("folder", folder));
        if (storage != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("storage", storage));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/zip"
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
    private com.squareup.okhttp.Call GetDocumentImagesValidateBeforeCall(String name, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling GetDocumentImages(Async)");
        }
        

        com.squareup.okhttp.Call call = GetDocumentImagesCall(name, folder, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Return all HTML document images packaged as a ZIP archive.
     * 
     * @param name The document name. (required)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File GetDocumentImages(String name, String folder, String storage) throws ApiException {
        ApiResponse<File> resp = GetDocumentImagesWithHttpInfo(name, folder, storage);
        return resp.getData();
    }

    /**
     * Return all HTML document images packaged as a ZIP archive.
     * 
     * @param name The document name. (required)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<File> GetDocumentImagesWithHttpInfo(String name, String folder, String storage) throws ApiException {
        com.squareup.okhttp.Call call = GetDocumentImagesValidateBeforeCall(name, folder, storage, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Return all HTML document images packaged as a ZIP archive. (asynchronously)
     * 
     * @param name The document name. (required)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call GetDocumentImagesAsync(String name, String folder, String storage, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = GetDocumentImagesValidateBeforeCall(name, folder, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
