package com.avmy.str

import com.avmy.palindrome.ShortestPalindrome.kmp


/*
* You are building a string s of length n one character at a time, prepending each new character to the front of the string. The strings are labeled from 1 to n, where the string with length i is labeled si.
*
* For example, for s = "abaca", s1 == "a", s2 == "ca", s3 == "aca", etc.
* The score of si is the length of the longest common prefix between si and sn (Note that s == sn).
*
* Given the final string s, return the sum of the score of every si.
*
* */
object SumScoresBuiltStrings {

    fun sumScoresV1(s: String): Long {
        val len = s.length
        val list = mutableListOf<Long>()
        val kmp = kmp(s)
        println("KMP ${kmp.joinToString() }")
        for (k in kmp) {
            val i = if (k == 0) 0 else list[k - 1] + 1
            list.add(i)
            println("I $i")
        }
        println("LIST $list")
        return list.sum() + len
    }

    class Data (
        var ind: Int = 0,
        var value: Int = 0
    )

    fun sumScores(s: String): Long {
        val n: Int = s.length
        var count = 0L
        val list = mutableListOf<Data>()

        val map = mutableMapOf<Char, Int>()
        val mapD = mutableMapOf<String, Int>()
        s.forEachIndexed { index, c ->
            map[c] = index
        }
        if (map.size == 1) {
            for (i in 1..n.toLong()) {
                count += i
            }
            return count
        }
        map.clear()
        if (n % 2 == 0) {
            s.forEachIndexed { index, c ->
                if (index % 2 != 0) {
                    val v = s[index - 1] + c.toString()
                    mapD[v] = index
                }
            }
        }
        if (mapD.size == 1) {
            for (i in 0..n.toLong() step 2) {
                count += i
            }
            return count
        }
        mapD.clear()
        count = n.toLong()

        for (index in 1 until n) {

            if (s[index] == s[0]) {
                list.add(Data(index, 0))
            }
            val remove = mutableListOf<Data>()
            list.forEach {
                if (s[index] == s[index - it.ind]) it.value += 1
                else {
                    count += it.value
                    remove.add(it)
                }
            }
            list.removeAll(remove)

        }
        list.forEach {
            count += it.value
        }
        return count
    }

}
