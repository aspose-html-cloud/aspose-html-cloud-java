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

Get ready package or build from source.
### Maven users
Add this dependency to your project's POM:

```xml
<repositories>
	<repository>
		<id>AsposeJavaCloudAPI</id>
		<url>https://releases.aspose.cloud/java/repo/</url>
	</repository>
</repositories>

<dependencies>
     ...
	<dependency>
		<groupId>com.aspose</groupId>
		<artifactId>aspose-html-cloud</artifactId>
		<version>22.12.1</version>
		<scope>compile</scope>
	</dependency>
	...
</dependencies>
```


### Convert URL tp PDF format

```java
package com.aspose.test_package;

import com.aspose.html.Configuration;
import com.aspose.html.ConverterBuilder;
import com.aspose.html.model.OperationResult;
import com.aspose.html.options.PDFConversionOptions;

import java.io.File;

public class App {


    public static void main(String[] args) {

// Get keys from aspose site.
// There is free quota available. 
// For more details, see https://purchase.aspose.cloud/pricing

        Configuration.setBasePath("https://api.aspose.cloud");
        Configuration.setAuthPath("https://api.aspose.cloud/connect/token");
        Configuration.setUserAgent("WebKit");
        Configuration.setDebug(true);

        HtmlApi api = new HtmlApi("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX");


        String inputUrl = "https://stallman.org/articles/anonymous-payments-thru-phones.html";
        String outputFile = "c:/temp/Output.pdf";

        File f = new File(outputFile);
        if (f.exists()) f.delete();

        PDFConversionOptions opt_A5 = new PDFConversionOptions()
                .setWidth(5.8)
                .setHeight(8.3)
                .setTopMargin(0.5)
                .setBottomMargin(0.5)
                .setLeftMargin(0.5)
                .setRightMargin(0.5)
                .setQuality(95);

        JobBuilder builder = new ConverterBuilder()
                .fromUrl(inputUrl)
                .useOptions(opt)
                .saveToLocal(outputFile);

        OperationResult result = api.convert(builder);

        String f = result.getFile();

        File dst = new File(result.getFile());

        if (dst.exists()) {
            System.out.println("Result file is " + dst);
        } else {
            System.out.println("Error conversion");
        }
    }
}
```


### Vectorize the image to SVG format

```java
package com.aspose.test_package;

import com.aspose.html.Configuration;
import com.aspose.html.ConverterBuilder;
import com.aspose.html.model.OperationResult;
import com.aspose.html.options.PDFConversionOptions;

import java.io.File;

public class App {


    public static void main(String[] args) {

// Get keys from aspose site.
// There is free quota available. 
// For more details, see https://purchase.aspose.cloud/pricing

        Configuration.setBasePath("https://api.aspose.cloud");
        Configuration.setAuthPath("https://api.aspose.cloud/connect/token");
        Configuration.setUserAgent("WebKit");
        Configuration.setDebug(true);

        HtmlApi api = new HtmlApi("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX");


        VectorizationOptions opts = new VectorizationOptions()
                .setErrorThreshold(50)
                .setColorLimit(30)
                .setLineWidth(1.5)
                .setMaxIteration(10);

        JobBuilder builder = new VectorizationBuilder()
                .fromLocalFile("/path/to/input/file.png")
                .useOptions(opts)
                .saveToLocal("/path/to/output/file.svg");

        OperationResult result = api.vectorize(builder);
        File dst = new File(result.getFile());

        if (dst.exists()) {
            System.out.println("Result file is " + dst);
        } else {
            System.out.println("Error vectorization");
        }
    }
}
```



# Documentation for API Endpoints
All URIs are relative to https://api.aspose.cloud/


## Possible conversions:
- HTML -> PDF, XPS, DOCX, MD, MHTML, JPEG, BMP, PNG, TIFF, GIF
- EPUB -> PDF, XPS, DOCX, JPEG, BMP, PNG, TIFF, GIF
- MD -> PDF, XPS, DOCX, HTML, MHTML, JPEG, BMP, PNG, TIFF, GIF
- MHTML -> PDF, XPS, DOCX, JPEG, BMP, PNG, TIFF, GIF
- SVG -> PDF, XPS, JPEG, BMP, PNG, TIFF, GIF
- JPEG, BMP, PNG, TIFF, GIF -> SVG

## JobBuilder (VectorizationBuilder, ConverterBuilder)

| Method                                                   | Parameters                                                                             | Description                                     |
|----------------------------------------------------------|----------------------------------------------------------------------------------------|-------------------------------------------------|
| **fromLocalFile(String fileName)**                       | fileName - full path to a local file                                                   | A source is a file in a local file system.      |
| **fromStorageFile(String fileName)**                     | fileName - path to the file in the cloud storage                                       | A source is a file in the cloud (user storage). |
| **fromStorageFile(String fileName, String storageName)** | fileName - path to the file in the cloud storage. storageName - your storage, if exist | A source is a file in the cloud (user storage). |
| **fromUrl(String url)**                                  | url - URI for conversion.                                                              | Convert from url as source.                     |
| **saveToLocal(String fileName)**                         | fileName - full path to the result.                                                    | Recreating, if the file exists.                 |
| **saveToStorage(String fileName)**                       | fileName - full path to the result.                                                    | Recreating, if the file exists.                 |
| **saveToStorage(String fileName, String storageName)**   | fileName - full path to the result. storageName - your storage, if exist               | Recreating, if the file exists.                 |
| **useOptions(Options options)**                          | options - additional options for operation.                                            | (optional)                                      |


### useOptions(Options)

Specifies the output format for operation.

| Options                                                                          | Description                                      |
|----------------------------------------------------------------------------------|--------------------------------------------------|
| [ImageConversionOptions](docs/Options.md#ImageConversionOptions)       | Converting source file or URL to single or several images. |
| [PDFConversionOptions](docs/Options.md#PDFConversionOptions)           | Converting source file or URL to PDF.                      |
| [XPSConversionOptions](docs/Options.md#XPSConversionOptions)           | Converting source file or URL to XPS.                      |
| [DOCConversionOptions](docs/Options.md#DOCConversionOptions)           | Converting source file or URL to DOCX.                     |
| [MarkdownConversionOptions](docs/Options.md#MarkdownConversionOptions) | Converting source file or URL to Markdown.                 |
| [VectorizationOptions](docs/Options.md#VectorizationOptions)           | Vectorize images to SVG (trace image).                     |


### SaveTo...

The target directory for a result.

| Method                                | Parameters                                    | Description                                               |
|---------------------------------------|-----------------------------------------------|-----------------------------------------------------------|
| SaveToLocal(string outputDirectory)   | outputDirectory - directory to save a result. | A directory in the local file system to save a result.    |
| SaveToStorage(string outputDirectory) | outputDirectory - directory to save a result. | A directory in the cloud (user storage) to save a result. |

## OperationResult

Result object for operation.

| Field              | Description                                       |
|--------------------|---------------------------------------------------|
| String file        | A result file.                                    |
| String description | A description in case of unsuccessful operation.  |


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

* target/aspose-html-cloud-22.12.1.jar
* target/lib/*.jar

## Recommendation
It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.


### Examples
[Tests](./src/test/java/com/aspose/html/tests/) contain various examples of using the Aspose.HTML SDK.

