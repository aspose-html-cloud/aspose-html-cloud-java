package convert;

import java.io.File;

import com.aspose.html.client.api.ConversionApi;
import com.aspose.html.client.invoker.ApiException;

public class GetConvertDocumentToXps {
	//Aspose.HTML Cloud Example
	//Demonstrates how to HTML Page to XPS Document
	public static void main(String[] args) throws ApiException {
		String name = "index.html"; // String | Document name.
		Integer width = 800; // Integer | Resulting image width.
		Integer height = 1000; // Integer | Resulting image height.
		Integer leftMargin = 10; // Integer | Left resulting image margin.
		Integer rightMargin = 10; // Integer | Right resulting image margin.
		Integer topMargin = 10; // Integer | Top resulting image margin.
		Integer bottomMargin = 10; // Integer | Bottom resulting image margin.
		String folder = null; // String | The document folder.
		String storage = null; // String | The document storage.

		ConversionApi apiInstance = new ConversionApi();

		File result = apiInstance.GetConvertDocumentToXps(name, width, height, leftMargin, rightMargin,
				topMargin, bottomMargin, folder, storage);

		// Save to test directory
		File copyFile = new File("test.xps");
		result.renameTo(copyFile);

	}

}
