package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * Given the roots of two binary trees (root) and (subRoot), return (true) if there is a subtree of (root)
 * with the same structure and node values of (subRoot) and (false) otherwise.
 *
 * A subtree of a binary tree (tree) is a tree that consists of a node in (tree) and all of this node's
 * descendants. The tree (tree) could also be considered as a subtree of itself.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Check if (subRoot) is null, if so, it is a subtree.
 * - Check if (root) is null, if so, it cannot be a subtree.
 * - Create a recursive function (isSameTree(root, subRoot)):
 *   - If (root) and (subRoot) are null, return true; they are equal.
 *   - If (root) and (subRoot) node values are equal:
 *     - Recursively make a call to (isSameTree()) for the left and right children of (root) and (subRoot).
 *     - Return true if they are both equal, else false.
 * - Call (isSameTree());
 *   - If it is true, return true.
 *   - If it is false, call (isSubtree()) for the left and right children.
 *   - If (isSubtree(left)) or (isSubtree(right)) return true else false.
 */

//endregion

//region Solution

private fun main() {

}

private fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (subRoot == null) {
        return true
    } else if (root == null) {
        return false
    }

    if (isSameTree(root, subRoot)) {
        return true
    } else {
        val isSameLeft = isSubtree(root.left, subRoot)
        val isSameRight = isSubtree(root.right, subRoot)

        return isSameLeft || isSameRight
    }
}

private fun isSameTree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (root == null && subRoot == null) {
        return true
    }

    if (root?.`val` == subRoot?.`val`) {
        val left = isSameTree(root?.left, subRoot?.left)
        val right = isSameTree(root?.right, subRoot?.right)

        return left && right
    } else {
        return false
    }
}

//endregion
