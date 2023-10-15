package leetcode.medium

//region Problem

/**
 * Given an integer array `nums` and an integer `k`, return the `k` most frequent elements. You may
 * return the answer in any order.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the array of numbers.
 * 2. Place each item into a map:
 *    - Key: number.
 *    - Value: frequency we have seen the number.
 * 3. Sort the map by frequency.
 * 4. Return the map by taking k items.
 */

//endregion

//region Solution

private fun main() {
    // Output: [0]
    topKFrequent(nums = intArrayOf(3, 0, 1, 0), k = 1)

    // Output: [1,2]
    topKFrequent(nums = intArrayOf(1, 1, 1, 2, 2, 3), k = 2)

    // Output: [1]
    topKFrequent(nums = intArrayOf(1), k = 1)
}

private fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val frequencyMap = mutableMapOf<Int, Int>()

    nums.forEach { num ->
        if (frequencyMap.contains(num)) {
            frequencyMap[num] = frequencyMap[num]!! + 1
        } else {
            frequencyMap[num] = 1
        }
    }

    return frequencyMap.entries.sortedByDescending { it.value }.map { it.key }.take(k).toIntArray()
}

//endregion