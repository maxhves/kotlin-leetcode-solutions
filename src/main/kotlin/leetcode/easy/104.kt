package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to
 * the farthest leaf node.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Create a recursive depth first search function (dfs(node): Int).
 * - If the passed-in node is null, return 0.
 * - Create an Int value (left) set to (dfs(node.left)).
 * - Create an Int value (right) set to (dfs(node.right)).
 * - Return in the recursive function, the max value of (left, right) plus (1).
 *   - We want to always know what is the maximum path of a given node, since we are only ever interested
 *     in what the longest path is.
 *   - We also must account for the current node, and therefore we plus (1) onto the result of
 *     (max(left, right) which will give us the new depth for the current node.
 * - Ultimately, return the (dfs()) function, passing in (root) as the parameter.
 */

//endregion

//region Solution

private fun main() {
    val root = TreeNode(3)
    val nine = TreeNode(9)
    val twenty = TreeNode(20)
    val fifteen = TreeNode(15)
    val seven = TreeNode(7)

    root.left = nine
    root.right = twenty
    twenty.left = fifteen
    twenty.right = seven

    maxDepth(root)
}

private fun maxDepth(root: TreeNode?): Int {
    fun dfs(node: TreeNode?): Int {
        node ?: return 0

        val left = dfs(node.left)
        val right = dfs(node.right)

        return 1 + (maxOf(left, right))
    }

    return dfs(root)
}

//endregion
