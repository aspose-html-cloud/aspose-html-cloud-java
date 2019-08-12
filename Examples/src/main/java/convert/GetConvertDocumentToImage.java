package convert;

import java.io.File;

import com.aspose.html.client.api.ConversionApi;

public class GetConvertDocumentToImage {
	//Aspose.HTML Cloud Example
	//Demonstrates how to convert a HTML Page to image by calling GetConvertDocumentToImage api
	public static void main(String[] args) throws com.aspose.html.client.invoker.ApiException {

		String name = "index.html"; // String | Document name.
		String outFormat = "jpeg"; // String | Resulting image format.
		Integer width = 800; // Integer | Resulting image width.
		Integer height = 1000; // Integer | Resulting image height.
		Integer leftMargin = 10; // Integer | Left resulting image margin.
		Integer rightMargin = 10; // Integer | Right resulting image margin.
		Integer topMargin = 10; // Integer | Top resulting image margin.
		Integer bottomMargin = 10; // Integer | Bottom resulting image margin.
		Integer xResolution = 300; // Integer | Horizontal resolution of resulting image.
		Integer yResolution = 300; // Integer | Vertical resolution of resulting image.
		String folder = null; // String | The document folder.
		String storage = null; // String | The document storage.

		ConversionApi apiInstance = new ConversionApi();

		File result = apiInstance.GetConvertDocumentToImage(name, outFormat, width, height, leftMargin, rightMargin,
				topMargin, bottomMargin, xResolution, yResolution, folder, storage);

		// Save to test directory
		File copyFile = new File("test.jpg");
		result.renameTo(copyFile);

	}

}
