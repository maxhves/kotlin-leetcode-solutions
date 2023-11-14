package leetcode.easy

import leetcode.common.LinkedList
import leetcode.common.ListNode

//region Problem

/**
 * Given the (head) of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - We can use a fast and slow pointer solution.
 *
 * Steps:
 * - Initialize a pointer (fast) that is equal to (head).
 * - Initialize a pointer (slow) that is equal to (head).
 * - Start a loop for while (fast.next != null):
 *   - Set (fast) to (fast.next.next).
 *   - Set (slow) to (slow.next).
 * - When the loop completes, (fast)'s next node it null.
 * - (slow) should now be at the midpoint.
 * - Ultimately return (slow).
 */

//endregion

//region Solution

private fun main() {
    val linkedList = LinkedList(1, 2, 3, 4, 5, 6)

    // Output: [4, 5, 6]
    middleNode(linkedList.head)
}

private fun middleNode(head: ListNode?): ListNode? {
    head ?: return null

    var fast = head
    var slow = head

    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }

    return slow
}

//endregion
