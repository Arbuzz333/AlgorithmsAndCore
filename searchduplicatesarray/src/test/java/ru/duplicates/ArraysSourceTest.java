package ru.duplicates;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;


public class ArraysSourceTest implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.arguments(new int[]{7},            new int[]{5, 7, 6, 1, 4, 7, 3},                    1),
                Arguments.arguments(new int[]{7},            new int[]{5, 7, 7, 6, 1, 4, 3, 7},                 1),
                Arguments.arguments(new int[]{3, 7},         new int[]{5, 7, 7, 6, 1, 3, 4, 3},                 2),
                Arguments.arguments(new int[]{3, 7},         new int[]{5, 7, 7, 6, 7, 1, 3, 4, 3, 3},           2),
                Arguments.arguments(new int[]{3, 7, 10, 20}, new int[]{20, 5, 7, 7, 6, 1, 10, 4, 3, 3, 10, 20}, 4),
                Arguments.arguments(new int[]{5},            new int[]{5, 5},                                   1),
                Arguments.arguments(new int[]{5},            new int[]{5, 5, 5},                                1),
                Arguments.arguments(new int[0],              new int[]{5},                                      0)
        );
    }
}
