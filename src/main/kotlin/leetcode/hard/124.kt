package leetcode.hard

import leetcode.common.TreeNode
import kotlin.math.max

//region Problem

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an
 * edge connecting them. A node can only appear in the sequence at most once. Note that the path does not
 * need to pass through the root.
 *
 * The path sum of a path is the node's values in the path.
 *
 * Given the (root) of a binary tree, return the maximum path sum of any non-empty path.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - Is this similar to just finding the max of each node's paths?
 */

//endregion

//region Solution

private fun main() {
    val root = TreeNode(-10)
    val nine = TreeNode(9)
    val twenty = TreeNode(20)
    val fifteen = TreeNode(15)
    val seven = TreeNode(7)
    root.left = nine
    root.right = twenty
    twenty.left = fifteen
    twenty.right = seven

    maxPathSum(root)
}

private fun maxPathSum(root: TreeNode?): Int {
    root ?: return 0

    var max = Int.MIN_VALUE

    fun dfs(node: TreeNode?): Int {
        node ?: return 0

        val left = maxOf(dfs(node.left), 0)
        val nodeValue = node.`val`
        val right = maxOf(dfs(node.right), 0)

        max = maxOf(max, left + right + nodeValue)

        return maxOf(left, right) + nodeValue
    }
    dfs(root)

    return max
}

//endregion
