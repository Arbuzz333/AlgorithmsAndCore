package avahidov.com.sorting.comb

import avahidov.com.sorting.SortingArray


class CombSort : SortingArray {

    /*Фактор уменьшения*/
    private val factor: Double = 1.247

    override fun sortFun(original: Array<Int>): Array<Int> {
        var step: Int = original.size - 1

        while (step > 1) {
            for (i in original.indices) {
                val j = if (i + step < original.size) i + step else original.size - 1
                if (original[i] > original[j]) {
                    swapArray(original, i, j)
                }
            }
            step = (step / factor).toInt()
        }
        /*сортировка пузырьком*/
        for (idx_i in original.indices) {
            var j = 0
            while (j + 1 < original.size - idx_i) {
                if (original[j + 1] < original[j]) {
                    swapArray(original, j, j + 1)
                }
                j++
            }
        }
        return original
    }
}
