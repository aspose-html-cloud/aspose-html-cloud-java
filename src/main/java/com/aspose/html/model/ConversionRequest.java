/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="ConversionRequest.java">
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

package com.aspose.html.model;

import com.aspose.html.options.ConversionOptions;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ConversionRequest   {
  private String inputPath = null;
  private String storageName = null;
  private List<String> resources = null;
  private String outputFile = null;
  private ConversionOptions options = null;

 /**
   * Get inputPath
   * @return inputPath
  **/
  @SerializedName("inputPath")
  public String getInputPath() {
    return inputPath;
  }

  public void setInputPath(String inputPath) {
    this.inputPath = inputPath;
  }

  public ConversionRequest inputPath(String inputPath) {
    this.inputPath = inputPath;
    return this;
  }

 /**
   * Get storageName
   * @return storageName
  **/
  @SerializedName("storageName")
  public String getStorageName() {
    return storageName;
  }

  public void setStorageName(String storageName) {
    this.storageName = storageName;
  }

  public ConversionRequest storageName(String storageName) {
    this.storageName = storageName;
    return this;
  }

 /**
   * Get resources
   * @return resources
  **/
  @SerializedName("resources")
  public List<String> getResources() {
    return resources;
  }

  public void setResources(List<String> resources) {
    this.resources = resources;
  }

  public ConversionRequest resources(List<String> resources) {
    this.resources = resources;
    return this;
  }

  public ConversionRequest addResourcesItem(String resourcesItem) {
    this.resources.add(resourcesItem);
    return this;
  }

 /**
   * Get outputFile
   * @return outputFile
  **/
  @SerializedName("outputFile")
  public String getOutputFile() {
    return outputFile;
  }

  public void setOutputFile(String outputFile) {
    this.outputFile = outputFile;
  }

  public ConversionRequest outputFile(String outputFile) {
    this.outputFile = outputFile;
    return this;
  }

 /**
   * Get options
   * @return options
  **/
  @SerializedName("options")
  public ConversionOptions getOptions() {
    return options;
  }

  public void setOptions(ConversionOptions options) {
    this.options = options;
  }

  public ConversionRequest options(ConversionOptions options) {
    this.options = options;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversionRequest {\n");
    
    sb.append("    inputPath: ").append(toIndentedString(inputPath)).append("\n");
    sb.append("    storageName: ").append(toIndentedString(storageName)).append("\n");
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
    sb.append("    outputFile: ").append(toIndentedString(outputFile)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
