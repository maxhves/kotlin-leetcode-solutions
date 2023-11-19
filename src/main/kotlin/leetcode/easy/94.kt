package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary tree, return the inorder traversal of its nodes' values.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Traverse left node.
 * - Evaluate node.
 * - Traverse right node.
 */

//endregion

//region Solution

private fun main() {

}

private fun inorderTraversal(root: TreeNode?): List<Int> {
    val nodeValues = mutableListOf<Int>()

    traverse(root, nodeValues)

    return nodeValues
}

private fun traverse(node: TreeNode?, nodeValues: MutableList<Int>) {
    node ?: return

    traverse(node.left, nodeValues)

    nodeValues.add(node.`val`)

    traverse(node.right, nodeValues)
}

//endregion
