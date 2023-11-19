package leetcode.medium

//region Problem

/**
 * The frequency of an element is the number of times it occurs in an array.
 *
 * You are given an integer array (nums) and an integer (k). In one operation you can choose an index of
 * (nums) and increment the element at that index by (1).
 *
 * Return the maximum possible frequency of an element after performing at most (k) operations.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - We should sort the array.
 * - Use a sliding window.
 *
 * Steps
 * - Initialize a HashMap<Int, Int> (windowNums) to contain our current window.
 * - Initialize an Int (maximumWindowSize) to track the greatest window size.
 * - Initialize an Int (left) the left pointer for our window; set to 0.
 * - Initialize an Int (right) the right pointer for our window; set to 0.
 * - Initialize an Int (currentWindowSum) set to (nums[0]).
 * - Initialize an Int (currentWindowSize) set to 1.
 * - Create a loop for while (left) is smaller than (right):
 *   - Calculate the (maxSum) we can create:
 *     - (nums[right]) * (currentWindowSize).
 *   - Calculate the (projectedSum):
 *     - (currentWindowSum) + (k).
 *   - If the (projectedSum) is smaller than or equal to (maxSum)
 *     - Set (maximumWindowSize) to the max of (currentWindowSize), (maximumWindowSize)
 *     - Increase (currentWindowSize) by 1.
 *     - Increase (right) by 1.
 *     - Add (nums[right]) to (windowNums).
 *     - Increase (currentWindowSum) by (nums[right]).
 *   - Else; the (projectedSum) is greater than (maxSum):
 *     - Increase (left) by 1.
 *     - Decrease (currentWindowSize) by 1.
 *     - Decrease (currentWindowSum) by (nums[left]).
 *     - Remove the element for key (left) from (windowNums).
 * - Ultimately return (maximumWindowSize).
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    maxFrequency(nums = intArrayOf(1, 2, 4), k = 5)
}

private fun maxFrequency(nums: IntArray, k: Int): Int {
    nums.sort()
    var greatestSeenWindowSize = 0
    var currentWindowSum: Long = 0

    var left = 0
    var right = 0

    while (right < nums.size) {
        currentWindowSum += nums[right]

        while (nums[right] * (right - left + 1) > currentWindowSum + k) {
            currentWindowSum -= nums[left]
            left++
        }

        greatestSeenWindowSize = maxOf(right - left + 1, greatestSeenWindowSize)
        right++
    }

    return greatestSeenWindowSize
}

//endregion
