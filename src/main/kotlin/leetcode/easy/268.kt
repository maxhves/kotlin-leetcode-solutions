package leetcode.easy

//region Problem

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in
 * the range that is missing from the array.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We can initialise an integer array that is the size of the nums array.
 * - We can then iterate over the nums array, and when we see a number set the correlating position to
 *   1.
 * - We can then iterate over our result array and return the item that is equal to 0.
 * - Perhaps we can do a binary search for the missing number.
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    missingNumber(nums = intArrayOf(3, 0, 1))

    // Output: 2
    missingNumber(nums = intArrayOf(0, 1))
}

private fun missingNumber(nums: IntArray): Int {
    val trackedNumbers = IntArray(nums.size + 1)

    for (num in nums) {
        trackedNumbers[num] = 1
    }

    return trackedNumbers.indexOf(0)
}

//endregion
