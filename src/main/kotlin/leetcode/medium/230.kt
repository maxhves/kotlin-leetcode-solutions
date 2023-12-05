package leetcode.medium

import leetcode.common.BinarySearchTree
import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary search tree, and an integer (k), return the (kth) smallest value
 * (1-indexed) of all values of the nodes in the tree.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We can use an inorder traversal strategy.
 * - Keep a count outside the traversal function.
 * - Check what the count is, if it isn't equal to (k) increase the count, continue traversing.
 * - If the count is equal to (k), return the current node value.
 */

//endregion

//region Solution

private fun main() {
    val tree = BinarySearchTree(3, 1, 2, 4)
    kthSmallest(root = tree.root, k = 1)
}

private fun kthSmallest(root: TreeNode?, k: Int): Int {
    var result = -1
    root ?: return result

    var count = 1
    fun inorderTraversal(node: TreeNode?) {
        node ?: return

        inorderTraversal(node.left)

        if (count == k) {
            result = node.`val`
        }
        count++

        inorderTraversal(node.right)
    }

    inorderTraversal(root)

    return result
}

//endregion
