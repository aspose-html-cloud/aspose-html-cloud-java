package com.aspose.html.tests;

import com.aspose.html.Configuration;
import com.aspose.html.JobBuilder;
import com.aspose.html.VectorizationBuilder;
import com.aspose.html.model.OperationResult;
import com.aspose.html.options.VectorizationOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VectorizeImageToSVGTest extends BaseTest {

    @BeforeAll
    public static void init(){
        inputFile = Configuration.getTestSrcDir() + File.separator + "car.";
    }

    @ParameterizedTest(name = "{index} - {0} -> svg trace")
    @ValueSource(strings = { "jpg", "bmp", "png", "tiff", "gif" })
    public void vectorizeImageToSvgLocalToLocal(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "vectorizeFrom" + ext.toUpperCase() + "ToSVG.svg";

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        JobBuilder builder = new VectorizationBuilder()
                .fromLocalFile(inputFile + ext)
                .saveToLocal(outputFile);

        OperationResult result = api.vectorize(builder);
        File dst = new File(result.getFile());
        assertTrue(dst.exists());
    }

    @ParameterizedTest(name = "{index} - {0} -> svg vectorize with opts")
    @ValueSource(strings = { "jpg", "bmp", "png", "tiff", "gif" })
    public void vectorizeImageToSvgLocalToLocalWithOpts(String ext) {

        String outputFile = Configuration.getTestDstDir() + File.separator + "vectorizeFrom" + ext.toUpperCase() + "ToSVGWithOpts.svg";

        File f = new File(outputFile);
        if(f.exists()) f.delete();

        VectorizationOptions opts = new VectorizationOptions()
                .setErrorThreshold(50)
                .setColorLimit(2)
                .setLineWidth(1.5)
                .setMaxIteration(10);

        JobBuilder builder = new VectorizationBuilder()
                .fromLocalFile(inputFile + ext)
                .useOptions(opts)
                .saveToLocal(outputFile);

        OperationResult result = api.vectorize(builder);
        File dst = new File(result.getFile());
        assertTrue(dst.exists());
    }
}
