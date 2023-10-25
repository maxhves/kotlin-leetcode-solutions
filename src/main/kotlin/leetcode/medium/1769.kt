package leetcode.medium

import kotlin.math.abs

//region Problem

/**
 * You have (n) boxes. You are given a binary string (boxes) of length (n), where (boxes[i]) is ('0') if
 * the (ith) box is empty and ('1') if it contains one ball.
 *
 * In one operation, you can move one ball from a box to an adjacent box. Box (i) is adjacent to box (j)
 * if (abs(i - j) == 1). Note that after doing so, there may be more than one ball in some boxes.
 *
 * Return an array (answer) of size (n), where (answer[i]) is the minimum number of operations needed to
 * move all the balls to the (ith) box.
 *
 * Each (answer[i]) is calculated considering the initial state of the boxes.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - We need to move all the balls into the (ith) box.
 *
 * Example: "001011"
 *
 * 1. Calculate how many moves it would take to move balls into the box for each position, for
 *    both left and right.
 * 2. Iterate over the array from 0 to (boxes.lastIndex):
 *    - For each (i):
 *      - Iterate from (boxes.lastIndex) downTo (i):
 *        - If there is a ball in (j):
 *          - Calculate how many moves it would take to move the ball into (i).
 *          - Store the number of moves into a (right) array.
 *        - Repeat for all indexes.
 * 3. Iterate over the array from (boxes.lastIndex) downTo 0:
 *    - For each (i):
 *      - Iterate from 0 to (i):
 *       - If there is a ball in (j):
 *         - Calculate how many moves it would take to move that ball into (i).
 *         - Store the number of moves in a (left) array.
 *       - Repeat for all indexes.
 * 4. Iterate from 0 to (boxes.lastIndex):
 *    - For each (i) sum the numbers in (left[i]) and (right[i]).
 * 5. Return this resulting array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [1, 1, 3]
    // minOperations(boxes = "110")

    // Output: [11, 8, 5, 4, 3, 4]
    minOperations(boxes = "001011")
}

private fun minOperations(boxes: String): IntArray {
    val n = boxes.length
    val result = IntArray(n)
    var leftMoves = 0
    var rightMoves = 0
    var leftCount = 0
    var rightCount = 0

    for (i in 0 until n) {
        result[i] += leftMoves
        if (boxes[i] == '1') {
            leftCount++
        }
        leftMoves += leftCount
    }

    for (i in n - 1 downTo 0) {
        result[i] += rightMoves
        if (boxes[i] == '1') {
            rightCount++
        }
        rightMoves += rightCount
    }

    return result
}

//endregion
