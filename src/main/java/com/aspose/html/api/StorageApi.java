/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="StorageApi.java">
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

import com.aspose.html.model.*;
import retrofit2.Call;
import retrofit2.http.*;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

public interface StorageApi {
    /* FileApi */
    /**
     * Delete file
     *
     * @param path File path e.g. '/folder/file.ext' (required)
     * @param storageName Storage name (optional)
     * @param versionId File version ID to delete (optional)
     * @return Call &lt;Void&gt;
     */
    @Headers({"Content-Type:application/json"})
    @DELETE("html/storage/file/{path}")
    Call<Void> deleteFile(
            @Path("path") String path,
            @Query("storageName") String storageName,
            @Query("versionId") String versionId
    );

    /**
     * Download file
     *
     * @param path File path e.g. '/folder/file.ext' (required)
     * @param storageName Storage name (optional)
     * @param versionId File version ID to download (optional)
     * @return Call &lt;ResponseBody&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("html/storage/file/{path}")
    Call<ResponseBody> downloadFile(
            @Path("path") String path,
            @Query("storageName") String storageName,
            @Query("versionId") String versionId
    );

    /**
     * Move file
     *
     * @param srcPath Source file path e.g. '/src.ext' (required)
     * @param destPath Destination file path e.g. '/dest.ext' (required)
     * @param srcStorageName Source storage name (optional)
     * @param destStorageName Destination storage name (optional)
     * @param versionId File version ID to move (optional)
     * @return Call &lt;Void&gt;
     */
    @Headers({"Content-Type:application/json"})
    @PUT("html/storage/file/move/{srcPath}")
    Call<Void> moveFile(
            @Path("srcPath") String srcPath,
            @Query("destPath") String destPath,
            @Query("srcStorageName") String srcStorageName,
            @Query("destStorageName") String destStorageName,
            @Query("versionId") String versionId
    );

    /**
     * Upload file
     *
     * @param path Path where to upload including filename and extension e.g. /file.ext or /Folder 1/file.ext If the content is multipart and path does not contains the file name it tries to get them from filename parameter from Content-Disposition header. (required)
     * @param file File to upload (required)
     * @param storageName Storage name (optional)
     * @return Call &lt;FilesUploadResult&gt;
     */
    @Multipart
    @PUT("html/storage/file/{path}")
    Call<FilesUploadResult> uploadFile(
            @Path("path") String path,
            @Part MultipartBody.Part file,
            @Query("storageName") String storageName
    );

    /* FolderApi */
    /**
     * Delete folder
     *
     * @param path Folder path e.g. '/folder' (required)
     * @param storageName Storage name (optional)
     * @param recursive Enable to delete folders, subfolders and files (optional, default to false)
     * @return Call &lt;Void&gt;
     */
    @Headers({"Content-Type:application/json"})
    @DELETE("html/storage/folder/{path}")
    Call<Void> deleteFolder(
            @Path("path") String path,
            @Query("storageName") String storageName,
            @Query("recursive") Boolean recursive
    );

    /**
     * Get all files and folders within a folder
     *
     * @param path Folder path e.g. '/folder' (required)
     * @param storageName Storage name (optional)
     * @return Call &lt;FilesList&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("html/storage/folder/{path}")
    Call<FilesList> getFilesList(
            @Path("path") String path,
            @Query("storageName") String storageName
    );

    /**
     * Move folder
     *
     * @param srcPath Folder path to move e.g. '/folder' (required)
     * @param destPath Destination folder path to move to e.g '/dst' (required)
     * @param srcStorageName Source storage name (optional)
     * @param destStorageName Destination storage name (optional)
     * @return Call &lt;Void&gt;
     */
    @Headers({"Content-Type:application/json"})
    @PUT("html/storage/folder/move/{srcPath}")
    Call<Void> moveFolder(
            @Path("srcPath") String srcPath,
            @Query("destPath") String destPath,
            @Query("srcStorageName") String srcStorageName,
            @Query("destStorageName") String destStorageName
    );

    /**
     * Create the folder
     *
     * @param path Folder path to create e.g. 'folder_1/folder_2/' (required)
     * @param storageName Storage name (optional)
     * @return Call &lt;Void&gt;
     */
    @Headers({"Content-Type:application/json"})
    @PUT("html/storage/folder/{path}")
    Call<Void> createFolder(
            @Path("path") String path,
            @Query("storageName") String storageName
    );

    /* StorageApi */

    /**
     * Get disc usage
     *
     * @param storageName Storage name (optional)
     * @return Call &lt;DiscUsage&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("html/storage/disc")
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
    @GET("html/storage/exist/{path}")
    Call<ObjectExist> objectExists(
            @Path("path") String path,
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
    @GET("html/storage/{storageName}/exist")
    Call<StorageExist> storageExists(
            @Path("storageName") String storageName
    );

    /**
     * Get file versions
     *
     * @param path File path e.g. '/file.ext' (required)
     * @param storageName Storage name (optional)
     * @return Call &lt;FileVersions&gt;
     */
    @Headers({"Content-Type:application/json"})
    @GET("html/storage/version/{path}")
    Call<FileVersions> getFileVersions(
            @Path("path") String path,
            @Query("storageName") String storageName
    );

}
