package com.aspose.html.options;

import java.util.Optional;

public class XPSConversionOptions implements ConversionOptions{
    public Optional<Double> width = Optional.empty();
    public Optional<Double> height = Optional.empty();
    public Optional<Double> leftMargin = Optional.empty();
    public Optional<Double> rightMargin = Optional.empty();
    public Optional<Double> topMargin = Optional.empty();
    public Optional<Double> bottomMargin = Optional.empty();

    public XPSConversionOptions()
    {

    }

    public XPSConversionOptions setWidth(double width)
    {
        this.width = Optional.of(width);
        return this;
    }

    public XPSConversionOptions setHeight(double height)
    {
        this.height = Optional.of(height);
        return this;
    }

    public XPSConversionOptions setLeftMargin(double leftMargin)
    {
        this.leftMargin = Optional.of(leftMargin);
        return this;
    }

    public XPSConversionOptions setRightMargin(double rightMargin)
    {
        this.rightMargin = Optional.of(rightMargin);
        return this;
    }

    public XPSConversionOptions setTopMargin(double topMargin)
    {
        this.topMargin = Optional.of(topMargin);
        return this;
    }

    public XPSConversionOptions setBottomMargin(double bottomMargin)
    {
        this.bottomMargin = Optional.of(bottomMargin);
        return this;
    }

}
