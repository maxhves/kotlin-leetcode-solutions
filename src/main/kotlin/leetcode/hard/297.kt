package leetcode.hard

import leetcode.common.TreeNode

//region Problem

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that
 * it can be stored in a file or memory bugger, or transmitted across a network connection link to be
 * reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be
 * serialized to a string an this string can be deserialized to the original tree structure.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - We will receive a binary tree, we should serialize this to a string.
 *   - We could store each node in a string and each node will be separated by a comma.
 *   - We should store the null nodes so that we know.
 *   - We can store these in a preorder format.
 */

//endregion

//region Solution

private fun main() {
    val root = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    val four = TreeNode(4)
    val five = TreeNode(5)
    root.left = two
    root.right = three
    three.left = four
    four.right = five

    val codec = Codec()
    val serializedTree = codec.serialize(root)
    val deserializedTree = codec.deserialize(serializedTree)
    val resultRoot = deserializedTree
}

private class Codec {
    fun serialize(root: TreeNode?): String {
        val result = StringBuilder()

        fun preorderTraverse(node: TreeNode?) {
            if (node == null) {
                result.append("null,")
                return
            }

            result.append("${node.`val`},")

            preorderTraverse(node.left)
            preorderTraverse(node.right)
        }
        preorderTraverse(root)

        result.deleteCharAt(result.lastIndex)
        return result.toString()
    }

    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) {
            return null
        }

        var currentIndex = 0

        fun inorderBuild(nodes: List<String>): TreeNode? {
            if (nodes[currentIndex] == "null") {
                currentIndex++
                return null
            }

            val root = TreeNode(nodes[currentIndex].toInt())
            currentIndex++
            root.left = inorderBuild(nodes)
            root.right = inorderBuild(nodes)

            return root
        }

        return inorderBuild(data.split(","))
    }
}

//endregion
