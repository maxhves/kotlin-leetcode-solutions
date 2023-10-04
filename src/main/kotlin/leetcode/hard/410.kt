package leetcode.hard

//region Problem

/**
 * Given an integer array `nums` and an integer `k`, split `nums` into `k` non-empty subarrays such
 * that the largest sum of any subarray is minimized.
 *
 * Return the minimized largest sum of the split.
 */

//endregion

//region Test cases

/**
 * Input: nums = [7,2,5,10,8], k = 2
 * Output: 18
 */

//endregion

//region Solution

private fun main() {
    splitArray(nums = intArrayOf(7, 2, 5, 10, 8), k = 2)
}

private fun splitArray(nums: IntArray, k: Int): Int {
    var start = 0
    var end = 0

    // Get the maximum value and the sum of all values
    for (i in nums.indices) {
        start = Math.max(start, nums[i])
        end += nums[i]
    }

    // Perform a binary search
    while (start < end) {
        // Try for the middle as potential answer
        val midpoint = start + (end - start) / 2

        // Calculate how many pieces you can divide this in with this max sum
        var sum = 0
        var pieces = 1

        for (number in nums) {
            if ((sum + number) > midpoint) {
                // You cannot add this to the subarray
                sum = number
                pieces++
            } else {
                sum += number
            }
        }

        if (pieces > k) {
            start = midpoint + 1
        } else {
            end = midpoint
        }
    }

    return end
}

//endregion