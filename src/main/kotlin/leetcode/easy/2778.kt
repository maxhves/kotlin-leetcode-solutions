package leetcode.easy

//region Problem

/**
 * You are given a 1-indexed integer array (nums) of length (n).
 *
 * An element (nums[i]) of (nums) is called special if (i) divides (n), i.e. (n % i == 0).
 *
 * Return the sum of the squares of all special elements of (nums).
 */

//endregion

//region Steps to solve

/**
 * Steps:
 * 1. Initialize some variables:
 *     - (numsSize): Int, size of the array.
 *     - (squareSum): Int, keep track of the sums.
 * 2. Iterate over the (nums) array, for each iteration;
 *     - Check if (nums[i]) is special (meaning is it divisible by (n)).
 *     - If it is, add (nums[i] * nums[i) to (squareSum).
 * 3. Return (squareSum).
 */

//endregion

//region Solution

private fun main() {
    // Output: 21
    sumOfSquares(nums = intArrayOf(1, 2, 3, 4))
}

private fun sumOfSquares(nums: IntArray): Int {
    val numsSize = nums.size
    var squareSum = 0

    for (i in nums.indices) {
        val element = nums[i]

        if (numsSize % (i + 1) == 0) {
            squareSum += element * element
        }
    }

    return squareSum
}

//endregion
