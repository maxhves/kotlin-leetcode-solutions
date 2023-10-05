package leetcode.easy

import kotlin.math.abs

//region Problem

/**
 * Given an integer array `nums` and an integer `k`, return te number of pairs `(i, j)` where `i < j`
 * such that `|nums[i] - nums[j]| == k`.
 *
 * The value of |x| is defined as:
 *  - `x` if `x >= 0`.
 *  - `-x` if `x < 0`.
 */

//endregion

//region Test cases

/**
 * Input: nums = [1,2,2,1], k = 1
 * Output: 4
 *
 * Input: nums = [1,3], k = 3
 * Output: 0
 */

//endregion

//region Steps to solve

/**
 * 1. Loop over the list.
 * 2. Check if the absolute of index - index + 1 == k.
 * 3. Increment pair result if so.
 */

//endregion

//region Solution

private fun main() {
    countKDifference(nums = intArrayOf(1, 2, 2, 1), k = 1)
}

fun countKDifference(nums: IntArray, k: Int): Int {
    var pairs = 0

    for (i in nums.indices) {
        for (j in nums.indices) {
            if (j > i) {
                if (abs(nums[i] - nums[j]) == k) {
                    pairs++
                }
            }
        }
    }

    return pairs
}

/**
 * Optimized solution, using a HashMap.
 *
 * Runtime: 189ms (beats 47.62%).
 * Memory: 36.81mb (beats 71.43%).
 */
fun countKDifferenceOptimized(nums: IntArray, k: Int): Int {
    val numCount = HashMap<Int, Int>()
    var pairs = 0

    for (num in nums) {
        pairs += numCount.getOrDefault(num - k, 0)
        pairs += numCount.getOrDefault(num + k, 0)

        numCount[num] = numCount.getOrDefault(num, 0) + 1
    }

    return pairs
}

//endregion