package com.avmy.palindrome


/**
 * Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.
 * */
object PalindromicSubstrings {

    fun countSubstrings(s: String): Int {
        val n: Int = s.length
        val palEven = IntArray(n)
        val palOdd = IntArray(n)
        var result = 0

        for (index in 0 until n) {
            while (index - palEven[index] >= 0 && index + palEven[index] + 1 < n &&
                s[index - palEven[index]] == s[index + palEven[index] + 1]
            ) {

                result++
                palEven[index]++
            }

            val nextIndex = index + 1
            while (nextIndex < n && nextIndex - palOdd[nextIndex] >= 0 && nextIndex + palOdd[nextIndex] < n &&
                (palOdd[nextIndex] == 0 || s[nextIndex - palOdd[nextIndex]] == s[nextIndex + palOdd[nextIndex]])
            ) {

                result++
                palOdd[nextIndex]++
            }

        }
        return result + 1
    }

}