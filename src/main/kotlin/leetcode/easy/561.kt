package leetcode.easy

//region Problem

/**
 * Given an integer array (nums) of (2n) integers, group these integers into (n) pairs ((a 1, b 1),
 * (a 2, b 2), ..., (a n, b n)) such that the sum of (min(a i, b i)) is maximized.
 *
 * Return the maximuzed sum.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - We are to find the maximal sum of taking the minimal value from a created pair.
 *
 * Steps:
 * - Sort the (nums) array in-place.
 * - Split the (nums) array into a list of pairs.
 * - Iterate over the pairs and for each pair:
 *   - Take the minimum value of the two, and sum it to a result value.
 * - Return the resulting value.
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    arrayPairSum(nums = intArrayOf(1, 4, 3, 2))

    // Output: 9
    arrayPairSum(nums = intArrayOf(6, 2, 6, 5, 1, 2))
}

private fun arrayPairSum(nums: IntArray): Int {
    nums.sort()
    var result = 0

    for (i in nums.indices step 2) {
        result += nums[i]
    }

    return result
}

//endregion
