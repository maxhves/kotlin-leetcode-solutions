package leetcode.easy

import leetcode.common.TreeNode
import java.util.*

//region Problem

/**
 * Given the `root` node of a binary search tree and two integers `low` and `high`, return the sum of
 * values of all nodes with a value in the inclusive range `[low, high]`.
 */

//endregion

//region Test cases

/**
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 */

//endregion

//region Solution

private fun main() {
    rangeSumBST(
        root = null,
        high = 15,
        low = 7,
    )
}

fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    if (root == null) return 0

    var sum = 0
    val stack = Stack<TreeNode>()
    stack.push(root)

    while (stack.isNotEmpty()) {
        val current = stack.pop()

        if (current.`val` in low..high) {
            sum += current.`val`
        }

        if (current.right != null) {
            stack.push(current.right)
        }

        if (current.left != null) {
            stack.push(current.left)
        }
    }

    return sum
}

/**
 * Alternative solution
 */
fun rangeSumBSTAlternative(root: TreeNode?, low: Int, high: Int): Int {
    if (root == null) return 0

    var answer = 0

    if (root.`val` in low..high) {
        answer = root.`val`
    }

    return answer + rangeSumBSTAlternative(root.left, low, high) + rangeSumBSTAlternative(root.right, low, high)
}

//endregion