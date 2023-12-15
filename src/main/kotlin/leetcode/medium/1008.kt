package leetcode.medium

import datastructures.Stack
import leetcode.common.TreeNode

//region Problem

/**
 * Given an array of integers in preorder, which represents the preorder traversal of a BST, construct
 * the tree and return its root.
 *
 * It is guaranteed that it is always possible to find a binary search tree with the given requirements
 * for the given test cases.
 *
 * A binary search tree is a binary tree where for every node, any descendant of (Node.left) has a value
 * strictly less than (Node.val), and any descendant of (Node.right) has a value strictly greater than
 * (Node.val).
 *
 * A preorder traversal of a binary tree displays the value of the node first, then traverses (Node.left),
 * then traverses (Node.right).
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Create a Stack component (nodeStack).
 * - Create a (root) node using the first value in (preorder).
 * - Iterate over the rest of the values in (preorder):
 *   - Create a (newNode) using the current value.
 *   - Create a loop to check that, while (nodeStack) is not empty, remove all nodes in the stack that
 *     are smaller than the current value.
 *     - This is to ensure that we can insert the nodes in the correct place, since the greater nodes
 *       should always go on the right.
 *   - If the current value is smaller than the last node in the stack:
 *     - Set this nodes left child to (newNode).
 *   - Otherwise, set its right child to (newNode).
 * - Ultimately, return (root).
 */

//endregion

//region Solution

private fun main() {
    // Output: [8,5,10,1,7,null,12]
    bstFromPreorder(preorder = intArrayOf(8, 5, 1, 7, 10, 12))
}

private fun bstFromPreorder(preorder: IntArray): TreeNode? {
    val root = TreeNode(preorder[0])
    var currentNode = root
    val nodeStack = Stack<TreeNode>()

    nodeStack.push(root)

    for (i in 1..preorder.lastIndex) {
        val newNode = TreeNode(preorder[i])

        while (!nodeStack.isEmpty() && nodeStack.peek().`val` < newNode.`val`) {
            currentNode = nodeStack.pop()
        }

        if (newNode.`val` < currentNode.`val`) {
            currentNode.left = newNode
        } else {
            currentNode.right = newNode
        }

        nodeStack.push(newNode)
        currentNode = newNode
    }

    return root
}

//endregion
