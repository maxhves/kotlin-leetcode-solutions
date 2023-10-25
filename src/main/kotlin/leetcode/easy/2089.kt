package leetcode.easy

//region Problem

/**
 * You are given an 0-indexed integer array (nums) and a target element (target).
 *
 * A target index is an index (i) such that (nums[i] == target).
 *
 * Return a list of the target indices of (nums) after sorting (nums) in non-decreasing order. If there are
 * no target indices, return an empty list. The returned list must be sorted in increasing order.
 */

//endregion

//region Steps to solve

/**
 * 1. Sort the (nums) array in place.
 * 2. Iterate over the (nums) array:
 *    - If nums[i] == (target):
 *      - Add (i) into the resulting array.
 * 3. Return the eventual result.
 */

//endregion

//region Solution

private fun main() {
    // Output: [1, 2]
    targetIndices(nums = intArrayOf(1, 2, 5, 2, 3), target = 2)

    // Output: [3]
    targetIndices(nums = intArrayOf(1, 2, 5, 2, 3), target = 3)

    // Output: [4]
    targetIndices(nums = intArrayOf(1, 2, 5, 2, 3), target = 5)
}

private fun targetIndices(nums: IntArray, target: Int): List<Int> {
    nums.sort()
    val result = mutableListOf<Int>()

    for (i in nums.indices) {
        if (nums[i] == target) {
            result.add(i)
        }
    }

    return result
}

//endregion
