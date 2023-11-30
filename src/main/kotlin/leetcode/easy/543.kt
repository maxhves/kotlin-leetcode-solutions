package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the (root).
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - For each node, we want to find the diameter and the height.
 * - Height: the max of it's left and right children heights.
 * - Diameter: take the height of the left child, plus the height of the right child plus two
 *   (for each child).
 *   - Note: null nodes have a height of -1.
 *
 * Steps
 * -
 */

//endregion

//region Solution

private fun main() {
    val root = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    val four = TreeNode(4)
    val five = TreeNode(5)
    root.left = two
    root.right = three
    two.left = four
    two.right = five

    // Output: 3
    diameterBinaryTree(root)
}

private fun diameterBinaryTree(root: TreeNode?): Int {
    var maxDiameter = 0

    fun dfs(node: TreeNode?): Int {
        node ?: return -1

        val left = dfs(node.left)
        val right = dfs(node.right)

        val diameter = (left + right) + 2
        val height = maxOf(left, right) + 1

        maxDiameter = maxOf(diameter, maxDiameter)

        return height
    }

    dfs(root)

    return maxDiameter
}

//endregion
