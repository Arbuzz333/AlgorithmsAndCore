package com.avmy.sumListNode


class ListNode constructor(var `val`: Int = 0, var next: ListNode? = null) {
    override fun toString(): String {
        return "$`val` -> ${next.toString()}"
    }

    companion object {
        fun fromList(nodes: List<Int>): ListNode {
            val prom = ListNode()
            nodes.reversed().forEach {
                val temp = ListNode(it)
                temp.next = prom.next
                prom.next = temp
            }
            return prom.next!!
        }

        fun toList(nodes: ListNode): List<Int> {
            val list = mutableListOf<Int>()
            list.add(nodes.`val`)
            var prom = nodes.next
            while (prom != null) {
                list.add(prom.`val`)
                prom = prom.next
            }
            return list
        }
    }

}
