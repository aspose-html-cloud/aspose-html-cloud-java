package com.aspose.html.api;

import com.aspose.html.Configuration;

public class BaseTest {

    BaseTest(){
        Configuration.setAPI_KEY("60487a72d6325241191177e37ae52146");
        Configuration.setAPP_SID("80e32ca5-a828-46a4-9d54-7199dfd3764a");
        Configuration.setBasePath("https://api-qa.aspose.cloud/v3.0");
        Configuration.setAuthPath("https://api-qa.aspose.cloud/connect/token");
        Configuration.setUserAgent("WebKit");
        Configuration.setDebug(true);
        Configuration.setTestSrcDir("testdata");
        Configuration.setTestDstDir("testresult");
    }
}
