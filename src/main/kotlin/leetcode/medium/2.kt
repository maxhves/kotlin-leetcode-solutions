package leetcode.medium

import leetcode.common.LinkedList
import leetcode.common.ListNode

//region Problem

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored
 * in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the
 * sum as a linked list.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - We can traverse both lists at the same time.
 * - We can afterward build the result linked list.
 * - We could potentially build the result linked list in the same pass, if we carry the remainder over
 *   to the next node.
 * - Can we do this when it's in reverse order though?
 *
 * Steps
 * - Initialize a MutableArray<ListNode> variable (sumNodes).
 * - Initialize an Int variable (currentRemainder).
 * - Initialize a ListNode? variable (l1Current) set to (l1).
 * - Initialize a ListNode? variable (l2Current) set to (l2).
 * - Begin a loop while (l1Current) and (l2Current) is not equal to null:
 *   - Take the value of (l1Current) and sum it with the value of (l2Current).
 *   - If there is a remainder, already add the remainder (aka the first digit).
 *   - If there is a remainder now, set (currentRemainder) to this value.
 *   - Add the resulting ListNode(integer) to (sumNodes).
 * - Iterate from (sumNodes) size down to 1 and for each:
 *   - Set (sumNodes[i]) next equal to (sumNodes[i - 1]).
 * - Ultimately return (sumNodes) last element.
 */

//endregion

//region Solution

private fun main() {
    val l1LinkedList = LinkedList(2, 4, 3)
    val l2LinkedList = LinkedList(5, 6, 4)

    // Output: [7, 0, 8]
    addTwoNumbers(l1 = l1LinkedList.head, l2 = l2LinkedList.head)
}

private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null || l2 == null) {
        return null
    }

    var l1Result = ""
    var l2Result = ""

    var currentNode = l1
    while (currentNode != null) {
        l1Result += currentNode.`val`
        currentNode = currentNode.next
    }

    currentNode = l2
    while (currentNode != null) {
        l2Result += currentNode.`val`
        currentNode = currentNode.next
    }

    l1Result = l1Result.reversed()
    l2Result = l2Result.reversed()

    val resultDigits = (l1Result.toBigInteger() + l2Result.toBigInteger()).toString().reversed()
    val resultHead = ListNode(resultDigits[0].digitToInt())
    var currentResultNode: ListNode? = resultHead

    for (i in 1 .. resultDigits.lastIndex) {
        currentResultNode?.next = ListNode(resultDigits[i].digitToInt())
        currentResultNode = currentResultNode?.next
    }

    return resultHead
}

//endregion
