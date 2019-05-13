package document;

import java.io.File;

import com.aspose.html.client.api.DocumentApi;
import com.aspose.html.client.invoker.ApiException;

public class GetDocumentImages {
	//Aspose.HTML Cloud Example
	//Demonstrates how to download all images in a HTML Page 
	public static void main(String[] args) throws ApiException {
		DocumentApi api=new DocumentApi();
		String name="testpage-zip.zip";
		String folder=null;
		String storage=null;
		
		
		File resultant= api.GetDocumentImages(name,folder,storage);
		File copyFile = new File("all_document_images.zip");
		resultant.renameTo(copyFile);
		
		
	
		
	}
}

