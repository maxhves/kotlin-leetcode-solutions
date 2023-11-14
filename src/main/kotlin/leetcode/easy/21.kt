package leetcode.easy

import leetcode.common.ListNode

//region Problem

/**
 * You are given the heads of two sorted linked lists (list1) and (list2).
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes
 * of the first two nodes.
 *
 * Return the head of the merged linked list.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - ALl we need to do is iterate both linked lists at the same time, and pick the node which is smallest.
 * - After taking this smallest node, we set it to the next property and subsequently the greater node
 *   will be set to the next of the smaller node.
 *
 * Steps:
 * - Initialize (list1Current): the current node we are at in (list1).
 * - Initialize (list2Current): the current node we are at in (list2).
 * - Initialize (resultHead): the head of the resulting linked list.
 * - Initialize (resultCurrent) the current node of the resulting linked list.
 * - Create a loop while (list1Current != null) and (list2Current != null):
 *   - Compare the value of (list1Current) to (list2Current).
 *   - If (resultHead) is null, (resultHead) is now equal to the node that has the min of (list1Current,
 *     list2Current).
 *   - If (resultHead) is not null, (resultCurrent.next) is equal to (minOf(list1Current, list2Current).
 *   - (resultCurrent) is now equal to (resultCurrent.next).
 *   - (resultCurrent.next) is now equal to the (maxOf(list1Current, list2Current).
 *   - (resultCurrent) is now equal to (resultCurrent.next).
 *   - (list1Current) is now equal to (list1Current.next).
 *   - (list2Current) is now equal to (list2Current.next).
 * - Ultimately return (resultHead).
 */

//endregion

//region Solution

private fun main() {
    val listOneRoot = ListNode(1)
    val oneTwo = ListNode(2)
    val oneFour = ListNode(4)
    listOneRoot.next = oneTwo
    oneTwo.next = oneFour

    val listTwoRoot = ListNode(1)
    val twoThree = ListNode(3)
    val twoFour = ListNode(4)
    listTwoRoot.next = twoThree
    twoThree.next = twoFour

    mergeTwoLists(
        l1 = listOneRoot,
        l2 = listTwoRoot,
    )
}

private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1

    val dummyHead = ListNode(0)
    var current = dummyHead
    var list1 = l1
    var list2 = l2

    while (list1 != null && list2 != null) {
        if (list1.`val` < list2.`val`) {
            current.next = list1
            list1 = list1.next
        } else {
            current.next = list2
            list2 = list2.next
        }
        current = current.next!!
    }

    current.next = list1 ?: list2

    return dummyHead.next
}

//endregion
