# aspose-html-cloud-java
Java library for communicating with the Aspose.HTML for Cloud API

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

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
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.aspose.html.client.invoker.*;
import com.aspose.html.client.invoker.auth.*;
import com.aspose.html.client.model.*;
import com.aspose.html.client.api.ConversionApi;

import java.io.File;
import java.util.*;

public class ConversionApiExample {

    public static void main(String[] args) {
        
        ConversionApi apiInstance = new ConversionApi();
        String name = "name_example"; // String | Document name.
        String outFormat = "outFormat_example"; // String | Resulting image format.
        Integer width = 56; // Integer | Resulting image width. 
        Integer height = 56; // Integer | Resulting image height. 
        Integer leftMargin = 56; // Integer | Left resulting image margin.
        Integer rightMargin = 56; // Integer | Right resulting image margin.
        Integer topMargin = 56; // Integer | Top resulting image margin.
        Integer bottomMargin = 56; // Integer | Bottom resulting image margin.
        Integer xResolution = 56; // Integer | Horizontal resolution of resulting image.
        Integer yResolution = 56; // Integer | Vertical resolution of resulting image.
        String folder = "folder_example"; // String | The document folder.
        String storage = "storage_example"; // String | The document storage.
        try {
            File result = apiInstance.conversionGetConvertDocumentToImage(name, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, xResolution, yResolution, folder, storage);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConversionApi#conversionGetConvertDocumentToImage");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.aspose.cloud/v1.1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ConversionApi* | [**conversionGetConvertDocumentToImage**](docs/ConversionApi.md#conversionGetConvertDocumentToImage) | **GET** /html/{name}/convert/image/{outFormat} | Convert the HTML document from the storage by its name to the specified image format.
*ConversionApi* | [**conversionGetConvertDocumentToImageByUrl**](docs/ConversionApi.md#conversionGetConvertDocumentToImageByUrl) | **GET** /html/convert/image/{outFormat} | Convert the HTML page from the web by its URL to the specified image format.
*ConversionApi* | [**conversionGetConvertDocumentToPdf**](docs/ConversionApi.md#conversionGetConvertDocumentToPdf) | **GET** /html/{name}/convert/pdf | Convert the HTML document from the storage by its name to PDF.
*ConversionApi* | [**conversionGetConvertDocumentToPdfByUrl**](docs/ConversionApi.md#conversionGetConvertDocumentToPdfByUrl) | **GET** /html/convert/pdf | Convert the HTML page from the web by its URL to PDF.
*ConversionApi* | [**conversionGetConvertDocumentToXps**](docs/ConversionApi.md#conversionGetConvertDocumentToXps) | **GET** /html/{name}/convert/xps | Convert the HTML document from the storage by its name to XPS.
*ConversionApi* | [**conversionGetConvertDocumentToXpsByUrl**](docs/ConversionApi.md#conversionGetConvertDocumentToXpsByUrl) | **GET** /html/convert/xps | Convert the HTML page from the web by its URL to XPS.
*ConversionApi* | [**conversionPutConvertDocumentToImage**](docs/ConversionApi.md#conversionPutConvertDocumentToImage) | **PUT** /html/convert/image/{outFormat} | Convert the HTML document to the specified image format.
*ConversionApi* | [**conversionPutConvertDocumentToPdf**](docs/ConversionApi.md#conversionPutConvertDocumentToPdf) | **PUT** /html/convert/pdf | Convert the HTML document to PDF.
*ConversionApi* | [**conversionPutConvertDocumentToXps**](docs/ConversionApi.md#conversionPutConvertDocumentToXps) | **PUT** /html/convert/xps | Convert the HTML document to XPS.
*DocumentApi* | [**documentGetDocument**](docs/DocumentApi.md#documentGetDocument) | **GET** /html/{name} | Return the HTML document by the name from default or specified storage.
*DocumentApi* | [**documentGetDocumentFragmentByXPath**](docs/DocumentApi.md#documentGetDocumentFragmentByXPath) | **GET** /html/{name}/fragments/{outFormat} | Return list of HTML fragments matching the specified XPath query. 
*DocumentApi* | [**documentGetDocumentImages**](docs/DocumentApi.md#documentGetDocumentImages) | **GET** /html/{name}/images/all | Return all HTML document images packaged as a ZIP archive.
*TranslationApi* | [**translationGetTranslateDocument**](docs/TranslationApi.md#translationGetTranslateDocument) | **GET** /html/{name}/translate/{srcLang}/{resLang} | Translate the HTML document specified by the name from default or specified storage.
*TranslationApi* | [**translationGetTranslateDocumentByUrl**](docs/TranslationApi.md#translationGetTranslateDocumentByUrl) | **GET** /html/translate/{srcLang}/{resLang} | Translate the HTML document specified by its URL.
*TranslationApi* | [**translationPutTranslateDocument**](docs/TranslationApi.md#translationPutTranslateDocument) | **PUT** /html/{name}/translate/{srcLang}/{resLang} | Translate the HTML document specified by the name from default or specified storage.
*TranslationApi* | [**translationPutTranslateDocumentByUrl**](docs/TranslationApi.md#translationPutTranslateDocumentByUrl) | **PUT** /html/translate/{srcLang}/{resLang} | Translate the HTML document specified by its URL.


## Documentation for Models



## Documentation for Authorization

Authentication schemes defined for the API:
### appsid

- **Type**: API key
- **API key parameter name**: appsid
- **Location**: URL query string

### oauth

- **Type**: OAuth
- **Flow**: application
- **Authorization URL**: api.aspose.cloud/oauth2/token
- **Scopes**: N/A

### signature

- **Type**: API key
- **API key parameter name**: signature
- **Location**: URL query string


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author




