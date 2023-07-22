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

    fun sumScoresV1(s: String): Long {
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

    fun sumScoresV2(s: String): Long {
        var count = 0L
        val len = s.length
        for (n in len - 1 downTo 0) {
            var con = 0L
            var k = n + 1
            while (k <= len) {
                val st = s.substring(n, k)
                if (s.startsWith(st)) con = (k - n).toLong()
                if (k > 1 && con == 0L) k = len + 1
                k++
            }
            count += con
        }

        return count
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
