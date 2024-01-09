package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves
 * from a leaf value sequence.
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Return (true) if and only if the two given trees with head nodes (root1) and (root2) are leaf-similar.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We can do an inorder traversal on each binary tree.
 *   - If the current node is a leaf node (both left and right is null)
 *     - We can add this node to a list of leaf nodes.
 * - We can run the recursive function once for each binary tree.
 * - We can then compare the lists of leaf nodes.
 * - Return if the two lists match.
 */

//endregion

//region Solution

private fun main() {
    // ...
}

private fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val root1Leaves = mutableListOf<Int>()
    val root2Leaves = mutableListOf<Int>()

    fun inorderTraverse(node: TreeNode?, list: MutableList<Int>) {
        node ?: return

        inorderTraverse(node.left, list)

        if (node.left == null && node.right == null) {
            list.add(node.`val`)
        }

        inorderTraverse(node.right, list)
    }

    inorderTraverse(root1, root1Leaves)
    inorderTraverse(root2, root2Leaves)

    return root1Leaves == root2Leaves
}

//endregion
