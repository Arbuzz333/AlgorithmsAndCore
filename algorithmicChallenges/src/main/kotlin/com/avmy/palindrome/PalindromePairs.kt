package com.avmy.palindrome


/*
* given a 0-indexed array of unique strings words.
A palindrome pair is a pair of integers (i, j) such that:
0 <= i, j < words.length,
i != j, and
words[i] + words[j] (the concatenation of the two strings) is a
palindrome
.
Return an array of all the palindrome pairs of words.
* */
object PalindromePairs {

    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val wordIndexMap = words.mapIndexed { w, i -> i to w }.toMap()
        val ans = mutableListOf<List<Int>>()
        for (i in words.indices) {
            if (words[i].isEmpty()) {
                for (j in words.indices) {
                    val w = words[j]
                    if (j != i && isPalindrome(w)) {
                        ans.add(listOf(i, j))
                        ans.add(listOf(j, i))
                    }
                }
                continue
            }
            val wordReversed = words[i].reversed()
            if (wordIndexMap.containsKey(wordReversed)) {
                val res = wordIndexMap[wordReversed]!!
                if (res != i) ans.add(listOf(i, res))
            }
            for (j in 1 until wordReversed.length) {
                val substringRight = wordReversed.substring(j)
                if (wordIndexMap.containsKey(substringRight) && isPalindrome(words[i] + substringRight)) {
                    ans.add(listOf(i, wordIndexMap[substringRight]!!))
                }
                val substringLeft = wordReversed.substring(0, j)
                if (wordIndexMap.containsKey(substringLeft) && isPalindrome(substringLeft + words[i])) {
                    ans.add(listOf(wordIndexMap[substringLeft]!!, i))
                }
            }
        }
        return ans
    }

    private fun isPalindrome(word: String): Boolean {
        var i = 0
        var j = word.length - 1
        while (i < j) {
            if (word[i++] != word[j--]) return false
        }
        return true
    }
}