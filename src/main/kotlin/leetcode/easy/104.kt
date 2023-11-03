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
 * Considerations:
 *  - We should find the longest path in the binary tree.
 *
 * 1. Check if the root is null, if so; return 0.
 * 2. Initialise a (leftCount), and (rightCount) variable, both at 1.
 *     - 1 accounts for the node we are currently at.
 * 3. If the (root.left) node is not null then (leftCount) should be set to:
 *     - 1 + (maxDepth()) recursive call.
 *        - This ultimately returns the max of the (leftCount) and (rightCount).
 * 4. If the (root.right) node is not null then (rightCount) should be set to:
 *     - 1 + (maxDepth()) recursive call.
 * 5. Ultimately we will return the max of (leftCount, rightCount).
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
    if (root == null) {
        return 0
    }

    var leftCount = 1
    var rightCount = 1

    if (root.left != null) {
        leftCount = 1 + maxDepth(root.left)
    }

    if (root.right != null) {
        rightCount = 1 + maxDepth(root.right)
    }

    return maxOf(leftCount, rightCount)
}

//endregion
