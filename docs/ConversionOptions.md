## Conversion options

<a name="PDFConversionOptions"></a>
### PDFConversionOptions
```code
ConversionOptions pdfOpts = new PDFConversionOptions()
    .setHeight(800)
    .setWidth(1000)
    .setLeftMargin(10)
    .setRightMargin(10)
    .setBottomMargin(10)
    .setTopMargin(10)
    .setQuality(95);
```

| Name              | Type                  | Description                                       | Notes      |
|-------------------|-----------------------|---------------------------------------------------|------------|
| **width**         | **Optional<Integer>** | Resulting document page width in pixels.          | [optional] | 
| **height**        | **Optional<Integer>** | Resulting document page height in pixels.         | [optional] |
| **leftMargin**    | **Optional<Integer>** | Left resulting document page margin in pixels.    | [optional] |
| **rightMargin**   | **Optional<Integer>** | Right resulting document page margin in pixels.   | [optional] |
| **topMargin**     | **Optional<Integer>** | Top resulting document page margin in pixels.     | [optional] |
| **bottomMargin**  | **Optional<Integer>** | Bottom resulting document page margin in pixels.  | [optional] |
| **jpegQuality**   | **Optional<Integer>** | Quality of jpeg compression in percent.           | [optional] |

<a name="XPSConversionOptions"></a>

### XPSConversionOptions
```code
ConversionOptions xpsOpts = new XPSConversionOptions()
    .setHeight(800)
    .setWidth(1000)
    .setLeftMargin(10)
    .setRightMargin(10)
    .setBottomMargin(10)
    .setTopMargin(10);
```
| Name             | Type                  | Description                                      | Notes      |
|------------------|-----------------------|--------------------------------------------------|------------|
| **width**        | **Optional<Integer>** | Resulting document page width in pixels.         | [optional] |
| **height**       | **Optional<Integer>** | Resulting document page height in pixels.        | [optional] |
| **leftMargin**   | **Optional<Integer>** | Left resulting document page margin in pixels.   | [optional] |
| **rightMargin**  | **Optional<Integer>** | Right resulting document page margin in pixels.  | [optional] |
| **topMargin**    | **Optional<Integer>** | Top resulting document page margin in pixels.    | [optional] |
| **bottomMargin** | **Optional<Integer>** | Bottom resulting document page margin in pixels. | [optional] |

<a name="DocConversionOptions"></a>

### DOCConversionOptions

```code
ConversionOptions docOpts = new DOCConversionOptions()
    .setHeight(800)
    .setWidth(1000)
    .setLeftMargin(10)
    .setRightMargin(10)
    .setBottomMargin(10)
    .setTopMargin(10);
```

| Name             | Type                  | Description                                      | Notes      |
|------------------|-----------------------|--------------------------------------------------|------------|
| **width**        | **Optional<Integer>** | Resulting document page width in pixels.         | [optional] |
| **height**       | **Optional<Integer>** | Resulting document page height in pixels.        | [optional] |
| **leftMargin**   | **Optional<Integer>** | Left resulting document page margin in pixels.   | [optional] |
| **rightMargin**  | **Optional<Integer>** | Right resulting document page margin in pixels.  | [optional] |
| **topMargin**    | **Optional<Integer>** | Top resulting document page margin in pixels.    | [optional] |
| **bottomMargin** | **Optional<Integer>** | Bottom resulting document page margin in pixels. | [optional] |

<a name="JPEGConversionOptions"></a>

### JPEGConversionOptions
```code
ConversionOptions jpgOpts = new JPEGConversionOptions()
    .setHeight(800)
    .setWidth(1000)
    .setLeftMargin(10)
    .setRightMargin(10)
    .setBottomMargin(10)
    .setTopMargin(10)
    .setResolution(300);
```

| Name             | Type                  | Description                                           | Notes      |
|------------------|-----------------------|-------------------------------------------------------|------------|
| **width**        | **Optional<Integer>** | Resulting document page width in pixels.              | [optional] | 
| **height**       | **Optional<Integer>** | Resulting document page height in pixels.             | [optional] |
| **leftMargin**   | **Optional<Integer>** | Left resulting document page margin in pixels.        | [optional] |
| **rightMargin**  | **Optional<Integer>** | Right resulting document page margin in pixels.       | [optional] |
| **topMargin**    | **Optional<Integer>** | Top resulting document page margin in pixels.         | [optional] |
| **bottomMargin** | **Optional<Integer>** | Bottom resulting document page margin in pixels.      | [optional] |
| **Resolution**   | **Optional<Integer>** | Resolution of resulting image. The default is 96 dpi. | [optional] |

<a name="PNGConversionOptions"></a> 
### PNGConversionOptions
```code
ConversionOptions pngOpts = new PNGConversionOptions()
    .setHeight(800)
    .setWidth(1000)
    .setLeftMargin(10)
    .setRightMargin(10)
    .setBottomMargin(10)
    .setTopMargin(10)
    .setResolution(300);
```

