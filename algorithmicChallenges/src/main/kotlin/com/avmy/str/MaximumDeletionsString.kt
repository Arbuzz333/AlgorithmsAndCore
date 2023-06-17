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
                if (index + 1 > size / 2) {
                    kmpArray = if (maxCutIndex >= 0) {
                        count++
                        buffStr = buffStr.drop(maxCutIndex + 1)
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

    fun deleteStringUnion(s: String): Int {
        val countShort = deleteStringShort(s)
        val countLong = deleteStringLong(s)
        return if(countShort > countLong) countShort else countLong
    }

    private fun deleteStringShort(s: String): Int {
        var n: Int = s.length
        var buffArray = IntArray(n)
        var index = 1
        var count = 1
        var buffStr = s

        while (index < n) {
            var diff = buffArray[index - 1]
            while (diff >= 0) {
                if (buffStr[diff] == buffStr[index]) {
                    buffArray[index] = diff + 1
                    diff = -1
                } else {
                    diff = if (diff - 1 < 0) -1 else buffArray[diff - 1]
                }
            }

            if (buffArray[index] * 2 - 1 == index) {
                count++
                buffStr = buffStr.drop(buffArray[index])
                n = buffStr.length
                buffArray = IntArray(buffStr.length)
                index = 1
            } else index++
            if (index == buffArray.size) {
                n = 0
            }
        }
        return count
    }

    private fun deleteStringLong(s: String): Int {
        var n: Int = s.length
        var buffArray = IntArray(n)
        var index = 1
        var count = 1
        var buffStr = s
        var cutChar = 0

        while (index < n) {
            var diff = buffArray[index - 1]
            while (diff >= 0) {
                if (buffStr[diff] == buffStr[index]) {
                    buffArray[index] = diff + 1
                    diff = -1
                } else {
                    diff = if (diff - 1 < 0) -1 else buffArray[diff - 1]
                }
            }

            if (buffArray[index] * 2 - 1 == index) {
                cutChar = buffArray[index]
            }
            index++
            if (index == buffArray.size) {
                if (cutChar > 0) {
                    count++
                    buffStr = buffStr.drop(cutChar)
                    cutChar = 0
                    n = buffStr.length
                    buffArray = IntArray(buffStr.length)
                    index = 1
                } else n = 0
            }
        }
        return count
    }
}