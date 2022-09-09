package com.aspose.html.options;

import com.aspose.html.model.OutputFormats;

import java.util.Optional;

public class PDFConversionOptions extends FixedLayoutConversionOptions {

    public Optional<Integer> jpegQuality = Optional.empty();

    public PDFConversionOptions()
    {
        outputFormat = OutputFormats.PDF;
    }

    public PDFConversionOptions setWidth(int width)
    {
        this.width = Optional.of(width);
        return this;
    }

    public PDFConversionOptions setHeight(int height)
    {
        this.height = Optional.of(height);
        return this;
    }

    public PDFConversionOptions setLeftMargin(int leftMargin)
    {
        this.leftMargin = Optional.of(leftMargin);
        return this;
    }

    public PDFConversionOptions setRightMargin(int rightMargin)
    {
        this.rightMargin = Optional.of(rightMargin);
        return this;
    }

    public PDFConversionOptions setTopMargin(int topMargin)
    {
        this.topMargin = Optional.of(topMargin);
        return this;
    }

    public PDFConversionOptions setBottomMargin(int bottomMargin)
    {
        this.bottomMargin = Optional.of(bottomMargin);
        return this;
    }

    public PDFConversionOptions setQuality(int jpegQuality)
    {
        this.jpegQuality = Optional.of(jpegQuality);
        return this;
    }
}
