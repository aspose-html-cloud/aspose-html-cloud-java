package com.aspose.html.api;

import com.aspose.html.model.DiscUsage;
import com.aspose.html.model.FileVersions;
import com.aspose.html.model.FilesList;
import com.aspose.html.model.FilesUploadResult;
import com.aspose.html.model.ObjectExist;
import com.aspose.html.model.StorageExist;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Aspose.HTML Cloud API Reference
 *
 * Storage API for manipulation with storage objects
 *
 */
public interface StorageApi  {

    // Storage API
    /**
     * Get disc usage
     *
     * @param storageName Storage name (optional)
     * @return Call &lt;DiscUsage&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("v4.0/html/storage/disc")
    Call<DiscUsage> getDiscUsage(
            @Query("storageName") String storageName
    );


    /**
     * Check if file or folder exists
     *
     * @param path File or folder path e.g. '/file.ext' or '/folder' (required)
     * @param storageName Storage name (optional)
     * @param versionId File version ID (optional)
     * @return Call &lt;ObjectExist&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("v4.0/html/storage/exist")
    Call<ObjectExist> objectExists(
            @Query("path") String path,
            @Query("storageName") String storageName,
            @Query("versionId") String versionId
    );

    /**
     * Check if storage exists
     *
     * @param storageName Storage name (required)
     * @return Call &lt;StorageExist&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("v4.0/html/storage/exist/storage")
    Call<StorageExist> storageExists(
            @Query("storageName") String storageName
    );

    // Folder API

    /**
     * Create the folder
     *
     * @param path Folder path to create e.g. 'folder_1/folder_2/' (required)
     * @param storageName Storage name (optional)
     * @return Call &lt;Void&gt;
     */
    @Headers({"Content-Type:application/json"})
    @POST("v4.0/html/folder")
    Call<Void> createFolder(
            @Query("path") String path,
            @Query("storageName") String storageName
    );


    /**
     * Get all files and folders within a folder
     *
     * @param path Folder path e.g. '/folder' (required)
     * @param storageName Storage name (optional)
     * @return Call &lt;FilesList&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("v4.0/html/folder")
    public Call<FilesList> getFilesList(
            @Query("path") String path,
            @Query("storageName")String storageName);


    /**
     * Delete folder
     *
     * @param path Folder path e.g. '/folder' (required)
     * @param storageName Storage name (optional)
     * @param recursive Enable to delete folders, subfolders and files (optional, default to false)
     * @return Call &lt;Void&gt;
     */
    @Headers({"Content-Type:application/json"})
    @DELETE("v4.0/html/folder/")
    Call<Void> deleteFolder(
            @Query("path") String path,
            @Query("storageName") String storageName,
            @Query("recursive") Boolean recursive

    );

    // File API

    /**
     * Download file
     *
     * @param path File path e.g. '/folder/file.ext' (required)
     * @param storageName Storage name (optional)
     * @param versionId File version ID to download (optional)
     * @return Call &lt;ResponseBody&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("v4.0/html/file")
    Call<ResponseBody> downloadFile(
            @Query("path") String path,
            @Query("storageName") String storageName,
            @Query("versionId") String versionId
    );

    /**
     * Delete file
     *
     * @param path File path e.g. '/folder/file.ext' (required)
     * @param storageName Storage name (optional)
     * @param versionId File version ID to download (optional)
     * @return Call &lt;ResponseBody&gt;
     */
    @Headers({"Content-Type:application/json"})
    @DELETE("v4.0/html/file")
    Call<ResponseBody> deleteFile(
            @Query("path") String path,
            @Query("storageName") String storageName,
            @Query("versionId") String versionId
    );

    /**
     * Upload file
     *
     * @param path Path where to upload excluding filename and extension e.g. /Folder1
     * @param file File to upload (required)
     * @param storageName Storage name (optional)
     * @return Call &lt;FilesUploadResult&gt;
     */
    @Multipart
    @POST("v4.0/html/file")
    Call<FilesUploadResult> uploadFile(
            @Part MultipartBody.Part file,
            @Query("path") String path,
            @Query("storageName") String storageName
    );

}
