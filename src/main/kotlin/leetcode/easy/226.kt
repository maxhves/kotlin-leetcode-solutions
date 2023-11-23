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
 * - Call a function to recursively traverse each tree node.
 * - Left first, and then right.
 * - After the traversal calls, set the current nodes' left node to right and vice versa.
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

    inorderTraverse(root)

    return root
}

private fun inorderTraverse(node: TreeNode?) {
    node ?: return

    inorderTraverse(node.left)
    inorderTraverse(node.right)

    val temp: TreeNode? = node.left
    node.left = node.right
    node.right = temp
}

//endregion
