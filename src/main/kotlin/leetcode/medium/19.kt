package leetcode.medium

import leetcode.common.LinkedList
import leetcode.common.ListNode

//region Problem

/**
 * Given the (head) of a linked list, remove the (nth) node from the end of the list and return its
 * head.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - Using two passes, we can first get the length of the linked list then we can iterate up to that
 *   node and then remove it.
 *
 * Steps
 * - Initialize a (listSize) variable, initially set to 0.
 * - Initialize a (dummyHead) variable, set to ListNode(0).
 * - Set (dummyHead.next) to (head).
 * - Initialize a (current) variable, set to (dummyHead).
 * - Create a loop for while (current.next) is not equal to null:
 *   - On each iteration, increase the (listSize) counter.
 * - Now the (listSize) variable will be correctly set.
 * - Set (current) to (dummyHead.next).
 * - Initialize a variable (count) equal to 0.
 * - Create a new loop for while (current.next) is not equal to null:
 *   - Increment (count) by 1.
 *   - Set (current) to (current.next).
 * - Ultimately return (dummyHead.next).
 */

//endregion

//region Solution

private fun main() {
    val linkedList = LinkedList(1, 2, 3, 4, 5)

    // Output: [1, 2, 3, 5]
    removeNthFromEnd(head = linkedList.head, n = 2)
}

private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    head ?: return null

    var listSize = 0
    val dummyHead = ListNode(0)
    dummyHead.next = head
    var current: ListNode? = dummyHead

    while(current?.next != null) {
        listSize++
        current = current.next
    }

    current = dummyHead
    var count = 0

    while(current?.next != null) {
        if (count == listSize - n) {
            current.next = current.next?.next
        }
        count++
        current = current.next
    }

    return dummyHead.next
}

//endregion
