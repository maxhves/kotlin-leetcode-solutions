package leetcode.easy

import leetcode.common.ListNode

//region Problem

/**
 * You are given the 'head' of a linked list, which contains a series of integers separated by '0''s.
 * The beginning and end of the linked list will have 'Node.val == 0'.
 *
 * For every two consecutive '0''s, merge all the nodes lying in between them into a single node whose
 * value is the sum of all the merged nodes. The modified list should not contain any '0''s.
 *
 * Return the 'head' of the modified linked list.
 */

//endregion

//region Steps to solve

/**
 * - Iterate over each node.
 * - Track if we have an open zero.
 * - Merge nodes until we see a closing zero.
 * - This closing zero is now the next opening zero.
 * - Repeat merging.
 */

//endregion

//region Solution

private fun main() {
    // Output: [4, 11]
    val values = listOf(3, 1, 0, 4, 5, 2, 0)
    val root = ListNode(0)
    var head: ListNode? = root

    for (element in values) {
        head?.next = ListNode(element)
        head = head?.next
    }

    mergeNodes(head = root)
}

private fun mergeNodes(head: ListNode?): ListNode? {
    var currentMergeTotal = 0
    var newRoot: ListNode? = null
    var currentResultNode = newRoot

    var currentNode = head
    while (currentNode?.next != null) {
        currentMergeTotal += currentNode.`val`

        if (currentNode.next!!.`val` == 0) {
            if (newRoot == null) {
                newRoot = ListNode(currentMergeTotal)
                currentResultNode = newRoot
            } else {
                currentResultNode?.next = ListNode(currentMergeTotal)
                currentResultNode = currentResultNode?.next
            }

            currentMergeTotal = 0
        }

        currentNode = currentNode.next
    }

    return newRoot
}

//endregion
