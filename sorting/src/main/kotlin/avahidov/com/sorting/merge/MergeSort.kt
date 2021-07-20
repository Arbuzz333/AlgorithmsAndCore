package avahidov.com.sorting.merge

import avahidov.com.sorting.SortingArray


class MergeSort: SortingArray {

    override fun sortFun(original: Array<Int>): Array<Int> {
        val buffer = Array(original.size) {-1}
        return mergeSortImpl(original, buffer, 0, original.size - 1)
    }

    private fun mergeSortImpl(original: Array<Int>, buffer: Array<Int>, left: Int, right: Int): Array<Int> {
        if (left == right){
            buffer[left] = original[left]
            return buffer
        }
        val middle = (left + right) / 2

        val buffL = mergeSortImpl(original, buffer, left, middle)
        val buffR = if (original.size == 2) original else mergeSortImpl(original, buffer, middle + 1, right)

        val target = if (buffL.contentEquals(original)) buffer else original

        var sL = left
        var sR = middle + 1
        for (i  in left..right){
            if (sL <= middle && sR <= right) {
                if (buffL[sL] < buffR[sR]) {
                    target[i] = buffL[sL++]
                } else {
                    target[i] = buffR[sR++]
                }
            } else if (sL <= middle) {
                target[i] = buffL[sL++]
            } else {
                target[i] = buffR[sR++]
            }
        }
        return target
    }
}