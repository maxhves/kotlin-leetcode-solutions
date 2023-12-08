package leetcode.medium

import leetcode.common.BinarySearchTree
import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the
 * original key plus the sum of all keys greater than the original key in BST.
 *
 * As a reminder, a binary search tree is a tree tha satisfies these constraints:
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both left and right subtrees must also be a binary search tree.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Traverse in a reverse inorder function, and set each node to the accumulative sum.
 */

//endregion

//region Solution

private fun main() {
    val tree = BinarySearchTree(4, 1, 0, 2, 3, 6, 5, 7, 8)
    bstToGst(root = tree.root)
}

private fun bstToGst(root: TreeNode?): TreeNode? {
    var accumulativeNodeSum = 0

    fun reverseInorderTraverse(node: TreeNode?) {
        node ?: return

        reverseInorderTraverse(node.right)

        accumulativeNodeSum += node.`val`
        node.`val` = accumulativeNodeSum

        reverseInorderTraverse(node.left)
    }
    reverseInorderTraverse(root)

    return root
}

//endregion
