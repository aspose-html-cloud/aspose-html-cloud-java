package com.aspose.html.options;

import java.util.Optional;

public class PDFConversionOptions implements Options {

    public Optional<Double> width = Optional.empty();
    public Optional<Double> height = Optional.empty();
    public Optional<Double> leftMargin = Optional.empty();
    public Optional<Double> rightMargin = Optional.empty();
    public Optional<Double> topMargin = Optional.empty();
    public Optional<Double> bottomMargin = Optional.empty();
    public Optional<Integer> jpegQuality = Optional.empty();

    public PDFConversionOptions()
    {
    }

    public PDFConversionOptions setWidth(double width)
    {
        this.width = Optional.of(width);
        return this;
    }

    public PDFConversionOptions setHeight(double height)
    {
        this.height = Optional.of(height);
        return this;
    }

    public PDFConversionOptions setLeftMargin(double leftMargin)
    {
        this.leftMargin = Optional.of(leftMargin);
        return this;
    }

    public PDFConversionOptions setRightMargin(double rightMargin)
    {
        this.rightMargin = Optional.of(rightMargin);
        return this;
    }

    public PDFConversionOptions setTopMargin(double topMargin)
    {
        this.topMargin = Optional.of(topMargin);
        return this;
    }

    public PDFConversionOptions setBottomMargin(double bottomMargin)
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
