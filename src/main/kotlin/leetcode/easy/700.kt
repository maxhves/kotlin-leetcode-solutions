package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * You are given the (root) of a binary search tree (BST) and an integer (val).
 *
 * Find the node in the BST that the node's value equals `val` and return the subtree rooted with
 * that node. If such a node does not exist, return null.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We can do a preorder traversal to visit the parent node first.
 *  - If that parent is equal to (val) immediately return it.
 *  - Otherwise, keep going and when every node has been traversed then we should return null.
 */

//endregion

//region Solution

private fun main() {
    val root = TreeNode(4)
    val seven = TreeNode(7)
    val two = TreeNode(2)
    val one = TreeNode(1)
    val three = TreeNode(3)

    root.right = seven
    root.left = two
    two.right = three
    two.left = one

    searchBST(root, 2)
}

private fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    val traversalResult = preorderTraversal(root, `val`)
    return traversalResult
}

private fun preorderTraversal(root: TreeNode?, target: Int): TreeNode? {
    if (root == null) {
        return null
    }

    if (root.`val` == target) {
        return root
    }

    val leftResult = preorderTraversal(root.left, target)
    if (leftResult != null) {
        return leftResult
    }

    val rightResult = preorderTraversal(root.right, target)
    if (rightResult != null) {
        return rightResult
    }

    return null
}

//endregion
