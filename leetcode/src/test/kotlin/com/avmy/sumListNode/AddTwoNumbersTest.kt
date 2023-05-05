package com.avmy.sumListNode

import com.avmy.sumListNode.AddTwoNumbers.sumTwoListNode
import com.avmy.sumListNode.ListNode.Companion.fromList
import com.avmy.sumListNode.ListNode.Companion.toList
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


internal class AddTwoNumbersTest {

    companion object {

        @JvmStatic
        fun dataListSum(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Triple(listOf(1, 2, 0), listOf(2, 9, 1), listOf(3, 1, 2))),
                Arguments.of(Triple(listOf(1, 2, 0), listOf(2, 9, 9, 1), listOf(3, 1, 0, 2))),
                Arguments.of(Triple(listOf(2, 9, 9, 1), listOf(1, 2, 0), listOf(3, 1, 0, 2))),
                Arguments.of(Triple(listOf(0), listOf(0), listOf(0))),
                Arguments.of(Triple(listOf(9, 9, 9, 9, 9, 9, 9), listOf(9, 9, 9, 9), listOf(8, 9, 9, 9, 0, 0, 0, 1))),
            )
        }
    }

    @ParameterizedTest
    @MethodSource(value = ["dataListSum"])
    fun sumTwoListNodeTest(data: Triple<List<Int>, List<Int>, List<Int>>) {
        val nextOne: ListNode = fromList(data.first)
        val nextTwo: ListNode = fromList(data.second)

        val result = sumTwoListNode(nextOne, nextTwo)

        println("resultB $result")
        assertEquals(toList(result), data.third)
    }

}