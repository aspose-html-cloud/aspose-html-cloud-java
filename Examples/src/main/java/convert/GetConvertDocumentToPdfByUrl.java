package convert;

import java.io.File;

import com.aspose.html.client.api.ConversionApi;
import com.aspose.html.client.invoker.ApiException;

public class GetConvertDocumentToPdfByUrl {
	//Aspose.HTML Cloud Example
	//Demonstrates how to convert a URL to a PDF Page
	public static void main(String[] args) throws ApiException {
		String outFormat="jpeg";
		Integer width = 800; // Integer | Resulting image width.
		Integer height = 1000; // Integer | Resulting image height.
		Integer leftMargin = 10; // Integer | Left resulting image margin.
		Integer rightMargin = 10; // Integer | Right resulting image margin.
		Integer topMargin = 10; // Integer | Top resulting image margin.
		Integer bottomMargin = 10; // Integer | Bottom resulting image margin.
		String folder = null; // String | The document folder.
		String storage = null; // String | The document storage.
		Integer xResolution=300;
	    Integer yResolution=300;
	    String sourceUrl="https://www.le.ac.uk/oerresources/bdra/html/page_01.htm";
		ConversionApi apiInstance = new ConversionApi();

		File result = apiInstance.GetConvertDocumentToImageByUrl(sourceUrl, outFormat, width, height, leftMargin, rightMargin, topMargin, bottomMargin, 
				xResolution, yResolution, folder, storage);
		// Save to test directory
		File copyFile = new File("url_image.jpeg");
		result.renameTo(copyFile);

	}

}
