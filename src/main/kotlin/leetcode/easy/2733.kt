package leetcode.easy

//region Problem

/**
 * Given an integer array (nums) containing distinct positive integers, find and return any number from the
 * array that is neither the minimum nor the maximum value in the array, or (-1) if there is no such
 * number.
 *
 * Return the selected integer.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the (nums) array.
 * 2. Keep track of a max number, a min number and anything else.
 * 3. Return the "anything else" number.
 * 4. If the (nums) array is of size 2 we must return -1 as no solution can be found.
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    findNonMinOrMax(nums = intArrayOf(3, 2, 1, 4))

    // Output: -1
    findNonMinOrMax(nums = intArrayOf(1, 2))
}

private fun findNonMinOrMax(nums: IntArray): Int {
    if (nums.size <= 2) return -1

    val max = nums.max()
    val min = nums.min()

    return nums.find { it != max && it != min } ?: -1
}

//endregion
