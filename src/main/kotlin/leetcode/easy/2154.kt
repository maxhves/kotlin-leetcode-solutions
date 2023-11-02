package leetcode.easy

//region Problem

/**
 * You are given an array of integers (nums). You are also given an integer (original) which is the first
 * number that needs to be searched for in (nums).
 *
 * You then do the following steps:
 *  1. If (original) is found in (nums), multiply it by two (i.e., set (original = 2 * original).
 *  2. Otherwise, stop the process.
 *  3. Repeat theis process with the new number as long as you keep finding the number.
 *
 * Return the final value of (original).
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We need to essentially:
 *     - Find (original).
 *     - Double (original).
 *     - Repeat until we can't anymore; return (original).
 *
 * 1. Sort the (nums) array.
 * 2. Iterate over the (nums) array.
 * 3. For each element:
 *    - If it is equal to (original):
 *       - Multiple original by 2.
 *       - Continue forwards.
 * 4. Ultimately, return (original).
 */

//endregion

//region Solution

private fun main() {
    // Output: 24
    findFinalValue(nums = intArrayOf(5, 3, 6, 1, 12), original = 3)

    // Output: 4
    findFinalValue(nums = intArrayOf(2, 7, 9), original = 4)
}

private fun findFinalValue(nums: IntArray, original: Int): Int {
    nums.sort()
    var currentDouble = original

    for (i in nums) {
        if (i == currentDouble) {
            currentDouble *= 2
        }
    }

    return currentDouble
}

//endregion
