package summarization;

import java.io.File;

import com.aspose.html.api.SummarizationApi;
import com.aspose.html.client.ApiException;

public class GetDetectHtmlKeywordsByUrl {
	//Aspose.HTML Cloud Example
	//Demonstrates how to detect and sumarize a URL Pafge
	public static void main(String[] args) throws ApiException {
        String sourceUrl = "https://www.le.ac.uk/oerresources/bdra/html/page_02.htm"; ;

		SummarizationApi api=new SummarizationApi();
        File response = api.GetDetectHtmlKeywordsByUrl(sourceUrl);


	}

}
