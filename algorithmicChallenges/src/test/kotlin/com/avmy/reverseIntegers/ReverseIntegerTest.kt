package com.avmy.reverseIntegers

import com.avmy.reverseIntegers.ReverseInteger.reverseInt
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


internal class ReverseIntegerTest {

    companion object {
        @JvmStatic
        fun data(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Pair(123, 321)),
                Arguments.of(Pair(-123, -321)),
                Arguments.of(Pair(120, 21)),
                Arguments.of(Pair(1534236469, 9646324351)),
                Arguments.of(Pair(-2147483412, -2143847412)),
            )
        }

    }

    @ParameterizedTest
    @MethodSource(value = ["data"])
    fun reverseIntegerTest(data: Pair<Int, Int>) {

        val reverse = reverseInt(data.first)
        assertEquals(reverse, data.second)
    }

}