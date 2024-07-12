package leetcode.easy

//region Problem

/**
 * You are given a 0-indexed integer array 'nums' of even length and there is also an empty array 'arr'
 * Alice and Bob decided to play a game where in every round Alice and Bob will do one move. The rules of
 * the game are as follows:
 *
 * - Every round, first Alice will remove the minimum element from 'nums', and then Bob does the same.
 * - Now, first Bob will append the removed element in the array 'arr', and then Alice does the same.
 * - The game continues until 'nums' becomes empty.
 *
 * Return the resulting array 'arr'.
 */

//endregion

//region Steps to solve

/**
 * - Sort the array.
 * - Iterate over the array in steps of 2.
 *   - Take the current element, add it to the answer array.
 *   - Take the previous element, add it to the answer array.
 * - Return the answer array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [3, 2, 5, 4]
    numberGame(nums = intArrayOf(5, 4, 2, 3))

    // Output: [2, 5]
    numberGame(nums = intArrayOf(5, 2))
}

private fun numberGame(nums: IntArray): IntArray {
    val rearrangedNumbers = mutableListOf<Int>()

    nums.sort()

    for (i in 1..nums.lastIndex step 2) {
        val previousNum = nums[i - 1]
        val currentNum = nums[i]

        rearrangedNumbers.add(currentNum)
        rearrangedNumbers.add(previousNum)
    }

    return rearrangedNumbers.toIntArray()
}

//endregion
