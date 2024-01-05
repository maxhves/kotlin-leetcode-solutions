package leetcode.medium

//region Problem

/**
 * Given an integer array (nums), return the length of the longest strictly increasing subsequence.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialize a IntArray, this is our (cache).
 * - Iterate over each element in (nums), from 1 to the end of the array.
 * - Create an inner loop (j), from 0 to the outer loop (i).
 * - If (nums[i]) is greater than (nums[j]):
 *   - Add the max of (cache[j] + 1) and (cache[i]) to (cache[i]).
 * - Ultimately return the max value in (cache).
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    lengthOfLIS(nums = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18))

    // Output: 4
    lengthOfLIS(nums = intArrayOf(0, 1, 0, 3, 2, 3))

    // Output: 1
    lengthOfLIS(nums = intArrayOf(7, 7, 7, 7, 7, 7, 7))
}

private fun lengthOfLIS(nums: IntArray): Int {
    val cache = IntArray(nums.size) { 1 }

    for (i in 1..nums.lastIndex) {
        for (j in 0..i) {
            if (nums[i] > nums[j]) {
                cache[i] = maxOf(cache[j] + 1, cache[i])
            }
        }
    }

    return cache.max()
}

//endregion
