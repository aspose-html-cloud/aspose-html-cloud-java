## Conversion options

<a name="PDFConversionOptions"></a>
### PDFConversionOptions
```code
ConversionOptions pdfOpts_A4 = new PDFConversionOptions()
    .setHeight(11.7)
    .setWidth(8.3)
    .setLeftMargin(0.2)
    .setRightMargin(0.2)
    .setBottomMargin(0.2)
    .setTopMargin(0.2)
    .setQuality(95);
```

| Name             | Type                 | Description                                      | Notes      |
|------------------|----------------------|--------------------------------------------------|------------|
| **width**        | **Optional<Double>** | Resulting document page width in inches.         | [optional] | 
| **height**       | **Optional<Double>** | Resulting document page height in inches.        | [optional] |
| **leftMargin**   | **Optional<Double>** | Left resulting document page margin in inches.   | [optional] |
| **rightMargin**  | **Optional<Double>** | Right resulting document page margin in inches.  | [optional] |
| **topMargin**    | **Optional<Double>** | Top resulting document page margin in inches.    | [optional] |
| **bottomMargin** | **Optional<Double>** | Bottom resulting document page margin in inches. | [optional] |
| **jpegQuality**  | **Optional<Double>** | Quality of jpeg compression in percent.          | [optional] |

<a name="XPSConversionOptions"></a>

### XPSConversionOptions
```code
ConversionOptions xpsOpts_A5 = new XPSConversionOptions()
    .setHeight(8.3)
    .setWidth(5.8)
    .setLeftMargin(0.5)
    .setRightMargin(0.5)
    .setBottomMargin(0.5)
    .setTopMargin(0.5);
```
| Name             | Type                 | Description                                      | Notes      |
|------------------|----------------------|--------------------------------------------------|------------|
| **width**        | **Optional<Double>** | Resulting document page width in inches.         | [optional] |
| **height**       | **Optional<Double>** | Resulting document page height in inches.        | [optional] |
| **leftMargin**   | **Optional<Double>** | Left resulting document page margin in inches.   | [optional] |
| **rightMargin**  | **Optional<Double>** | Right resulting document page margin in inches.  | [optional] |
| **topMargin**    | **Optional<Double>** | Top resulting document page margin in inches.    | [optional] |
| **bottomMargin** | **Optional<Double>** | Bottom resulting document page margin in inches. | [optional] |

<a name="DocConversionOptions"></a>

### DOCConversionOptions

```code
ConversionOptions docOpts_A3 = new DOCConversionOptions()
    .setHeight(16.5)
    .setWidth(11.7)
    .setLeftMargin(0.5)
    .setRightMargin(0.5)
    .setBottomMargin(0.5)
    .setTopMargin(0.5);
```

| Name             | Type                 | Description                                      | Notes      |
|------------------|----------------------|--------------------------------------------------|------------|
| **width**        | **Optional<Double>** | Resulting document page width in inches.         | [optional] |
| **height**       | **Optional<Double>** | Resulting document page height in inches.        | [optional] |
| **leftMargin**   | **Optional<Double>** | Left resulting document page margin in inches.   | [optional] |
| **rightMargin**  | **Optional<Double>** | Right resulting document page margin in inches.  | [optional] |
| **topMargin**    | **Optional<Double>** | Top resulting document page margin in inches.    | [optional] |
| **bottomMargin** | **Optional<Double>** | Bottom resulting document page margin in inches. | [optional] |

<a name="ImageConversionOptions"></a>
### ImageConversionOptions
```code
ConversionOptions opts = new ImageConversionOptions()
    .setHeight(800)
    .setWidth(1000)
    .setLeftMargin(10)
    .setRightMargin(10)
    .setBottomMargin(10)
    .setTopMargin(10);
```

| Name             | Type                  | Description                                           | Notes      |
|------------------|-----------------------|-------------------------------------------------------|------------|
| **width**        | **Optional<Integer>** | Resulting document page width in pixels.              | [optional] | 
| **height**       | **Optional<Integer>** | Resulting document page height in pixels.             | [optional] |
| **leftMargin**   | **Optional<Integer>** | Left resulting document page margin in pixels.        | [optional] |
| **rightMargin**  | **Optional<Integer>** | Right resulting document page margin in pixels.       | [optional] |
| **topMargin**    | **Optional<Integer>** | Top resulting document page margin in pixels.         | [optional] |
| **bottomMargin** | **Optional<Integer>** | Bottom resulting document page margin in pixels.      | [optional] |


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