package leetcode.medium

import leetcode.common.TreeNode

//region Problem

/**
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - It looks like we are searching for a branch with the most left nodes.
 * - We still have to traverse all nodes, but we can take a count of the number of "left" nodes in
 *   the path, and then whatever has the longest path, is the result.
 */

//endregion

//region Solution

private fun main() {
    // Output: 7
    val root = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    val four = TreeNode(4)
    val five = TreeNode(5)
    val six = TreeNode(6)
    val seven = TreeNode(7)

    root.left = two
    two.left = four
    root.right = three
    three.left = five
    five.left = seven
    three.right = six

    findBottomLeftValue(root = root)
}

private fun findBottomLeftValue(root: TreeNode?): Int {
    var step = 0
    var result = root?.`val` ?: 0

    fun dfs(node: TreeNode?, level: Int) {
        node ?: return

        if (level >= step) {
            step = level
            result = node.`val`
        }

        node.right?.let {
            dfs(it, level + 1)
        }

        node.left?.let {
            dfs(it, level + 1)
        }
    }

    dfs(root, 0)

    return result
}

//endregion
