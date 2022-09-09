package com.aspose.html.options;

import java.util.Optional;

public class DOCConversionOptions extends FixedLayoutConversionOptions{

    public DOCConversionOptions setWidth(int width)
    {
        this.width = Optional.of(width);
        return this;
    }

    public DOCConversionOptions setHeight(int height)
    {
        this.height = Optional.of(height);
        return this;
    }

    public DOCConversionOptions setLeftMargin(int leftMargin)
    {
        this.leftMargin = Optional.of(leftMargin);
        return this;
    }

    public DOCConversionOptions setRightMargin(int rightMargin)
    {
        this.rightMargin = Optional.of(rightMargin);
        return this;
    }

    public DOCConversionOptions setTopMargin(int topMargin)
    {
        this.topMargin = Optional.of(topMargin);
        return this;
    }

    public DOCConversionOptions setBottomMargin(int bottomMargin)
    {
        this.bottomMargin = Optional.of(bottomMargin);
        return this;
    }

}
