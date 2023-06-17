package com.avmy.str

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


internal class MaximumDeletionsStringTest {


    companion object {
        @JvmStatic
        fun pair(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of(Pair("aabaab", 3)),
                    Arguments.of(Pair("abcabcdabc", 2)),
                    Arguments.of(Pair("abcdabc", 1)),
                    Arguments.of(Pair("dabc", 1)),
                    Arguments.of(Pair("aaaaa", 5)),
                    Arguments.of(Pair("aa", 2)),
                    Arguments.of(Pair("ab", 1)),
                    Arguments.of(Pair("ababv", 2)),
                    Arguments.of(Pair("aaabaab", 4)),
                    Arguments.of(Pair("ababzyzy", 2)),
                    Arguments.of(Pair("cbccbc", 2)),
                    Arguments.of(Pair("cbccbccbcty", 3)),
                    Arguments.of(Pair("abaabaababaab", 4)),
                    Arguments.of(Pair("mxmqbmxmqb", 2)),
                    Arguments.of(Pair("ababaababa", 4)),
                    Arguments.of(Pair("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir", 1)),
            )
        }
    }


    @ParameterizedTest
    @MethodSource(value = ["pair"])
    fun deleteStringTest(data: Pair<String, Int>) {
        val result = MaximumDeletionsString.deleteString(data.first)

        assertEquals(data.second, result)
    }

    @ParameterizedTest
    @MethodSource(value = ["pair"])
    fun deleteStringTestUnion(data: Pair<String, Int>) {
        val result = MaximumDeletionsString.deleteStringUnion(data.first)

        assertEquals(data.second, result)
    }
}