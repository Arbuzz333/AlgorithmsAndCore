package ru.duplicates;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;



class BySortedArrayTest {

    private final Logger logger = Logger.getLogger(BySortedArray.class.getName());

    @BeforeEach
    void setUp() {
        logger.info("---- Start test ----");
    }

    @AfterEach
    void tearDown() {
        logger.info("---- End test ----");
    }

    @ParameterizedTest
    @ArgumentsSource(ArraysSourceTest.class)
    void searchDuplicates(int[] expected, int[] array, int expectedSize) {
        SearchDuplicateArray searchDuplicateArray = new BySortedArray();
        int[] actual = searchDuplicateArray.searchDuplicates(array);

        logger.info(Arrays.toString(expected) + " " + Arrays.toString(actual) + " " + expectedSize);
        assertAll("testSearchDuplicates",
                () -> assertEquals(expectedSize, actual.length),
                () -> assertArrayEquals(expected, actual)
        );
    }
}