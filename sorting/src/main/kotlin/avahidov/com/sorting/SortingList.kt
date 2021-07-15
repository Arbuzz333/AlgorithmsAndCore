package avahidov.com.sorting


interface SortingList {

    fun sortFun(original: Array<Int>): Array<Int>

    fun swapArray(original: Array<Int>, i: Int, j: Int) {
        val temp = original[i]
        original[i] = original[j]
        original[j] = temp
    }
}
