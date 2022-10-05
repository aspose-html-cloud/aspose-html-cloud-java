package com.aspose.html.tests;

import com.aspose.html.JSON;
import com.aspose.html.options.ConversionOptions;
import com.aspose.html.options.ImageConversionOptions;
import com.aspose.html.options.MarkdownConversionOptions;
import com.aspose.html.options.PDFConversionOptions;
import com.aspose.html.options.XPSConversionOptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SerializatorTest {

    @Test
    public void OptionalImageParamsAll(){
        ConversionOptions source = new ImageConversionOptions()
                .setHeight(800)
                .setWidth(1000)
                .setLeftMargin(10)
                .setRightMargin(10)
                .setBottomMargin(10)
                .setTopMargin(10);
        String expected = "{\"width\":1000,\"height\":800,\"leftMargin\":10," +
                "\"rightMargin\":10,\"topMargin\":10,\"bottomMargin\":10}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalImageParamsPart(){
        ConversionOptions source = new ImageConversionOptions()
                .setHeight(800)
                .setWidth(1000);

        String expected = "{\"width\":1000,\"height\":800}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalImageParamsZero(){
        ConversionOptions source = new ImageConversionOptions();

        String expected = "{}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalPDFParamsAll(){
        ConversionOptions source = new PDFConversionOptions()
                .setWidth(5.8)
                .setHeight(8.3)
                .setTopMargin(0.5)
                .setBottomMargin(0.5)
                .setLeftMargin(0.5)
                .setRightMargin(0.5)
                .setQuality(95);
        String expected = "{\"width\":5.8,\"height\":8.3,\"leftMargin\":0.5," +
                "\"rightMargin\":0.5,\"topMargin\":0.5,\"bottomMargin\":0.5,\"jpegQuality\":95}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalPDFParamsPart(){
        ConversionOptions source = new PDFConversionOptions() .setQuality(95);


        String expected = "{\"jpegQuality\":95}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalPDFParamsZero(){
        ConversionOptions source = new PDFConversionOptions();

        String expected = "{}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalXPSParamsAll(){
        ConversionOptions source = new XPSConversionOptions()
                .setWidth(5.8)
                .setHeight(8.3)
                .setTopMargin(0.5)
                .setBottomMargin(0.5)
                .setLeftMargin(0.5)
                .setRightMargin(0.5);
        String expected = "{\"width\":5.8,\"height\":8.3,\"leftMargin\":0.5," +
                "\"rightMargin\":0.5,\"topMargin\":0.5,\"bottomMargin\":0.5}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalXPSParamsPart(){
        ConversionOptions source = new XPSConversionOptions()
                .setHeight(800)
                .setWidth(1000);

        String expected = "{\"width\":1000.0,\"height\":800.0}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalXPSParamsZero(){
        ConversionOptions source = new XPSConversionOptions();

        String expected = "{}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalMarkdownParamsAll(){
        ConversionOptions source = new MarkdownConversionOptions().setUseGit(true);

        String expected = "{\"useGit\":true}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalMarkdownParamsPart(){
        ConversionOptions source = new MarkdownConversionOptions().setUseGit(false);

        String expected =  "{\"useGit\":false}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalMarkdownParamsZero(){
        ConversionOptions source = new XPSConversionOptions();

        String expected = "{}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

}
