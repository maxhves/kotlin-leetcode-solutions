package leetcode.easy

//region Problem

/**
 * Given a 0-indexed integer array `nums` of length `n` and an integer `target`, return the number of
 * pairs `(i,j)` where `0 <= i < j < n` and `nums[i] + nums[j] < target`.
 */

//endregion

//region Test cases

/**
 * Input: nums = [-1,1,2,3,1], target = 2
 * Output: 3
 *
 * Input: nums = [-6,2,5,-2,-7,-1,3], target = -2
 * Output: 10
 */

//endregion

//region Solution

private fun main() {
    countPairs(nums = listOf(-1, 1, 2, 3, 1), target = 2)
    countPairs(nums = listOf(-6, 2, 5, -2, -7, -1, 3), target = -2)
}

fun countPairs(nums: List<Int>, target: Int): Int {
    var successfulPairCount = 0

    for (i in nums.indices) {
        for (j in nums.indices) {
            if (i < j && nums[i] + nums[j] < target) {
                successfulPairCount++
            }
        }
    }

    println("Number of successful pairs: $successfulPairCount")
    return successfulPairCount
}

//endregion