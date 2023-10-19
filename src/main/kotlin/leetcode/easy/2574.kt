package leetcode.easy

import kotlin.math.abs

//region Problem

/**
 * Given a 0-indexed integer array `nums`, find a 0-indexed integer array `answer`.
 * Where:
 * - `answer.length == nums.length`.
 * - `answer[i] = |leftSum[i] - rightSum[i]|`.
 *
 * Where:
 * - `leftSum[i]` is the sum of elements to the left of the index `i` in the array `nums`. If there is no such
 *    element, `leftSum[i] = 0`.
 * - `rightSum[i]` is the sum of elements to the right of the index `i` in the array `nums`. If there is no such
 *    element, `rightSum[i] = 0`.
 *
 * Return the array `answer`.
 */

//endregion

//region Test case

/**
 * Input: nums = [10,4,8,3]
 * Output: [15,1,11,22]
 *
 * Input: nums = [1]
 * Output: [0]
 */

//endregion

//region Solution

private fun main() {
    leftRightDifference(nums = intArrayOf(10, 4, 8, 3))
    leftRightDifference(nums = intArrayOf(1))
}

private fun leftRightDifference(nums: IntArray): IntArray {
    val arraySize = nums.size
    val leftSum = IntArray(arraySize)
    val rightSum = IntArray(arraySize)
    val answer = IntArray(arraySize)

    for (i in 1 until arraySize) {
        leftSum[i] = leftSum[i - 1] + nums[i - 1]
    }

    for (i in arraySize - 2 downTo 0) {
        rightSum[i] = rightSum[i + 1] + nums[i + 1]
    }

    for (i in 0 until arraySize) {
        answer[i] = abs(leftSum[i] - rightSum[i])
    }

    println("Answer array is: ${answer.joinToString() }")
    return answer
}

//endregion