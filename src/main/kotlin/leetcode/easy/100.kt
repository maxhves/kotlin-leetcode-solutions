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
 * Considerations
 * - Using a loop, we could iterate over all the nodes, inorder.
 * - We can use one loop for (p) and one for (q).
 * - In between each left and right traversal, we can compare the node values.
 * - If the node values aren't equal, then the trees are not the same, and we can return false.
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
