package leetcode.medium

import java.util.Stack
import kotlin.math.min

//region Problem

/**
 * Alice has (n) balloons arranged on a rope. You are given a 0-indexed string (colors) where
 * (colors[i]) is the color of the (i th) balloon).
 *
 * Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color,
 * so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are
 * given a 0-indexed integer array (neededTime) where (neededTime[i]) is the time (in seconds) that Bob
 * needs to remove the (i th) balloon from the rope.
 *
 * Return the minimum time Bob needs to make the rope colorful.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We could iterate over the list of colors and keep track of the current and previous color.
 * - If we find a color in current that is equal to previous, then one of these two must be removed.
 * - We then make a comparison between the neededTime for the current and previous elements.
 *   - Subsequently we remove the one that takes the least needed time.
 *
 * - In some instances there are more than two same colored balloons in a row. So we need to account
 *   for the fact that the first of the three has been removed, and now the second of them need to be
 *   removed, and so on, until we have only one of a single color.
 * - Maybe we can simply store the previous color and index.
 */

//endregion

//region Solution

private fun main() {
    // Output: 26
    minCost(
        colors = "aaabbbabbbb",
        neededTime = intArrayOf(3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1),
    )

    // Output: 3
    minCost(
        colors = "abaac",
        neededTime = intArrayOf(1, 2, 3, 4, 5),
    )
}

private fun minCost(colors: String, neededTime: IntArray): Int {
    var minimumTimeNeeded = 0
    var previousColor = colors[0]
    var previousIndex = 0

    for (i in 1..colors.lastIndex) {
        val currentColor = colors[i]

        if (previousColor == currentColor) {
            val previousNeededTime = neededTime[previousIndex]
            val currentNeededTime = neededTime[i]

            if (previousNeededTime < currentNeededTime) {
                minimumTimeNeeded += previousNeededTime

                previousColor = currentColor
                previousIndex = i
            } else {
                minimumTimeNeeded += currentNeededTime
            }
        } else {
            previousColor = currentColor
            previousIndex = i
        }
    }

    return minimumTimeNeeded
}

//endregion
