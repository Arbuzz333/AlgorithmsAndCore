package com.avmy.palindrome


/**
 * You are given a string s. You can convert s to a
 * palindrome
 * by adding characters in front of it.
 * Return the shortest palindrome you can find by performing this transformation.
 * */
object ShortestPalindrome {

    fun shortestPalindrome(s: String): String {
        if(s.isEmpty()) return s

        var dEvenMax = 0
        var iEvenMax = 0
        var dOddMax = 0
        var iOddMax = 0

        val n: Int = s.length
        val evenArray = IntArray(n)
        val oddArray = IntArray(n)

        for (index  in 0 until n) {

            while (index - evenArray[index] >= 0 && index + evenArray[index] + 1 < n &&
                s[index - evenArray[index]] == s[index + evenArray[index] + 1]) {

                evenArray[index]++
                if (index - evenArray[index] + 1 == 0) {
                    dEvenMax = evenArray[index]
                    iEvenMax = index
                }
            }

            while (index - oddArray[index] >= 0 && index + oddArray[index] < n &&
                (oddArray[index] == 0 || s[index - oddArray[index]] == s[index + oddArray[index]])) {

                oddArray[index]++
                if (index - oddArray[index] + 1 == 0) {
                    dOddMax = oddArray[index]
                    iOddMax = index
                }
            }
        }

        return if (dOddMax > dEvenMax) {
            val oddSubEnd = s.substring(dOddMax + iOddMax)
            oddSubEnd.reversed() + s
        } else {
            val evenSubEnd = s.substring(dEvenMax + iEvenMax + 1)
            evenSubEnd.reversed() + s
        }


    }
}