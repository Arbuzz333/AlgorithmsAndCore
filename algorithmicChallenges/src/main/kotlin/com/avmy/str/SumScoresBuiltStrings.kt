package com.avmy.str


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

    fun sumScores(s: String): Long {
        var count = 0L
        val len = s.length
        val mapPrefixes = mutableMapOf<String, Long>()
        for (n in 1..len) {
            mapPrefixes[s.substring(0, n)] = n.toLong()
        }
        for (n in len - 1 downTo 0) {
            var con = 0L
            var k = n + 1
            while (k <= len) {
                val st = s.substring(n, k)
                val prefix = mapPrefixes[st]
                if (prefix != null) con = prefix
                if (k > 1 && con == 0L) k = len + 1
                k++
            }
            count += con
        }

        return count
    }

}
