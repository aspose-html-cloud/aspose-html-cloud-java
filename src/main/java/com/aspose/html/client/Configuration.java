/**
 * --------------------------------------------------------------------------------------------------------------------
 * <copyright company="Aspose" file="Configuration.java">
 *  Copyright (c) 2018 Aspose.HTML for Cloud
 * </copyright>
 * <summary>
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
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


package com.aspose.html.client;

import java.io.BufferedReader;
import java.io.FileReader;
import com.google.gson.Gson;

public class Configuration {

    private static volatile ApiClient defaultApiClient;

    static Configuration config = getConfig();
    
    // For json conversions only    
	private String basePath;
    private String authPath;
    private String apiKey;
    private String appSID;
    private String storage;
    private String testdata;
    private String defaultUserAgent;
    private Boolean debug;
   
    
    //Singleton for other classes
    public static ApiClient getDefaultApiClient() {
    	ApiClient localDefaultApiClient = defaultApiClient;
    	if(localDefaultApiClient == null) {
    		synchronized (Configuration.class) {
    			localDefaultApiClient = defaultApiClient;
    			if(localDefaultApiClient == null) {
    				defaultApiClient = localDefaultApiClient = new ApiClient().setDebugging(getDebugging());
    			}
    		}
    	}
        return localDefaultApiClient;
    }

    private static Configuration getConfig() {
    	
    	String path = System.getProperty("user.dir") + "/setting/config.json";
    	
    	try {
    		final BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
    		Gson gson = new Gson();
    		Configuration obj = gson.fromJson(bufferedReader, Configuration.class);
    		return obj;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }

    public static String getBasePath() {
    	return config.basePath;
    }

    public static String getAuthPath() {
    	return config.authPath;
    }
	
	public static void setStorage(String storage) {
		config.storage = storage;
	}
	
	public static String getAPP_SID() {
		return config.appSID;
	}
	
	public static String getAPI_KEY() {
		return config.apiKey;
	}

	public static String getTestDataDir() {
		return System.getProperty("user.dir") + config.testdata;
	}

	public static String getStorage() {
		return System.getProperty("user.dir") + config.storage;
	}

	public static String getDefaultUserAgent() {
		return config.defaultUserAgent;
	}

	public static Boolean getDebugging() {
		return config.debug;
	}
	
}
