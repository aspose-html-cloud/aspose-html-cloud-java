/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="ObjectExist.java">
*   Copyright (c) 2020 Aspose.HTML for Cloud
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

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Object exists
 */
public class ObjectExist {
  @SerializedName("exists")
  private Boolean exists = null;

  @SerializedName("isFolder")
  private Boolean isFolder = null;

  public ObjectExist exists(Boolean exists) {
    this.exists = exists;
    return this;
  }

   /**
   * Indicates that the file or folder exists.
   * @return exists
  **/
  public Boolean isExists() {
    return exists;
  }

  public void setIsExists(Boolean exists) {
    this.exists = exists;
  }

//  public ObjectExist isFolder(Boolean isFolder) {
//    this.isFolder = isFolder;
//    return this;
//  }

   /**
   * True if it is a folder, false if it is a file.
   * @return isFolder
  **/
  public Boolean isFolder() {
    return isFolder;
  }

  public void setIsFolder(Boolean isFolder) {
    this.isFolder = isFolder;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectExist objectExist = (ObjectExist) o;
    return Objects.equals(this.exists, objectExist.exists) &&
        Objects.equals(this.isFolder, objectExist.isFolder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exists, isFolder);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectExist {\n");
    
    sb.append("    exists: ").append(toIndentedString(exists)).append("\n");
    sb.append("    isFolder: ").append(toIndentedString(isFolder)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

