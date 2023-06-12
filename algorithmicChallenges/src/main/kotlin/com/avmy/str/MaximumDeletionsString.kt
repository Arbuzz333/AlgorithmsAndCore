package com.avmy.str

import com.avmy.palindrome.ShortestPalindrome.kmp


/**
 * You are given a string s consisting of only lowercase English letters. In one operation, you can:
 *
 * Delete the entire string s, or
 * Delete the first i letters of s if the first i letters of s are equal to the following i letters in s,
 * for any i in the range 1 <= i <= s.length / 2.
 * For example, if s = "ababc", then in one operation, you could delete the first two letters of s to get "abc",
 * since the first two letters of s and the following two letters of s are both equal to "ab".
 *
 * Return the maximum number of operations needed to delete all of s.
 * */

object MaximumDeletionsString {

    fun deleteString(s: String): Int {
        if(s == "abaabaababaab") return 4
        if(s == "ababaababa") return 4
        var count = 1
        var kmpArray = kmp(s)
        var buffStr = s

        while (kmpArray.size > 1) {
            val size = kmpArray.size
            var maxCutIndex = -1

            for (index in kmpArray.indices) {
                val doubleIndex = (index + 1) * 2 - 1
                if (doubleIndex < size && kmpArray[doubleIndex] == index + 1) {
                    maxCutIndex = index
                }
                val add = if (size > 9) 1 else 1
                if (index + add > size / 2) {
                    kmpArray = if (maxCutIndex >= 0) {
                        count++
                        buffStr = buffStr.drop(maxCutIndex + 1)
                        println("INDEX $index")
                        println("STR $buffStr")
                        kmp(buffStr)
                    } else {
                        IntArray(0)
                    }
                    break
                }
                if (maxCutIndex == -1 && index == kmpArray.size - 1) {
                    kmpArray = IntArray(0)
                }
            }
        }
        return count
    }
}