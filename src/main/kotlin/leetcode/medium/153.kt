package leetcode.medium

//region Problem

/**
 *  Suppose an array of length (n) sorted in ascending order is rotated between (1) and (n) times. For
 *  example, the array (nums = [0, 1, 2, 4, 5, 6, 7]) might become:
 *   - ([4, 5, 6, 7, 0, 1, 2]) if it was rotated (4) times.
 *   - ([0, 1, 2, 4, 5, 6, 7]) if it was rotated (7) times.
 *
 * Notice that rotating an array ([a[0], a[1], a[2], ..., a[n-1]]) 1 time results in the array
 * ([a[n-1], a[0], a[1], a[2], ..., a[n-2]]).
 *
 * Given the sorted rotated array (nums) of unique elements, return the minimum element of this array.
 *
 * You must write the algorithm in (O(log n)) time.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - Sorted ascending array suggests: Binary Search.
 *  - O(log n) time complexity suggests: Binary Search.
 *  - We need to find that midpoint in which the next number is smaller than the current number.
 *
 * 1. Initialize two pointers; left and right:
 *     - Left: 0
 *     - Right: (nums.lastIndex)
 * 2. Create a for loop, while left is smaller than right:
 *     - Create the midpoint; (left + right) / 2.
 *     - Check if the element at midpoint is greater than the end of the array (right).
 *        - If the element is greater than the end:
 *           - Our answer must be in the second half of the array.
 *           - Move the left pointer to midpoint + 1.
 *        - Else; the answer must be in the first half of the array.
 *           - Move the right pointer to the midpoint.
 *           - We don't move to midpoint - 1 because the midpoint could still be our answer.
 * 3. At the end we can simply return the left pointer because it will be smaller than the right
 *    meaning that if it wasn't found in the right pointer, it's the left.
 */

//endregion

//region Solution

private fun main() {
    // Output: 1
    findMin(nums = intArrayOf(3, 4, 5, 1, 2))

    // Output: 0
    findMin(nums = intArrayOf(4, 5, 6, 7, 0, 1, 2))

    // Output: 11
    findMin(nums = intArrayOf(11, 13, 15, 17))
}

private fun findMin(nums: IntArray): Int {
    var left = 0
    var right = nums.lastIndex

    while (left < right) {
        val midpoint = (left + right) / 2
        val element = nums[midpoint]

        // If the current number at the midpoint is bigger than the
        // element at the right pointer (the end index).
        if (element > nums[right]) {
            // Search in the second half of the array.
            left = midpoint + 1
        } else {
            // Otherwise search in the first half.
            right = midpoint
        }
    }

    return nums[left]
}

//endregion
