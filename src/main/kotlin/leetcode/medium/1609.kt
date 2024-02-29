package leetcode.medium

import leetcode.common.TreeNode

//region Problem

/**
 * A binary tree is named Even-Odd if it meets the following conditions:
 *
 * - The root of the binary tree is at level index 0, it's children are at level index 1, their
 *   children are at level index 2, etc.
 *
 * - For every even-indexed level, all nodes at the level have odd integer values in strictly increasing
 *   order (from left to right).
 *
 * - For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing
 *   order (from left to right).
 *
 * Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * -
 */

//endregion

//region Solution

private fun main() {
    // Output: true

}

private fun isEvenOddTree(root: TreeNode?): Boolean {
    val queue = ArrayDeque<TreeNode>()

    if (root != null) {
        queue.add(root)
    }

    var level = 0
    var previousNodeValue = -1

    while (!queue.isEmpty()) {
        for (i in 0..queue.lastIndex) {
            val current = queue.removeFirst()

            if (level % 2 == 0) {
                if (current.`val` % 2 == 0) {
                    return false
                }

                if (previousNodeValue != -1) {
                    if (previousNodeValue >= current.`val`) {
                        return false
                    }
                }
            } else {
                if (current.`val` % 2 != 0) {
                    return false
                }

                if (previousNodeValue != -1) {
                    if (previousNodeValue <= current.`val`) {
                        return false
                    }
                }
            }

            current.left?.let { queue.add(it) }
            current.right?.let { queue.add(it) }

            previousNodeValue = current.`val`
        }

        level++
        previousNodeValue = -1
    }

    return true
}

//endregion
