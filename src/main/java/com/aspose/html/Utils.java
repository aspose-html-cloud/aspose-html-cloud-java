/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="Utils.java">
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

import com.aspose.html.model.InputFormats;
import com.aspose.html.model.OutputFormats;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class Utils {

    private static final List<String> protocols = Arrays.asList("http", "https");

    public static InputFormats getInputFormat(String filePath){
        int lastIndexOf = filePath.lastIndexOf(".");
        if(lastIndexOf == -1) return null;
        String ext = filePath.substring(lastIndexOf + 1).toUpperCase();
        switch (ext){
            case "HTML":
            case "HTM": return InputFormats.HTML;
            case "MHT":
            case "MHTML": return InputFormats.MHTML;
            case "XML":
            case "XHTML": return InputFormats.XHTML;
            case "EPUB": return InputFormats.EPUB;
            case "SVG": return InputFormats.SVG;
            case "MD": return InputFormats.MD;
            case "JPEG":
            case "JPG": return InputFormats.JPEG;
            case "TIF":
            case "TIFF": return InputFormats.TIFF;
            case "PNG": return InputFormats.PNG;
            case "GIF": return InputFormats.GIF;
            case "BMP": return InputFormats.BMP;
            default: return null;
        }
    }

    public static OutputFormats getOutputFormat(String filePath){
        int lastIndexOf = filePath.lastIndexOf(".");
        if(lastIndexOf == -1) return null;
        String ext = filePath.substring(lastIndexOf + 1).toUpperCase();
        return OutputFormats.fromValue(ext);
    }

    public static boolean isURI(String str) {
        int colon = str.indexOf(':');
        if (colon < 3) return false;

        String proto = str.substring(0, colon).toLowerCase();
        if (!protocols.contains(proto)) return false;

        try {
            URI uri = new URI(str);
            if (uri.getHost() == null) return false;

            String path = uri.getPath();
            if (path != null) {
                for (int i=path.length()-1; i >= 0; i--) {
                    if ("?<>:*|\"".indexOf( path.charAt(i) ) > -1)
                        return false;
                }
            }
            return true;
        } catch ( Exception ex ) {}

        return false;
    }

}
