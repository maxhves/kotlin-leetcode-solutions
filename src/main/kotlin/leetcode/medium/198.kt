package leetcode.medium

import kotlin.math.max

//region Problem

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount
 * of money stashed, the only constraint stopping you from robbing each of them is that adjacent
 * houses have security systems connected, and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum
 * amount of money you can rob tonight without alerting the police.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We should keep track of the previous two indexes:
 *   - rob1: the previous previous index.
 *   - rob2: the previous index.
 * - We then iterate over the nums array:
 *   - For each element, we should take the maximum value of element + rob1 and rob2
 *     - This is because we cannot rob adjacent houses, so either we can rob the previous house,
 *       or we can rob the previous previous house, plus the current house.
 * - We then set rob1 to rob2 and then rob2 to the maximum value we just calculated.
 * - Ultimately we return rob2, which will be the maximum.
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    rob(nums = intArrayOf(1, 2, 3, 1))
}

private fun rob(nums: IntArray): Int {
    var rob1 = 0
    var rob2 = 0

    for (num in nums) {
        val maximum = max(num + rob1, rob2)

        rob1 = rob2
        rob2 = maximum
    }

    return rob2
}

//endregion
