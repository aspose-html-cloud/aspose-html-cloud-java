package com.aspose.html.tests;

import com.aspose.html.Configuration;
import com.aspose.html.HtmlApi;

public class BaseTest {
    public static HtmlApi api;
    public static String inputFile;
    public static String inputUrl;

    static {
        Configuration.setBasePath("https://api.aspose.cloud");
        Configuration.setAuthPath("https://api.aspose.cloud/connect/token");
        Configuration.setUserAgent("WebKit");
        Configuration.setDebug(true);
        Configuration.setTestSrcDir("sourceTest");
        Configuration.setTestDstDir("destTest");
        api = new HtmlApi("c8dda7d6445d82635b8797d1c8edd153", "2225baa2-097b-4731-9831-d0d56c28230f");
    }
}
