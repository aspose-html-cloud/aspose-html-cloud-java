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

public class ConvertEpubTest extends BaseTest{

    @BeforeAll
    public static void init(){
        inputFile = Configuration.getTestSrcDir() + File.separator + "test.epub";
    }

    @ParameterizedTest(name = "{index} - epub -> {0} : local -> local")
    @ValueSource(strings = { "pdf", "xps", "docx", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertEpubLocalToLocalTest(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "test." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .saveToLocal(outputFile);

        ConversionResult result = api.convert(builder);
        File dst = new File(result.getFile());
        assertTrue(dst.exists());
    }

    @ParameterizedTest(name = "{index} - epub -> {0} : local -> storage")
    @ValueSource(strings = { "pdf", "xps", "docx", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertEpubLocalToStorageTest(String ext) {

        String outputFile = "LocalToStorageTest" + File.separator + "test." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ConverterBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .saveToStorage(outputFile);

        ConversionResult result = api.convert(builder);
        assertTrue(TestHelper.isExist(result.getFile()));
        TestHelper.deleteFile(result.getFile());
    }

    @Test
    public void convertEpubToPdfWithOptions() {

        String outputFile = Configuration.getTestDstDir() + File.separator + "testWithOpt.pdf";

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
    public void convertEpubToXpsWithOptions() {

        String outputFile = Configuration.getTestDstDir() + File.separator + "testWithOpt.xps";

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


    @ParameterizedTest(name = "{index} - convert to {0}")
    @ValueSource(strings = { "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertEpubToImageWithOptions(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "testWithOpt." + ext;

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
