/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="TemplateMergeApi.java">
*   Copyright (c) 2018 Aspose.HTML for Cloud
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

import com.aspose.html.client.ApiCallback;
import com.aspose.html.client.ApiClient;
import com.aspose.html.client.ApiException;
import com.aspose.html.client.ApiResponse;
import com.aspose.html.client.Configuration;
import com.aspose.html.client.Pair;
import com.aspose.html.client.ProgressRequestBody;
import com.aspose.html.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateMergeApi {
    private ApiClient apiClient;

    public TemplateMergeApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TemplateMergeApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for GetMergeHtmlTemplate
     * @param templateName Template document name. Template document is HTML or zipped HTML. (required)
     * @param dataPath Data source file path in the storage. Supported data format: XML (required)
     * @param options Template merge options: reserved for further implementation. (optional)
     * @param folder The template document folder. (optional)
     * @param storage The template document and data source storage. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call GetMergeHtmlTemplateCall(String templateName, String dataPath, String options, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/{templateName}/merge"
            .replaceAll("\\{" + "templateName" + "\\}", apiClient.escapeString(templateName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (dataPath != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("dataPath", dataPath));
        if (options != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("options", options));
        if (folder != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("folder", folder));
        if (storage != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("storage", storage));

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
    private com.squareup.okhttp.Call GetMergeHtmlTemplateValidateBeforeCall(String templateName, String dataPath, String options, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'templateName' is set
        if (templateName == null) {
            throw new ApiException("Missing the required parameter 'templateName' when calling GetMergeHtmlTemplate(Async)");
        }
        
        // verify the required parameter 'dataPath' is set
        if (dataPath == null) {
            throw new ApiException("Missing the required parameter 'dataPath' when calling GetMergeHtmlTemplate(Async)");
        }
        

        com.squareup.okhttp.Call call = GetMergeHtmlTemplateCall(templateName, dataPath, options, folder, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Populate HTML document template with data located as a file in the storage.
     * 
     * @param templateName Template document name. Template document is HTML or zipped HTML. (required)
     * @param dataPath Data source file path in the storage. Supported data format: XML (required)
     * @param options Template merge options: reserved for further implementation. (optional)
     * @param folder The template document folder. (optional)
     * @param storage The template document and data source storage. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File GetMergeHtmlTemplate(String templateName, String dataPath, String options, String folder, String storage) throws ApiException {
        ApiResponse<File> resp = GetMergeHtmlTemplateWithHttpInfo(templateName, dataPath, options, folder, storage);
        return resp.getData();
    }

    /**
     * Populate HTML document template with data located as a file in the storage.
     * 
     * @param templateName Template document name. Template document is HTML or zipped HTML. (required)
     * @param dataPath Data source file path in the storage. Supported data format: XML (required)
     * @param options Template merge options: reserved for further implementation. (optional)
     * @param folder The template document folder. (optional)
     * @param storage The template document and data source storage. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> GetMergeHtmlTemplateWithHttpInfo(String templateName, String dataPath, String options, String folder, String storage) throws ApiException {
        com.squareup.okhttp.Call call = GetMergeHtmlTemplateValidateBeforeCall(templateName, dataPath, options, folder, storage, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Populate HTML document template with data located as a file in the storage. (asynchronously)
     * 
     * @param templateName Template document name. Template document is HTML or zipped HTML. (required)
     * @param dataPath Data source file path in the storage. Supported data format: XML (required)
     * @param options Template merge options: reserved for further implementation. (optional)
     * @param folder The template document folder. (optional)
     * @param storage The template document and data source storage. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call GetMergeHtmlTemplateAsync(String templateName, String dataPath, String options, String folder, String storage, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = GetMergeHtmlTemplateValidateBeforeCall(templateName, dataPath, options, folder, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for PutMergeHtmlTemplate
     * @param templateName Template document name. Template document is HTML or zipped HTML. (required)
     * @param outPath Result document path. (required)
     * @param file A data file to populate template. (required)
     * @param options Template merge options: reserved for further implementation. (optional)
     * @param folder The template document folder. (optional)
     * @param storage The template document and data source storage. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call PutMergeHtmlTemplateCall(String templateName, String outPath, File file, String options, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

    	try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            localVarPostBody = bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        // create path and map variables
        String localVarPath = "/html/{templateName}/merge"
            .replaceAll("\\{" + "templateName" + "\\}", apiClient.escapeString(templateName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (outPath != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("outPath", outPath));
        if (options != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("options", options));
        if (folder != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("folder", folder));
        if (storage != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("storage", storage));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
//        if (file != null)
//        localVarFormParams.put("file", file);

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "application/xml", "multipart/form-data"
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call PutMergeHtmlTemplateValidateBeforeCall(String templateName, String outPath, File file, String options, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'templateName' is set
        if (templateName == null) {
            throw new ApiException("Missing the required parameter 'templateName' when calling PutMergeHtmlTemplate(Async)");
        }
        
        // verify the required parameter 'outPath' is set
        if (outPath == null) {
            throw new ApiException("Missing the required parameter 'outPath' when calling PutMergeHtmlTemplate(Async)");
        }
        
        // verify the required parameter 'file' is set
        if (file == null) {
            throw new ApiException("Missing the required parameter 'file' when calling PutMergeHtmlTemplate(Async)");
        }
        

        com.squareup.okhttp.Call call = PutMergeHtmlTemplateCall(templateName, outPath, file, options, folder, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Populate HTML document template with data from the request body. Result document will be saved to storage.
     * 
     * @param templateName Template document name. Template document is HTML or zipped HTML. (required)
     * @param outPath Result document path. (required)
     * @param file A data file to populate template. (required)
     * @param options Template merge options: reserved for further implementation. (optional)
     * @param folder The template document folder. (optional)
     * @param storage The template document and data source storage. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File PutMergeHtmlTemplate(String templateName, String outPath, File file, String options, String folder, String storage) throws ApiException {
        ApiResponse<File> resp = PutMergeHtmlTemplateWithHttpInfo(templateName, outPath, file, options, folder, storage);
        return resp.getData();
    }

    /**
     * Populate HTML document template with data from the request body. Result document will be saved to storage.
     * 
     * @param templateName Template document name. Template document is HTML or zipped HTML. (required)
     * @param outPath Result document path. (required)
     * @param file A data file to populate template. (required)
     * @param options Template merge options: reserved for further implementation. (optional)
     * @param folder The template document folder. (optional)
     * @param storage The template document and data source storage. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> PutMergeHtmlTemplateWithHttpInfo(String templateName, String outPath, File file, String options, String folder, String storage) throws ApiException {
        com.squareup.okhttp.Call call = PutMergeHtmlTemplateValidateBeforeCall(templateName, outPath, file, options, folder, storage, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Populate HTML document template with data from the request body. Result document will be saved to storage. (asynchronously)
     * 
     * @param templateName Template document name. Template document is HTML or zipped HTML. (required)
     * @param outPath Result document path. (required)
     * @param file A data file to populate template. (required)
     * @param options Template merge options: reserved for further implementation. (optional)
     * @param folder The template document folder. (optional)
     * @param storage The template document and data source storage. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call PutMergeHtmlTemplateAsync(String templateName, String outPath, File file, String options, String folder, String storage, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = PutMergeHtmlTemplateValidateBeforeCall(templateName, outPath, file, options, folder, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
