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
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/aspose-html-cloud-1.0.0.jar
* target/lib/*.jar

### Sample usage

Before fill all fields in /setting/config.json   

Example:   
```json
{
    "basePath":"https://api.aspose.cloud/v1.1",
    "authPath":"https://api.aspose.cloud/oauth2/token",
    "apiKey":"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
    "appSID":"XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX",
    "storage":"\\data\\",
    "testdata":"\\testdata\\",
    "defaultUserAgent":"Webkit",
    "debug": false
}
```

```java

import com.aspose.html.client.invoker.*;
import com.aspose.html.client.invoker.auth.*;
import com.aspose.html.client.api.ConversionApi;

import java.io.File;
import java.util.*;

public class ConversionApiExample {

    public static void main(String[] args) {
        
        ConversionApi apiInstance = new ConversionApi();
        String name = "name_example"; // String | Document name.
        String outFormat = "jpg"; // String | Resulting image format.
        Integer width = 800; // Integer | Resulting image width. 
        Integer height = 1000; // Integer | Resulting image height. 
        Integer leftMargin = 10; // Integer | Left resulting image margin.
        Integer rightMargin = 10; // Integer | Right resulting image margin.
        Integer topMargin = 10; // Integer | Top resulting image margin.
        Integer bottomMargin = 10; // Integer | Bottom resulting image margin.
        Integer xResolution = 300; // Integer | Horizontal resolution of resulting image.
        Integer yResolution = 300; // Integer | Vertical resolution of resulting image.
        String folder = "folder_example"; // String | The document folder.
        String storage = "storage_example"; // String | The document storage.
        try {
            File result = apiInstance.GetConvertDocumentToImage(name, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, xResolution, yResolution, folder, storage);

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

## Documentation for API Endpoints

All URIs are relative to *https://api.aspose.cloud/v1.1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ConversionApi* | **GetConvertDocumentToImage** | **GET** /html/{name}/convert/image/{outFormat} | Convert the HTML document from the storage by its name to the specified image format.
*ConversionApi* | **GetConvertDocumentToImageByUrl** | **GET** /html/convert/image/{outFormat} | Convert the HTML page from the web by its URL to the specified image format.
*ConversionApi* | **GetConvertDocumentToPdf** | **GET** /html/{name}/convert/pdf | Convert the HTML document from the storage by its name to PDF.
*ConversionApi* | **GetConvertDocumentToPdfByUrl** | **GET** /html/convert/pdf | Convert the HTML page from the web by its URL to PDF.
*ConversionApi* | **GetConvertDocumentToXps** | **GET** /html/{name}/convert/xps | Convert the HTML document from the storage by its name to XPS.
*ConversionApi* | **GetConvertDocumentToXpsByUrl** | **GET** /html/convert/xps | Convert the HTML page from the web by its URL to XPS.
*DocumentApi* | **GetDocument** | **GET** /html/{name} | Return the HTML document by the name from default or specified storage.
*DocumentApi* | **GetDocumentFragmentByXPath** | **GET** /html/{name}/fragments/{outFormat} | Return list of HTML fragments matching the specified XPath query. 
*DocumentApi* | **GetDocumentImages** | **GET** /html/{name}/images/all | Return all HTML document images packaged as a ZIP archive.
*TranslationApi* | **GetTranslateDocument** | **GET** /html/{name}/translate/{srcLang}/{resLang} | Translate the HTML document specified by the name from default or specified storage.
*TranslationApi* | **GetTranslateDocumentByUrl** | **GET** /html/translate/{srcLang}/{resLang} | Translate the HTML document specified by its URL.


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

### Examples

[Tests](./src/test/java/com/aspose/html/client/api) contain various examples of using the Aspose.HTML SDK.

[Docs](./docs/) Full javadoc for Aspose.HTML Api SDK