| Name              | Type                  | Description                                           | Notes      |
|-------------------|-----------------------|-------------------------------------------------------|------------|
| **width**         | **Optional<Integer>** | Resulting document page width in pixels.              | [optional] | 
| **height**        | **Optional<Integer>** | Resulting document page height in pixels.             | [optional] |
| **leftMargin**    | **Optional<Integer>** | Left resulting document page margin in pixels.        | [optional] | 
| **rightMargin**   | **Optional<Integer>** | Right resulting document page margin in pixels.       | [optional] |
| **topMargin**     | **Optional<Integer>** | Top resulting document page margin in pixels.         | [optional] |
| **bottomMargin**  | **Optional<Integer>** | Bottom resulting document page margin in pixels.      | [optional] |
| **resolution**    | **Optional<Integer>** | Resolution of resulting image. The default is 96 dpi. | [optional] |

<a name="BMPConversionOptions"></a>
### BMPConversionOptions
```code
ConversionOptions bmpOpts = new BMPConversionOptions()
    .setHeight(800)
    .setWidth(1000)
    .setLeftMargin(10)
    .setRightMargin(10)
    .setBottomMargin(10)
    .setTopMargin(10)
    .setResolution(300);
```

| Name             | Type                  | Description                                           | Notes      |
|------------------|-----------------------|-------------------------------------------------------|------------|
| **width**        | **Optional<Integer>** | Resulting document page width in pixels.              | [optional] | 
| **height**       | **Optional<Integer>** | Resulting document page height in pixels.             | [optional] |
| **leftMargin**   | **Optional<Integer>** | Left resulting document page margin in pixels.        | [optional] | 
| **rightMargin**  | **Optional<Integer>** | Right resulting document page margin in pixels.       | [optional] |
| **topMargin**    | **Optional<Integer>** | Top resulting document page margin in pixels.         | [optional] |
| **bottomMargin** | **Optional<Integer>** | Bottom resulting document page margin in pixels.      | [optional] |
| **resolution**   | **Optional<Integer>** | Resolution of resulting image. The default is 96 dpi. | [optional] |

<a name="GIFConversionOptions"></a>
### GIFConversionOptions
```code
ConversionOptions gifOpts = new GIFConversionOptions()
    .setHeight(800)
    .setWidth(1000)
    .setLeftMargin(10)
    .setRightMargin(10)
    .setBottomMargin(10)
    .setTopMargin(10)
    .setResolution(300);
```

| Name             | Type                  | Description                                           | Notes      |
|------------------|-----------------------|-------------------------------------------------------|------------|
| **width**        | **Optional<Integer>** | Resulting document page width in pixels.              | [optional] |
| **height**       | **Optional<Integer>** | Resulting document page height in pixels.             | [optional] |
| **leftMargin**   | **Optional<Integer>** | Left resulting document page margin in pixels.        | [optional] |
| **rightMargin**  | **Optional<Integer>** | Right resulting document page margin in pixels.       | [optional] |
| **topMargin**    | **Optional<Integer>** | Top resulting document page margin in pixels.         | [optional] |
| **bottomMargin** | **Optional<Integer>** | Bottom resulting document page margin in pixels.      | [optional] |
| **resolution**   | **Optional<Integer>** | Resolution of resulting image. The default is 96 dpi. | [optional] |

<a name="TIFFConversionOptions"></a>
### TIFFConversionOptions
```code
ConversionOptions tiffOpts = new TIFFConversionOptions()
    .setHeight(800)
    .setWidth(1000)
    .setLeftMargin(10)
    .setRightMargin(10)
    .setBottomMargin(10)
    .setTopMargin(10)
    .setResolution(300);
```

| Name              | Type                  | Description                                           | Notes      |
|-------------------|-----------------------|-------------------------------------------------------|------------|
| **width**         | **Optional<Integer>** | Resulting document page width in pixels.              | [optional] |
| **height**        | **Optional<Integer>** | Resulting document page height in pixels.             | [optional] |
| **leftMargin**    | **Optional<Integer>** | Left resulting document page margin in pixels.        | [optional] | 
| **rightMargin**   | **Optional<Integer>** | Right resulting document page margin in pixels.       | [optional] |
| **topMargin**     | **Optional<Integer>** | Top resulting document page margin in pixels.         | [optional] |
| **bottomMargin**  | **Optional<Integer>** | Bottom resulting document page margin in pixels.      | [optional] |
| **resolution**    | **Optional<Integer>** | Resolution of resulting image. The default is 96 dpi. | [optional] |

<a name="MarkdownConversionOptions"></a>
### MarkdownConversionOptions
```code
ConversionOptions mdOpts = new MarkdownConversionOptions()
    .setUseGit(true);
```
| Name       | Type        | Description                                                        | Notes       |
|------------|-------------|--------------------------------------------------------------------|-------------|
| **useGit** | **boolean** | Use [Git Markdown flavor](https://github.github.com/gfm/) to save. | [optional]  |



For additional information about Aspose.HTML Cloud REST API and SDKs, visit the [Aspose documentation site](https://docs.aspose.cloud/html/overview/).