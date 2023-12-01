package leetcode.common

class BinarySearchTree(
    vararg nodeValues: Int,
) {
    var root: TreeNode? = null

    init {
        for (value in nodeValues) {
            root = insertNode(root, value)
        }
    }

    private fun insertNode(root: TreeNode?, value: Int): TreeNode {
        root ?: return TreeNode(value)

        if (value < root.`val`) {
            root.left = insertNode(root.left, value)
        } else if (value > root.`val`) {
            root.right = insertNode(root.right,  value)
        }

        return root
    }
}