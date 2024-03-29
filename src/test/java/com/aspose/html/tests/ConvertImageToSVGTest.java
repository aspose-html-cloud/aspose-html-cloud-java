package com.aspose.html.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aspose.html.Configuration;
import com.aspose.html.ConverterBuilder;
import com.aspose.html.JobBuilder;
import com.aspose.html.model.OperationResult;
import com.aspose.html.options.VectorizationOptions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;

public class ConvertImageToSVGTest extends BaseTest {

    @BeforeAll
    public static void init(){
        inputFile = Configuration.getTestSrcDir() + File.separator + "car.";
    }

    @ParameterizedTest(name = "{index} - {0} -> svg trace")
    @ValueSource(strings = { "jpg", "bmp", "png", "tiff", "gif" })
    public void traceImageToSvgLocalToLocal(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "traceFrom" + ext.toUpperCase() + "ToSVG.svg";

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        JobBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile + ext)
                .saveToLocal(outputFile);

        OperationResult result = api.convert(builder);
        File dst = new File(result.getFile());
        assertTrue(dst.exists());
    }

    @ParameterizedTest(name = "{index} - {0} -> svg trace with opts")
    @ValueSource(strings = { "jpg", "bmp", "png", "tiff", "gif" })
    public void traceImageToSvgLocalToLocalWithOpts(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "traceFrom" + ext.toUpperCase() + "ToSVGWithOpts.svg";

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        VectorizationOptions opts = new VectorizationOptions()
                .setErrorThreshold(50)
                .setColorLimit(2)
                .setLineWidth(1.5)
                .setMaxIteration(10);

        JobBuilder builder = new ConverterBuilder()
                .fromLocalFile(inputFile + ext)
                .useOptions(opts)
                .saveToLocal(outputFile);

        OperationResult result = api.convert(builder);
        File dst = new File(result.getFile());
        assertTrue(dst.exists());
    }


}
