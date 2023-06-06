package com.avmy.palindrome


/*
* Given a string s, return the longest palindromic substring in s.
* */
object LongestPalindromicSubstring {

    fun longestPalindromic(s: String): String {
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
                if (evenArray[index] >= dEvenMax) {
                    dEvenMax = evenArray[index]
                    iEvenMax = index
                }
            }

            while (index - oddArray[index] >= 0 && index + oddArray[index] < n &&
                (oddArray[index] == 0 || s[index - oddArray[index]] == s[index + oddArray[index]])) {

                oddArray[index]++
                if (oddArray[index] >= dOddMax) {
                    dOddMax = oddArray[index]
                    iOddMax = index
                }
            }
        }

        val oddSub = s.substring(iOddMax - dOddMax + 1, iOddMax + dOddMax)
        val evenSub = s.substring(iEvenMax - dEvenMax + 1, iEvenMax + dEvenMax + 1)
        return if (oddSub.length > evenSub.length) oddSub else evenSub
    }

}