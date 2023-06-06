package com.avmy.palindrome

import com.avmy.palindrome.LongestPalindromeConcatenatingTwoLetterWords.longestPalindrome
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


internal class LongestPalindromeConcatenatingTwoLetterWordsTest {

    companion object {
        @JvmStatic
        fun listPair(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Pair(arrayOf("gg"), 2)),
                Arguments.of(Pair(arrayOf("ab","ty","yt","lc","cl","ab"), 8)),
                Arguments.of(Pair(arrayOf("lc","cl","gg"), 6)),
                Arguments.of(Pair(arrayOf("cc","ll","xx"), 2)),
                Arguments.of(Pair(arrayOf("dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"), 22)),
                Arguments.of(Pair(arrayOf("em","pe","mp","ee","pp","me","ep","em","em","me"), 14)),
                Arguments.of(Pair(arrayOf("qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"), 14)),
            )
        }
    }


    @ParameterizedTest
    @MethodSource(value = ["listPair"])
    fun longestPalindromeTest(data: Pair<Array<String>, Int>) {
        val longest = longestPalindrome(data.first)
        assertEquals(data.second, longest)
    }
}