package leetcode.easy

import kotlin.math.abs

//region Problem

/**
 * On a 2D plane, there are (n) points with integer coordinates (points[i] = [x i, y i]). Return the
 * minimum time in seconds to visit all the points in the order given by (points).
 *
 * You can move according to these rules:
 * - In (1) second you can either:
 *   - Move horizontally by one unit, or
 *   - Move diagonally (sqrt(2)) units (in other words, move one unit vertically then one unit horizontally
 *     in (1) second.
 * - You have to visit the points in the same order as they appear in the array.
 * - You are allowed ot pass through points that appear later in the order, but these do not count as
 *   visits.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - Can we simply return the Chebyshev distance between each point?
 */

//endregion

//region Solution

private fun main() {
    // Output: 7
    minTimeToVisitAllPoints(
        points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(3, 4),
            intArrayOf(-1, 0),
        )
    )
}

private fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    var totalDistance = 0

    for (i in 0 until points.lastIndex) {
        val currentPoint = points[i]
        val nextPoint = points[i + 1]

        val chebyshevDistance = maxOf(
            abs(nextPoint[1] - currentPoint[1]),
            abs(nextPoint[0] - currentPoint[0]),
        )
        totalDistance += chebyshevDistance
    }

    return totalDistance
}

//endregion
