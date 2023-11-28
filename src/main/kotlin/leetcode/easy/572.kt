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
 *   - If it is false, call (isSameTree()) for the left and right children.
 *   - If (isSameTree(left)) or (isSameTree(right)) return true else false.
 */

//endregion

//region Solution

private fun main() {

}

private fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    subRoot ?: return true
    root ?: return false

    if (isSameTree(root, subRoot)) {
        return true
    }

    val leftIsSubtree = isSameTree(root.left, subRoot)
    val rightIsSubtree = isSameTree(root.right, subRoot)

    return leftIsSubtree || rightIsSubtree
}

private fun isSameTree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (root == null && subRoot == null) {
        return true
    }

    if (root != null && subRoot != null && root.`val` == subRoot.`val`) {
        val leftIsSame = isSameTree(root.left, subRoot.left)
        val rightIsSame = isSameTree(root.right, subRoot.right)

        return leftIsSame && rightIsSame
    }

    return false
}

//endregion
