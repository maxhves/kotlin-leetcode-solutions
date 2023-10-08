package leetcode.easy

//region Problem

/**
 * You are given an integer array `nums` (0-indexed). In one operation, you can choose an element of the array
 * and increment it by `1`.
 *   - For example, if `nums = [1,2,3]`, you can choose to increment `nums[1]` to make `nums = [1,3,3]`.
 *
 * Return the minimum number of operations needed to make `nums` strictly increasing.
 */

//endregion

//region Test cases

/**
 * Input: nums = [1,1,1]
 * Output: 3
 *
 * Input: nums = [1,5,2,4,1]
 * Output: 14
 *
 * Input: nums = [8]
 * Output: 0
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the array.
 * 2. Check if the next element is larger than the current.
 *    - Be mindful that the next element is null
 *    - If larger, no action
 *    - If smaller than or equal to, increase this element to current + 1
 *    - Move on
 * 3. Count the sum of increases.
 * 4. Return the result.
 */

//endregion

//region Solution

private fun main() {
    minOperations(nums = intArrayOf(1, 5, 2, 4, 1))
}

private fun minOperations(nums: IntArray): Int {
    var result = 0

    for (i in nums.indices) {
        if (i + 1 <= nums.lastIndex) {
            val nextNumber = nums[i + 1]
            val current = nums[i]

            if (nextNumber <= current) {
                result += (current - nextNumber) + 1
                nums[i + 1] = current + 1
            }
        }
    }

    return result
}

//endregion