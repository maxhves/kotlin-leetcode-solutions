package leetcode.easy

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
    val root = ListNode(1)
    val nodeTwo = ListNode(2)
    val nodeThree = ListNode(3)
    val nodeFour = ListNode(4)
    val nodeFive = ListNode(5)
    val nodeSix = ListNode(6)
    root.next = nodeTwo
    nodeTwo.next = nodeThree
    nodeThree.next = nodeFour
    nodeFour.next = nodeFive
    nodeFive.next = nodeSix

    middleNode(root)
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
