package leetcode.medium

import leetcode.common.BinarySearchTree
import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary search tree, return a balanced binary search tree with the same node
 * values. If there is more than one answer, retun any of them.
 *
 * A binary search tree is balanced if the depth of the two subtrees of every node never differs by
 * more than (1).
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Traverse the given tree (root) and collect all the node values into a list.
 *   - We should traverse in-order.
 * - Take the midpoint of the list and set this as our new root.
 * - Recursively build the new tree by passing in a range to each recursion.
 *   - Pass the range 0 - midpoint for the left node.
 *   - Pass the range midpoint + 1 - lastIndex for the right node.
 *   - Return the new node.
 * - Return the new root we created.
 */

//endregion

//region Solution

private fun main() {
    val tree = BinarySearchTree(1, 2, 3, 4)
    balanceBST(tree.root)
}

private fun balanceBST(root: TreeNode?): TreeNode? {
    val nodeValues = mutableListOf<Int>()

    fun inorderTraverse(node: TreeNode?) {
        node ?: return

        inorderTraverse(node.left)
        nodeValues.add(node.`val`)
        inorderTraverse(node.right)
    }

    inorderTraverse(root)

    fun buildBST(start: Int, end: Int): TreeNode? {
        if (start > end) return null

        val midpoint  = (start + end) / 2
        val node = TreeNode(nodeValues[midpoint])

        node.left = buildBST(start, midpoint - 1)
        node.right = buildBST(midpoint + 1, end)

        return node
    }

    return buildBST(0, nodeValues.lastIndex)
}

//endregion
