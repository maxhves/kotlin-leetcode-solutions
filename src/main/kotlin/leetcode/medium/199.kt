package leetcode.medium

import leetcode.common.BinarySearchTree
import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary tree, imagine yourself standing on the right side of it, return the values
 * of the nodes you can see ordered from top to bottom.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - We should return the right-most node at each level of the tree structure.
 * - This should mean that we only need to return the last node at each level.
 * - This is a slight modification on a regular BFS traversal.
 */

//endregion

//region Solution

private fun main() {
    // Output [1, 3, 4]
    val tree = BinarySearchTree(1, 2, 3, 5, 4)
    rightSideView(root = tree.root)
}

private fun rightSideView(root: TreeNode?): List<Int> {
    root ?: return emptyList()

    val currentChildren = ArrayDeque<TreeNode>()
    val rightMostNodeValues = arrayListOf<Int>()

    currentChildren.add(root)

    while (currentChildren.isNotEmpty()) {
        rightMostNodeValues.add(currentChildren.last().`val`)

        for (i in 0 .. currentChildren.lastIndex) {
            val child = currentChildren.removeFirst()

            child.left?.let { currentChildren.add(it) }
            child.right?.let { currentChildren.add(it) }
        }
    }

    return rightMostNodeValues
}

//endregion
