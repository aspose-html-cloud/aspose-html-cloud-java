package com.aspose.html.options;


import java.util.Optional;

public class ImageConversionOptions implements ConversionOptions{

    public Optional<Integer> width = Optional.empty();
    public Optional<Integer> height = Optional.empty();
    public Optional<Integer> leftMargin = Optional.empty();;
    public Optional<Integer> rightMargin = Optional.empty();;
    public Optional<Integer> topMargin = Optional.empty();;
    public Optional<Integer> bottomMargin = Optional.empty();;

    public ImageConversionOptions setWidth(int width)
    {
        this.width = Optional.of(width);
        return this;
    }

    public ImageConversionOptions setHeight(int height)
    {
        this.height = Optional.of(height);
        return this;
    }

    public ImageConversionOptions setLeftMargin(int leftMargin)
    {
        this.leftMargin = Optional.of(leftMargin);
        return this;
    }

    public ImageConversionOptions setRightMargin(int rightMargin)
    {
        this.rightMargin = Optional.of(rightMargin);
        return this;
    }

    public ImageConversionOptions setTopMargin(int topMargin)
    {
        this.topMargin = Optional.of(topMargin);
        return this;
    }

    public ImageConversionOptions setBottomMargin(int bottomMargin)
    {
        this.bottomMargin = Optional.of(bottomMargin);
        return this;
    }

}
