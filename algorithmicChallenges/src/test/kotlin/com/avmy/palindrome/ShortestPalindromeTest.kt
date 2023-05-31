package com.avmy.palindrome

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


internal class ShortestPalindromeTest{

    companion object {
        @JvmStatic
        fun stringPair(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Pair("", "")),
                Arguments.of(Pair("aacecaaa", "aaacecaaa")),
                Arguments.of(Pair("aacetecaaa", "aaacetecaaa")),
                Arguments.of(Pair("abcd", "dcbabcd")),
                Arguments.of(Pair("aabba", "abbaabba")),
                Arguments.of(Pair("aeeabba", "abbaeeabba")),
                Arguments.of(Pair("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir", "riojddgxlqzkevzycqhrjcmluhtvlkajhiutiqunffzwqkjkkwcbwaodcdjifnstkeryvgmycuwwdqepcqckutyvrfiuimmklneiwmwxobqbnlirtgnzifqbdlerxdsifgzuprvkadisfudynrprcvanzrquqxexbbcpdlbrkpwjqdkazeqoxqqexaotsfxzamuuwjydwdgzisvlehxtqocmgkpikxjeaodujrslmnxgykrkygpzxqqqzlcweuurqaoeoyocjcudbvtsmzhykinkjdxizvcvnpkddywfoschrjjleuazxnrezomyhmripoydeqpojakiieqezymvnismpeprodxvdcyhemgvlvxyijxxuetusfyeqbpvaikyouitwkrgbifmnajfusrfsuqviiyvyfpjvnayvxtxzybkazmqvspreuvfokobrvhpizjgdtaqleslplxlinqfsddintfeqjfuoyozrblakuvyykpbmadqaomkyyyqbprygbaejtdwmkjljfgxipwzmkwlhsjozmyrlwxxgqulwowajlelycvbpazzhelkhxzbyvcidqqiqoqqrqebfsghpjcphtrqpbioawhzodrpymjdnbfixsqwwckqiuuoirsazwajlkrdqjdjjratmsywjcenhuoihaqiuwzgoivomgelhyqvzvhxbpkksupqhayoiquezzwnnqgrckoclktljytdlixkkqhwvnnjvilpcwzwhyippkypudcygcdsqaqwmrhtpvrksegpummaczyauglxeuvjgrcecywgedvmwrdthdwpkogrjokhgyqbmdhldobckfunbxqkvvuwkhegziyopoetxuifvlgwvungpcwyfqgttghtonqcahichdtstjmjvdwgregmmdeqtrxtceruxamrypjzrijjucyjtamroewfduzudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir")),
            )
        }
    }

    @ParameterizedTest
    @MethodSource(value = ["stringPair"])
    fun shortestPalindromeTest(data: Pair<String, String>) {
        val result = ShortestPalindrome.shortestPalindrome(data.first)

        kotlin.test.assertEquals(data.second, result)
    }
}