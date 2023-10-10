package leetcode.easy

//region Problem

/**
 * The product difference between two pairs `(a, b)` and `(c, d)` is defined as `(a * b) - (c * d)`.
 *  - For example, the product difference between `(5, 6)` and `(2, 7)` is `(5 * 6) - (2 * 7) = 16`.
 *
 *  Given an integer array `nums`, choose four distinct indices `w`, `x`, `y` and `z` such that the
 *  product difference between pairs `(nums[w], nums[x])` and `(nums[y], nums[z])` is maximized.
 *
 *  Return the maximum such product difference.
 */

//endregion

//region Test cases

/**
 * Input: nums = [5,6,2,7,4]
 * Output: 34
 *
 * Input: nums = [4,2,5,9,7,4,8]
 * Output: 64
 */

//endregion

//region Steps to solve

/**
 * 1. Sort the array.
 * 2. Select the first two and last two indices.
 * 3. Return the product.
 */

//endregion

//region Solution

private fun main() {
    println(maxProductDifference(nums = intArrayOf(5, 6, 2, 7, 4)))
}

private fun maxProductDifference(nums: IntArray): Int {
    var largest = Int.MIN_VALUE
    var secondLargest = Int.MIN_VALUE
    var smallest = Int.MAX_VALUE
    var secondSmallest = Int.MAX_VALUE

    for (num in nums) {
        if (num > largest) {
            secondLargest = largest
            largest = num
        } else if (num > secondLargest) {
            secondLargest = num
        }

        if (num < smallest) {
            secondSmallest = smallest
            smallest = num
        } else if (num < secondSmallest) {
            secondSmallest = num
        }
    }

    return (largest * secondLargest) - (smallest * secondSmallest)
}

//endregion