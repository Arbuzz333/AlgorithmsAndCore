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
                    Arguments.of(Triple(intArrayOf(0, 0, 1, 0, 3, 0, 1), 'a', "abacaba")),
                    Arguments.of(Triple(intArrayOf(0, 0, 2, 0), 'a', "abab")),
                    Arguments.of(Triple(intArrayOf(4, 3, 2, 1), 'a', "")),
                    Arguments.of(Triple(intArrayOf(0, 0, 0, 0, 0, 1, 2, 0), 'a', "abcdeaab")),
                    Arguments.of(Triple(intArrayOf(   0, 0, 1, 1, 0, 0, 1), 'b', "bcbbdeb")),
                    Arguments.of(Triple(intArrayOf(      0, 0, 0, 0, 0, 0), 'c', "cdefgh")),
                    Arguments.of(Triple(intArrayOf(         0, 1, 0, 0, 1), 'b', "bbcdb")),
                    Arguments.of(Triple(intArrayOf(            0, 0, 0, 1), 'b', "bcdb")),
                    Arguments.of(Triple(intArrayOf(               0, 1, 0), 'a', "aab")),
                    Arguments.of(Triple(intArrayOf(                  0, 0), 'a', "ab")),

                    Arguments.of(Triple(intArrayOf(0, 0, 0, 1, 1, 0, 0, 1), 'b', "bcdbbefb")),
                    Arguments.of(Triple(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0), 'c', "cdefghij")),
                    Arguments.of(Triple(intArrayOf(0, 1, 0, 0, 1, 0, 0, 1), 'b', "bbcdbefb")),
                    Arguments.of(Triple(intArrayOf(0, 1, 0, 1, 4, 0, 0, 1), 'b', "bbcbbbcb")),
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

        @JvmStatic
        fun findTheString(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of(Pair("abab",
                            arrayOf(intArrayOf(4, 0, 2, 0), intArrayOf(0, 3, 0, 1), intArrayOf(2, 0, 2, 0), intArrayOf(0, 1, 0, 1)))),
                    Arguments.of(Pair("aaaa",
                            arrayOf(intArrayOf(4, 3, 2, 1), intArrayOf(3, 3, 2, 1), intArrayOf(2, 2, 2, 1), intArrayOf(1, 1, 1, 1)))),
                    Arguments.of(Pair("",
                            arrayOf(intArrayOf(4, 3, 2, 1), intArrayOf(3, 3, 2, 1), intArrayOf(2, 2, 2, 1), intArrayOf(1, 1, 1, 3)))),
                    Arguments.of(Pair("",
                            arrayOf(intArrayOf(2, 2), intArrayOf(1, 1)))),
                    Arguments.of(Pair("ab",
                            arrayOf(intArrayOf(2, 0), intArrayOf(0, 1)))),
                    Arguments.of(Pair("",
                            arrayOf(intArrayOf(3,2,0), intArrayOf(2,2,1), intArrayOf(1,1,1)))),
                    Arguments.of(Pair("",
                            arrayOf(intArrayOf(0)))),
                    Arguments.of(Pair("abcbbaab",
                            arrayOf(intArrayOf(8, 0, 0, 0, 0, 1, 2, 0), intArrayOf(0, 7, 0, 1, 1, 0, 0, 1), intArrayOf(0, 0, 6, 0, 0, 0, 0, 0),
                                    intArrayOf(0, 1, 0, 5, 1, 0, 0, 1), intArrayOf(0, 1, 0, 1, 4, 0, 0, 1),
                                    intArrayOf(1, 0, 0, 0, 0, 3, 1, 0), intArrayOf(2, 0, 0, 0, 0, 1, 2, 0), intArrayOf(0, 1, 0, 1, 1, 0, 0, 1)))),
                    Arguments.of(Pair("abacaaaaacbacaa",
                            arrayOf(intArrayOf(15, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1),
                                    intArrayOf(0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0),
                                    intArrayOf(1, 0, 13, 0, 1, 1, 1, 1, 2, 0, 0, 4, 0, 1, 1),
                                    intArrayOf(0, 0, 0, 12, 0, 0, 0, 0, 0, 1, 0, 0, 3, 0, 0),
                                    intArrayOf(1, 0, 1, 0, 11, 4, 3, 2, 1, 0, 0, 1, 0, 2, 1),
                                    intArrayOf(1, 0, 1, 0, 4, 10, 3, 2, 1, 0, 0, 1, 0, 2, 1),
                                    intArrayOf(1, 0, 1, 0, 3, 3, 9, 2, 1, 0, 0, 1, 0, 2, 1),
                                    intArrayOf(1, 0, 1, 0, 2, 2, 2, 8, 1, 0, 0, 1, 0, 2, 1),
                                    intArrayOf(1, 0, 2, 0, 1, 1, 1, 1, 7, 0, 0, 2, 0, 1, 1),
                                    intArrayOf(0, 0, 0, 1, 0, 0, 0, 0, 0, 6, 0, 0, 1, 0, 0),
                                    intArrayOf(0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0),
                                    intArrayOf(1, 0, 4, 0, 1, 1, 1, 1, 2, 0, 0, 4, 0, 1, 1),
                                    intArrayOf(0, 0, 0, 3, 0, 0, 0, 0, 0, 1, 0, 0, 3, 0, 0),
                                    intArrayOf(1, 0, 1, 0, 2, 2, 2, 2, 1, 0, 0, 1, 0, 2, 1),
                                    intArrayOf(1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1)))),
            )
        }
    }


    @ParameterizedTest
    @MethodSource(value = ["pair"])
    fun buildFromZTest(data: Triple<IntArray, Char, String>) {
        val prefix = FindTheStringWithLCP.buildFromZ(data.first, data.second)
        assertEquals(data.third, prefix)
    }


    @ParameterizedTest
    @MethodSource(value = ["zFunction"])
    fun zFunctionTest(data: Pair<String, IntArray>) {
        val prefix = FindTheStringWithLCP.zFunction(data.first)
        assertEquals(data.second.joinToString(), prefix.joinToString())
    }

    @ParameterizedTest
    @MethodSource(value = ["findTheString"])
    fun findTheStringTest(data: Pair<String, Array<IntArray>>) {
        val s = FindTheStringWithLCP.findTheString(data.second)
        assertEquals(data.first, s)
    }

}