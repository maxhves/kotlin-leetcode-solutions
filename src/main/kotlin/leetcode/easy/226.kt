package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary tree, invert the tree and return it's root.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Use DFS to traverse down the tree.
 * - Use a recursive function to visit each node.
 * - First visit the left child, then the right child.
 * - Then set (node.left) to (node.right) and vice versa.
 * - Can we change the order of when we swap the nodes?
 */

//endregion

//region Solution

private fun main() {
    val root = TreeNode(4)
    val two = TreeNode(2)
    val one = TreeNode(1)
    val three = TreeNode(3)
    val seven = TreeNode(7)
    val six = TreeNode(6)
    val nine = TreeNode(9)

    root.left = two
    two.left = one
    two.right = three
    root.right = seven
    seven.left = six
    seven.right = nine

    invertTree(root)
}

private fun invertTree(root: TreeNode?): TreeNode? {
    root ?: return null

    val tempNode = root.left
    root.left = root.right
    root.right = tempNode

    invertTree(root.left)
    invertTree(root.right)

    return root
}

//endregion
