package leetcode.easy

//region Problem

/**
 * You are given 2 integer arrays 'nums1' and 'nums2' of lengths 'n' and 'm' respectively. You are given
 * a positive integer 'k'.
 *
 * A pair '(i, j)' is called good if 'nums[i]' is divisible by 'nums2[j] * k' ('0 <= i <= n - 1, 0 <= j
 * <= m - 1').
 */

//endregion

//region Steps to solve

/**
 * Check if each index of 'nums1' is divisible by any index in 'nums2' * k.
 * - Iterate over each element in 'nums1'
 * - For each element:
 *   - Iterate over 'nums2'
 *   - Check the divisible condition
 *   - If divisible, add to a resulting sum
 */

//endregion

//region Solution

private fun main() {
    // Output: 5
    numberOfPairs(nums1 = intArrayOf(1, 3, 4), nums2 = intArrayOf(1, 3, 4), k = 1)

    // Output: 2
    numberOfPairs(nums1 = intArrayOf(1, 2, 4, 12), nums2 = intArrayOf(2, 4), k = 3)
}

private fun numberOfPairs(nums1: IntArray, nums2: IntArray, k: Int): Int {
    var goodPairs = 0

    for (num1 in nums1) {
        for (num2 in nums2) {
            if (num1 % (num2 * k) == 0) {
                goodPairs++
            }
        }
    }

    return goodPairs
}

//endregion
