package avahidov.com.sorting.insertion

import avahidov.com.sorting.SortingArray


class InsertionSort: SortingArray {

    override fun sortFun(original: Array<Int>): Array<Int> {
        var i = 1
        while (i < original.size) {
            val x = original[i]
            var j = i
            while (j > 0 && original[j - 1] > x) {
                original[j] = original[j - 1]
                --j
            }
            original[j] = x
            ++i
        }
        return original
    }
}
