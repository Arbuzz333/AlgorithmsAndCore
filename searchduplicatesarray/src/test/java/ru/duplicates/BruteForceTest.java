package ru.duplicates;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BruteForceTest {

    private final Logger logger = Logger.getLogger("NeighbourArraySearchTest");

    @BeforeAll
    void setUp() {
        logger.info("*** Start ***" + BruteForceTest.class.getName());
    }

    @AfterAll
    void tearDown() {
        logger.info("*** End ***" + BruteForceTest.class.getName());
    }

    @ParameterizedTest
    @MethodSource("getTestArray")
    void testSearchDuplicates(int[] expected, int[] array, int expectedSize) {
        SearchDuplicateArray searchDuplicateArray = new BruteForce();
        int[] actual = searchDuplicateArray.searchDuplicates(array);
        logger.info(Arrays.toString(expected) + " " + Arrays.toString(actual) + " " + expectedSize);
        assertAll("testSearchDuplicates",
                () -> assertEquals(expectedSize, actual.length),
                () -> assertArrayEquals(expected, actual)
        );
    }

    private Stream<Arguments> getTestArray() {
        return Stream.of(
                Arguments.arguments(new int[]{7},        new int[]{5, 7, 6, 1, 4, 7, 3},            1),
                Arguments.arguments(new int[]{7},        new int[]{5, 7, 7, 6, 1, 4, 3, 7},         1),
                Arguments.arguments(new int[]{7, 3},     new int[]{5, 7, 7, 6, 1, 3, 4, 3},         2),
                Arguments.arguments(new int[]{7, 3},     new int[]{5, 7, 7, 6, 7, 1, 3, 4, 3, 3},   2),
                Arguments.arguments(new int[]{7, 10, 3}, new int[]{5, 7, 7, 6, 1, 10, 4, 3, 3, 10}, 3),
                Arguments.arguments(new int[]{5},        new int[]{5, 5},                           1),
                Arguments.arguments(new int[]{5},        new int[]{5, 5, 5},                        1),
                Arguments.arguments(new int[0],          new int[]{5},                              0)
        );
    }
}