# Aspose HTML Cloud SDK 
This repository contains Aspose.HTML Cloud SDK source code. This SDK allows you to work with Aspose.HTML Cloud REST APIs in your applications quickly and easily.

See [API Reference](https://apireference.aspose.cloud/html/) for full API specification.

## How to use the SDK?
The complete source code is available in this repository folder, you can either directly use it in your project.

## Requirements
Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

### Prerequisites
To use Aspose HTML for Cloud SDK you need to register an account with [Aspose Cloud](https://www.aspose.cloud/) and lookup/create App Key and SID at [Cloud Dashboard](https://dashboard.aspose.cloud/#/apps). There is free quota available. For more details, see [Aspose Cloud Pricing](https://purchase.aspose.cloud/pricing).

## Installation
To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users
Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.aspose</groupId>
    <artifactId>aspose-html-cloud</artifactId>
    <version>19.5.0</version>
    <scope>compile</scope>
</dependency>
```

### Others

At first generate the JAR by executing:

    mvn package -DskipTests

Then manually install the following JARs:

* target/aspose-html-cloud-19.5.0.jar
* target/lib/*.jar

### Sample usage
```java
import com.aspose.html.client.invoker.*;
import com.aspose.html.client.invoker.auth.*;
import com.aspose.html.client.api.ConversionApi;

import java.io.File;
import java.util.*;

public class ConversionApiExample {

    public static void main(String[] args) {

        Configuration.setAPI_KEY("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        Configuration.setAPP_SID("XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX");
        Configuration.setBasePath("https://api.aspose.cloud/v3.0");
        Configuration.setAuthPath("https://api.aspose.cloud/connect/token");
        Configuration.setUserAgent("WebKit");
        Configuration.setDebug(true);

        ConversionApi api = new ApiClient().createService(ConversionApi.class);
      
        String name = "name_example"; // String | Document name.
        String outFormat = "jpg"; // String | Resulting image format.
        Integer width = 800; // Integer | Resulting image width. 
        Integer height = 1000; // Integer | Resulting image height. 
        Integer leftMargin = 10; // Integer | Left resulting image margin.
        Integer rightMargin = 10; // Integer | Right resulting image margin.
        Integer topMargin = 10; // Integer | Top resulting image margin.
        Integer bottomMargin = 10; // Integer | Bottom resulting image margin.
        Integer resolution = 300; // Integer | Resolution of resulting image.
        String folder = "folder_example"; // String | The document folder.
        String storage = "storage_example"; // String | The document storage.
        try {
            File result = apiInstance.GetConvertDocumentToImage(name, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, resolution, folder, storage);

    		//Save to test directory
    		File copyFile = new File("~/testdir/test.jpg");
    		result.renameTo(copyFile);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConversionApi#GetConvertDocumentToImage");
            e.printStackTrace();
        }
    }
}
```

# Documentation for API Endpoints
All URIs are relative to *https://api.aspose.cloud/v3.0*


## ConversionApi
- Input format (html, epub, svg)
- Output format for images (jpeg, png, bmp, tiff, gif)

Method | HTTP request | Description
------------- | ------------- | -------------
**GetConvertDocumentToImage** | **GET** html/{name}/convert/image/{outFormat} | Convert the HTML document from the storage by its name to the specified image format.
**GetConvertDocumentToImageByUrl** | **GET** html/convert/image/{outFormat} | Convert the HTML page from the web by its URL to the specified image format.
**GetConvertDocumentToPdf** | **GET** html/{name}/convert/pdf | Convert the HTML document from the storage by its name to PDF.
**GetConvertDocumentToPdfByUrl** | **GET** html/convert/pdf | Convert the HTML page from the web by its URL to PDF.
**GetConvertDocumentToXps** | **GET** html/{name}/convert/xps | Convert the HTML document from the storage by its name to XPS.
**GetConvertDocumentToXpsByUrl** | **GET** html/convert/xps | Convert the HTML page from the web by its URL to XPS.
**PostConvertDocumentInRequestToImage** | **POST** html/convert/image/{outFormat} | Converts the HTML document (in request content) to the specified image format and uploads resulting file to storage.
**PostConvertDocumentInRequestToPdf** | **POST** html/convert/pdf | Converts the HTML document (in request content) to PDF and uploads resulting file to storage.
**PostConvertDocumentInRequestToXps** | **POST** html/convert/xps | Converts the HTML document (in request content) to XPS and uploads resulting file to storage.
**PutConvertDocumentToImage** | **PUT** html/{name}/convert/image/{outFormat} | Converts the HTML document (located on storage) to the specified image format and uploads resulting file to storage.
**PutConvertDocumentToPdf** | **PUT** html/{name}/convert/pdf | Converts the HTML document (located on storage) to PDF and uploads resulting file to storage.
**PutConvertDocumentToXps** | **PUT** html/{name}/convert/xps | Converts the HTML document (located on storage) to XPS and uploads resulting file to storage.
**GetConvertDocumentToMHTMLByUrl** | **GET** /html/convert/mhtml | Converts the HTML page from Web by its URL to MHTML returns resulting file in response content.
**GetConvertDocumentToMarkdown** | **GET** /html/{name}/convert/md | Converts the HTML document (located on storage) to Markdown and returns resulting file in response content.
**PostConvertDocumentInRequestToMarkdown** | **POST** /html/convert/md | Converts the HTML document (in request content) to Markdown and uploads resulting file to storage by specified path.
**PutConvertDocumentToMarkdown** | **PUT** /html/{name}/convert/md | Converts the HTML document (located on storage) to Markdown and uploads resulting file to storage by specified path.

## ImportApi
Method | HTTP request | Description
------------- | ------------- | -------------
**GetConvertMarkdownToHtml** | **GET** /html/{name}/import/md | Converts the Markdown document (located on storage) to HTML and returns resulting file in response content.
**PostConvertMarkdownInRequestToHtml** | **POST** /html/{name}/import/md | Converts the Markdown document (in request content) to HTML and uploads resulting file to storage by specified path.
**PutConvertMarkdownToHtml** | **PUT** /html/import/md | Converts the Markdown document (located on storage) to HTML and uploads resulting file to storage by specified path.

## DocumentApi
Method | HTTP request | Description
------------- | ------------- | -------------
**GetDocumentByUrl** | **GET** html/download | Return all HTML page with linked resources packaged as a ZIP archive by the source page URL.
**GetDocumentFragmentByXPath** | **GET** html/{name}/fragments/{outFormat} | Return list of HTML fragments matching the specified XPath query.
**GetDocumentFragmentByXPathByUrl** | **GET** html/fragments/{outFormat} | Return list of HTML fragments matching the specified XPath query by the source page URL.
**GetDocumentFragmentsByCSSSelector** | **GET** /html/{name}/fragments/css/{outFormat} | Return list of HTML fragments matching the specified CSS selector.
**GetDocumentFragmentsByCSSSelectorByUrl** | **GET** /html/fragments/css/{outFormat} | Return list of HTML fragments matching the specified CSS selector by the source page URL.
**GetDocumentImages** | **GET** html/{name}/images/all | Return all HTML document images packaged as a ZIP archive.
**GetDocumentImagesByUrl** | **GET** html/images/all | Return all HTML page images packaged as a ZIP archive by the source page URL.

## TemplateMergeApi    
Method | HTTP request | Description
------------- | ------------- | -------------
**GetMergeHtmlTemplate** | **GET** /html/{templateName}/merge | Populate HTML document template with data located as a file in the storage.
**PostMergeHtmlTemplate** | **POST** /html/{templateName}/merge | Populate HTML document template with data from the request body. Result document will be saved to storage.


## Recommendation
It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

### Examples
[Tests](./src/test/java/com/aspose/html/client/api) contain various examples of using the Aspose.HTML SDK.

[Docs](./doc/) Full javadoc for Aspose.HTML Api SDK
