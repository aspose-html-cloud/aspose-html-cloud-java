package com.aspose.html.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aspose.html.Configuration;
import com.aspose.html.ConverterBuilder;
import com.aspose.html.JobBuilder;
import com.aspose.html.model.OperationResult;
import com.aspose.html.options.ImageConversionOptions;
import com.aspose.html.options.PDFConversionOptions;
import com.aspose.html.options.XPSConversionOptions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

public class ConvertHtmlTestAsync extends BaseTest{

    @BeforeAll
    public static void init(){
        inputFile = Configuration.getTestSrcDir() + File.separator + "test1.html";
        inputUrl = "https://stallman.org/articles/anonymous-payments-thru-phones.html";
    }

    @ParameterizedTest(name = "{index} - html -> {0} : local -> local async")
    @ValueSource(strings = { "pdf", "xps", "docx", "md", "mhtml", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertHtmlLocalToLocalAsync(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "convertHtmlLocalToLocalAsync." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        JobBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .saveToLocal(outputFile);

        CompletableFuture<OperationResult>
                cf = CompletableFuture.supplyAsync(() -> api.convert(builder));

        cf.whenComplete((result, err) -> {
           if(err == null){
               File dst = new File(result.getFile());
               assertTrue(dst.exists());
           } else {
               throw new RuntimeException(err.getMessage());
           }
        });

        waitForDone(cf);

    }

    @ParameterizedTest(name = "{index} - html -> {0} : local -> storage async")
    @ValueSource(strings = { "pdf", "xps", "docx", "md", "mhtml", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertHtmlLocalToStorageAsync(String ext) {

        String outputFile = "LocalToStorageTest" + File.separator + "convertHtmlLocalToStorageAsync." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        JobBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .saveToStorage(outputFile);

        CompletableFuture<OperationResult>
                cf = CompletableFuture.supplyAsync(() -> api.convert(builder));

        cf.whenComplete((result, err) -> {
            assertTrue(TestHelper.isExist(result.getFile()));
            TestHelper.deleteFile(result.getFile());
        });

        waitForDone(cf);
    }

    @ParameterizedTest(name = "{index} - url -> {0} : save to local async")
    @ValueSource(strings = { "pdf", "xps", "docx", "md", "mhtml", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertUrlToLocalAsync(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "convertUrlToLocalAsync." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        JobBuilder builder = new ConverterBuilder()
                .fromUrl(inputUrl)
                .saveToLocal(outputFile);

        CompletableFuture<OperationResult>
                cf = CompletableFuture.supplyAsync(() -> api.convert(builder));

        cf.whenComplete((result, err) -> {
            File dst = new File(result.getFile());
            assertTrue(dst.exists());
        });
        waitForDone(cf);
    }

    @ParameterizedTest(name = "{index} - url -> {0} : save to storage async")
    @ValueSource(strings = { "pdf", "xps", "docx", "md", "mhtml", "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertUrlToStorageAsync(String ext) {

        String outputFile = "UrlToStorageTest" + File.separator + "convertUrlToStorageAsync." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        JobBuilder builder = new ConverterBuilder()
                .fromUrl(inputUrl)
                .saveToStorage(outputFile);

        CompletableFuture<OperationResult>
                cf = CompletableFuture.supplyAsync(() -> api.convert(builder));

        cf.whenComplete((result, err) -> {
            String ff = result.getFile();
            assertTrue(TestHelper.isExist(ff));
            TestHelper.deleteFile(ff);
        });
        waitForDone(cf);
    }

    @Test
    public void convertHtmlToPdfWithOptionsAsync() {

        String outputFile = Configuration.getTestDstDir() + File.separator + "convertHtmlToPdfWithOptionsAsync.pdf";

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

        JobBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .useOptions(opt_A5)
                .saveToLocal(outputFile);

        CompletableFuture<OperationResult>
                cf = CompletableFuture.supplyAsync(() -> api.convert(builder));

        cf.whenComplete((result, err) -> {
            String target = Paths.get(builder.target.filePath).getParent().toString()
                    + "/" + Paths.get(result.getFile()).getFileName().toString();
            File testFile = new File(target);
            assertTrue(testFile.exists());
        });
        waitForDone(cf);
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

        JobBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .useOptions(opt_A5)
                .saveToLocal(outputFile);

        CompletableFuture<OperationResult>
                cf = CompletableFuture.supplyAsync(() -> api.convert(builder));

        cf.whenComplete((result, err) -> {
            String target = Paths.get(builder.target.filePath).getParent().toString()
                    + "/" + Paths.get(result.getFile()).getFileName().toString();
            File testFile = new File(target);
            assertTrue(testFile.exists());
        });
        waitForDone(cf);
    }


    @ParameterizedTest(name = "{index} - convert to {0}")
    @ValueSource(strings = { "jpeg", "bmp", "png", "tiff", "gif" })
    public void convertHtmlToImageWithOptionsAsync(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "convertHtmlToImageWithOptionsAsync." + ext;

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        ImageConversionOptions opt = new ImageConversionOptions()
                .setWidth(600)
                .setHeight(900)
                .setTopMargin(20)
                .setBottomMargin(20)
                .setLeftMargin(20)
                .setRightMargin(20);

        JobBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile)
                .useOptions(opt)
                .saveToLocal(outputFile);

        CompletableFuture<OperationResult>
                cf = CompletableFuture.supplyAsync(() -> api.convert(builder));
        cf.whenComplete((result, err) -> {
            String target = Paths.get(builder.target.filePath).getParent().toString()
                    + "/" + Paths.get(result.getFile()).getFileName().toString();
            File testFile = new File(target);
            assertTrue(testFile.exists());
        });
        waitForDone(cf);
    }

    private void waitForDone(CompletableFuture<OperationResult> cf) {
        while (!cf.isDone()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                assertTrue(false);
            }
        }
    }

}
