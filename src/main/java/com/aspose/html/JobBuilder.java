package com.aspose.html;

import com.aspose.html.model.DataSource;
import com.aspose.html.model.DataTarget;
import com.aspose.html.model.InputFormats;
import com.aspose.html.model.OutputFormats;
import com.aspose.html.options.Options;

import java.io.File;
import java.util.Arrays;
import java.util.List;


public class JobBuilder {

    public DataSource source;
    public DataTarget target;
    public Options options;


    public JobBuilder()
    {
        source = new DataSource();
        target = new DataTarget();
    }

    public JobBuilder fromLocalFile(String filePath, List<String> resources)
    {
        this.source.resources = resources;
        return fromLocalFile(filePath);
    }

    public JobBuilder fromLocalFile(String filePath, String resourcesDirectory)
    {
        return resourcesDirectory == null || resourcesDirectory.isEmpty() || resourcesDirectory.trim().isEmpty()
                ? fromLocalFile(filePath)
                : fromLocalFile(filePath, Arrays.asList(resourcesDirectory));
    }

    public JobBuilder fromLocalFile(String filePath)
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

    public JobBuilder fromStorageFile(String filePath, String storageName){

        if (storageName == null || storageName.trim().isEmpty())
        {
            throw new IllegalArgumentException("Storage name is empty");
        }

        this.source.storageName = storageName;
        return fromStorageFile(filePath);
    }

    public JobBuilder fromStorageFile(String filePath){

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

    public JobBuilder fromUrl(String url){

        if(url == null || url.trim().isEmpty() || !Utils.isURI(url)){
            throw new IllegalArgumentException("Bad URI");
        }

        this.source.inputFormat = InputFormats.HTML;
        this.source.filePath = url;
        this.source.isUrl = true;
        return this;
    }

    public JobBuilder saveToLocal(String outputFilePath){
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

    public JobBuilder saveToStorage(String outputFilePath, String storageName){
        if(storageName == null || storageName.trim().isEmpty() || !source.storageName.equals(target.storageName)){
            throw new IllegalArgumentException("Only same storage conversion is allowed");
        }
        target.storageName = storageName;
        return saveToStorage(outputFilePath);
    }

    public JobBuilder saveToStorage(String outputFilePath){
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

    public JobBuilder useOptions(Options options){
        this.options = options;
        return this;
    }


}
