/**
 * --------------------------------------------------------------------------------------------------------------------
 * <copyright company="Aspose" file="DiscUsage.java">
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

public class DiscUsage {
  private Long UsedSize = null;
  private Long TotalSize = null;
  /**
	 * getUsedSize
	 * Gets Long
	 * @return UsedSize
	 */
  public Long getUsedSize() {
    return UsedSize;
  }

	/**
	 * setUsedSize
	 * Sets Long
	 * @param UsedSize Long
	 */
  public void setUsedSize(Long UsedSize) {
    this.UsedSize = UsedSize;
  }

  /**
	 * getTotalSize
	 * Gets Long
	 * @return TotalSize
	 */
  public Long getTotalSize() {
    return TotalSize;
  }

	/**
	 * setTotalSize
	 * Sets Long
	 * @param TotalSize Long
	 */
  public void setTotalSize(Long TotalSize) {
    this.TotalSize = TotalSize;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DiscUsage {\n");
    sb.append("  UsedSize: ").append(UsedSize).append("\n");
    sb.append("  TotalSize: ").append(TotalSize).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

