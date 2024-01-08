package leetcode.hard

import kotlin.math.abs

//region Problem

/**
 * Given an integer array (nums), return the number of all the arithmetic subsequences of (nums).
 *
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the
 * difference between any two consecutive elements is the same.
 * - For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
 * - For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
 *
 * A subsequence of an array is a sequence that can be formed by removing some elements (possible none)
 * of the array.
 * - For example, [2, 5, 10] is a subsequence of [1, 2, 1, 2, 4, 1, 5, 10].
 *
 * The test cases are generated so tha the answer fits in a 32-bit integer.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialize a cache property, an Array of Map.
 * - Iterate over each element in (nums):
 *   - Create an inner loop for each element up until (i) - the outer loop.
 *     - Get the difference between (nums[i] - nums[j]).
 *     - Set (cache[i][difference]) to (cache[i][difference]) + (cache[j][difference]).
 * - The total number of subsequences can be calculated by summing all the values in (cache).
 * - We need to remove the number of combinations (to get rid of duplicates)
 *   - This can be done by calculating the number of combinations (n * (n - 1) / 2).
 */

//endregion

//region Solution

private fun main() {
    // Output: 7
    numberOfArithmeticSlices(
        nums = intArrayOf(2, 4, 6, 8, 10),
    )
}

private fun numberOfArithmeticSlices(nums: IntArray): Int {
    val n = nums.size

    val cache = Array(n) { mutableMapOf<Long, Long>() }

    for (i in nums.indices) {
        for (j in 0 until i) {
            val difference = nums[i].toLong() - nums[j].toLong()
            cache[i][difference] = 1 + (cache[i][difference] ?: 0L) + (cache[j][difference] ?: 0L)
        }
    }

    val totalSubsequences = cache.sumOf { it.values.sum() }.toInt()
    return totalSubsequences - (n * (n - 1) / 2)
}

//endregion
