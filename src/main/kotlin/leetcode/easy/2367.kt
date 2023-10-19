package leetcode.easy

//region Problem

/**
 * You are given a 0-indexed, strictly increasing integer array `nums` and a positive integer `diff`.
 * A triplet `(i, j, k)` is an arithmetic triplet if the following conditions are met:
 *  - `i < j < k`
 *  - `nums[j] - nums[i] == diff`, and
 *  - `nums[k] - nums[j] == diff`.
 *
 * Return the number of unique arithmetic triplets.
 */

//endregion

//region Test cases

/**
 * Input: nums = [0,1,4,6,7,10], diff = 3
 * Output: 2
 *
 * Input: nums = [4,5,6,7,8,9], diff = 2
 * Output: 2
 */

//endregion

//region Solution

private fun main() {
    arithmeticTriplets(nums = intArrayOf(0, 1, 4, 6, 7, 10), diff = 3)
    arithmeticTriplets(nums = intArrayOf(4, 5, 6, 7, 8, 9), diff = 2)
}

private fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
    var answerCount = 0
    var midpoint = 1

    while(midpoint < nums.lastIndex) {
        val startMatch = searchForMatch(nums, diff, midpoint, true)
        val endMatch = searchForMatch(nums, diff, midpoint, false)

        if (startMatch && endMatch) {
            answerCount++
        }

        midpoint++
    }

    return answerCount
}

private fun searchForMatch(
    nums: IntArray,
    diff: Int,
    midpoint: Int,
    searchForStart: Boolean,
): Boolean {
    var start = 0
    var end = nums.lastIndex

    if (searchForStart) {
        while (start != midpoint) {
            if (nums[midpoint] - nums[start] == diff) {
                return true
            } else {
                start++
            }
        }
    } else {
        while (end != midpoint) {
            if (nums[end] - nums[midpoint] == diff) {
                return true
            } else {
                end--
            }
        }
    }

    return false
}

//endregion