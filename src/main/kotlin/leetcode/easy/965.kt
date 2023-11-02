package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * A binary tree is uni-valued if every node in the tree has the same value.
 *
 * Given the (root) of a binary tree, return (true) if the given tree is uni-valued or (false) otherwise.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We need to traverse the entire tree, keeping track of the node values and if they match.
 *  - We really only need to traverse until we find a value that is different.
 *
 * 1. Create a preorder traversal function to evaluate a parent before its children.
 * 2. Pass the initial node value to the traversal function.
 * 2. If the current node value matches, continue onto the next nodes.
 * 3. If the current node does not match, immediately return false.
 */

//endregion

//region Solution

private fun main() {
    val root = TreeNode(2)
    val twoOne = TreeNode(2)
    val twoTwo = TreeNode(2)
    val twoThree = TreeNode(2)
    val five = TreeNode(5)

    root.right = twoOne
    root.left = twoTwo
    twoTwo.right = twoThree
    twoTwo.left = five

    isUnivalTree(root)
}

private fun isUnivalTree(root: TreeNode?): Boolean {
    return preorderTraverse(root, root?.`val`)
}

private fun preorderTraverse(node: TreeNode?, nodeValue: Int?): Boolean {
    if (node == null) {
        return true
    }

    if (node.`val` != nodeValue) {
        return false
    }

    val leftMatches = preorderTraverse(node.left, node.`val`)
    val rightMatches = preorderTraverse(node.right, node.`val`)

    return leftMatches && rightMatches
}


//endregion
