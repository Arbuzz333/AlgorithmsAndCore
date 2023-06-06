package avahidov.com.sorting.quick

import avahidov.com.sorting.SortingArray


class QuickSort: SortingArray {

    override fun sortFun(original: Array<Int>): Array<Int> {
        return quickSortImpl(original, 0, original.size - 1)
    }

    private fun quickSortImpl(original: Array<Int>, L: Int, R: Int): Array<Int> {
        if (L < R) {
            val q = partition(original, L, R)
            quickSortImpl(original, L, q - 1)
            quickSortImpl(original, q + 1, R)
        }
        return original
    }

    private fun partition(original: Array<Int>, L: Int, R: Int): Int {
        val pointer = original[R]
        var i = (L - 1)

        for (j in L until  R) {
            if (original[j] <= pointer) {
                i++
                val temp = original[i]
                original[i] = original[j]
                original[j] = temp
            }
        }

        val temp = original[i + 1]
        original[i + 1] = original[R]
        original[R] = temp

        return i + 1
    }
}
