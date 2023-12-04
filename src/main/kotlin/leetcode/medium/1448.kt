package leetcode.medium

import leetcode.common.TreeNode

//region Problem

/**
 * Given a binary tree (root), a node (X) in the tree is named good if in the path from (root) to (X) there
 * are no nodes with a value greater than (X).
 *
 * Return the number of good nodes in the binary tree.
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {

}

private fun goodNodes(root: TreeNode?): Int {
    var numberOfGoodNodes = 0

    fun dfs(node: TreeNode?, currentMaxValue: Int) {
        node ?: return

        val nodeValue = node.`val`
        val newMaxValue = maxOf(currentMaxValue, nodeValue)

        if (nodeValue >= currentMaxValue) {
            numberOfGoodNodes++
        }

        dfs(node.left, newMaxValue)
        dfs(node.right, newMaxValue)
    }

    root?.let { dfs(it, it.`val`) }

    return numberOfGoodNodes
}

//endregion
