package leetcode.easy

import leetcode.common.TreeNode
import kotlin.math.abs
import kotlin.math.max

//region Problem

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * Height-balanced: A binary tree in which the depth of the two subtrees of every node never differs
 * by more than one.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - The height of each subtree node, never differs more than one.
 * - We have to count the paths from each child node going upwards.
 * - We could call a recursive function for the (root)s left and right children.
 * - This function could count the deepest paths.
 */

//endregion

//region Solution

private fun main() {

}

private fun isBalanced(root: TreeNode?): Boolean {
    fun dfs(node: TreeNode?): Pair<Boolean, Int> {
        node ?: return true to 0

        val left = dfs(node.left)
        val right = dfs(node.right)
        val balanced = left.first && right.first && abs(left.second - right.second) <= 1

        return balanced to 1 + max(left.second, right.second)
    }

    return dfs(root).first
}

//endregion
