package leetcode.easy

import leetcode.common.ListNode

//region Problem

/**
 * Given the (head) of a singly linked list, return (true) if it is a palindrome of (false) otherwise.
 */

//endregion

//region Steps to solve

/**
 * Steps:
 * - Iterate over the linked list, and for each:
 *   - Store the value of the linked list into a string.
 * - Return if the string is the same as the string but reversed.
 */

//endregion

//region Solution

private fun main() {
    val root = ListNode(1)
    val twoOne = ListNode(2)
    val twoTwo = ListNode(2)
    val oneTwo = ListNode(1)
    root.next = twoOne
    twoOne.next = twoTwo
    twoTwo.next = oneTwo

    // Output: true
    isPalindrome(head = root)
}

private fun isPalindrome(head: ListNode?): Boolean {
    head ?: return false

    var current = head
    val result = mutableListOf<Int>()

    while (current != null) {
        result += current.`val`
        current = current.next
    }

    return result == result.reversed()
}

//endregion
