package template;

import java.io.File;

import com.aspose.html.api.TemplateMergeApi;
import com.aspose.html.client.ApiException;

public class GetMergeHtmlTemplate {

	public static void main(String[] args) throws ApiException {
		//Aspose.HTML Cloud Example
		//Demonstrates how to apply a data file to a Template to generate a HTML Page
		String templateName="template.html";
		String options=null;
		String folder=null;
		String dataPath="data.xml";
				
		
		TemplateMergeApi api=new TemplateMergeApi();
		File response = api.GetMergeHtmlTemplate(
	                templateName, dataPath, options, folder,null);
		
		File copyFile = new File("template_result.html");
		response.renameTo(copyFile);

	}

}
