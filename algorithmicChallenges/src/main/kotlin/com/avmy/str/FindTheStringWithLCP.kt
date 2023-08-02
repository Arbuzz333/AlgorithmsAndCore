package com.avmy.str

import kotlin.math.max
import kotlin.math.min


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

    fun buildFromZ(z : IntArray): String
    {
        var s = ""
        var prefixLength = 0 // длина префикса, который мы записываем
        var j = 0 // позиция символа в строке, который будем записывать
        var newCharacter = 'a' // индекс нового символа
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
            zf[i] = max(0, min(right - i, zf[i - left]))
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

}
