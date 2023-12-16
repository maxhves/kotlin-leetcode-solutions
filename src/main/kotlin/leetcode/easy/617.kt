package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * You are given two binary trees (root1) and (root2).
 *
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped
 * while the others are not.
 *
 * You need to merge the two trees into a new binary Tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be
 * used as the node of the new tree.
 *
 * Return the merged tree.
 *
 * Note: The merging process must start from the root nodes of both trees.
 */

//endregion

//region Steps to solve

/**
 *
 */

//endregion

//region Solution

private fun main() {
    val root1 = TreeNode(1)
    root1.left = TreeNode(3)
    root1.right = TreeNode(2)
    root1.left?.left = TreeNode(5)

    val root2 = TreeNode(2)
    root2.left = TreeNode(1)
    root2.right = TreeNode(3)
    root2.left?.right = TreeNode(4)
    root2.right?.right = TreeNode(7)

    mergeTrees(root1, root2)
}

private fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null && root2 == null) {
        return null
    }

    val nodeToReturn = if (root1 == null) {
        root2
    } else if (root2 == null) {
        root1
    } else {
        root1.`val` += root2.`val`
        root1
    }

    val left = mergeTrees(root1?.left, root2?.left)
    val right = mergeTrees(root1?.right, root2?.right)

    nodeToReturn?.left = left
    nodeToReturn?.right = right

    return nodeToReturn
}

//endregion
