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

public class ConvertXhtmlTest extends BaseTest{

    @BeforeAll
    public static void init(){
        inputFile = Configuration.getTestSrcDir() + File.separator + "test.xhtml";
    }

    @ParameterizedTest(name = "{index} - xhtml -> {0} : local -> local")
    @ValueSource(strings = { "pdf", "xps", "docx", "md", "mhtml", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertXhtmlLocalToLocal(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "xhtmlLocalToLocalTest." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .saveToLocal(outputFile);

        ConversionResult result = api.convert(builder);
        File dst = new File(result.getFile());
        assertTrue(dst.exists());
    }

    @ParameterizedTest(name = "{index} - xhtml -> {0} : local -> storage")
    @ValueSource(strings = { "pdf", "xps", "docx", "md", "mhtml", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertXhtmlLocalToStorage(String ext) {

        String outputFile = "LocalToStorageTest" + File.separator + "xhtmlLocalToStorageTest." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .saveToStorage(outputFile);

        ConversionResult result = api.convert(builder);
        String ff = result.getFile();
        assertTrue(TestHelper.isExist(ff));
        TestHelper.deleteFile(ff);
    }

    @Test
    public void convertXhtmlToPdfWithOptions() {

        String outputFile = Configuration.getTestDstDir() + File.separator + "testXhtmlToPdfWithOpt.pdf";

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        PDFConversionOptions opt = new PDFConversionOptions()
                .setWidth(600)
                .setHeight(900)
                .setTopMargin(20)
                .setBottomMargin(20)
                .setLeftMargin(20)
                .setRightMargin(20)
                .setQuality(95);

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

    @Test
    public void convertXhtmlToXpsWithOptions() {

        String outputFile = Configuration.getTestDstDir() + File.separator + "testXhtmlToXpsWithOpt.xps";

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        XPSConversionOptions opt = new XPSConversionOptions()
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


    @ParameterizedTest(name = "{index} - html convert to {0}")
    @ValueSource(strings = { "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertXhtmlToImageWithOptions(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "testXhtmlToImgWithOpt." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ImageConversionOptions opt = new ImageConversionOptions()
                .setWidth(600)
                .setHeight(900)
                .setTopMargin(20)
                .setBottomMargin(20)
                .setLeftMargin(20)
                .setRightMargin(20)
                .setResolution(300);

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .useOptions(opt)
                .saveToLocal(outputFile);

        ConversionResult result = api.convert(builder);
        File testFile = new File(result.getFile());
        assertTrue(testFile.exists());
        TestHelper.deleteFile(result.getFile());
    }

}
