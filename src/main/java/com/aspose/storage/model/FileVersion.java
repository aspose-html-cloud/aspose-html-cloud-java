/**
 * --------------------------------------------------------------------------------------------------------------------
 * <copyright company="Aspose" file="FileVersion.java">
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


package com.aspose.storage.model;

public class FileVersion {
  private String VersionId = null;
  private Boolean IsLatest = null;
  private String Name = null;
  private Boolean IsFolder = null;
  private String ModifiedDate = null;
//  private DateTime ModifiedDate = null;
  private Long Size = null;
  private String Path = null;
  /**
	 * getVersionId
	 * Gets String
	 * @return VersionId
	 */
  public String getVersionId() {
    return VersionId;
  }

	/**
	 * setVersionId
	 * Sets String
	 * @param VersionId String
	 */
  public void setVersionId(String VersionId) {
    this.VersionId = VersionId;
  }

  /**
	 * getIsLatest
	 * Gets Boolean
	 * @return IsLatest
	 */
  public Boolean getIsLatest() {
    return IsLatest;
  }

	/**
	 * setIsLatest
	 * Sets Boolean
	 * @param IsLatest Boolean
	 */
  public void setIsLatest(Boolean IsLatest) {
    this.IsLatest = IsLatest;
  }

  /**
	 * getName
	 * Gets String
	 * @return Name
	 */
  public String getName() {
    return Name;
  }

	/**
	 * setName
	 * Sets String
	 * @param Name String
	 */
  public void setName(String Name) {
    this.Name = Name;
  }

  /**
	 * getIsFolder
	 * Gets Boolean
	 * @return IsFolder
	 */
  public Boolean getIsFolder() {
    return IsFolder;
  }

	/**
	 * setIsFolder
	 * Sets Boolean
	 * @param IsFolder Boolean
	 */
  public void setIsFolder(Boolean IsFolder) {
    this.IsFolder = IsFolder;
  }

  /**
	 * getModifiedDate
	 * Gets DateTime
	 * @return ModifiedDate
	 */
  public /*DateTime*/ String getModifiedDate() {
    return ModifiedDate;
  }

	/**
	 * setModifiedDate
	 * Sets DateTime
	 * @param ModifiedDate String
	 */
  public void setModifiedDate(/*DateTime*/String ModifiedDate) {
    this.ModifiedDate = ModifiedDate;
  }

  /**
	 * getSize
	 * Gets Long
	 * @return Size
	 */
  public Long getSize() {
    return Size;
  }

	/**
	 * setSize
	 * Sets Long
	 * @param Size Long
	 */
  public void setSize(Long Size) {
    this.Size = Size;
  }

  /**
	 * getPath
	 * Gets String
	 * @return Path
	 */
  public String getPath() {
    return Path;
  }

	/**
	 * setPath
	 * Sets String
	 * @param Path String
	 */
  public void setPath(String Path) {
    this.Path = Path;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileVersion {\n");
    sb.append("  VersionId: ").append(VersionId).append("\n");
    sb.append("  IsLatest: ").append(IsLatest).append("\n");
    sb.append("  Name: ").append(Name).append("\n");
    sb.append("  IsFolder: ").append(IsFolder).append("\n");
    sb.append("  ModifiedDate: ").append(ModifiedDate).append("\n");
    sb.append("  Size: ").append(Size).append("\n");
    sb.append("  Path: ").append(Path).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

