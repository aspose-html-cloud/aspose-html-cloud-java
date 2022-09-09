/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="Configuration.java">
*   Copyright (c) 2022 Aspose.HTML for Cloud
* </copyright>
* <summary>
*   Permission is hereby granted, free of charge, to any person obtaining a copy
*  of this software and associated documentation files (the "Software"), to deal
*  in the Software without restriction, including without limitation the rights
*  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
*  copies of the Software, and to permit persons to whom the Software is
*  furnished to do so, subject to the following conditions:
*
*  The above copyright notice and this permission notice shall be included in all
*  copies or substantial portions of the Software.
*
*  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
*  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
*  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
*  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
*  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
*  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
*  SOFTWARE.
* </summary>
* --------------------------------------------------------------------------------------------------------------------
*/
package com.aspose.html;

public class Configuration {

    static String basePath = "https://html-cloud-api.aspose.cloud";
    static String authPath = "https://api.aspose.cloud/connect/token";
    static String apiKey;
    static String appSID;
    static String defaultUserAgent = "WebKit";
    static String srcTest;
    static String dstTest;
    static boolean debug;


    public static String getBasePath() {
        return Configuration.basePath;
    }

    public static void setBasePath(String basePath) {
        Configuration.basePath = basePath;
    }

    public static String getAuthPath() {
        return Configuration.authPath;
    }

    public static void setAuthPath(String authPath) {
        Configuration.authPath = authPath;
    }

    public static String getAPP_SID() {
        return Configuration.appSID;
    }

    public static void setAPP_SID(String appSID) {
        Configuration.appSID = appSID;
    }

    public static String getAPI_KEY() {
        return Configuration.apiKey;
    }

    public static void setAPI_KEY(String apiKey){
        Configuration.apiKey = apiKey;
    }

    public static String getTestSrcDir() {
        return System.getProperty("user.dir") + "/" + Configuration.srcTest;
    }

    public static void setTestSrcDir(String testSrcDir) {
        Configuration.srcTest = testSrcDir;
    }

    public static String getTestDstDir() {
        return System.getProperty("user.dir") + "/" + Configuration.dstTest;
    }

    public static void setTestDstDir(String testDstDir) {
        Configuration.dstTest = testDstDir;
    }

    public static String getUserAgent() {
        return Configuration.defaultUserAgent;
    }

    public static void setUserAgent(String userAgent) {
        Configuration.defaultUserAgent = userAgent;
    }

    public static boolean getDebug() {
        return Configuration.debug;
    }

    public static void setDebug(Boolean status) {
        Configuration.debug = status;
    }
}

