package avahidov.com.sorting.selection

import avahidov.com.sorting.SortingArray


class SelectionSort: SortingArray {

    override fun sortFun(original: Array<Int>): Array<Int> {
        for (i in original.indices) {
            val j = findMin(original, i)
            swapArray(original, i, j)
        }
        return original
    }

    private fun findMin(original: Array<Int>, i: Int): Int {
        var result = i
        var ind = i
        while (++ind < original.size) {
            result = if (original[result] < original[ind]) result else ind
        }
        return result
    }
}
