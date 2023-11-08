package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary search tree, rearrange the tree in-order so that the leftmost node in
 * the tree is now the root of the tree, and every node has no left child and only one right child.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We can traverse the tree in-order and add the node as the right child of the last node.
 *  - When traversing, we check the left node first.
 *  - We set the current (tempNode) right node to a new node (the value of which is the current node value).
 *  - We then set the temp node to the current temp nodes right node.
 *  - We then check the right node.
 */

//endregion

//region Solution

private fun main() {
    val root = TreeNode(5)
    val six = TreeNode(6)
    val eight = TreeNode(8)
    val seven = TreeNode(7)
    val nine = TreeNode(9)
    val three = TreeNode(3)
    val four = TreeNode(4)
    val two = TreeNode(2)
    val one = TreeNode(1)

    root.right = six
    six.right = eight
    eight.left = seven
    eight.right = nine

    root.left = three
    three.right = four
    three.left = two
    two.left = one

    increasingBST(root)
}

var flatRoot = TreeNode(0)
var tempNode: TreeNode? = flatRoot

private fun increasingBST(root: TreeNode?): TreeNode? {
    inorderTraversal(root)

    return flatRoot.right
}

private fun inorderTraversal(node: TreeNode?) {
    node ?: return

    inorderTraversal(node.left)

    tempNode?.right = TreeNode(node.`val`)
    tempNode = tempNode?.right

    inorderTraversal(node.right)
}

//endregion
