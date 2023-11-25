package leetcode.medium

import kotlin.math.abs

//region Problem

/**
 * You are given an integer array (nums) sorted in non-decreasing order.
 *
 * Build and return an integer array (result) with the same length as (nums) such that (result[i]) is equal
 * to the summation of the absolute difference between (nums[i]) and all the other elements in the array.
 *
 * In other words, (result[i]) is equal to (sum(nums[i]-nums[j]]) where (0 <= j < nums.length) and
 * (j != i) 0-indexed.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - An initial solution could involve basically a brute force approach which is to run a nested loop.
 *
 * Steps
 * - Initialize an IntArray (result), to contain the result.
 * - Iterate over the (nums) array, and for each:
 *   - Initialize an Int (current) set to (nums[i]).
 *   - Initialize an Int (total) set to 0.
 *   - Iterate over (nums) again and for each:
 *     - Make sure that (i) and (j) are not equal.
 *     - Initialize an Int (absoluteDifference) set to (abs(nums[i] - nums[j])).
 *     - Add (absoluteDifference) to (sum).
 *   - Set (result[i]) to (current).
 * - Ultimately, return the (result) array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [4, 3, 5]
    getSumAbsoluteDifferences(nums = intArrayOf(2, 3, 5))
}

private fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n)

    var prefixSum = 0
    for (i in nums.indices) {
        result[i] = nums[i] * i - prefixSum
        prefixSum += nums[i]
    }

    var suffixSum = 0
    for (i in n - 1 downTo 0) {
        result[i] += suffixSum - nums[i] * (n - i - 1)
        suffixSum += nums[i]
    }

    return result
}

//endregion
