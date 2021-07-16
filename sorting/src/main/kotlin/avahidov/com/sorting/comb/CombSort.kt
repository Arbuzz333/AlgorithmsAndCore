package avahidov.com.sorting.comb

import avahidov.com.sorting.SortingArray


class CombSort : SortingArray {

    /*Фактор уменьшения*/
    private val factor: Double = 1.247

    override fun sortFun(original: Array<Int>): Array<Int> {
        var step: Int = original.size - 1

        while (step >= 1) {
            for (i in original.indices) {
                val j = if (i + step < original.size) i + step else original.size - 1
                if (original[i] > original[j]) {
                    swapArray(original, i, j)
                }
            }
            step = (step / factor).toInt()
        }
        return original
    }
}
