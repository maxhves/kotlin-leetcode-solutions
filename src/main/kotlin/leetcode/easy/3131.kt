package leetcode.easy

//region Problem

/**
 * You are given two arrays of equal lenght, 'nums1' and 'nums2'.
 *
 * Each element in 'nums1' has been increased (or decreased in the case of negative) by an integer, represented by
 * the variable 'x'.
 *
 * As a result, 'nums1' becomes equal to 'nums2'. Two arrays are considered equal when they contain the same integers
 * with the same frequencies.
 *
 * Return the integer 'x'.
 */

//endregion

//region Steps to solve

/**
 * - Iterate over each element in the array.
 * - Keep track of the minimum (or maximum) value in each array.
 * - Finally compare the difference between 'nums1Min' and 'nums2Min'.
 * - Return the difference.
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    addedInteger(nums1 = intArrayOf(2, 6, 4), nums2 = intArrayOf(9, 7, 5))

    // Output: -5
    addedInteger(nums1 = intArrayOf(10), nums2 = intArrayOf(5))

    // Output: 0
    addedInteger(nums1 = intArrayOf(1, 1, 1, 1), nums2 = intArrayOf(1, 1, 1, 1))
}

private fun addedInteger(nums1: IntArray, nums2: IntArray): Int {
    var nums1Min = Int.MAX_VALUE
    var nums2Min = Int.MAX_VALUE

    for (i in nums1.indices) {
        nums1Min = minOf(nums1Min, nums1[i])
        nums2Min = minOf(nums2Min, nums2[i])
    }

    return nums2Min - nums1Min
}

//endregion
