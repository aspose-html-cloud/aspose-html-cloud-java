package com.aspose.html.options;

import com.aspose.html.model.OutputFormats;

import java.util.Optional;

public class XPSConversionOptions extends FixedLayoutConversionOptions{

    public XPSConversionOptions()
    {
        this.outputFormat = OutputFormats.XPS;
    }

    public XPSConversionOptions setWidth(int width)
    {
        this.width = Optional.of(width);
        return this;
    }

    public XPSConversionOptions setHeight(int height)
    {
        this.height = Optional.of(height);
        return this;
    }

    public XPSConversionOptions setLeftMargin(int leftMargin)
    {
        this.leftMargin = Optional.of(leftMargin);
        return this;
    }

    public XPSConversionOptions setRightMargin(int rightMargin)
    {
        this.rightMargin = Optional.of(rightMargin);
        return this;
    }

    public XPSConversionOptions setTopMargin(int topMargin)
    {
        this.topMargin = Optional.of(topMargin);
        return this;
    }

    public XPSConversionOptions setBottomMargin(int bottomMargin)
    {
        this.bottomMargin = Optional.of(bottomMargin);
        return this;
    }

}
