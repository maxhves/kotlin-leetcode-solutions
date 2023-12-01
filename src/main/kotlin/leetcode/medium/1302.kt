package leetcode.medium

import leetcode.common.BinarySearchTree
import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary tree, return the sum of values of its deepest leaves.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - We should find the sum of nodes with null children, whom are sitting at the deepest possible level.
 *
 * Steps
 * - Traverse the tree for the first time, and return the deepest level.
 *   - This can be done by comparing each nodes' (maxOf()) path.
 * - Traverse the tree again, this time checking which level we are in.
 *   - If we are at the deepest level, escalate this nodes' value to a sum value.
 * - Ultimately return the resulting sum.
 */

//endregion

//region Solution

private fun main() {
    val root = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    val four = TreeNode(4)
    val five = TreeNode(5)
    val six = TreeNode(6)
    val seven = TreeNode(7)
    val eight = TreeNode(8)
    root.left = two
    root.right = three
    two.left = four
    two.right = five
    four.left = seven
    three.right = six
    six.right = eight

    deepestLeavesSum(root = root)
}

private fun deepestLeavesSum(root: TreeNode?): Int {
    root ?: return 0

    fun findDeepestLevel(node: TreeNode?): Int {
        node ?: return 0

        val left = findDeepestLevel(node.left)
        val right = findDeepestLevel(node.right)

        return maxOf(left, right) + 1
    }
    val deepestLevel = findDeepestLevel(root)

    var leavesSum = 0
    fun sumIfDeepestLevel(node: TreeNode?, currentLevel: Int) {
        node ?: return

        if (currentLevel == deepestLevel) {
            leavesSum += node.`val`
        }

        sumIfDeepestLevel(node.left, currentLevel + 1)
        sumIfDeepestLevel(node.right, currentLevel + 1)
    }
    sumIfDeepestLevel(root, 1)

    return leavesSum
}

//endregion
