package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * Given the roots of two binary trees (p) and (q), write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same
 * value.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Check is (p) and (q) are null, this is the base case, return (true) if so.
 * - Return:
 *   - Value of (p) and (q) are equal.
 *   - Recursive call to (isSameTree()) for left children.
 *   - Recursive vall to (isSameTree()) for right children.
 */

//endregion

//region Solution

private fun main() {
    val root = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)

    root.left = two
    root.right = three

    isSameTree(p = root, q = root)
}

private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) {
        return true
    }

    return p?.`val` == q?.`val` && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
}

//endregion
