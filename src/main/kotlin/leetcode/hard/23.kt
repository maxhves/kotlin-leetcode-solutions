package leetcode.hard

import leetcode.common.LinkedList
import leetcode.common.ListNode
import java.util.PriorityQueue

//region Problem

/**
 * You are given an array of (k) linked-lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted-list and return it.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialize a PriorityQueue (queue).
 * - Iterate over each linked list:
 *   - Add each node's value to (queue).
 * - While (queue) is not empty:
 *   - Create a new linked list by polling (queue).
 */

//endregion

//region Solution

private fun main() {
    // Output: [1,1,2,3,4,4,5,6]
    mergeKLists(
        lists = arrayOf(
            LinkedList(1, 4, 5).head,
            LinkedList(1, 3, 4).head,
            LinkedList(2, 6).head,
        )
    )
}

private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val queue = PriorityQueue<Int>()

    for (listHead in lists) {
        var current: ListNode? = listHead

        while (current != null) {
            queue.offer(current.`val`)
            current = current.next
        }
    }

    val dummyHead = ListNode(0)
    var current: ListNode? = dummyHead

    while (queue.isNotEmpty()) {
        current?.next = ListNode(queue.poll())
        current = current?.next
    }

    return dummyHead.next
}

//endregion
