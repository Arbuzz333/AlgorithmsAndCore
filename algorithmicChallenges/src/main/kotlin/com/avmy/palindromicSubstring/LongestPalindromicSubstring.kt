package com.avmy.palindromicSubstring


/*
* Given a string s, return the longest palindromic substring in s.
* */
object LongestPalindromicSubstring {

    fun longestPalindromic(s: String): String {
        if (s.length < 2) return s

        val oddPair = palOdd(s)
        val oddSub = s.substring(oddPair.second - oddPair.first + 1, oddPair.second + oddPair.first)
        val evenPair = palEven(s)
        val evenSub = s.substring(evenPair.second - evenPair.first + 1, evenPair.second + evenPair.first + 1)
        return if (oddSub.length > evenSub.length) oddSub else evenSub
    }

    private fun palOdd(s: String): Pair<Int, Int> {
        var dMax = 0
        var iMax = 0

        val n: Int = s.length
        val d = IntArray(s.length)
        var right = 0
        for (index  in 1 until n) {

            while (index - d[index] >= 0 && index + d[index] < n && (index - d[index] == index + d[index] || s[index - d[index]] == s[index + d[index]])) {
                d[index]++
                if (d[index] >= dMax) {
                    dMax = d[index]
                    iMax = index
                }
            }
            if (index + d[index] - 1 > right) {
                right = index + d[index] - 1
            }
        }
        return Pair(dMax, iMax)
    }

    private fun palEven(s: String): Pair<Int, Int> {

        var dMax = 0
        var iMax = 0

        val n: Int = s.length
        val d = IntArray(s.length)

        var right = -1

        for (index  in 0 until n) {

            while (index - d[index] >= 0 && index + d[index] + 1 < n && s[index - d[index]] == s[index + d[index] + 1]) {
                d[index]++
                if (d[index] >= dMax) {
                    dMax = d[index]
                    iMax = index
                }
            }
            if (index + d[index] > right) {
                right = index + d[index]
            }
        }

        return Pair(dMax, iMax)
    }
}