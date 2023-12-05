package leetcode.medium

import leetcode.common.TreeNode

//region Problem

/**
 * Given two integer arrays (preorder) and (inorder) where (preorder) is the preorder traversal of a binary
 * tree and (inorder) is the inorder traversal of the same tree, construct and return the binary tree.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - The first element in the (preorder) array is the root node.
 *
 * Steps
 * - Take first element of (preorder) this is the root.
 * - Initialize a new Integer (currentRoot) and set it to first element of (preorder).
 * - Find (currentRoot) in (inorder):
 *   - Left of (inorder[currentRoot]) ar the left children.
 *   - Right of (inorder[currentRoot]) are the right children.
 * - Take the first next element of (preorder).
 * - Recurse.
 */

//endregion

//region Solution

private fun main() {

}

private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) {
        return null
    }

    val root = TreeNode(preorder[0])
    val mid = inorder.indexOf(preorder[0])

    root.left = buildTree(preorder.sliceArray(1 .. mid), inorder.sliceArray(0 until mid))
    root.right = buildTree(preorder.sliceArray(mid + 1 .. preorder.lastIndex), inorder.sliceArray(mid + 1 .. inorder.lastIndex))

    return root
}

//endregion
