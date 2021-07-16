package avahidov.com.sorting.bubble

import avahidov.com.sorting.SortingArray


class BubbleSorting: SortingArray {

    override fun sortFun(original: Array<Int>): Array<Int> {
        val size = original.size
        for (index in original.indices) {
            var j = index + 1
            while (j < size) {
                if (original[j] < original[index]) {
                    swapArray(original, j, index)
                }
                j++
            }
        }
        return original
    }
}
