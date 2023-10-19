package leetcode.easy

//region Problem

/**
 * Given two 0-indexed integer arrays (nums1) and (nums2), return a list (answer) of size (2) where:
 *  - (answer[0]) is a list of all distinct integers in (nums1) which are not present in (nums2).
 *  - (answer[1]) is a list of all distinct integers in (nums2) which are not present in (nums1).
 *
 * Note that all integers in the lists may be returned in any order.
 */

//endregion

//region Steps to solve

/**
 * 1. Place (nums1) and (nums2) into HashSets.
 * 2. Iterate over 0 to (nums1) array size:
 *    - Create a list of elements that appear in (nums1) but not (nums2).
 *    - Create a list of elements that appear in (nums2) but not (nums1).
 * 3. Return the resulting lists.
 */

//endregion

//region Solution

private fun main() {
    // Output: [[1,3],[4,6]]
    findDifference(nums1 = intArrayOf(1, 2, 3), nums2 = intArrayOf(2, 4, 6))

    // Output: [[3],[]]
    findDifference(nums1 = intArrayOf(1, 2, 3, 3), nums2 = intArrayOf(1, 1, 2, 2))
}

private fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val nums1Set = nums1.toHashSet()
    val nums2Set = nums2.toHashSet()

    val notInNums1 = (nums2Set subtract nums1Set).toList()
    val notInNums2 = (nums1Set subtract nums2Set).toList()

    return listOf(notInNums2, notInNums1)
}

//endregion
