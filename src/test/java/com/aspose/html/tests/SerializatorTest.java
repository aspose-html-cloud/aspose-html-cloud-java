package com.aspose.html.tests;

import com.aspose.html.JSON;
import com.aspose.html.options.Options;
import com.aspose.html.options.ImageConversionOptions;
import com.aspose.html.options.MarkdownConversionOptions;
import com.aspose.html.options.PDFConversionOptions;
import com.aspose.html.options.XPSConversionOptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SerializatorTest {

    @Test
    public void OptionalImageParamsAll(){
        Options source = new ImageConversionOptions()
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
        Options source = new ImageConversionOptions()
                .setHeight(800)
                .setWidth(1000);

        String expected = "{\"width\":1000,\"height\":800}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalImageParamsZero(){
        Options source = new ImageConversionOptions();

        String expected = "{}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalPDFParamsAll(){
        Options source = new PDFConversionOptions()
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
        Options source = new PDFConversionOptions() .setQuality(95);


        String expected = "{\"jpegQuality\":95}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalPDFParamsZero(){
        Options source = new PDFConversionOptions();

        String expected = "{}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalXPSParamsAll(){
        Options source = new XPSConversionOptions()
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
        Options source = new XPSConversionOptions()
                .setHeight(800)
                .setWidth(1000);

        String expected = "{\"width\":1000.0,\"height\":800.0}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalXPSParamsZero(){
        Options source = new XPSConversionOptions();

        String expected = "{}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalMarkdownParamsAll(){
        Options source = new MarkdownConversionOptions().setUseGit(true);

        String expected = "{\"useGit\":true}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalMarkdownParamsPart(){
        Options source = new MarkdownConversionOptions().setUseGit(false);

        String expected =  "{\"useGit\":false}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void OptionalMarkdownParamsZero(){
        Options source = new XPSConversionOptions();

        String expected = "{}";

        String result = new JSON().getGson().toJson(source);
        Assertions.assertEquals(expected,result);
    }

}
