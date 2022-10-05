package com.aspose.html.tests;

import com.aspose.html.Utils;
import com.aspose.html.model.InputFormats;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FileFormatTest {

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("test.txt", null),
                Arguments.of("test.html", InputFormats.HTML),
                Arguments.of("test.htm", InputFormats.HTML),
                Arguments.of("test.xml", InputFormats.XHTML),
                Arguments.of("test.xhtml", InputFormats.XHTML),
                Arguments.of("test.epub", InputFormats.EPUB),
                Arguments.of("test.svg", InputFormats.SVG),
                Arguments.of("test.md", InputFormats.MD),

                Arguments.of("TEST.TXT", null),
                Arguments.of("TEST.HTML", InputFormats.HTML),
                Arguments.of("TEST.HTM", InputFormats.HTML),
                Arguments.of("TEST.XML", InputFormats.XHTML),
                Arguments.of("TEST.XHTML", InputFormats.XHTML),
                Arguments.of("TEST.EPUB", InputFormats.EPUB),
                Arguments.of("TEST.SVG", InputFormats.SVG),
                Arguments.of("TEST.MD", InputFormats.MD),

                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\test.txt", null),
                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\test.html", InputFormats.HTML),
                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\test.htm", InputFormats.HTML),
                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\test.xml", InputFormats.XHTML),
                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\test.xhtml", InputFormats.XHTML),
                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\test.epub", InputFormats.EPUB),
                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\test.svg", InputFormats.SVG),
                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\test.md", InputFormats.MD),

                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\TEST.TXT", null),
                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\TEST.HTML", InputFormats.HTML),
                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\TEST.HTM", InputFormats.HTML),
                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\TEST.XML", InputFormats.XHTML),
                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\TEST.XHTML", InputFormats.XHTML),
                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\TEST.EPUB", InputFormats.EPUB),
                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\TEST.SVG", InputFormats.SVG),
                Arguments.of("e:\\TEMP\\HtmlCloud\\html_cloud\\42dfae39-4058-4890-b33e-8af239860851\\TEST.MD", InputFormats.MD)

        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void inputFormatsDetect(String input, InputFormats expected) {
        Assertions.assertEquals(expected, Utils.getInputFormat(input));
    }
}
