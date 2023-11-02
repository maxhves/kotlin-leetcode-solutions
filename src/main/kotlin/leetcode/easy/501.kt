package leetcode.easy

import leetcode.common.TreeNode

//region Problem

/**
 * Given the (root) of a binary search tree (BST) with duplicates, return all the modes (i.e., the most
 * frequently occurred element) in it.
 *
 * If the tree has more than one mode, return them in any order.
 *
 * Assume a BST is defined as follows:
 *  - The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 *  - The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 *  - Both the left and right subtrees must also be binary search trees.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We should be traversing all the nodes in the tree.
 *  - We also need to create a frequency map of the node values.
 *
 * 1. Traverse the array with am inorder Depth First Search approach.
 * 2. Take the root of the node:
 *     - Visit the left node.
 *     - Evaluate its value:
 *        - Add the value to a frequency hash map.
 *     - Visit the right node.
 *     - Recursively call this function.
 * 3. Check the values in the hashmap and return all the greatest values.
 */

//endregion

//region Solution

private fun main() {
    // Output: [2]
    val root = TreeNode(1)
    val twoOne = TreeNode(2)
    val twoTwo = TreeNode(2)

    twoOne.left = twoTwo
    root.right = twoOne

    findNode(root)
}

private fun findNode(root: TreeNode?): IntArray {
    val frequencyMap = HashMap<Int, Int>()
    val answer = mutableListOf<Int>()

    inorderTraverse(frequencyMap, root)

    var max = frequencyMap.values.max()
    for (entry in frequencyMap.entries) {
        if (entry.value >= max) {
            answer.add(entry.key)
            max = entry.value
        }
    }

    return answer.toIntArray()
}

private fun inorderTraverse(frequencyMap: HashMap<Int, Int>, node: TreeNode?) {
    if (node == null) {
        return
    }

    inorderTraverse(frequencyMap, node.left)

    frequencyMap[node.`val`] = frequencyMap.getOrDefault(node.`val`, 0) + 1

    inorderTraverse(frequencyMap, node.right)
}

//endregion
