package leetcode.easy

import leetcode.common.ListNode

//region Problem

/**
 * Given (head), the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the (next) pointer. Internally, (pos) is used to denote the index of the node
 * that tail's (next) pointer is connected to. Note that (pos) is not passed as a parameter.
 *
 * Return (true) if there is a cycle in the linked list. Otherwise, return (false).
 */

//endregion

//region Steps to solve

/**
 * Steps:
 * - Create a (fast) pointer, set to (head).
 * - Create a (slow) pointer, set to (head).
 * - Initiate a loop, while (fast) is not null:
 *   - Set (fast) to (fast.next.next).
 *   - Set (slow) to (slow.next).
 *   - If (slow) and (fast) become equal at any point, return (true).
 * - If we reach this far, return (false).
 */

//endregion

//region Solution

private fun main() {
    val root = ListNode(3)
    val two = ListNode(2)
    val zero = ListNode(0)
    val minusFour = ListNode(-4)
    root.next = two
    two.next = zero
    zero.next = minusFour
    minusFour.next = two

    // Output: true
    hasCycle(head = root)
}

private fun hasCycle(head: ListNode?): Boolean {
    head ?: return false

    var slow = head
    var fast = head

    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next

        if (fast == slow) {
            return true
        }
    }

    return false
}

//endregion
