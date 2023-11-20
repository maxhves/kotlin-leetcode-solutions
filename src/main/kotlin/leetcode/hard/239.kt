package leetcode.hard

import kotlin.math.max

//region Problem

/**
 * You are given an array of integers (nums), there is a sliding window of size (k) which is moving from
 * the very left of the array to the very right. You can only see (k) numbers in the window. Each time the
 * sliding window moves right by one position.
 *
 * Return the max sliding window.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialize a HashMap<Int, Int> (currentWindow).
 * - Initialize an ArrayList<Int> (maxElementsInWindows).
 * - Initialize an Int (left), set to 0.
 * - Initialize an Int (right), set to 0.
 * - Initialize an Int (currentMaxElementForWindow) set to 0.
 * - Create a loop while (right) is smaller than the last index of (nums):
 *   - Add (nums[right]) to (currentWindow).
 *   - Set (maxCurrentMaxElementForWindow) to the max of (maxCurrentMaxElementForWindow) and (nums[right]).
 *   - If (currentWindow)'s size is equal to k:
 *     - Add (currentMaxElementForWindow) to (maxElementsInWindows).
 *     - Increase (left) by 1.
 *     - Remove (left) from (currentWindow).
 *   - Else:
 *     - Increase (right) by 1.
 * - Ultimately return (maxElementsInWindows).
 */

//endregion

//region Solution

private fun main() {
    // Output: [1, -1]
    maxSlidingWindow(
        nums = intArrayOf(1, -1),
        k = 1,
    )

    // Output: [3, 3, 5, 5, 6, 7]
    maxSlidingWindow(
        nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7),
        k = 3,
    )

    // Output: [1]
    maxSlidingWindow(
        nums = intArrayOf(1),
        k = 1,
    )
}

private fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty() || k <= 0) return intArrayOf()
    if (k == 1) return nums

    val deque = ArrayDeque<Int>()
    val result = IntArray(nums.size - k + 1)
    var resultIndex = 0

    for (i in nums.indices) {
        while (!deque.isEmpty() && deque.first() < i - k + 1) {
            deque.removeFirst()
        }

        while (!deque.isEmpty() && nums[i] > nums[deque.last()]) {
            deque.removeLast()
        }
        deque.addLast(i)

        if (i >= k - 1) {
            result[resultIndex++] = nums[deque.first()]
        }
    }

    return result
}

//endregion
