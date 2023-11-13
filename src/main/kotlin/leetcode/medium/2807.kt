package leetcode.medium

import leetcode.common.ListNode

//region Problem

/**
 * Given the head of a linked list `head`, in which each node contains an integer value.
 *
 * Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.
 *
 * Return the linked list after insertion.
 */

//endregion

//region Test cases

/**
 * Input: head = [18,6,10,3]
 * Output: [18,6,6,2,10,1,3]
 *
 * Input: head = [7]
 * Output: head = [7]
 */

//endregion

//region Solution

private fun main() {
    val listNode = ListNode(18)
    listNode.next = ListNode(6)
    listNode.next?.next = ListNode(10)
    listNode.next?.next?.next = ListNode(3)

    insertGreatestCommonDivisors(head = listNode)
}

private fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
    fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b

        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }

        return x
    }

    var previousNode: ListNode? = head
    var currentNode: ListNode? = head?.next

    while (currentNode != null) {
        val tempNode = ListNode(gcd(previousNode?.`val` ?: 0, currentNode.`val`))
        previousNode?.next = tempNode
        tempNode.next = currentNode

        previousNode = currentNode
        currentNode = previousNode.next
    }

    return head
}

//endregion