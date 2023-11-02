package leetcode.medium

import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary tree, return the number of nodes where the value of the node is equal
 * to the average of the values in its subtree.
 *
 * Note:
 *  - The average of (n) elements is the sum of the (n) elements divided by (n) and rounded down to the
 *    nearest integer.
 *  - A subtree of (root) is a tree consisting of (root) and all of its descendants.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We need to find the average for each individual subtree in the array and compare it to the value
 *    in the root node, if they match, increment our result count.
 *  - We need to traverse the subtree for each node and average up it's two nodes.
 *
 * 1. Create a postorder traversal function.
 * 2. Get the result of a traversal as a Pair:
 *     - First: Sum of the node values.
 *     - Second: Number of non-null nodes.
 * 3. With each traversal; check if the average is equal to the node value:
 *     - If yes, then we've found a match.
 *     - We need to increase a count of how many matches we find.
 * 4. Return this resulting count.
 */

//endregion

//region Solution

private fun main() {
    val root = TreeNode(4)
    val eight = TreeNode(8)
    val five = TreeNode(5)
    val zero = TreeNode(0)
    val one = TreeNode(1)
    val six = TreeNode(6)

    root.right = five
    five.right = six
    root.left = eight
    eight.left = zero
    eight.right = one

    averageOfSubtree(root = root)
}

private fun averageOfSubtree(root: TreeNode?): Int {
    val subtreeAverageMatches = mutableListOf<Int>()

    postorderTraversal(subtreeAverageMatches, root)
    return subtreeAverageMatches.count()
}

private fun postorderTraversal(
    subtreeAverageMatches: MutableList<Int>,
    node: TreeNode?,
): Pair<Int, Int> {
    if (node == null) {
        return 0 to 0
    }

    val left = postorderTraversal(subtreeAverageMatches, node.left)
    val right = postorderTraversal(subtreeAverageMatches, node.right)

    if (
        ((left.first + right.first + node.`val`) / (left.second + right.second + 1) == node.`val`)
    ) {
        subtreeAverageMatches.add(node.`val`)
    }

    return (left.first + right.first + node.`val`) to (left.second + right.second + 1)
}

//endregion
