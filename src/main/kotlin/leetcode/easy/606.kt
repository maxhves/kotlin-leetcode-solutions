package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary tree, construct a string consisting of parenthesis and integers from a
 * binary tree with the preorder traversal way, and return it.
 *
 * Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the
 * string and the original binary tree.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialize a (result) StringBuilder variable.
 * - Create a (preorderTraverse(node)) function:
 *   - If (node) is equal to null, simply return.
 *   - Append (node) value to (result).
 *   - If the left node is null:
 *     - Append "(" (preorderTraverse(node.left)) ")" to (result)
 *   - Else; if right node is not null; append "()" to (result).
 *   - If right node is not null:
 *     - Append "(" (preorderTraverse(node.right)) ")" to (result)
 */

//endregion

//region Solution

private fun main() {
    val root = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    val four = TreeNode(4)
    root.left = two
    root.right = three
    two.left = four

    tree2str(root = root)
}

private fun tree2str(root: TreeNode?): String {
    val result = StringBuilder()

    fun preorderTraverse(node: TreeNode?) {
        if (node == null) {
            return
        }

        result.append("${node.`val`}")

        if (node.left != null) {
            result.append("(")
            preorderTraverse(node.left)
            result.append(")")
        } else {
            if (node.right != null) {
                result.append("()")
            }
        }

        if (node.right != null) {
            result.append("(")
            preorderTraverse(node.right)
            result.append(")")
        }
    }

    preorderTraverse(root)

    return result.toString()
}

//endregion
