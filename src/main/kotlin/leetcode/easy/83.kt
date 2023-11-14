package leetcode.easy

import leetcode.common.LinkedList
import leetcode.common.ListNode

//region Problem

/**
 * Given the (head) of a sorted linked list, delete all duplicates, such that each element appears
 * only once. Return the linked list sorted as well.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - We can store node values in a hash set to retain uniqueness.
 * - The list will already be sorted if we remove in place.
 *
 * Steps
 * - Initialize a (dummyHead) variable set to ListNode(1).
 * - Set (dummyHead.next) to (head).
 * - Initialize a variable (current) set to (dummyHead).
 * - Initialize a HashSet (nodeValues) of type Int.
 * - Create a loop while (current.next != null):
 *   - For each node.next value, check if it exists in (nodeValues).
 *   - If it exists in (nodeValues):
 *     - Set (current) to (current.next.next).
 *   - Else, set (current) to (current.next).
 * - Ultimately return (dummyHead.next).
 */

//endregion

//region Solution

private fun main() {
    val linkedList = LinkedList(1, 1, 2, 3, 3)

    // Output: [1, 2, 3]
    deleteDuplicates(head = linkedList.head)
}

private fun deleteDuplicates(head: ListNode?): ListNode? {
    head ?: return null

    val nodeValues = HashSet<Int>()
    val dummyHead = ListNode(0)
    dummyHead.next = head
    var current: ListNode? = dummyHead

    while (current?.next != null) {
        if (current.next?.`val` in nodeValues) {
            current.next = current.next?.next
        } else {
            nodeValues.add(current.next!!.`val`)
            current = current.next
        }
    }

    return dummyHead.next
}

//endregion
