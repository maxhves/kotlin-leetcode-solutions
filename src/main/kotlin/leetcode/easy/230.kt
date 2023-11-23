package leetcode.easy

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
    val root = TreeNode(3)
    val one = TreeNode(1)
    val two = TreeNode(2)
    val four = TreeNode(4)

    root.left = one
    root.right = four
    one.right = two

    kthSmallest(root = root, k = 1)
}

var count = 1
var result = -1

private fun kthSmallest(root: TreeNode?, k: Int): Int {
    root ?: return result

    inorderTraverse(root, k)

    return result
}

private fun inorderTraverse(node: TreeNode?, k: Int) {
    node ?: return

    inorderTraverse(node.left, k)

    if (count == k) {
        result = node.`val`
    }
    count++

    inorderTraverse(node.right, k)
}

//endregion
