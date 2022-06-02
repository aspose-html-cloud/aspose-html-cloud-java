![](https://img.shields.io/badge/api-v3.0-lightgrey) [![Maven](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepository.aspose.cloud%2Frepo%2Fcom%2Faspose%2Faspose-html-cloud%2Fmaven-metadata.xml)](https://repository.aspose.cloud/repo/com/aspose/aspose-html-cloud/) [![License](https://img.shields.io/github/license/aspose-html-cloud/aspose-html-cloud-java)](https://repository.aspose.cloud/repo/com/aspose/aspose-html-cloud/)
# HTML Rendering & Conversion Java Cloud REST API
Aspose.HTML Cloud for Java is a programming SDK that allows software developers to manipulate and convert HTML documents from within their own applications. A Wrapper of RESTful APIs, Aspose.HTML Cloud for Java speeds up HTML programming and conversion.
This cloud SDK assists to develop cloud-based [HTML page rendering, processing, translation & conversion](https://products.aspose.cloud/html/java) apps in Java languages via REST API.

## HTML Processing Features
- Fetch the HTML page along with its resources as a ZIP archive by providing the page URL.
- Based on page URL, retrieve all images of an HTML page as a ZIP package.
- Load data from a local file to populate the HTML document template.
- Use the request body to populate the HTML document template.
- Convert HTML page to numerous other file formats.

## Read & Write HTML Formats
HTML, XHTML, zipped HTML, zipped XHTML, MHTML, HTML containing SVG markup, Markdown, JSON

## Save HTML As
*Fixed Layout*: PDF, XPS
*Images*: TIFF, JPEG, PNG, BMP, GIF
*Other*: TXT, ZIP (images)

## Read HTML Formats
*eBook*: EPUB
*Other*: XML, SVG

## Enhancements Version 20.11

- New generation of Aspose.HTML Cloud SDK for .NET (C#) is provided.
- This version of SDK has been redesigned from scratch being based on the new Aspose.HTML Cloud REST API (v3.0).
- Currently, it provides only the conversion feature. Other features that are still available in the versions up to v.20.08 are planned to be implemented in this SDK later.
- Conversion interface provides a more flexible conversion parameters setup.
- Redesigned storage access is provided using SDK entry point HtmlApi.Storage.
- Availability of synchronous and asynchronous file upload and download methods.
- Asynchronous download provides the ability to get progress data for the longer downloads.
## How to use the SDK?
The complete source code is available in this repository folder, you can either directly use it in your project.

## Requirements
Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

### Prerequisites
To use Aspose HTML for Cloud SDK you need to register an account with [Aspose Cloud](https://www.aspose.cloud/) and lookup/create App Key and SID at [Cloud Dashboard](https://dashboard.aspose.cloud/#/apps). There is free quota available. For more details, see [Aspose Cloud Pricing](https://purchase.aspose.cloud/pricing).

## Installation

Get ready package or build from source.
### Maven users
Add this dependency to your project's POM:

```xml
<repositories>
    ...
	<repository>
		<id>AsposeJavaAPI</id>
		<name>Aspose Java API</name>
		<url>https://repository.aspose.cloud/repo/</url>
	</repository>
	...
</repositories>

<dependencies>
     ...
	<dependency>
		<groupId>com.aspose</groupId>
		<artifactId>aspose-html-cloud</artifactId>
		<version>20.7.0</version>
		<scope>compile</scope>
	</dependency>
	...
</dependencies>
```


## HTML to JPG in Java

```java
	// Get your ClientId and ClientSecret from https://dashboard.aspose.cloud (free registration required).

	Configuration.setAPP_SID("MY_CLIENT_ID");
	Configuration.setAPI_KEY("MY_CLIENT_SECRET");
	Configuration.setBasePath("https://api.aspose.cloud/v3.0");
	Configuration.setAuthPath("https://api.aspose.cloud/connect/token");
	Configuration.setUserAgent("WebKit");
	Configuration.setDebug(true);
	Configuration.setTestSrcDir("My_Source_Folder");
	Configuration.setTestDstDir("My_Output_Folder");

	ConversionApi conversionApi = new ApiClient().createService(ConversionApi.class);
	
	String name = "test.html";// Document name. Place the html document in the folder "testdata".
	String outFormat = "jpg"; // Convert to jpg
	
	Integer width = 800; // Resulting image width.
	Integer height = 1000; // Resulting image height.
	Integer leftMargin = 10; // Left resulting image margin.
	Integer rightMargin = 10; // Right resulting image margin.
	Integer topMargin = 10; // Top resulting image margin.
	Integer bottomMargin = 10; // Bottom resulting image margin.
	Integer resolution = 300; // Resolution of resulting image.
	String folder = "/"; // The folder in the storage. Should exist.
	String storage = "My_Storage_Name"; // Name of the storage. null
	
	// Prepare call execute
	Call<ResponseBody> call = conversionApi.GetConvertDocumentToImage(name, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, resolution, folder, storage);

	// Execute request
	Response<ResponseBody> img = call.execute();

	// Get body from response
	ResponseBody answer = img.body();
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


## SeoApi    
Method | HTTP request | Description
------------- | ------------- | -------------
**GetSeoWarning** | **GET** /html/seo | Page analysis and return of SEO warnings.
**GetHtmlWarning** | **GET** /html/validator | Checks the markup validity of Web documents in HTML, XHTML, etc.


## StorageApi
Method | HTTP request | Description
------------- | ------------- | -------------
**downloadFile** | **GET** /html/storage/file/{path} | Download file from storage.
**uploadFile** | **PUT** /html/storage/file/{path} | Upload file to storage.
**moveFile** | **PUT** /html/storage/file/move/{srcPath} | Move file in storage.
**deleteFile** | **DELETE** /html/storage/file/{path} | Delete file in the storage.
**createFolder** | **PUT** /html/storage/folder/{path} | Create the folder in the storage.
**moveFolder** | **PUT** /html/storage/folder/move/{srcPath} | Move folder in the storage.
**deleteFolder** | **DELETE** /html/storage/folder/{path} | Delete folder in the storage.
**getFilesList** | **GET** /html/storage/folder/{path} | Get all files and folders within a folder.
**getDiscUsage** | **GET** /html/storage/disc | Get disc usage in the storage.
**objectExists** | **GET** /html/storage/exist/{path} | Check if file or folder exists.
**storageExists** | **GET** /html/storage/{storageName}/exist | Check if storage exists.
**getFileVersions** | **GET** /html/storage/version/{path} | Get file versions in the storage.


## Build from source
To install the API client library to your local Maven repository, simply execute from root of the git folder:

```shell
mvn install -DskipTests
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Others

At first generate the JAR by executing:

    mvn package -DskipTests

Then manually install the following JARs:

* target/aspose-html-cloud-20.7.0.jar
* target/lib/*.jar

## Recommendation
It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Workflow

In order to make changes in the repository, you need to:

1. Create a branch with the proposed changes whose name matches the feature/* pattern.
2. Create a pull request for this branch. It will be automatically assigned to a suitable reviewer.
3. Once the request is approved, it can be merged.

## Aspose.HTML Cloud SDKs in Popular Languages

| .NET | Java | PHP | Python | Ruby | Node.js | Android | Swift|C++|Go|
|---|---|---|---|---|---|---|--|--|--|
| [GitHub](https://github.com/aspose-html-cloud/aspose-html-cloud-dotnet) | [GitHub](https://github.com/aspose-html-cloud/aspose-html-cloud-java) | [GitHub](https://github.com/aspose-html-cloud/aspose-html-cloud-php) | [GitHub](https://github.com/aspose-html-cloud/aspose-html-cloud-python) | [GitHub](https://github.com/aspose-html-cloud/aspose-html-cloud-ruby)  | [GitHub](https://github.com/aspose-html-cloud/aspose-html-cloud-nodejs) | [GitHub](https://github.com/aspose-html-cloud/aspose-html-cloud-android) | [GitHub](https://github.com/aspose-html-cloud/aspose-html-cloud-swift)|[GitHub](https://github.com/aspose-html-cloud/aspose-html-cloud-cpp) |[GitHub](https://github.com/aspose-html-cloud/aspose-html-cloud-go) |
| [NuGet](https://www.nuget.org/packages/Aspose.html-Cloud/) | [Maven](https://repository.aspose.cloud/webapp/#/artifacts/browse/tree/General/repo/com/aspose/aspose-html-cloud) | [Composer](https://packagist.org/packages/aspose/aspose-html-cloud-php) | [PIP](https://pypi.org/project/asposehtmlcloud/) | [GEM](https://rubygems.org/gems/aspose_html_cloud)  | [NPM](https://www.npmjs.com/package/@asposecloud/aspose-html-cloud) | [Maven](https://repository.aspose.cloud/webapp/#/artifacts/browse/tree/General/repo/com/aspose/aspose-html-cloud) | [Cocoapods](https://cocoapods.org/pods/AsposeHtmlCloud)|[NuGet](https://www.nuget.org/packages/Aspose.Html-Cloud.Cpp/) | [Go.Dev](#) |

[Product Page](https://products.aspose.cloud/html/java) | [Documentation](https://docs.aspose.cloud/display/htmlcloud/Home) | [API Reference](https://apireference.aspose.cloud/html/) | [Code Samples](https://github.com/aspose-html-cloud/aspose-html-cloud-java) | [Blog](https://blog.aspose.cloud/category/html/) | [Free Support](https://forum.aspose.cloud/c/html) | [Free Trial](https://dashboard.aspose.cloud/#/apps)
