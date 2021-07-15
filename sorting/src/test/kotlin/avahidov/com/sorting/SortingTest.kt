package avahidov.com.sorting

import avahidov.com.sorting.bubble.BubbleSorting
import avahidov.com.sorting.shaker.ShakerSort
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.logging.Logger


internal class SortingTest {

    private val logger = Logger.getLogger(SortingTest::class.java.getName())

    @BeforeEach
    fun setUp() {
        logger.info("---- Start test ----")
    }

    @AfterEach
    fun tearDown() {
        logger.info("---- End test ----")
    }

    @ParameterizedTest
    @ArgumentsSource(ArraysSourceTest::class)
    fun sortBubbleFun(expected: Array<Int>, array: Array<Int>) {
        val bubbleSorting = BubbleSorting()
        val sorted = bubbleSorting.sortFun(array)

        logger.info(array.contentToString() + " **** " + sorted.contentToString())

        assertArrayEquals(expected, sorted)
    }

    @ParameterizedTest
    @ArgumentsSource(ArraysSourceTest::class)
    fun sortShakerFun(expected: Array<Int>, array: Array<Int>) {
        val bubbleSorting = ShakerSort()
        val sorted = bubbleSorting.sortFun(array)

        logger.info(array.contentToString() + " **** " + sorted.contentToString())

        assertArrayEquals(expected, sorted)
    }
}