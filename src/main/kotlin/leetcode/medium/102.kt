package leetcode.medium

import leetcode.common.BinarySearchTree
import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary tree, return the level order traversal of its nodes' values (i.e. from
 * left to right, level by level).
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - This should be a BFS solution.
 * - Initialize an ArrayDequeue (currentChildren).
 * - Initialize a List of List<Int> (levels).
 * - Add (root) to (currentChildren).
 * - Create a loop that will run while (currentChildren) is not empty.
 * - Initialize a new List<Int> (level).
 * - For each of the children in the queue, take the first one:
 *   - Evaluate the nodes value, add it to (level).
 *   - Add its children to (currentChildren).
 * - Add (level) to (levels).
 * - Return the resulting array (levels).
 */

//endregion

//region Solution

private fun main() {
    // Output: [[3]. [9, 20], [15, 7]]
    val tree = BinarySearchTree(3, 9, 20, 15, 7)
    levelOrder(root = tree.root)
}

private fun levelOrder(root: TreeNode?): List<List<Int>> {
    root ?: return emptyList()

    val currentChildren = ArrayDeque<TreeNode>()
    val levels = arrayListOf<List<Int>>()

    currentChildren.add(root)

    while (currentChildren.isNotEmpty()) {
        val level = arrayListOf<Int>()

        for (i in 0 .. currentChildren.lastIndex) {
            val child = currentChildren.removeFirst()
            level.add(child.`val`)

            child.left?.let { currentChildren.add(it) }
            child.right?.let { currentChildren.add(it) }
        }

        levels.add(level)
    }

    return levels
}

//endregion
