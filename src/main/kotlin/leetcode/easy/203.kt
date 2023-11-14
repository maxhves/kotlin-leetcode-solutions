package leetcode.easy

import leetcode.common.ListNode

//region Problem

/**
 * Given the (head) of a linked list and an integer (val), remove all the nodes of the linked list that
 * has (Node.val == val), and return the new head.
 */

//endregion

//region Steps to solve

/**
 * Steps:
 * - Create a (headCopy) variable, set it to head.
 * - Create a (dummyHead) variable, set it to (ListNode(0)).
 * - Create a (current) variable, set it to (dummyHead).
 * - Loop for while (current != null):
 *   - If (headCopy.val == val), we don't want this node:
 *     - (headCopy = headCopy.next).
 *   - Else:
 *     - (current.next = headCopy).
 *     - (current = current.next).
 *     - (headCopy = headCopy.next).
 * - Ultimately return (dummyHead.next).
 */

//endregion

//region Solution

private fun main() {
    val root = ListNode(1)
    val two = ListNode(2)
    val sixOne = ListNode(6)
    val three = ListNode(3)
    val four = ListNode(4)
    val five = ListNode(5)
    val sixTwo = ListNode(6)

    root.next = two
    two.next = sixOne
    sixOne.next = three
    three.next = four
    four.next = five
    five.next = sixTwo

    // Output: [1, 2, 3, 4, 5]
    removeElements(head = root, `val` = 6)
}

private fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    val dummyHead = ListNode(0)
    dummyHead.next = head
    var current: ListNode? = dummyHead

    while (current?.next != null) {
        if (current.next?.`val` == `val`) {
            current.next = current.next?.next
        } else {
            current = current.next
        }
    }

    return dummyHead.next
}

//endregion
