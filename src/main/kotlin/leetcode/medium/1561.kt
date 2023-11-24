package leetcode.medium

//region Problem

/**
 * There are (3n) piles of coins of varying size, you and your friends will take piles of coins as follows:
 * - In each step, you will choose any (3) piles of coins (not necessarily consecutive).
 * - Of your choice, Alice will pick the pile with the maximum number of coins.
 * - You will pick the next pile with the maximum number of coins.
 * - Your friend Bob will pick the last pile.
 * - Repeat until there are no more piles of coins.
 *
 * Given an array of integers (piles) where (piles[i]) is the number of coins in the (ith) pile.
 *
 * Return the maximum number of coins that you can have.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - We always need to pick:
 *   - One larger element.
 *   - One element directly smaller (or equal to) the above.
 *   - One element that is as small as possible.
 * - This could be two elements from the end, and one from the beginning, after sorting the array.
 * - Could we use two pointers, after sorting?
 */

//endregion

//region Solution

private fun main() {
    // Output: 9
    maxCoins(piles = intArrayOf(2, 4, 1, 2, 7, 8))
}

private fun maxCoins(piles: IntArray): Int {
    piles.sort()

    var coinsCollected = 0

    var left = 0
    var right = piles.lastIndex

    while (left < (right - 1)) {
        coinsCollected += piles[right - 1]

        left++
        right -= 2
    }

    return coinsCollected
}

//endregion
