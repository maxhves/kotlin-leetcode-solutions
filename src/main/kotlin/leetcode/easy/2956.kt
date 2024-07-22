package leetcode.easy

//region Problem

/**
 * You are given two integer arrays 'nums1' and 'nums2' of sizes 'n' and 'm', respectively. Calculate the following values:
 *
 * - 'answer1': the number of indices 'i' such that 'nums1[i]' exists in 'nums2'
 * - 'answer2': the number of indices 'i' such that 'nums2[i]' exists in 'nums1'
 *
 * Return '[answer1, answer2]'
 */

//endregion

//region Steps to solve

/**
 * How many elements in one given array exist in the other array?
 *
 * For each element iterate over the other, check if it exists.
 * Do this for both arrays.
 */

//endregion

//region Solution

private fun main() {
    // Output: [2, 1]
    findIntersectionValues(nums1 = intArrayOf(2, 3, 2), nums2 = intArrayOf(1, 2))

    // Output: [3, 4]
    findIntersectionValues(nums1 = intArrayOf(4, 3, 2, 3, 1), nums2 = intArrayOf(2, 2, 5, 2, 3, 6))
}

private fun findIntersectionValues(nums1: IntArray, nums2: IntArray): IntArray {
    var firstElementsInSecond = 0
    var secondElementsInFirst = 0

    for (i in nums1) {
        for (j in nums2) {
            if (i == j) {
                firstElementsInSecond++
                break
            }
        }
    }

    for (i in nums2) {
        for (j in nums1) {
            if (i == j) {
                secondElementsInFirst++
                break
            }
        }
    }

    return intArrayOf(firstElementsInSecond, secondElementsInFirst)
}

//endregion
