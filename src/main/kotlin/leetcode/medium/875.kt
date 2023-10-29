package leetcode.medium

import kotlin.math.abs
import kotlin.math.ceil

//region Problem

/**
 * Koko loves to eat bananas. There are (n) piles of bananas, the (ith) pile has (piles[i]) bananas. The
 * guards have gone and will come back in (h) hours.
 *
 * Koko can decide her bananas-per-hour eating speed of (k). Each hour, she chooses some pile of bananas and
 * eats (k) bananas from that pile. If that pile has less than (k) bananas, she eats all of them instead and
 * will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer (k) such that she can eat all the bananas within (h) hours.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - Each element in the (piles) array contains the number of bananas in the pile.
 *  - (h) represents the number of hours the guards are gone.
 *  - Koko decides how many bananas she eats per hour, a speed of (k).
 *  - Each hour we are to pick a pile of bananas and eat (k) bananas.
 *  - If the pile is smaller than (k), we will stop after eating that pile.
 *  - We are to return how many bananas (k) Koko can eat, so that all bananas are eaten within (h) hours.
 *  - We can use binary search to choose a number between:
 *     - K = 1.
 *     - K = piles.max.
 *
 * 1. Initialize two pointers; left and right.
 *     - Left: 0.
 *     - Right: piles.max.
 * 2. Create a loop; for while left is smaller than or equal to right.
 * 3. Initialize a midpoint; (left + right) / 2.
 * 4. For each iteration:
 *     - Create a loop, for each pile in piles.
 *     - For each iteration:
 *       - Divide (pile[i]) by the midpoint.
 *       - Add the result to a count.
 *       - If the count becomes greater than (h):
 *          - We must decrease right to the midpoint - 1.
 *       - If the count becomes smaller than (h):
 *          - We must increase left to the midpoint + 1.
 *       - If the count adds up to (h); return midpoint.
 * 5. If we have reached this point then we are to return -1.
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    minEatingSpeed(
        piles = intArrayOf(3, 6, 7, 11),
        h = 8
    )

    // Output: 30
    minEatingSpeed(
        piles = intArrayOf(30, 11, 23, 4, 20),
        h = 5
    )

    // Output: 23
    minEatingSpeed(
        piles = intArrayOf(30, 11, 23, 4, 20),
        h = 6
    )
}

private fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var left = 1
    var right = piles.max()
    var answer = right

    while (left < right) {
        var hoursCount = 0
        val midpoint = (left + right) / 2

        for (pile in piles) {
            hoursCount += ceil(pile.toDouble() / midpoint).toInt()
        }

        when {
            hoursCount <= h -> {
                answer = minOf(answer, midpoint)
                right = midpoint
            }
            else -> {
                left = midpoint + 1
            }
        }
    }

    return answer
}

//endregion
