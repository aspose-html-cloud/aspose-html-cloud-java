/**
 * --------------------------------------------------------------------------------------------------------------------
 * <copyright company="Aspose" file="ConversionApi.java">
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

public class ConversionApi {
    private ApiClient apiClient;

    public ConversionApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ConversionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for GetConvertDocumentToImage
     * @param name Document name. (required)
     * @param outFormat Resulting image format. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param xResolution Horizontal resolution of resulting image. (optional)
     * @param yResolution Vertical resolution of resulting image. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call GetConvertDocumentToImageCall(String name, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer xResolution, Integer yResolution, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/{name}/convert/image/{outFormat}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()))
            .replaceAll("\\{" + "outFormat" + "\\}", apiClient.escapeString(outFormat.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (width != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("width", width));
        if (height != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("height", height));
        if (leftMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("leftMargin", leftMargin));
        if (rightMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("rightMargin", rightMargin));
        if (topMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("topMargin", topMargin));
        if (bottomMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("bottomMargin", bottomMargin));
        if (xResolution != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("xResolution", xResolution));
        if (yResolution != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("yResolution", yResolution));
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

    private com.squareup.okhttp.Call GetConvertDocumentToImageValidateBeforeCall(String name, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer xResolution, Integer yResolution, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling GetConvertDocumentToImage(Async)");
        }
        
        // verify the required parameter 'outFormat' is set
        if (outFormat == null) {
            throw new ApiException("Missing the required parameter 'outFormat' when calling GetConvertDocumentToImage(Async)");
        }
        

        com.squareup.okhttp.Call call = GetConvertDocumentToImageCall(name, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, xResolution, yResolution, folder, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Convert the HTML document from the storage by its name to the specified image format.
     * 
     * @param name Document name. (required)
     * @param outFormat Resulting image format. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param xResolution Horizontal resolution of resulting image. (optional)
     * @param yResolution Vertical resolution of resulting image. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File GetConvertDocumentToImage(String name, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer xResolution, Integer yResolution, String folder, String storage) throws ApiException {
        ApiResponse<File> resp = GetConvertDocumentToImageWithHttpInfo(name, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, xResolution, yResolution, folder, storage);
        return resp.getData();
    }

    /**
     * Convert the HTML document from the storage by its name to the specified image format.
     * 
     * @param name Document name. (required)
     * @param outFormat Resulting image format. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param xResolution Horizontal resolution of resulting image. (optional)
     * @param yResolution Vertical resolution of resulting image. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> GetConvertDocumentToImageWithHttpInfo(String name, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer xResolution, Integer yResolution, String folder, String storage) throws ApiException {
        com.squareup.okhttp.Call call = GetConvertDocumentToImageValidateBeforeCall(name, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, xResolution, yResolution, folder, storage, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Convert the HTML document from the storage by its name to the specified image format. (asynchronously)
     * 
     * @param name Document name. (required)
     * @param outFormat Resulting image format. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param xResolution Horizontal resolution of resulting image. (optional)
     * @param yResolution Vertical resolution of resulting image. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call GetConvertDocumentToImageAsync(String name, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer xResolution, Integer yResolution, String folder, String storage, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = GetConvertDocumentToImageValidateBeforeCall(name, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, xResolution, yResolution, folder, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for GetConvertDocumentToImageByUrl
     * @param sourceUrl Source page URL. (required)
     * @param outFormat Resulting image format. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param xResolution Horizontal resolution of resulting image. (optional)
     * @param yResolution Vertical resolution of resulting image. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call GetConvertDocumentToImageByUrlCall(String sourceUrl, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer xResolution, Integer yResolution, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/convert/image/{outFormat}"
            .replaceAll("\\{" + "outFormat" + "\\}", apiClient.escapeString(outFormat.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (sourceUrl != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sourceUrl", sourceUrl));
        if (width != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("width", width));
        if (height != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("height", height));
        if (leftMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("leftMargin", leftMargin));
        if (rightMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("rightMargin", rightMargin));
        if (topMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("topMargin", topMargin));
        if (bottomMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("bottomMargin", bottomMargin));
        if (xResolution != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("xResolution", xResolution));
        if (yResolution != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("yResolution", yResolution));
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

    private com.squareup.okhttp.Call GetConvertDocumentToImageByUrlValidateBeforeCall(String sourceUrl, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer xResolution, Integer yResolution, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'sourceUrl' is set
        if (sourceUrl == null) {
            throw new ApiException("Missing the required parameter 'sourceUrl' when calling GetConvertDocumentToImageByUrl(Async)");
        }
        
        // verify the required parameter 'outFormat' is set
        if (outFormat == null) {
            throw new ApiException("Missing the required parameter 'outFormat' when calling GetConvertDocumentToImageByUrl(Async)");
        }
        

        com.squareup.okhttp.Call call = GetConvertDocumentToImageByUrlCall(sourceUrl, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, xResolution, yResolution, folder, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Convert the HTML page from the web by its URL to the specified image format.
     * 
     * @param sourceUrl Source page URL. (required)
     * @param outFormat Resulting image format. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param xResolution Horizontal resolution of resulting image. (optional)
     * @param yResolution Vertical resolution of resulting image. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File GetConvertDocumentToImageByUrl(String sourceUrl, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer xResolution, Integer yResolution, String folder, String storage) throws ApiException {
        ApiResponse<File> resp = GetConvertDocumentToImageByUrlWithHttpInfo(sourceUrl, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, xResolution, yResolution, folder, storage);
        return resp.getData();
    }

    /**
     * Convert the HTML page from the web by its URL to the specified image format.
     * 
     * @param sourceUrl Source page URL. (required)
     * @param outFormat Resulting image format. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param xResolution Horizontal resolution of resulting image. (optional)
     * @param yResolution Vertical resolution of resulting image. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> GetConvertDocumentToImageByUrlWithHttpInfo(String sourceUrl, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer xResolution, Integer yResolution, String folder, String storage) throws ApiException {
        com.squareup.okhttp.Call call = GetConvertDocumentToImageByUrlValidateBeforeCall(sourceUrl, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, xResolution, yResolution, folder, storage, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Convert the HTML page from the web by its URL to the specified image format. (asynchronously)
     * 
     * @param sourceUrl Source page URL. (required)
     * @param outFormat Resulting image format. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param xResolution Horizontal resolution of resulting image. (optional)
     * @param yResolution Vertical resolution of resulting image. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call GetConvertDocumentToImageByUrlAsync(String sourceUrl, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer xResolution, Integer yResolution, String folder, String storage, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = GetConvertDocumentToImageByUrlValidateBeforeCall(sourceUrl, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, xResolution, yResolution, folder, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for GetConvertDocumentToPdf
     * @param name Document name. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call GetConvertDocumentToPdfCall(String name, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/{name}/convert/pdf"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (width != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("width", width));
        if (height != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("height", height));
        if (leftMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("leftMargin", leftMargin));
        if (rightMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("rightMargin", rightMargin));
        if (topMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("topMargin", topMargin));
        if (bottomMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("bottomMargin", bottomMargin));
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

    private com.squareup.okhttp.Call GetConvertDocumentToPdfValidateBeforeCall(String name, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling GetConvertDocumentToPdf(Async)");
        }
        

        com.squareup.okhttp.Call call = GetConvertDocumentToPdfCall(name, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Convert the HTML document from the storage by its name to PDF.
     * 
     * @param name Document name. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File GetConvertDocumentToPdf(String name, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage) throws ApiException {
        ApiResponse<File> resp = GetConvertDocumentToPdfWithHttpInfo(name, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage);
        return resp.getData();
    }

    /**
     * Convert the HTML document from the storage by its name to PDF.
     * 
     * @param name Document name. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> GetConvertDocumentToPdfWithHttpInfo(String name, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage) throws ApiException {
        com.squareup.okhttp.Call call = GetConvertDocumentToPdfValidateBeforeCall(name, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Convert the HTML document from the storage by its name to PDF. (asynchronously)
     * 
     * @param name Document name. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call GetConvertDocumentToPdfAsync(String name, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = GetConvertDocumentToPdfValidateBeforeCall(name, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for GetConvertDocumentToPdfByUrl
     * @param sourceUrl Source page URL. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call GetConvertDocumentToPdfByUrlCall(String sourceUrl, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/convert/pdf";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (sourceUrl != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sourceUrl", sourceUrl));
        if (width != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("width", width));
        if (height != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("height", height));
        if (leftMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("leftMargin", leftMargin));
        if (rightMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("rightMargin", rightMargin));
        if (topMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("topMargin", topMargin));
        if (bottomMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("bottomMargin", bottomMargin));
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

    private com.squareup.okhttp.Call GetConvertDocumentToPdfByUrlValidateBeforeCall(String sourceUrl, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'sourceUrl' is set
        if (sourceUrl == null) {
            throw new ApiException("Missing the required parameter 'sourceUrl' when calling GetConvertDocumentToPdfByUrl(Async)");
        }
        

        com.squareup.okhttp.Call call = GetConvertDocumentToPdfByUrlCall(sourceUrl, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Convert the HTML page from the web by its URL to PDF.
     * 
     * @param sourceUrl Source page URL. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File GetConvertDocumentToPdfByUrl(String sourceUrl, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage) throws ApiException {
        ApiResponse<File> resp = GetConvertDocumentToPdfByUrlWithHttpInfo(sourceUrl, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage);
        return resp.getData();
    }

    /**
     * Convert the HTML page from the web by its URL to PDF.
     * 
     * @param sourceUrl Source page URL. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> GetConvertDocumentToPdfByUrlWithHttpInfo(String sourceUrl, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage) throws ApiException {
        com.squareup.okhttp.Call call = GetConvertDocumentToPdfByUrlValidateBeforeCall(sourceUrl, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Convert the HTML page from the web by its URL to PDF. (asynchronously)
     * 
     * @param sourceUrl Source page URL. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call GetConvertDocumentToPdfByUrlAsync(String sourceUrl, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = GetConvertDocumentToPdfByUrlValidateBeforeCall(sourceUrl, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for GetConvertDocumentToXps
     * @param name Document name. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call GetConvertDocumentToXpsCall(String name, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/{name}/convert/xps"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (width != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("width", width));
        if (height != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("height", height));
        if (leftMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("leftMargin", leftMargin));
        if (rightMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("rightMargin", rightMargin));
        if (topMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("topMargin", topMargin));
        if (bottomMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("bottomMargin", bottomMargin));
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

    private com.squareup.okhttp.Call GetConvertDocumentToXpsValidateBeforeCall(String name, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling GetConvertDocumentToXps(Async)");
        }
        

        com.squareup.okhttp.Call call = GetConvertDocumentToXpsCall(name, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Convert the HTML document from the storage by its name to XPS.
     * 
     * @param name Document name. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File GetConvertDocumentToXps(String name, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage) throws ApiException {
        ApiResponse<File> resp = GetConvertDocumentToXpsWithHttpInfo(name, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage);
        return resp.getData();
    }

    /**
     * Convert the HTML document from the storage by its name to XPS.
     * 
     * @param name Document name. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> GetConvertDocumentToXpsWithHttpInfo(String name, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage) throws ApiException {
        com.squareup.okhttp.Call call = GetConvertDocumentToXpsValidateBeforeCall(name, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Convert the HTML document from the storage by its name to XPS. (asynchronously)
     * 
     * @param name Document name. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call GetConvertDocumentToXpsAsync(String name, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = GetConvertDocumentToXpsValidateBeforeCall(name, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for GetConvertDocumentToXpsByUrl
     * @param sourceUrl Source page URL. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call GetConvertDocumentToXpsByUrlCall(String sourceUrl, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/convert/xps";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (sourceUrl != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sourceUrl", sourceUrl));
        if (width != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("width", width));
        if (height != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("height", height));
        if (leftMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("leftMargin", leftMargin));
        if (rightMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("rightMargin", rightMargin));
        if (topMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("topMargin", topMargin));
        if (bottomMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("bottomMargin", bottomMargin));
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

    private com.squareup.okhttp.Call GetConvertDocumentToXpsByUrlValidateBeforeCall(String sourceUrl, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'sourceUrl' is set
        if (sourceUrl == null) {
            throw new ApiException("Missing the required parameter 'sourceUrl' when calling GetConvertDocumentToXpsByUrl(Async)");
        }
        

        com.squareup.okhttp.Call call = GetConvertDocumentToXpsByUrlCall(sourceUrl, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Convert the HTML page from the web by its URL to XPS.
     * 
     * @param sourceUrl Source page URL. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File GetConvertDocumentToXpsByUrl(String sourceUrl, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage) throws ApiException {
        ApiResponse<File> resp = GetConvertDocumentToXpsByUrlWithHttpInfo(sourceUrl, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage);
        return resp.getData();
    }

    /**
     * Convert the HTML page from the web by its URL to XPS.
     * 
     * @param sourceUrl Source page URL. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> GetConvertDocumentToXpsByUrlWithHttpInfo(String sourceUrl, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage) throws ApiException {
        com.squareup.okhttp.Call call = GetConvertDocumentToXpsByUrlValidateBeforeCall(sourceUrl, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Convert the HTML page from the web by its URL to XPS. (asynchronously)
     * 
     * @param sourceUrl Source page URL. (required)
     * @param width Resulting image width.  (optional)
     * @param height Resulting image height.  (optional)
     * @param leftMargin Left resulting image margin. (optional)
     * @param rightMargin Right resulting image margin. (optional)
     * @param topMargin Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder The document folder. (optional)
     * @param storage The document storage. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call GetConvertDocumentToXpsByUrlAsync(String sourceUrl, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = GetConvertDocumentToXpsByUrlValidateBeforeCall(sourceUrl, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    
    /**
     * Build call for PutConvertDocumentInRequestToImage
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.jpg) (required)
     * @param outFormat  (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param resolution Resolution of resulting image. Default is 96 dpi. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call PutConvertDocumentInRequestToImageCall(String outPath, String outFormat, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer resolution, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
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
        String localVarPath = "/html/convert/image/{outFormat}"
            .replaceAll("\\{" + "outFormat" + "\\}", apiClient.escapeString(outFormat.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (outPath != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("outPath", outPath));
        if (width != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("width", width));
        if (height != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("height", height));
        if (leftMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("leftMargin", leftMargin));
        if (rightMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("rightMargin", rightMargin));
        if (topMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("topMargin", topMargin));
        if (bottomMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("bottomMargin", bottomMargin));
        if (resolution != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("resolution", resolution));

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
                "application/octet-stream"
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
    private com.squareup.okhttp.Call PutConvertDocumentInRequestToImageValidateBeforeCall(String outPath, String outFormat, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer resolution, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'outPath' is set
        if (outPath == null) {
            throw new ApiException("Missing the required parameter 'outPath' when calling PutConvertDocumentInRequestToImage(Async)");
        }
        
        // verify the required parameter 'outFormat' is set
        if (outFormat == null) {
            throw new ApiException("Missing the required parameter 'outFormat' when calling PutConvertDocumentInRequestToImage(Async)");
        }
        
        // verify the required parameter 'file' is set
        if (file == null) {
            throw new ApiException("Missing the required parameter 'file' when calling PutConvertDocumentInRequestToImage(Async)");
        }
        

        com.squareup.okhttp.Call call = PutConvertDocumentInRequestToImageCall(outPath, outFormat, file, width, height, leftMargin, rightMargin, topMargin, bottomMargin, resolution, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Converts the HTML document (in request content) to the specified image format and uploads resulting file to storage.
     * 
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.jpg) (required)
     * @param outFormat  (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param resolution Resolution of resulting image. Default is 96 dpi. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File PutConvertDocumentInRequestToImage(String outPath, String outFormat, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer resolution) throws ApiException {
        ApiResponse<File> resp = PutConvertDocumentInRequestToImageWithHttpInfo(outPath, outFormat, file, width, height, leftMargin, rightMargin, topMargin, bottomMargin, resolution);
        return resp.getData();
    }

    /**
     * Converts the HTML document (in request content) to the specified image format and uploads resulting file to storage.
     * 
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.jpg) (required)
     * @param outFormat  (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param resolution Resolution of resulting image. Default is 96 dpi. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> PutConvertDocumentInRequestToImageWithHttpInfo(String outPath, String outFormat, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer resolution) throws ApiException {
        com.squareup.okhttp.Call call = PutConvertDocumentInRequestToImageValidateBeforeCall(outPath, outFormat, file, width, height, leftMargin, rightMargin, topMargin, bottomMargin, resolution, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Converts the HTML document (in request content) to the specified image format and uploads resulting file to storage. (asynchronously)
     * 
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.jpg) (required)
     * @param outFormat  (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param resolution Resolution of resulting image. Default is 96 dpi. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call PutConvertDocumentInRequestToImageAsync(String outPath, String outFormat, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer resolution, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = PutConvertDocumentInRequestToImageValidateBeforeCall(outPath, outFormat, file, width, height, leftMargin, rightMargin, topMargin, bottomMargin, resolution, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for PutConvertDocumentInRequestToPdf
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.pdf) (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call PutConvertDocumentInRequestToPdfCall(String outPath, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
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
        String localVarPath = "/html/convert/pdf";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (outPath != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("outPath", outPath));
        if (width != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("width", width));
        if (height != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("height", height));
        if (leftMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("leftMargin", leftMargin));
        if (rightMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("rightMargin", rightMargin));
        if (topMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("topMargin", topMargin));
        if (bottomMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("bottomMargin", bottomMargin));

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
                "application/octet-stream"
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
    private com.squareup.okhttp.Call PutConvertDocumentInRequestToPdfValidateBeforeCall(String outPath, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'outPath' is set
        if (outPath == null) {
            throw new ApiException("Missing the required parameter 'outPath' when calling PutConvertDocumentInRequestToPdf(Async)");
        }
        
        // verify the required parameter 'file' is set
        if (file == null) {
            throw new ApiException("Missing the required parameter 'file' when calling PutConvertDocumentInRequestToPdf(Async)");
        }
        

        com.squareup.okhttp.Call call = PutConvertDocumentInRequestToPdfCall(outPath, file, width, height, leftMargin, rightMargin, topMargin, bottomMargin, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Converts the HTML document (in request content) to PDF and uploads resulting file to storage.
     * 
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.pdf) (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File PutConvertDocumentInRequestToPdf(String outPath, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin) throws ApiException {
        ApiResponse<File> resp = PutConvertDocumentInRequestToPdfWithHttpInfo(outPath, file, width, height, leftMargin, rightMargin, topMargin, bottomMargin);
        return resp.getData();
    }

    /**
     * Converts the HTML document (in request content) to PDF and uploads resulting file to storage.
     * 
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.pdf) (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> PutConvertDocumentInRequestToPdfWithHttpInfo(String outPath, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin) throws ApiException {
        com.squareup.okhttp.Call call = PutConvertDocumentInRequestToPdfValidateBeforeCall(outPath, file, width, height, leftMargin, rightMargin, topMargin, bottomMargin, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Converts the HTML document (in request content) to PDF and uploads resulting file to storage. (asynchronously)
     * 
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.pdf) (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call PutConvertDocumentInRequestToPdfAsync(String outPath, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = PutConvertDocumentInRequestToPdfValidateBeforeCall(outPath, file, width, height, leftMargin, rightMargin, topMargin, bottomMargin, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for PutConvertDocumentInRequestToXps
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.xps) (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call PutConvertDocumentInRequestToXpsCall(String outPath, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
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
        String localVarPath = "/html/convert/xps";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (outPath != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("outPath", outPath));
        if (width != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("width", width));
        if (height != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("height", height));
        if (leftMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("leftMargin", leftMargin));
        if (rightMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("rightMargin", rightMargin));
        if (topMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("topMargin", topMargin));
        if (bottomMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("bottomMargin", bottomMargin));

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
                "application/octet-stream"
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
    private com.squareup.okhttp.Call PutConvertDocumentInRequestToXpsValidateBeforeCall(String outPath, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'outPath' is set
        if (outPath == null) {
            throw new ApiException("Missing the required parameter 'outPath' when calling PutConvertDocumentInRequestToXps(Async)");
        }
        
        // verify the required parameter 'file' is set
        if (file == null) {
            throw new ApiException("Missing the required parameter 'file' when calling PutConvertDocumentInRequestToXps(Async)");
        }
        

        com.squareup.okhttp.Call call = PutConvertDocumentInRequestToXpsCall(outPath, file, width, height, leftMargin, rightMargin, topMargin, bottomMargin, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Converts the HTML document (in request content) to XPS and uploads resulting file to storage.
     * 
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.xps) (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File PutConvertDocumentInRequestToXps(String outPath, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin) throws ApiException {
        ApiResponse<File> resp = PutConvertDocumentInRequestToXpsWithHttpInfo(outPath, file, width, height, leftMargin, rightMargin, topMargin, bottomMargin);
        return resp.getData();
    }

    /**
     * Converts the HTML document (in request content) to XPS and uploads resulting file to storage.
     * 
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.xps) (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> PutConvertDocumentInRequestToXpsWithHttpInfo(String outPath, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin) throws ApiException {
        com.squareup.okhttp.Call call = PutConvertDocumentInRequestToXpsValidateBeforeCall(outPath, file, width, height, leftMargin, rightMargin, topMargin, bottomMargin, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Converts the HTML document (in request content) to XPS and uploads resulting file to storage. (asynchronously)
     * 
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.xps) (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call PutConvertDocumentInRequestToXpsAsync(String outPath, File file, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = PutConvertDocumentInRequestToXpsValidateBeforeCall(outPath, file, width, height, leftMargin, rightMargin, topMargin, bottomMargin, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for PutConvertDocumentToImage
     * @param name Document name. (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.jpg) (required)
     * @param outFormat  (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param resolution Resolution of resulting image. Default is 96 dpi. (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call PutConvertDocumentToImageCall(String name, String outPath, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer resolution, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/{name}/convert/image/{outFormat}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()))
            .replaceAll("\\{" + "outFormat" + "\\}", apiClient.escapeString(outFormat.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (outPath != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("outPath", outPath));
        if (width != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("width", width));
        if (height != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("height", height));
        if (leftMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("leftMargin", leftMargin));
        if (rightMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("rightMargin", rightMargin));
        if (topMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("topMargin", topMargin));
        if (bottomMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("bottomMargin", bottomMargin));
        if (resolution != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("resolution", resolution));
        if (folder != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("folder", folder));
        if (storage != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("storage", storage));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call PutConvertDocumentToImageValidateBeforeCall(String name, String outPath, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer resolution, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling PutConvertDocumentToImage(Async)");
        }
        
        // verify the required parameter 'outPath' is set
        if (outPath == null) {
            throw new ApiException("Missing the required parameter 'outPath' when calling PutConvertDocumentToImage(Async)");
        }
        
        // verify the required parameter 'outFormat' is set
        if (outFormat == null) {
            throw new ApiException("Missing the required parameter 'outFormat' when calling PutConvertDocumentToImage(Async)");
        }
        

        com.squareup.okhttp.Call call = PutConvertDocumentToImageCall(name, outPath, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, resolution, folder, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Converts the HTML document (located on storage) to the specified image format and uploads resulting file to storage.
     * 
     * @param name Document name. (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.jpg) (required)
     * @param outFormat  (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param resolution Resolution of resulting image. Default is 96 dpi. (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File PutConvertDocumentToImage(String name, String outPath, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer resolution, String folder, String storage) throws ApiException {
        ApiResponse<File> resp = PutConvertDocumentToImageWithHttpInfo(name, outPath, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, resolution, folder, storage);
        return resp.getData();
    }

    /**
     * Converts the HTML document (located on storage) to the specified image format and uploads resulting file to storage.
     * 
     * @param name Document name. (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.jpg) (required)
     * @param outFormat  (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param resolution Resolution of resulting image. Default is 96 dpi. (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> PutConvertDocumentToImageWithHttpInfo(String name, String outPath, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer resolution, String folder, String storage) throws ApiException {
        com.squareup.okhttp.Call call = PutConvertDocumentToImageValidateBeforeCall(name, outPath, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, resolution, folder, storage, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Converts the HTML document (located on storage) to the specified image format and uploads resulting file to storage. (asynchronously)
     * 
     * @param name Document name. (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.jpg) (required)
     * @param outFormat  (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param resolution Resolution of resulting image. Default is 96 dpi. (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call PutConvertDocumentToImageAsync(String name, String outPath, String outFormat, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, Integer resolution, String folder, String storage, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = PutConvertDocumentToImageValidateBeforeCall(name, outPath, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, resolution, folder, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for PutConvertDocumentToPdf
     * @param name Document name. (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.pdf) (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call PutConvertDocumentToPdfCall(String name, String outPath, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/{name}/convert/pdf"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (outPath != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("outPath", outPath));
        if (width != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("width", width));
        if (height != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("height", height));
        if (leftMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("leftMargin", leftMargin));
        if (rightMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("rightMargin", rightMargin));
        if (topMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("topMargin", topMargin));
        if (bottomMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("bottomMargin", bottomMargin));
        if (folder != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("folder", folder));
        if (storage != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("storage", storage));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call PutConvertDocumentToPdfValidateBeforeCall(String name, String outPath, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling PutConvertDocumentToPdf(Async)");
        }
        
        // verify the required parameter 'outPath' is set
        if (outPath == null) {
            throw new ApiException("Missing the required parameter 'outPath' when calling PutConvertDocumentToPdf(Async)");
        }
        

        com.squareup.okhttp.Call call = PutConvertDocumentToPdfCall(name, outPath, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Converts the HTML document (located on storage) to PDF and uploads resulting file to storage.
     * 
     * @param name Document name. (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.pdf) (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File PutConvertDocumentToPdf(String name, String outPath, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage) throws ApiException {
        ApiResponse<File> resp = PutConvertDocumentToPdfWithHttpInfo(name, outPath, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage);
        return resp.getData();
    }

    /**
     * Converts the HTML document (located on storage) to PDF and uploads resulting file to storage.
     * 
     * @param name Document name. (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.pdf) (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> PutConvertDocumentToPdfWithHttpInfo(String name, String outPath, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage) throws ApiException {
        com.squareup.okhttp.Call call = PutConvertDocumentToPdfValidateBeforeCall(name, outPath, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Converts the HTML document (located on storage) to PDF and uploads resulting file to storage. (asynchronously)
     * 
     * @param name Document name. (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.pdf) (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call PutConvertDocumentToPdfAsync(String name, String outPath, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = PutConvertDocumentToPdfValidateBeforeCall(name, outPath, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for PutConvertDocumentToXps
     * @param name Document name. (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.xps) (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call PutConvertDocumentToXpsCall(String name, String outPath, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/{name}/convert/xps"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (outPath != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("outPath", outPath));
        if (width != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("width", width));
        if (height != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("height", height));
        if (leftMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("leftMargin", leftMargin));
        if (rightMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("rightMargin", rightMargin));
        if (topMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("topMargin", topMargin));
        if (bottomMargin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("bottomMargin", bottomMargin));
        if (folder != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("folder", folder));
        if (storage != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("storage", storage));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call PutConvertDocumentToXpsValidateBeforeCall(String name, String outPath, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling PutConvertDocumentToXps(Async)");
        }
        
        // verify the required parameter 'outPath' is set
        if (outPath == null) {
            throw new ApiException("Missing the required parameter 'outPath' when calling PutConvertDocumentToXps(Async)");
        }
        

        com.squareup.okhttp.Call call = PutConvertDocumentToXpsCall(name, outPath, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Converts the HTML document (located on storage) to XPS and uploads resulting file to storage.
     * 
     * @param name Document name. (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.xps) (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File PutConvertDocumentToXps(String name, String outPath, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage) throws ApiException {
        ApiResponse<File> resp = PutConvertDocumentToXpsWithHttpInfo(name, outPath, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage);
        return resp.getData();
    }

    /**
     * Converts the HTML document (located on storage) to XPS and uploads resulting file to storage.
     * 
     * @param name Document name. (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.xps) (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> PutConvertDocumentToXpsWithHttpInfo(String name, String outPath, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage) throws ApiException {
        com.squareup.okhttp.Call call = PutConvertDocumentToXpsValidateBeforeCall(name, outPath, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Converts the HTML document (located on storage) to XPS and uploads resulting file to storage. (asynchronously)
     * 
     * @param name Document name. (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.xps) (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call PutConvertDocumentToXpsAsync(String name, String outPath, Integer width, Integer height, Integer leftMargin, Integer rightMargin, Integer topMargin, Integer bottomMargin, String folder, String storage, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = PutConvertDocumentToXpsValidateBeforeCall(name, outPath, width, height, leftMargin, rightMargin, topMargin, bottomMargin, folder, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    
}
