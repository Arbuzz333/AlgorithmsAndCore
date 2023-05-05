package com.avmy.reverseIntegers


object ReverseInteger {

    fun reverseInt(x: Int): Int {
        var remaining = x
        var digits = 0

        while (Math.abs(remaining) > 0) {
            val buf = digits * 10
            digits = remaining % 10 + buf
            remaining /= 10
        }
        return digits
    }
}