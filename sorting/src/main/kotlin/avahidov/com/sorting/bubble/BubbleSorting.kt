package avahidov.com.sorting.bubble

import avahidov.com.sorting.SortingArray


class BubbleSorting: SortingArray {

    override fun sortFun(original: Array<Int>): Array<Int> {
        val size = original.size
        for (index in original.indices) {
            for (j in index + 1 until size) {
                if (original[j] < original[index]) {
                    original swapArray(j to index)
                }
            }
        }
        return original
    }
}
