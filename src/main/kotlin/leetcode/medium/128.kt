package leetcode.medium

import java.util.*
import kotlin.collections.HashMap

//region Problem

/**
 * Given an unsorted array of integers (nums), return the length of the longest consecutive elements
 * sequence.
 *
 * You must write an algorithm that runs in (O(n)) time.
 */

//endregion

//region Steps to solve

/**
 * 1. Sort the array in ascending order.
 * 2. Iterate over the array:
 *    - Keep track of the previous number
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    longestConsecutive(nums = intArrayOf(100, 4, 200, 1, 3, 2))

    // Output: 9
    longestConsecutive(nums = intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1))
}

private fun longestConsecutive(nums: IntArray): Int {
    val numsHashSet = nums.toHashSet()
    var longestSequence = 0

    for (num in nums) {
        if (num - 1 !in numsHashSet) {
            var sequenceThisIteration = 0

            while (numsHashSet.contains(num + sequenceThisIteration)) {
                sequenceThisIteration++
            }

            longestSequence = maxOf(longestSequence, sequenceThisIteration)
        }
    }

    return longestSequence
}

//endregion