package com.avmy.str

import com.avmy.palindrome.ShortestPalindrome

/**
 * A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).
 *
 * Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.
 * */
object LongestHappyPrefix {

    fun longestPrefix(s: String): String {
        val kmpArray = ShortestPalindrome.kmp(s)
        val prefixLength = kmpArray[kmpArray.size - 1]
        return if (prefixLength == 0) "" else s.substring(0, prefixLength)
    }
}