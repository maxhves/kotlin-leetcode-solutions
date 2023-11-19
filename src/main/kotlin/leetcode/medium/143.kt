package leetcode.medium

import leetcode.common.ListNode

//region Problem

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * - L0 -> L1 -> ... -> Ln - 1 -> Ln
 *
 * Reorder the list to be on the following form:
 * - L0 -> Ln -> L1 -> Ln - 1 -> L2 -> Ln - 2 -> ...
 *
 * You may not modify the value sin the list's nodes. Only nodes themselves may be changed.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Find the center of the linked-list by using slow and fast pointers.
 * - Reverse the second portion of the list.
 * - Finally, merge the two halves together.
 */

//endregion

//region Solution

private fun main() {

}

private fun reorderList(head: ListNode?) {
    head ?: return

    var slow: ListNode? = head
    var fast: ListNode? = head.next

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    var second: ListNode? = slow?.next
    slow?.next = null
    var previous: ListNode? = null

    while (second != null) {
        val temp = second.next
        second.next = previous
        previous = second
        second = temp
    }

    var first = head
    second = previous

    while (second != null) {
        val tempOne = first?.next
        val tempTwo = second.next

        first?.next = second
        second.next = tempOne

        first = tempOne
        second = tempTwo
    }
}

//endregion
