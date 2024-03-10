package leetcode.easy

//region Problem

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the
 * result must be unique and you may return the result in any order.
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
    // Output [2]
    intersection(
        nums1 = intArrayOf(1, 2, 2, 1),
        nums2 = intArrayOf(2, 2)
    )
}

private fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val intersectionSet = mutableSetOf<Int>()

    for (num in nums2) {
        if (num in nums1) {
            intersectionSet.add(num)
        }
    }

    return intersectionSet.toIntArray()
}

//endregion
