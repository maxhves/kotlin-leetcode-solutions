package leetcode.easy

//region Problem

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than n / 2 times. You may assume that the
 * majority element always exists in the array.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Keep track of element frequencies with a HashMap.
 * - When we find an element that appears ceiling(n / 2) times, we simply return this element.
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    majorityElement(nums = intArrayOf(3, 2, 3))
}

private fun majorityElement(nums: IntArray): Int {
    val frequencies = HashMap<Int, Int>(nums.size)
    val majority = nums.size / 2

    for (num in nums) {
        val frequency = frequencies.getOrDefault(num, 0) + 1

        if (frequency > majority) {
            return num
        }

        frequencies[num] = frequency
    }

    return -1
}

//endregion
