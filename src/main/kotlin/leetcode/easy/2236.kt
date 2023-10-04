package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * You are given the `root` of a binary tree that consists of exactly `3` nodes: the root,
 * it's left child, and it's right child.
 *
 * Return `true` if the value of the root is equal to the sum of the values of it's two children,
 * or `false` otherwise.
 */

//endregion

//region Test cases

/**
 * Input: root = [10,4,6]
 * Output: true
 *
 * Input: root = [5,3,1]
 * Output: false
 */

//endregion

//region Solution

private fun main() {
    checkTree(null)
}

fun checkTree(root: TreeNode?): Boolean {
    if (root == null) {
        return false
    }

    val total = root.`val`
    val sum = (root.left?.`val` ?: 0) + (root.right?.`val` ?: 0)

    return sum == total
}

//endregion