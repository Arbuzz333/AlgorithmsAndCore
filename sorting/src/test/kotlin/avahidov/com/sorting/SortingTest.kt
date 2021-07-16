package avahidov.com.sorting

import avahidov.com.sorting.bubble.BubbleSorting
import avahidov.com.sorting.comb.CombSort
import avahidov.com.sorting.insertion.InsertionSort
import avahidov.com.sorting.quick.QuickSort
import avahidov.com.sorting.selection.SelectionSort
import avahidov.com.sorting.shaker.ShakerSort
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.logging.Logger


internal class SortingTest {

    private val logger = Logger.getLogger(SortingTest::class.java.name)

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
        val sorting = ShakerSort()
        val sorted = sorting.sortFun(array)

        logger.info(array.contentToString() + " **** " + sorted.contentToString())

        assertArrayEquals(expected, sorted)
    }

    @ParameterizedTest
    @ArgumentsSource(ArraysSourceTest::class)
    fun sortCombFun(expected: Array<Int>, array: Array<Int>) {
        val sorting = CombSort()
        val sorted = sorting.sortFun(array)

        logger.info(array.contentToString() + " **** " + sorted.contentToString())

        assertArrayEquals(expected, sorted)
    }

    @ParameterizedTest
    @ArgumentsSource(ArraysSourceTest::class)
    fun sortInsertionFun(expected: Array<Int>, array: Array<Int>) {
        val sorting = InsertionSort()
        val sorted = sorting.sortFun(array)

        logger.info(array.contentToString() + " **** " + sorted.contentToString())

        assertArrayEquals(expected, sorted)
    }

    @ParameterizedTest
    @ArgumentsSource(ArraysSourceTest::class)
    fun sortSelectionFun(expected: Array<Int>, array: Array<Int>) {
        val sorting = SelectionSort()
        val sorted = sorting.sortFun(array)

        logger.info(array.contentToString() + " **** " + sorted.contentToString())

        assertArrayEquals(expected, sorted)
    }

    @ParameterizedTest
    @ArgumentsSource(ArraysSourceTest::class)
    fun sortQuickFun(expected: Array<Int>, array: Array<Int>) {
        val sorting = QuickSort()
        val sorted = sorting.sortFun(array)

        logger.info(array.contentToString() + " **** " + sorted.contentToString())

        assertArrayEquals(expected, sorted)
    }
}
