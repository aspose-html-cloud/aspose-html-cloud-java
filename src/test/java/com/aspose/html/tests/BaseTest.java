package com.aspose.html.tests;

import com.aspose.html.Configuration;

public class BaseTest {

    BaseTest(){
        Configuration.setAPI_KEY("html.cloud");
        Configuration.setAPP_SID("html.cloud");
        Configuration.setBasePath("https://api-qa.aspose.cloud/v3.0");
        Configuration.setAuthPath("https://api-qa.aspose.cloud/connect/token");
//        Configuration.setAPI_KEY("60487a72d6325241191177e37ae52146");
//        Configuration.setAPP_SID("80e32ca5-a828-46a4-9d54-7199dfd3764a");
//        Configuration.setBasePath("http://localhost:5000/v3.0");
//        Configuration.setAuthPath("https://api-qa.aspose.cloud/connect/token");

//    	Configuration.setAPI_KEY("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        Configuration.setAPP_SID("XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX");
//        Configuration.setBasePath("https://api.aspose.cloud/v3.0");
//        Configuration.setAuthPath("https://api.aspose.cloud/connect/token");
        Configuration.setUserAgent("WebKit");
        Configuration.setDebug(true);
        Configuration.setTestSrcDir("testdata");
        Configuration.setTestDstDir("testresult");
    }
}
