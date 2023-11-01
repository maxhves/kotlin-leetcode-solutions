package leetcode.easy

//region Problem

/**
 * Given a 0-indexed integer array (nums), return the smallest index (i) of (nums) such that (i mod 10
 * == nums[i]), or (-1) if such index does not exist.
 *
 * (x mod y) denotes the remainder when (x) is divided by (y).
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the (nums) array.
 * 2. For each element:
 *     - Check if the (value % 10) is equal to (i).
 *     - If they are equal; return this index (i).
 * 3. If we reach this point, return -1.
 */

//endregion

//region Solution

private fun main() {
    // Output: 0
    smallestEqual(nums = intArrayOf(0, 1, 2))

    // Output: 2
    smallestEqual(nums = intArrayOf(4, 3, 2, 1))

    // Output: -1
    smallestEqual(nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0))
}

private fun smallestEqual(nums: IntArray): Int {
    for (i in 0 .. nums.lastIndex) {
        val element = nums[i]
        if ((i % 10) == element) {
            return i
        }
    }
    return -1
}

//endregion
