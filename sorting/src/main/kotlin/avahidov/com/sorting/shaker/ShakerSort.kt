package avahidov.com.sorting.shaker

import avahidov.com.sorting.SortingArray


class ShakerSort: SortingArray {

    override fun sortFun(original: Array<Int>): Array<Int> {
        if (original.isEmpty()) {
            return original
        }
        var left = 0
        var right = original.size - 1
        while (left <= right) {
            var i = right
            while (i > left) {
                if (original[i - 1] > original[i]) {
                    swapArray(original, i - 1, i)
                }
                --i
            }
            ++left
            i = left
            while (i < right) {
                if (original[i] > original[i + 1]) {
                    swapArray(original, i, i + 1)
                }
                ++i
            }
            --right
        }
        return original
    }
}
