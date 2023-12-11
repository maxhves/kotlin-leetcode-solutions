package leetcode.easy

//region Problem

/**
 * Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that
 * occurs more than 25% of the time, return that integer.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialize an Int (quarterFrequency) set to (arr.size / 4).
 * - Initialize a HashMap (frequencyMap).
 * - Iterate over (arr):
 *   - Increase the frequency for the given (num).
 *   - Check if the frequency is now larger than (quarterFrequency).
 *     - If it is, return this (num).
 * - If no result is found, just return (-1).
 */

//endregion

//region Solution

private fun main() {
    // Output: 6
    findSpecialInteger(arr = intArrayOf(1, 2, 2, 6, 6, 6, 6, 7, 10))
}

private fun findSpecialInteger(arr: IntArray): Int {
    val quarterFrequency = arr.size / 4
    val frequencyMap = HashMap<Int, Int>()

    for (num in arr) {
        frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        if (frequencyMap.getOrDefault(num, 0) > quarterFrequency) {
            return num
        }
    }

    return -1
}

//endregion
