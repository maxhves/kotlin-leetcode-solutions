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
 * Steps
 * - Initialize an Int (result) to keep track of the greatest diameter that we find.
 * - Create an inner function (dfs(root)):
 *   - If the (root) node is null, return (-1); this is our base case.
 *   - Initialize an Int (left) which will recursively call (dfs) on the left node.
 *   - Initialize an Int (right) which will recursively call (dfs) on the right node.
 *   - Calculate the (diameter) after traversing the (left) and (right) nodes:
 *     - The diameter will be 2 + (left) + (right).
 *     - Set (result) to the max of (result) and (diameter).
 *     - Return 1 + the max of (left) and (right); this is the height of the current node.
 * - Call the (dfs) function, passing in the root node as an argument.
 * - Ultimately return (result).
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
    var result = 0

    fun dfs(root: TreeNode?): Int {
        root ?: return -1

        val left = dfs(root.left)
        val right = dfs(root.right)

        val diameter = 2 + left + right
        result = maxOf(result, diameter)

        return 1 + maxOf(left, right)
    }

    dfs(root)

    return result
}

//endregion
