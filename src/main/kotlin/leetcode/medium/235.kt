package leetcode.medium

import leetcode.common.BinarySearchTree
import leetcode.common.TreeNode

//region Problem

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the
 * BST.
 *
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two
 * nodes (p) and (q) as the lowest node in (T) that has both (p) and (q) as descendants (where we allow
 * a node to be a descendant of itself)."
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - The root will always be an ancestor, so we start there.
 * - We can check the lowest common node by comparing if the nodes we are searching for are smaller than
 *   or greater than the current node (this will tell us which child they belong to).
 *
 * Steps
 * - We can recursively call the (lowestCommonAncestor) function.
 * - We should return nodes based on the following conditions:
 *   - If (currentNode) is equal to (p) or (q):
 *     - Return (currentNode).
 *   - If (p) and (q) are smaller than (currentNode):
 *     - Return the left child of (currentNode).
 *   - If (p) and (q) are greater than (currentNode):
 *     - Return the right child of (currentNode).
 */

//endregion

//region Solution

private fun main() {
    val tree = BinarySearchTree(6, 2, 8, 0, 4, 7, 9, 3, 5)
    lowestCommonAncestor(tree.root, TreeNode(2), TreeNode(8))
    lowestCommonAncestor(tree.root, TreeNode(2), TreeNode(4))
}

private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    root ?: return null
    p ?: return null
    q ?: return null

    val nodeValue = root.`val`
    val pValue = p.`val`
    val qValue = q.`val`

    if (nodeValue == pValue || nodeValue == qValue) {
        return root
    }

    return if (nodeValue > pValue && nodeValue > qValue) {
        lowestCommonAncestor(root.left, p, q)
    } else if (nodeValue < pValue && nodeValue < qValue) {
        lowestCommonAncestor(root.right, p, q)
    } else {
        root
    }
}

//endregion
