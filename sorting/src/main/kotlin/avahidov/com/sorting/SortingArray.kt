package avahidov.com.sorting


interface SortingArray {

    fun sortFun(original: Array<Int>): Array<Int>

    infix fun <T> Array<T>.swapArray(p: Pair<Int, Int>) {
        val temp = this[p.first]
        this[p.first] = this[p.second]
        this[p.second] = temp
    }
}
