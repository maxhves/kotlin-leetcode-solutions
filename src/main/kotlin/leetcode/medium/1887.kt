package leetcode.medium

//region Problem

/**
 * Given an integer array (nums), your goal is to make all the elements in (nums) equal. To complete one
 * operation, follow these steps:
 * - Find the largest value in (nums). Let its index be (i) 0-indexed. and its value be (largest). If there
 *   are multiple elements with the largest value, pick the smallest (i).
 * - Find the next largest value in (nums) strictly smaller than (largest). Let its value be (nextLargest).
 * - Reduce (nums[i]) to (nextLargest).
 *
 * Return the number of operations to make all elements in (nums) equal.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Sort the (nums) array.
 * - Initialize an Int (operationCount), set to 0.
 * - Initialize an Int (distinctNumberCount), set to 0.
 * - Iterate over the (nums) array from 1 to end.
 *   - If (currentNum) is not equal to the (previousNum).
 *     - Increase (distinctNumberCount) by 1.
 *   - Increase (operationCount) by the current (distinctNumberCount).
 * - Ultimately return (operationCount).
 */

//endregion

//region Solution

private fun main() {
    // Output 45
    reductionOperations(
        nums = intArrayOf(7, 9, 10, 8, 6, 4, 1, 5, 2, 3),
    )

    // Output: 3
    reductionOperations(
        nums = intArrayOf(5, 1, 3),
    )
}

private fun reductionOperations(nums: IntArray): Int {
    nums.sort()
    var operationCount = 0
    var distinctNumbersCount = 0

    for (i in 1 until nums.size) {
        if (nums[i] != nums[i - 1]) {
            distinctNumbersCount++
        }

        operationCount += distinctNumbersCount
    }

    return operationCount
}

//endregion
