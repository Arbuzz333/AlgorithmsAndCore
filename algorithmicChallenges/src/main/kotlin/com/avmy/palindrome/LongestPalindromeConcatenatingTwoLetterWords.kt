package com.avmy.palindrome


/**
 * You are given an array of strings words. Each element of words consists of two lowercase English letters.
Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
A palindrome is a string that reads the same forward and backward.
 * */
object LongestPalindromeConcatenatingTwoLetterWords {

    fun longestPalindrome(words: Array<String>): Int {
        val buffMap = hashMapOf<String, Int>()
        buffMap[words[0]] = 1
        var index = 1
        val length = words.size
        var result = 0
        val onePalindromeList = hashSetOf<String>()
        if (words[0][0] == words[0][1]) {
            onePalindromeList.add(words[0])
        }

        while (index < length) {
            val word = words[index]
            val reversed = word.reversed()
            if (buffMap.containsKey(reversed)) {
                result += 4
                val reversedInt = buffMap[reversed]
                if (reversedInt == 1) {
                    buffMap.remove(reversed)
                } else {
                    buffMap[reversed] = reversedInt!! - 1
                }
                onePalindromeList.remove(reversed)
            } else {
                val buffInt = buffMap[word]
                if (buffInt != null) {
                    buffMap[word] = buffInt + 1
                } else {
                    buffMap[word] = 1
                }
                if (word[0] == word[1]) {
                    onePalindromeList.add(word)
                }
            }
            index++
        }
        return if (onePalindromeList.isNotEmpty()) result + 2 else result
    }

}