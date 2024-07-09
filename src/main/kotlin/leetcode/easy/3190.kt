package leetcode.easy

//region Problem

/**
 * You are given an integer array 'nums'. In one operation, you can add or subtract 1 from any element of
 * 'nums'.
 *
 * Return the minimum number of operations to make all elements of 'nums' divisible by 3.
 */

//endregion

//region Steps to solve

/**
 * - Any number is 1 away from being divisible by 3.
 * - Iterate over each number, if it isn't immediately divisible by 3, add 1 to a running total.
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    minimumOperations(nums = intArrayOf(1, 2, 3, 4))
}

private fun minimumOperations(nums: IntArray): Int {
    return nums.fold(0) { acc, i -> if (i % 3 != 0) acc + 1 else acc }
}

//endregion
