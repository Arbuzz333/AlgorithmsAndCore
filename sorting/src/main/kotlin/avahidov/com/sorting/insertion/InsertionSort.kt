package avahidov.com.sorting.insertion

import avahidov.com.sorting.SortingArray


class InsertionSort: SortingArray {

    override fun sortFun(original: Array<Int>): Array<Int> {
        for (i in 1 until original.size) {
            val x = original[i]
            var j = i
            while (j > 0 && original[j - 1] > x) {
                original[j] = original[j - 1]
                --j
            }
            original[j] = x
        }
        return original
    }
}
