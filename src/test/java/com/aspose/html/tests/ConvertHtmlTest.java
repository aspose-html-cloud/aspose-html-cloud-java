package com.aspose.html.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aspose.html.Configuration;
import com.aspose.html.ConverterBuilder;
import com.aspose.html.model.ConversionResult;
import com.aspose.html.options.ImageConversionOptions;
import com.aspose.html.options.PDFConversionOptions;
import com.aspose.html.options.XPSConversionOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.File;
import java.nio.file.Paths;

public class ConvertHtmlTest extends BaseTest {

    @BeforeAll
    public static void init(){
        inputFile = Configuration.getTestSrcDir() + File.separator + "test1.html";
        inputUrl = "https://stallman.org/articles/anonymous-payments-thru-phones.html";
    }

    @ParameterizedTest(name = "{index} - html -> {0} : local -> local")
    @ValueSource(strings = { "pdf", "xps", "docx", "md", "mhtml", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertHtmlLocalToLocal(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "convertHtmlLocalToLocal." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .saveToLocal(outputFile);

        ConversionResult result = api.convert(builder);
        File dst = new File(result.getFile());
        assertTrue(dst.exists());
    }

    @ParameterizedTest(name = "{index} - html -> {0} : local -> storage")
    @ValueSource(strings = { "pdf", "xps", "docx", "md", "mhtml", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertHtmlLocalToStorage(String ext) {

        String outputFile = "LocalToStorageTest" + File.separator + "convertHtmlLocalToStorage." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .saveToStorage(outputFile);

        ConversionResult result = api.convert(builder);
        assertTrue(TestHelper.isExist(result.getFile()));
        TestHelper.deleteFile(result.getFile());
    }

    @ParameterizedTest(name = "{index} - url -> {0} : save to local")
    @ValueSource(strings = { "pdf", "xps", "docx", "md", "mhtml", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertUrlToLocal(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "convertUrlToLocal." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ConverterBuilder builder = new ConverterBuilder()
                .fromUrl(inputUrl)
                .saveToLocal(outputFile);

        ConversionResult result = api.convert(builder);
        File dst = new File(result.getFile());
        assertTrue(dst.exists());
    }

    @ParameterizedTest(name = "{index} - url -> {0} : save to storage")
    @ValueSource(strings = { "pdf", "xps", "docx", "md", "mhtml", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertUrlToStorage(String ext) {

        String outputFile = "UrlToStorageTest" + File.separator + "convertUrlToStorage." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ConverterBuilder builder = new ConverterBuilder()
                .fromUrl(inputUrl)
                .saveToStorage(outputFile);

        ConversionResult result = api.convert(builder);

        String ff = result.getFile();
        assertTrue(TestHelper.isExist(ff));
        TestHelper.deleteFile(ff);
    }

    @Test
    public void convertHtmlToPdfWithOptions() {

        String outputFile = Configuration.getTestDstDir() + File.separator + "convertHtmlToPdfWithOptions.pdf";

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        PDFConversionOptions opt_A5 = new PDFConversionOptions()
                .setWidth(5.8)
                .setHeight(8.3)
                .setTopMargin(0.5)
                .setBottomMargin(0.5)
                .setLeftMargin(0.5)
                .setRightMargin(0.5)
                .setQuality(95);

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .useOptions(opt_A5)
                .saveToLocal(outputFile);

        ConversionResult result = api.convert(builder);
        String target = Paths.get(builder.target.filePath).getParent().toString()
                + "/" + Paths.get(result.getFile()).getFileName().toString();
        File testFile = new File(target);
        assertTrue(testFile.exists());
    }

    @Test
    public void convertHtmlToXpsWithOptions() {

        String outputFile = Configuration.getTestDstDir() + File.separator + "convertHtmlToXpsWithOptions.xps";

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        XPSConversionOptions opt_A5 = new XPSConversionOptions()
                .setWidth(5.8)
                .setHeight(8.3)
                .setTopMargin(0.5)
                .setBottomMargin(0.5)
                .setLeftMargin(0.5)
                .setRightMargin(0.5);

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .useOptions(opt_A5)
                .saveToLocal(outputFile);

        ConversionResult result = api.convert(builder);
        String target = Paths.get(builder.target.filePath).getParent().toString()
                + "/" + Paths.get(result.getFile()).getFileName().toString();
        File testFile = new File(target);
        assertTrue(testFile.exists());
    }


    @ParameterizedTest(name = "{index} - convert to {0}")
    @ValueSource(strings = { "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertHtmlToImageWithOptions(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "convertHtmlToImageWithOptions." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ImageConversionOptions opt = new ImageConversionOptions()
                .setWidth(600)
                .setHeight(900)
                .setTopMargin(20)
                .setBottomMargin(20)
                .setLeftMargin(20)
                .setRightMargin(20);

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .useOptions(opt)
                .saveToLocal(outputFile);

        ConversionResult result = api.convert(builder);
        String target = Paths.get(builder.target.filePath).getParent().toString()
                + "/" + Paths.get(result.getFile()).getFileName().toString();

        File testFile = new File(target);
        assertTrue(testFile.exists());
    }

}
