package com.avmy.palindrome

import com.avmy.palindrome.PalindromePairs.palindromePairs
import com.avmy.palindrome.data.PalidromePairData
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals


internal class PalindromePairsTest {

    companion object {
        @JvmStatic
        fun listPair(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Pair(
                        arrayOf("abcd", "dcba", "lls", "s", "sssll"),
                        listOf(listOf(0, 1), listOf(1, 0), listOf(3, 2), listOf(2, 4))
                    )
                ),
                Arguments.of(
                    Pair(
                        arrayOf("abcd", "tdcba", "lls", "sllt", "sssll"),
                        listOf(listOf(0, 1), listOf(3, 2), listOf(2, 4))
                    )
                ),
                Arguments.of(Pair(arrayOf("bat", "tab", "cat"), listOf(listOf(0, 1), listOf(1, 0)))),

                Arguments.of(
                    Pair(
                        arrayOf(
                            "abccbb",
                            "bac",
                            "bb",
                            "bcbacbb",
                            "babbbbcc",
                            "a",
                            "bacaba",
                            "caaa",
                            "acbab",
                            "cbabbcba",
                            "bcbbcac",
                            "bbbcc",
                            "ba",
                            "bcb",
                            "caabbab",
                            "bcaaa",
                            "cacbaac",
                            "abb",
                            "aaabac",
                            "b"
                        ),
                        listOf(
                            listOf(2, 19),
                            listOf(19, 2),
                            listOf(5, 6),
                            listOf(12, 19),
                            listOf(5, 12),
                            listOf(17, 12),
                            listOf(17, 5),
                            listOf(2, 17)
                        )
                    )
                ),
                Arguments.of(
                    Pair(
                        arrayOf("bb", "bababab", "baab", "abaabaa", "aaba", "", "bbaa", "aba", "baa", "b"),
                        listOf(
                            listOf(0, 9),
                            listOf(9, 0),
                            listOf(8, 2),
                            listOf(4, 3),
                            listOf(4, 8),
                            listOf(7, 4),
                            listOf(5, 0),
                            listOf(0, 5),
                            listOf(5, 1),
                            listOf(1, 5),
                            listOf(5, 2),
                            listOf(2, 5),
                            listOf(5, 7),
                            listOf(7, 5),
                            listOf(5, 9),
                            listOf(9, 5),
                            listOf(6, 0),
                            listOf(8, 9)
                        )
                    )
                ),
                Arguments.of(Pair(arrayOf("a", ""), listOf(listOf(1, 0), listOf(0, 1)))),
            )
        }
    }

    @ParameterizedTest
    @MethodSource(value = ["listPair"])
    fun palindromePairsTest(data: Pair<Array<String>, List<List<Int>>>) {
        val result = palindromePairs(data.first)
        assertEquals(data.second, result)
    }

    @ParameterizedTest
    @MethodSource(value = ["listPair"])
    fun palindromePairsJAVATest(data: Pair<Array<String>, List<List<Int>>>) {
        val result = PalindromePairsJ.palindromePairs(data.first)
        assertEquals(data.second, result)
    }


    @Test
    fun palindromePairsEnormousTest() {
        val resultJ = PalindromePairsJ.palindromePairs(PalidromePairData.pairArray)
        assertEquals(27000, resultJ.size)

        val result = palindromePairs(PalidromePairData.pairArray)
        assertEquals(27000, result.size)
    }
}