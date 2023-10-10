package leetcode.easy

//region Problem

/**
 * You are given a 0-indexed integer array `nums` and an integer `k`. Your task is to perform the following
 * operation exactly `k` times in order to maximize your score:
 *  1. Select an element `m` from `nums`.
 *  2. Remove the selected element `m` from the array.
 *  3. Add a new element with a value of `m + 1` to the array.
 *  4. Increase your score by `m`.
 *
 *  Return the maximum score you can achieve after performing the operation exactly `k` times.
 */

//endregion

//region Test cases

/**
 * Input: nums = [1,2,3,4,5], k = 3
 * Output: 18
 *
 * Input: nums = [5,5,5], k = 2
 * Output: 11
 */

//endregion

//region Steps to solve

/**
 * 1. Find the max number.
 * 2. Apply operations.
 * 3. Repeat 1. and 2. for k times.
 * 4. Return sum.
 */

//endregion

//region Solution

private fun main() {
    maximizeSum(nums = intArrayOf(1, 2, 3, 4, 5), k = 3)
    maximizeSum(nums = intArrayOf(5, 5, 5), k = 2)
}

private fun maximizeSum(nums: IntArray, k: Int): Int {
    val max = nums.max()
    val sum = (max * k) + ((k - 1) * k) / 2
    return sum
}

//endregion