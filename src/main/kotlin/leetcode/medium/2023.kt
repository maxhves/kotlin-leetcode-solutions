package leetcode.medium

//region Problem

/**
 * Given an array of digit strings (nums) and a digit string (target), return the number of pairs of
 * indices (i, j) where (i != j) such that the concatenation of (nums[i] + nums[j]) equals (target).
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialize a variable (successfulPairs) set to 0.
 * - Iterate over the (nums) array; for each (i):
 *   - Iterate over (nums) from 0 to the end of (nums):
 *     - Check if (nums[i] + nums[j]) is equal to target:
 *       - Don't check indexes where (i) and (j) are equal.
 *       - If yes, increment (successfulPairs) by one.
 * - Return (successfulPairs).
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    numOfPairs(
        nums = arrayOf("777", "7", "77", "77"),
        target = "7777",
    )
}

private fun numOfPairs(nums: Array<String>, target: String): Int {
    var successfulPairs = 0

    for (i in 0..nums.lastIndex) {
        for (j in 0..nums.lastIndex) {
            if (i != j) {
                if ("${nums[i]}${nums[j]}" == target) {
                    successfulPairs++
                }
            }
        }
    }

    return successfulPairs
}

//endregion
