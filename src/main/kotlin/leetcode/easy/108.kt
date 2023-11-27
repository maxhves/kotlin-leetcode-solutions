package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * Given an integer array (nums) where the elements are sorted in ascending order, convert it to a
 * height-balanced binary tree.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - To make it balanced, the midpoint needs to be the root node.
 * - We should then keep performing binary search to find the next node.
 *
 * Steps
 * - Create a new function to recursively create the new nodes.
 * - This function should accept as parameters:
 *   - IntArray of the search range.
 *   - Int of the start pointer.
 *   - Int of the end pointer.
 * - If the start pointer is greater than the end, return null.
 * - Initialize the (midpoint) of the current search range, this is our new "root" node.
 * - Initialize the left of this node to a new search range which is from (start) to (midpoint - 1).
 * - Initialize the right of this node to a new search range which is from (midpoint + 1) to (end).
 * - Return this new node, this will recursively go up the call stack.
 */

//endregion

//region Solution

private fun main() {
    // Output: [0, -3, 9, -10, null, 5]
    sortedArrayToBST(nums = intArrayOf(-10, -3, 0, 5, 9))
}

private fun sortedArrayToBST(nums: IntArray): TreeNode? {
    return getNextNode(nums, 0, nums.lastIndex)
}

private fun getNextNode(
    nums: IntArray,
    start: Int,
    end: Int,
): TreeNode? {
    if (start > end) {
        return null
    }

    val midpoint = (start + end) / 2
    val newNode = TreeNode(nums[midpoint])

    val left = getNextNode(nums, start, midpoint - 1)
    val right = getNextNode(nums, midpoint + 1, end)

    newNode.left = left
    newNode.right = right

    return newNode
}

//endregion
