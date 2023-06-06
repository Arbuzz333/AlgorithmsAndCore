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

    fun shortestPalindromeKMP(s: String): String {
        val kmp = kmp(s + "#" + s.reversed())
        val front = s.substring(kmp[kmp.lastIndex]).reversed()
        return front + s
    }

    fun kmp(s: String): IntArray {
        val n: Int = s.length
        val buffArray = IntArray(n)

        for (index in 1 until n) {
            var count = buffArray[index - 1]
            while (count >= 0) {
                if (s[count] == s[index]) {
                    buffArray[index] = count + 1
                    count = -1
                } else {
                    count = if (count - 1 < 0){
                        -1
                    } else {
                        buffArray[count - 1]
                    }
                }
            }
        }

        return buffArray
    }

}