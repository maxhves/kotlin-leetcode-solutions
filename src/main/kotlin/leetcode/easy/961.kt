package leetcode.easy

//region Problem

/**
 * You are given an integer array (nums) with the following properties:
 *  - (nums.length == 2 * n).
 *  - (nums) contains (n + 1) unique elements.
 *  - Exactly one element of (nums) is repeated (n) times.
 *
 *  Return the element that is repeated (n) times.
 */

//endregion

//region Steps to solve

/**
 * Consideration:
 *  - (n) equal to half of the array size.
 *
 *  1. Create a frequency map.
 *  2. Return the item with a value that is equal to (n).
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    repeatedNTimes(nums = intArrayOf(1, 2, 3, 3))

    // Output: 2
    repeatedNTimes(nums = intArrayOf(2, 1, 2, 4, 3, 2))

    // Output: 5
    repeatedNTimes(nums = intArrayOf(5, 1, 5, 2, 5, 3, 5, 4))
}

private fun repeatedNTimes(nums: IntArray): Int {
    val occurrences = HashMap<Int, Int>()

    for (num in nums) {
        occurrences[num] = occurrences.getOrDefault(num, 0) + 1

        if (occurrences[num] == nums.size / 2) {
            return num
        }
    }

    return 0
}

//endregion
