package leetcode.medium

import leetcode.common.TreeNode

//region Problem

/**
 * You are given an integer array (nums) with no duplicates. A maximum binary tree can be built recursively
 * from (nums) using the following algorithm:
 *
 * 1. Create a root node whose value is the maximum value in (nums).
 * 2. Recursively build the left subtree on the sub-array prefix to the left of the maximum value.
 * 3. Recursively build the right subtree on the sub-array suffix to the right of the maximum value.
 *
 * Return the maximum binary tree built from nums.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Create a (dfs(nums): TreeNode?) recursive function.
 *   - If (nums) is empty; return null.
 *   - Initialize a new node (root) set to (max(nums)) - also retain its index.
 *   - Initialize a new node (left) set to a recursive call (dfs(nums(0 to rootIndex))).
 *   - Initialize a new node (right) set to a recursive call (dfs(nums[rootIndex to numsLastIndex])).
 *   - Set (root.left) to (left) and (root.right) to (right).
 *   - Return (root).
 * - Return the (dfs(nums)) function.
 */

//endregion

//region Solution

private fun main() {
    // Output: [6, 3, 5, null, 2, 0, null, null, 1]
    constructMaximumBinaryTree(nums = intArrayOf(3, 2, 1, 6, 0, 5))
}

private fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
    fun dfs(start: Int, end: Int): TreeNode? {
        if (start > end) {
            return null
        }

        var maxIndex = start
        for (i in start..end) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i
            }
        }

        val node = TreeNode(nums[maxIndex])
        node.left = dfs(start, maxIndex - 1)
        node.right = dfs(maxIndex + 1, end)

        return node
    }

    return dfs(0, nums.lastIndex)
}

//endregion
