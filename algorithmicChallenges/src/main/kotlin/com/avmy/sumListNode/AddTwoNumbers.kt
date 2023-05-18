package com.avmy.sumListNode


/*
    * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in
    * reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
      You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    * */
object AddTwoNumbers {

    fun sumTwoListNode(firstList: ListNode?, secondList: ListNode?): ListNode {
        var additional = 0
        var nextOne: ListNode? = firstList
        var nextTwo: ListNode? = secondList

        val result = ListNode()
        var buff: ListNode = result
        while (true) {
            val first = nextOne?.`val` ?: 0
            val second = nextTwo?.`val` ?: 0
            val sum = first + second + additional
            additional = if (sum > 9) 1 else 0
            nextOne = nextOne?.next
            nextTwo = nextTwo?.next
            buff.`val` = sum % 10
            if (nextOne == null && nextTwo == null && additional == 0) {
                break
            }
            buff.next = ListNode()
            buff = buff.next!!
        }
        return result
    }

}