package avahidov.com.sorting.shaker

import avahidov.com.sorting.SortingArray


class ShakerSort: SortingArray {

    override fun sortFun(original: Array<Int>): Array<Int> {
        if (original.isEmpty()) {
            return original
        }
        var right = original.size - 1
        for (left in 0..right) {
            var i = right
            while (i > left) {
                if (original[i - 1] > original[i]) {
                    original swapArray(i - 1 to i)
                }
                --i
            }
            i = left
            while (i < right) {
                if (original[i] > original[i + 1]) {
                    original swapArray(i to i + 1)
                }
                ++i
            }
            --right
        }
        return original
    }
}
