package leetcode.medium

import leetcode.common.BinarySearchTree
import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both ehe left and right subtrees must also be binary search trees.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - The in-order traversal should produce elements that increase, therefore the previous element should
 *   be smaller than or equal to the next element.
 */

//endregion

//region Solution

private fun main() {
    val tree = BinarySearchTree(5, 1, 4, 3, 6)
    isValidBST(root = tree.root)
}

private fun isValidBST(root: TreeNode?): Boolean {
    root ?: return false

    var previousNodeValue: Int? = null

    fun inorderTraverse(node: TreeNode?): Boolean {
        node ?: return true

        val nodeValue = node.`val`

        val leftValid = inorderTraverse(node.left)

        val nodeIsValid = if (previousNodeValue == null) {
            true
        } else {
            previousNodeValue!! < nodeValue
        }
        previousNodeValue = nodeValue

        val rightValid = inorderTraverse(node.right)

        return nodeIsValid && leftValid && rightValid
    }

    return inorderTraverse(root)
}

//endregion
