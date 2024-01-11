package leetcode.medium

import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary tree, find the maximum value (v) for which there exist different nodes
 * (a) and (b) where (v = [a.val - b.val]) and (a) is an ancestor of (b).
 *
 * A node (a) is an ancestor of (b) if either: any child of (a) is equal to (b) or any child of (a)
 * is an ancestor of (b).
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - For each node we visit, we simply need to keep track of what is the minimum value, and what is the
 *   maximum value.
 * - We can then calculate the maximum difference between the all-time minimum and all time maximum.
 * - In our DFS function we return the maximum of the left and right branches.
 */

//endregion

//region Solution

private fun main() {
    val root = TreeNode(8)
    val three = TreeNode(3)
    val one = TreeNode(1)
    val six = TreeNode(6)
    val four = TreeNode(4)
    val seven = TreeNode(7)
    val ten = TreeNode(10)
    val fourteen = TreeNode(14)
    val thirteen = TreeNode(13)
    root.left = three
    three.left = one
    three.right = six
    six.left = four
    six.right = seven
    root.right = ten
    ten.right = fourteen
    fourteen.left = thirteen

    // Output: 7
    maxAncestorDiff(root)
}

private fun maxAncestorDiff(root: TreeNode?): Int {
    root ?: return 0

    fun dfs(node: TreeNode?, min: Int, max: Int): Int {
        node ?: return 0

        val newMin = minOf(node.`val`, min)
        val newMax = maxOf(node.`val`, max)
        var maxDifference = newMax - newMin

        maxDifference = maxOf(maxDifference, dfs(node.left, newMin, newMax))
        maxDifference = maxOf(maxDifference, dfs(node.right, newMin, newMax))

        return maxDifference
    }

    return dfs(root, root.`val`, root.`val`)
}

//endregion
