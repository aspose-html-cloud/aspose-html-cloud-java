package com.aspose.html.model;


/**
 * Formats of the input files.
 */
public enum InputFormats {
  HTML("HTML"),
  XHTML("XHTML"),
  MHTML("MHTML"),
  EPUB("EPUB"),
  SVG("SVG"),
  MD("MD"),
  JPEG("JPEG"),
  BMP("BMP"),
  GIF("GIF"),
  TIFF("TIFF"),
  PNG("PNG");

  private String value;

  InputFormats(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static InputFormats fromValue(String text) {
    for (InputFormats b : InputFormats.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
  
}
