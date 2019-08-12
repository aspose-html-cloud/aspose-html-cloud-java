package translation;

import java.io.File;

import com.aspose.html.client.api.TranslationApi;
import com.aspose.html.client.invoker.ApiException;

public class GetTranslateDocumentByUrl {
	//Aspose.HTML Cloud Example
	//Demonstrates how to translate a Page to another language
	public static void main(String[] args) throws ApiException {
		TranslationApi api=new TranslationApi();
		String sourceUrl = "https://www.le.ac.uk/oerresources/bdra/html/page_02.htm";

        File response = api.GetTranslateDocumentByUrl(sourceUrl, "en", "fr");
        
        

		File copyFile = new File("translate_result.html");
		response.renameTo(copyFile);
	}
}
