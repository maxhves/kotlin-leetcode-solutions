package leetcode.easy

//region Problem

/**
 * Given `head` which is a reference node to a singly-linked list. The value of each node in the linked
 * list is either `0` or `1`. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 * The most significant bit is at the head of the linked list.
 */

//endregion

//region Test cases

/**
 * Input: head = [1,0,1]
 * Output: 5
 *
 * Input: head = [0]
 * Output: 0
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the binary tree via recursion.
 * 2. Store the values into a string.
 * 3. Convert the string to an integer representation.
 * 4. Return the result.
 */

//endregion

//region Solution

private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private fun main() {
    val listNode = ListNode(1)
    val second = ListNode(0)
    val third = ListNode(1)

    second.next = third
    listNode.next = second

    println(getDecimalValue(head = listNode))
}

private fun getDecimalValue(head: ListNode?): Int {
    var currentNode = head
    var result = 0

    while (currentNode != null) {
        result = result shl 1
        result += currentNode.`val`
        currentNode = currentNode.next
    }

    return result
}

//endregion