package leetcode.medium

import java.util.PriorityQueue
import java.util.SortedSet
import kotlin.math.max

//region Problem

/**
 * Given (n) (points) on a 2D plane where (points[i] = [x i, y i], return the widest vertical area
 * between two points such that no points are inside the area.
 *
 * A vertical area is an area of fixed-width extending indefinitely along the y-axis (i.e., infinite
 * height). The widest vertical area is the one with the maximum width.
 *
 * Note that points on fht edge of a vertical area are not considered included in the area.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Iterate over the (points) array and add each (x) axis value into a list.
 * - Sort the (xPoints) array.
 * - Iterate over (xPoints) and find the maximum difference between the current and next ponts.
 * - Return this maximum difference.
 */

//endregion

//region Solution

private fun main() {
    // Output: 1
    maxWidthOfVerticalArea(
        points = arrayOf(
            intArrayOf(8, 7),
            intArrayOf(9, 9),
            intArrayOf(7, 4),
            intArrayOf(9, 7),
        ),
    )

    // Output: 3
    maxWidthOfVerticalArea(
        points = arrayOf(
            intArrayOf(3, 1),
            intArrayOf(9, 0),
            intArrayOf(1, 0),
            intArrayOf(1, 4),
            intArrayOf(5, 3),
            intArrayOf(8, 8),
        ),
    )
}

private fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
    val xPoints = PriorityQueue<Int>()

    for (point in points) {
        xPoints.add(point[0])
    }

    var maxDifference = 0

    while (xPoints.size > 1) {
        val currentPoint = xPoints.poll()
        val nextPoint = xPoints.peek()

        maxDifference = max(maxDifference, nextPoint - currentPoint)
    }

    return maxDifference
}

//endregion
