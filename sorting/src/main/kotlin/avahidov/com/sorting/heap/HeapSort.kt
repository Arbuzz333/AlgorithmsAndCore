package avahidov.com.sorting.heap

import avahidov.com.sorting.SortingArray


class HeapSort: SortingArray {
    
    override fun sortFun(original: Array<Int>): Array<Int> {
        val n = original.size
        for (i in n / 2 - 1 downTo  0) heapify(original, n, i)

        for (i in n-1 downTo 0) {
            val temp = original[0]
            original[0] = original[i]
            original[i] = temp

            heapify(original, i, 0)
        }
        return original
    }

    private fun heapify(arr: Array<Int>, n: Int, i: Int)
    {
        var largest = i
        val l = 2  * i + 1
        val r = 2 * i + 2

        if (l < n && arr[l] > arr[largest]) largest = l

        if (r < n && arr[r] > arr[largest]) largest = r
        if (largest != i) {
            arr swapArray (i to largest)
            heapify(arr, n, largest)
        }
    }

}