/**
 * --------------------------------------------------------------------------------------------------------------------
 * <copyright company="Aspose" file="OcrApi.java">
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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OcrApi {
    private ApiClient apiClient;

    public OcrApi() {
        this(Configuration.getDefaultApiClient());
    }

    public OcrApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for GetRecognizeAndImportToHtml
     * @param name The image file name(required). Acceptable image formats is jpg, gif, png, bmp, tiff.
     * @param ocrEngineLang OCR engine language - language  (optional, default to en). Allowed values is "en", "de", "fr", "ru".
     * @param folder The source image folder. (optional)
     * @param storage The source image storage. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call GetRecognizeAndImportToHtmlCall(String name, String ocrEngineLang, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/{name}/ocr/import"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (ocrEngineLang != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("ocrEngineLang", ocrEngineLang));
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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    private com.squareup.okhttp.Call GetRecognizeAndImportToHtmlValidateBeforeCall(String name, String ocrEngineLang, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling GetRecognizeAndImportToHtml(Async)");
        }
        

        com.squareup.okhttp.Call call = GetRecognizeAndImportToHtmlCall(name, ocrEngineLang, folder, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Recognize text from the image file in the storage and import it to HTML format.
     * 
     * @param name The image file name(required). Acceptable image formats is jpg, gif, png, bmp, tiff.
     * @param ocrEngineLang OCR engine language - language  (optional, default to en). Allowed values is "en", "de", "fr", "ru".
     * @param folder The source image folder. (optional)
     * @param storage The source image storage. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File GetRecognizeAndImportToHtml(String name, String ocrEngineLang, String folder, String storage) throws ApiException {
        ApiResponse<File> resp = GetRecognizeAndImportToHtmlWithHttpInfo(name, ocrEngineLang, folder, storage);
        return resp.getData();
    }

    /**
     * Recognize text from the image file in the storage and import it to HTML format.
     * 
     * @param name The image file name(required). Acceptable image formats is jpg, gif, png, bmp, tiff.
     * @param ocrEngineLang OCR engine language - language  (optional, default to en). Allowed values is "en", "de", "fr", "ru".
     * @param folder The source image folder. (optional)
     * @param storage The source image storage. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> GetRecognizeAndImportToHtmlWithHttpInfo(String name, String ocrEngineLang, String folder, String storage) throws ApiException {
        com.squareup.okhttp.Call call = GetRecognizeAndImportToHtmlValidateBeforeCall(name, ocrEngineLang, folder, storage, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Recognize text from the image file in the storage and import it to HTML format. (asynchronously)
     * 
     * @param name The image file name(required). Acceptable image formats is jpg, gif, png, bmp, tiff.
     * @param ocrEngineLang OCR engine language - language  (optional, default to en). Allowed values is "en", "de", "fr", "ru".
     * @param folder The source image folder. (optional)
     * @param storage The source image storage. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call GetRecognizeAndImportToHtmlAsync(String name, String ocrEngineLang, String folder, String storage, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = GetRecognizeAndImportToHtmlValidateBeforeCall(name, ocrEngineLang, folder, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for GetRecognizeAndTranslateToHtml
     * @param name The image file name(required). Acceptable image formats is jpg, gif, png, bmp, tiff.
     * @param srcLang Source language - also supposed as the OCR engine language (required). Allowed values is "en", "de", "fr", "ru".
     * @param resLang Result language. (required)
     * @param folder The source image folder. (optional)
     * @param storage The source image storage. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call GetRecognizeAndTranslateToHtmlCall(String name, String srcLang, String resLang, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/html/{name}/ocr/translate/{srcLang}/{resLang}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()))
            .replaceAll("\\{" + "srcLang" + "\\}", apiClient.escapeString(srcLang.toString()))
            .replaceAll("\\{" + "resLang" + "\\}", apiClient.escapeString(resLang.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    private com.squareup.okhttp.Call GetRecognizeAndTranslateToHtmlValidateBeforeCall(String name, String srcLang, String resLang, String folder, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling GetRecognizeAndTranslateToHtml(Async)");
        }
        
        // verify the required parameter 'srcLang' is set
        if (srcLang == null) {
            throw new ApiException("Missing the required parameter 'srcLang' when calling GetRecognizeAndTranslateToHtml(Async)");
        }
        
        // verify the required parameter 'resLang' is set
        if (resLang == null) {
            throw new ApiException("Missing the required parameter 'resLang' when calling GetRecognizeAndTranslateToHtml(Async)");
        }
        

        com.squareup.okhttp.Call call = GetRecognizeAndTranslateToHtmlCall(name, srcLang, resLang, folder, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Recognize text from the image file in the storage, import it to HTML format and translate to specified language.
     * 
     * @param name The image file name(required). Acceptable image formats is jpg, gif, png, bmp, tiff.
     * @param srcLang Source language - also supposed as the OCR engine language (required). Allowed values is "en", "de", "fr", "ru".
     * @param resLang Result language. (required)
     * @param folder The source image folder. (optional)
     * @param storage The source image storage. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File GetRecognizeAndTranslateToHtml(String name, String srcLang, String resLang, String folder, String storage) throws ApiException {
        ApiResponse<File> resp = GetRecognizeAndTranslateToHtmlWithHttpInfo(name, srcLang, resLang, folder, storage);
        return resp.getData();
    }

    /**
     * Recognize text from the image file in the storage, import it to HTML format and translate to specified language.
     * 
     * @param name The image file name(required). Acceptable image formats is jpg, gif, png, bmp, tiff.
     * @param srcLang Source language - also supposed as the OCR engine language (required). Allowed values is "en", "de", "fr", "ru".
     * @param resLang Result language. (required)
     * @param folder The source image folder. (optional)
     * @param storage The source image storage. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> GetRecognizeAndTranslateToHtmlWithHttpInfo(String name, String srcLang, String resLang, String folder, String storage) throws ApiException {
        com.squareup.okhttp.Call call = GetRecognizeAndTranslateToHtmlValidateBeforeCall(name, srcLang, resLang, folder, storage, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Recognize text from the image file in the storage, import it to HTML format and translate to specified language. (asynchronously)
     * 
     * @param name The image file name(required). Acceptable image formats is jpg, gif, png, bmp, tiff.
     * @param srcLang Source language - also supposed as the OCR engine language (required). Allowed values is "en", "de", "fr", "ru".
     * @param resLang Result language. (required)
     * @param folder The source image folder. (optional)
     * @param storage The source image storage. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call GetRecognizeAndTranslateToHtmlAsync(String name, String srcLang, String resLang, String folder, String storage, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = GetRecognizeAndTranslateToHtmlValidateBeforeCall(name, srcLang, resLang, folder, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
