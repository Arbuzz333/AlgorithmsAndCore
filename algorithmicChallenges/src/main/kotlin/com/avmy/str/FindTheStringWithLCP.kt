package com.avmy.str


object FindTheStringWithLCP {

    fun isCorrect(p: IntArray): Boolean
    {
        for (i in p.indices) {
            if (i > 0 && p[i] > p[i - 1] + 1 || p[i] < 0) return false
        }
        return true
    }

    fun buildFromPrefix(p: IntArray): String {
        var s = ""
        var ind = 'a'
        for (i in p) {
            s += if (p[i] == 0) ind++
            else s[p[i] - 1]
        }
        return s
    }

    fun buildFromZ(z : IntArray, ch: Char = 'a'): String
    {
        var s = ""
        var prefixLength = 0 // длина префикса, который мы записываем
        var j = 0 // позиция символа в строке, который будем записывать
        var newCharacter = ch // индекс нового символа
        for (i in z.indices) {
            // мы не пишем какой-то префикс и не будем писать новый
            if (z[i] == 0 && prefixLength == 0) {
                s += if (newCharacter < 'z') {
                    newCharacter++
                } else 'a'
            }
            // нам нужно запомнить, что мы пишем префикс
            if (z[i] > prefixLength) {
                prefixLength = z[i]
                j = 0
            }
            // пишем префикс
            if (prefixLength > 0) {
                // z в этом случае не правильная
                if (j >= s.length) return ""
                s += s[j]
                j++
                prefixLength--
            }
        }
        return s
    }

    fun zFunction(s : String): IntArray {
        val n = s.length
        val zf = IntArray(n)
        var left = 0
        var right = 0
        for (i in 1 until n) {
            val min = if(right - i < zf[i - left]) right - i else zf[i - left]
            zf[i] = if(0 > min) 0 else min
            while (i + zf[i] < n && s[zf[i]] == s[i + zf[i]]) {
                zf[i]++
            }
            if (i + zf[i] > right) {
                left = i
                right = i + zf[i]
            }
        }
        return zf
    }

    fun findTheString(lcp: Array<IntArray>): String {
        if (lcp.size == 1 && lcp[0][0] == 0) return ""

        val result = CharArray(lcp[0].size) { _: Int ->  '#' }
        result[0] = 'a'
        var next = 'a'
        var dNext = 'a'
        for (ind in lcp.indices) {
            if (lcp[ind].last() > 1) return ""

            val arrForBuild = lcp[ind].takeLast(lcp.size - ind).toIntArray()
            arrForBuild.forEachIndexed { index, arr ->
                if (index > 0 && result[index + ind] == '#' && arr > 0) result[index + ind] = next
            }
            if (result[ind] == '#') result[ind] = next
            next = if (1 < arrForBuild.size) {
                if (arrForBuild.all { it == 0 }) {
                    next
                } else {
                    if (result[ind + 1] != '#') result[ind + 1] else {
                        if (dNext == 'z') 'a' else {
                            dNext += 1
                            dNext
                        }
                    }
                }
            } else {
                next
            }
        }
        var s = String(result)

        val length = s.length
        if (s.isEmpty()) return ""
        for (ind in lcp.indices) {
            val prefStr = if (ind == 0) s else s.takeLast(length - ind) + "#" + s
            val zArr = zFunction(prefStr)
            val zArrM = zArr.takeLast(length).toIntArray()
            zArrM[ind] = length - ind
            if (zArrM.joinToString() != lcp[ind].joinToString()) {
                s =  ""
                break
            }
        }

        return s
    }

}
