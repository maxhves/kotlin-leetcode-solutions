package leetcode.easy

//region Problem

/**
 * Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer
 * common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.
 *
 * Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one
 * occurrence of that integer.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * -
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    getCommon(
        nums1 = intArrayOf(1, 2, 3),
        nums2 = intArrayOf(2, 4)
    )
}

private fun getCommon(nums1: IntArray, nums2: IntArray): Int {
    val nums1Set = nums1.toSet()

    for (num in nums2) {
        if (num in nums1Set) {
            return num
        }
    }

    return -1
}

//endregion
