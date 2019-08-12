package ocr;

import java.io.File;

import com.aspose.html.client.api.OcrApi;
import com.aspose.html.client.invoker.ApiException;

public class GetRecognizeAndImportToHtml {
	//Aspose.HTML Cloud Example
	//Demonstrates how to convert a Image to a HTML Page
	public static void main(String[] args) throws ApiException {
		OcrApi api = new OcrApi();

		String name = "ocr_test_2.png";

		File response = api.GetRecognizeAndImportToHtml(name, "en", null, null);

		File copyFile = new File("ocr_to_html.html");
		response.renameTo(copyFile);
	}
}
