package com.aspose.html.options;

import java.util.Optional;

public class DOCConversionOptions implements Options {

    public Optional<Double> width = Optional.empty();
    public Optional<Double> height = Optional.empty();
    public Optional<Double> leftMargin = Optional.empty();;
    public Optional<Double> rightMargin = Optional.empty();;
    public Optional<Double> topMargin = Optional.empty();;
    public Optional<Double> bottomMargin = Optional.empty();;

    public DOCConversionOptions setWidth(double width)
    {
        this.width = Optional.of(width);
        return this;
    }

    public DOCConversionOptions setHeight(double height)
    {
        this.height = Optional.of(height);
        return this;
    }

    public DOCConversionOptions setLeftMargin(double leftMargin)
    {
        this.leftMargin = Optional.of(leftMargin);
        return this;
    }

    public DOCConversionOptions setRightMargin(double rightMargin)
    {
        this.rightMargin = Optional.of(rightMargin);
        return this;
    }

    public DOCConversionOptions setTopMargin(double topMargin)
    {
        this.topMargin = Optional.of(topMargin);
        return this;
    }

    public DOCConversionOptions setBottomMargin(double bottomMargin)
    {
        this.bottomMargin = Optional.of(bottomMargin);
        return this;
    }

}
