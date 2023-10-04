package leetcode.medium

import leetcode.common.MountainArray

//region Problem

/**
 * There is an integer array `nums` sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, `nums` is possibly rotated at an unknown pivot index
 * `k` `(1 <= k < nums.length)` such that the resulting array is `[nums[k], nums[k+1], ...,
 * nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (0-indexed).
 *
 * For example, `[0,1,2,3,4,5,6,7]` might be rotated at pivot index `3` and become `[4,5,6,7,0,1,2]`.
 *
 * Given the array `nums` after the possible rotation and an integer `target`, return the index of `target`
 * if it is in `nums` or `-1` if it is not in `nums`.
 */

//endregion

//region Test cases

/**
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Input: nums = [1], target = 0
 * Output: -1
 */

/**
 * Steps:
 *
 *  1. Discover if the array is rotated.
 *   - Is the last element greater than the start element?
 *    - If yes, not rotated.
 *    - If no, find peak of array.
 *  2. Sort the array, knowing how it should be rotated.
 *  3. Search for the target.
 *
 *  1. Discover if array is rotated.
 *  2. Find peak.
 *  3. Search left, then right based on target.
 */

//endregion

//region Solution

private fun main() {
    search(nums = intArrayOf(4, 5, 6, 7, 0, 1, 2), target = 0)
    search(nums = intArrayOf(4, 5, 6, 7, 0, 1, 2), target = 5)
    search(nums = intArrayOf(1), target = 0)
    search(nums = intArrayOf(1, 3), target = 3)
}

private fun search(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.lastIndex

    while (start <= end) {
        val midpoint = start + (end - start) / 2

        if (nums[midpoint] == target) {
            return midpoint
        }

        if (nums[midpoint] <= nums[end]) {
            if (target > nums[midpoint] && target <= nums[end]) {
                start = midpoint + 1
            } else {
                end = midpoint - 1
            }
        } else {
            if (target < nums[midpoint] && target >= nums[start]) {
                end = midpoint - 1
            } else {
                start = midpoint + 1
            }
        }
    }

    return -1
}

//endregion