package document;

import java.io.File;

import com.aspose.html.client.api.DocumentApi;
import com.aspose.html.client.invoker.ApiException;

public class GetDocumentFragmentByXPath {
	//Aspose.HTML Cloud Example
	//Demonstrates how to get a Fragment of a HTML Page by XPATH
	public static void main(String[] args) throws ApiException {
		DocumentApi api=new DocumentApi();
		String name="test-page1.html";
		String xPath=".//ol/li";
		String outFormat="jpeg";
		String folder=null;
		String storage=null;
		
		
		File response=api.GetDocumentFragmentByXPath(name, xPath, outFormat, storage, folder);
		File copyFile = new File("all_document_fragment.jpeg");
		response.renameTo(copyFile);
	}
}

