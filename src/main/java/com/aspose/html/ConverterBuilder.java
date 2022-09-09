package com.aspose.html;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import com.aspose.html.model.ConversionDataSource;
import com.aspose.html.model.ConversionDataTarget;
import com.aspose.html.model.InputFormats;
import com.aspose.html.model.OutputFormats;
import com.aspose.html.options.ConversionOptions;


public class ConverterBuilder {

    public ConversionDataSource source;
    public ConversionDataTarget target;
    public ConversionOptions options;

    
    public ConverterBuilder()
    {
        source = new ConversionDataSource();
        target = new ConversionDataTarget();
    }

    public ConverterBuilder fromLocalFile(String filePath, List<String> resources)
    {
        this.source.resources = resources;
        return fromLocalFile(filePath);
    }

    public ConverterBuilder fromLocalFile(String filePath, String resourcesDirectory)
    {
        return resourcesDirectory == null || resourcesDirectory.isEmpty() || resourcesDirectory.trim().isEmpty()
                ? fromLocalFile(filePath)
                : fromLocalFile(filePath, Arrays.asList(resourcesDirectory));
    }

    public ConverterBuilder fromLocalFile(String filePath)
    {
        if (filePath == null || filePath.trim().isEmpty())
        {
            throw new IllegalArgumentException("File path is empty");
        }

        filePath = filePath.trim();

        File f = new File(filePath);
        if (!f.exists())
        {
            throw new IllegalArgumentException("File not found");
        }

        InputFormats in = Utils.getInputFormat(filePath);
        if (in == null)
        {
            throw new IllegalArgumentException("Not supported output file extension");
        }

        this.source.inputFormat = in;
        this.source.filePath = filePath;
        this.source.isLocal = true;
        return this;
    }

    public ConverterBuilder fromStorageFile(String filePath, String storageName){

        if (storageName == null || storageName.trim().isEmpty())
        {
            throw new IllegalArgumentException("Storage name is empty");
        }

        this.source.storageName = storageName;
        return fromStorageFile(filePath);
    }

    public ConverterBuilder fromStorageFile(String filePath){

        if (filePath == null || filePath.trim().isEmpty())
        {
            throw new IllegalArgumentException("File path is empty");
        }

        InputFormats in = Utils.getInputFormat(filePath);
        if (in == null)
        {
            throw new IllegalArgumentException("Not supported input file extension");
        }
        this.source.inputFormat = in;
        this.source.filePath = filePath;
        this.source.isLocal = false;
        return this;
    }

    public ConverterBuilder fromUrl(String url){

        if(url == null || url.trim().isEmpty() || !Utils.isURI(url)){
            throw new IllegalArgumentException("Bad URI");
        }

        this.source.inputFormat = InputFormats.HTML;
        this.source.filePath = url;
        this.source.isUrl = true;
        return this;
    }

    public ConverterBuilder saveToLocal(String outputFilePath){
        if (outputFilePath == null || outputFilePath.trim().isEmpty())
        {
            throw new IllegalArgumentException("File path is empty");
        }

        OutputFormats out = Utils.getOutputFormat(outputFilePath);
        if (out == null)
        {
            throw new IllegalArgumentException("Not supported output file extension");
        }
        this.target.isLocal = true;
        this.target.outputFormat = out;
        this.target.filePath = outputFilePath;
        return this;
    }

    public ConverterBuilder saveToStorage(String outputFilePath, String storageName){
        if(storageName == null || storageName.trim().isEmpty() || !source.storageName.equals(target.storageName)){
            throw new IllegalArgumentException("Only same storage conversion is allowed");
        }
        target.storageName = storageName;
        return saveToStorage(outputFilePath);
    }

    public ConverterBuilder saveToStorage(String outputFilePath){
        if (outputFilePath == null || outputFilePath.trim().isEmpty() )
        {
            throw new IllegalArgumentException("Empty output path");
        }

        OutputFormats out = Utils.getOutputFormat(outputFilePath);
        if (out == null)
        {
            throw new IllegalArgumentException("Not supported output file extension");
        }

        this.target.isLocal = false;
        this.target.outputFormat = out;
        this.target.filePath = outputFilePath;
        return this;
    }

    public ConverterBuilder useOptions(ConversionOptions options){
        this.options = options;
        return this;
    }


}
