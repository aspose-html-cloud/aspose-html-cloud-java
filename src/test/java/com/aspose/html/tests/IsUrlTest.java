package com.aspose.html.tests;


import com.aspose.html.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsUrlTest {
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("https://www.youtube.com/watch?v=3MtCoqTqPW0", true),
                Arguments.of("https://www.facebook.com/", true),
                Arguments.of("https://ru.wikipedia.org/wiki/DAC", true),
                Arguments.of("www.facebook.com", false),
                Arguments.of("mailto:example.com", false)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void isUrl(String input, boolean expected) {
        Assertions.assertEquals(expected, Utils.isURI(input));
    }
}
