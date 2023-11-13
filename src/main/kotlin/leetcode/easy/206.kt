package leetcode.easy

import leetcode.common.ListNode

//region Problem

/**
 * Given the (head) of a singly linked list, reverse the list, and return the reversed list.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - How can we reverse the nodes?
 * - How can the end node become the first node?
 * - We can iterate over all the nodes, we know that.
 * - Can we iterate them, and place the nodes into an array.
 *   - Then, traverse the array backwards, and for each node after the first one, add it as a next child.
 *
 * Steps:
 * - Initialize some variables:
 *   - (current): The current node we are on for traversal.
 *   - (nodeArray): An array of nodes that are in the initial LinkedList.
 * - Create a loop while (current) is not null:
 *   - Add each node to (nodeArray).
 *   - Move to the next node, set (current) as this next node.
 * - Iterate over (nodeArray) in decreasing order:
 *   - For each item, get the node at the given index.
 *   - Set the next node to the next node in the array.
 *   - Repeat this until we have reached the end of the array.
 * - Ultimately, return the last node in (nodeArray).
 */

//endregion

//region Solution

private fun main() {
    // Output: [5, 4, 3, 2, 1]
    val root = ListNode(1)
    val two = ListNode(2)
    val three = ListNode(3)
    val four = ListNode(4)
    val five = ListNode(5)

    root.next = two
    two.next = three
    three.next = four
    four.next = five

    val reversedNodeHead = reverseList(head = root)
    println(reversedNodeHead)
}

private fun reverseList(head: ListNode?): ListNode? {
    head ?: return null

    var previous: ListNode? = null
    var current = head

    while (current != null) {
        val nextNode = current.next
        current.next = previous
        previous = current
        current = nextNode
    }

    return previous
}

//endregion
