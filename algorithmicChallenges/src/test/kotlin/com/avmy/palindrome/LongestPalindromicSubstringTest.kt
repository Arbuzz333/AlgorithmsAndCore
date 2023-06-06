package com.avmy.palindrome

import com.avmy.palindrome.LongestPalindromicSubstring.longestPalindromic
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals


internal class LongestPalindromicSubstringTest {

    companion object {
        @JvmStatic
        fun stringPair(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Pair("babacab", "bacab")),
                Arguments.of(Pair("babaffabb", "baffab")),
                Arguments.of(Pair("baabc", "baab")),
                Arguments.of(Pair("baab", "baab")),
                Arguments.of(Pair("babad", "aba")),
                Arguments.of(Pair("cbbd", "bb")),
                Arguments.of(Pair("cbb", "bb")),
                Arguments.of(Pair("ccc", "ccc")),
                Arguments.of(Pair("bbd", "bb")),
                Arguments.of(Pair("bb", "bb")),
                Arguments.of(Pair("ac", "c")),
                Arguments.of(Pair("b", "b")),
                Arguments.of(Pair("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir", "gykrkyg")),
            )
        }
    }

    @ParameterizedTest
    @MethodSource(value = ["stringPair"])
    fun longestPalindromicTest(data: Pair<String, String>) {
        val result = longestPalindromic(data.first)

        assertEquals(data.second, result)
    }
}