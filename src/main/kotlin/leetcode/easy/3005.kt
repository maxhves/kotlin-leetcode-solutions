package leetcode.easy

import kotlin.math.max

//region Problem

/**
 * You are given an array nums consisting of positive integers.
 *
 * Return the total frequencies of elements in nums such that those elements all have the maximum
 * frequencies.
 *
 * The frequency of an element is the number of occurences of that element in the array.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Create a frequency Hash Map, containing each elements frequency.
 * - Track the highest frequency count.
 * - Return a count of elements in the Hash Map with the highest frequency.
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    maxFrequencyElements(nums = intArrayOf(1, 2, 2, 3, 1, 4))
}

private fun maxFrequencyElements(nums: IntArray): Int {
    val frequencyMap = HashMap<Int, Int>()
    var maxFrequency = 0

    for (num in nums) {
        val currentFrequency = frequencyMap.getOrDefault(num, 0) + 1
        frequencyMap[num] = currentFrequency

        maxFrequency = maxOf(maxFrequency, currentFrequency)
    }

    var result = 0
    for (value in frequencyMap.values) {
        if (value == maxFrequency) {
            result += value
        }
    }

    return result
}

//endregion
