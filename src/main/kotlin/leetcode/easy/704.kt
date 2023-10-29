package leetcode.easy

//region Problem

/**
 * Given an array of integers (nums) which is sorted in ascending order and an integer (target), write
 * a function to search (target) in (nums). If (target exists, then return its index. Otherwise, return (-1).
 *
 * You must write an algorithm with (O(log n)) runtime complexity.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - Sorted array suggests Binary Search.
 *  - O(log n) time complexity suggest Binary Search.
 *
 * 1. Create two pointers; left and right:
 *     - Left: 0.
 *     - Right: (nums.lastIndex).
 * 2. While left is smaller than or equal to right:
 *    - Assign a midpoint value: (left + right) / 2
 *    - Check if the midpoint meets one of the following conditions:
 *      - Midpoint is greater than target:
 *         - Decrease right to midpoint - 1.
 *      - Midpoint is smaller than target:
 *         - Increase left to midpoint + 1.
 *      - Equal to target:
 *         - Return the midpoint.
 * 4. If we reach this point, then we are to return -1.
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    search(nums = intArrayOf(-1, 0, 3, 5, 9, 12), target = 9)

    // Output: -1
    search(nums = intArrayOf(-1, 0, 3, 5, 9, 12), target = 2)
}

private fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.lastIndex

    while (left <= right) {
        val midpoint = (left + right) / 2
        val num = nums[midpoint]

        when {
            num > target -> {
                right = midpoint - 1
            }
            num < target -> {
                left = midpoint + 1
            }
            else -> {
                return midpoint
            }
        }
    }

    return -1
}

//endregion
