package com.avmy.str

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FindTheStringWithLCPTest {

    companion object {
        @JvmStatic
        fun pair(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of(Pair(intArrayOf(0,0,1,0,3,0,1), "abacaba")),
                    Arguments.of(Pair(intArrayOf(0,0,2,0), "abab")),
                    Arguments.of(Pair(intArrayOf(4,3,2,1), "")),
            )
        }

        @JvmStatic
        fun zFunction(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of(Pair("bab#abab", intArrayOf(0, 0, 1, 0, 0, 3, 0, 1))),
                    Arguments.of(Pair("ab#abab", intArrayOf(0, 0, 0, 2, 0, 2, 0))),
                    Arguments.of(Pair("b#abab", intArrayOf(0, 0, 0, 1, 0, 1))),
            )
        }
    }


    @ParameterizedTest
    @MethodSource(value = ["pair"])
    fun buildFromZTest(data: Pair<IntArray, String>) {
        val prefix = FindTheStringWithLCP.buildFromZ(data.first)
        assertEquals(data.second, prefix)
    }


    @ParameterizedTest
    @MethodSource(value = ["zFunction"])
    fun zFunctionTest(data: Pair<String, IntArray>) {
        val prefix = FindTheStringWithLCP.zFunction(data.first)
        assertEquals(data.second.joinToString(), prefix.joinToString())
    }

}