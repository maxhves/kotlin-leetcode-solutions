package leetcode.medium

//region Problem

/**
 * You are given an array (points) where (points[i] = [xi, yi]) is the coordinates of the (ith) point
 * on a 2D plane. Multiple points can have the same coordinates.
 *
 * You are also given an array (queries) where (queries[j] = [xj, yj, rj]) describes a circle centered
 * at (xj, yj) with a radius of (rj).
 *
 * For each query (queries[j]), compute the number of points inside the (jth) circle. Points on the border
 * of the circle are considered inside.
 *
 * Return an array (answer), where (answer[j]) is the answer to the (jth) query.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the array of queries, which are essential circles.
 * 2. For each circle, calculate it's capturing area.
 * 3. Iterate over the list of points:
 *    - Count how many of these points are inside the capturing area.
 *    - Store in an answer array of size (queries).
 * 4. Finally return the array of answers.
 */

//endregion

//region Solution

private fun main() {
    // Output: [3, 2, 2]
    countPoints(
        points = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(3, 3),
            intArrayOf(5, 3),
            intArrayOf(2, 2),
        ),
        queries = arrayOf(
            intArrayOf(2, 3, 1),
            intArrayOf(4, 3, 1),
            intArrayOf(1, 1, 2),
        ),
    )

    // Output: [2, 3, 2, 4]
    countPoints(
        points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 3),
            intArrayOf(4, 4),
            intArrayOf(5, 5),
        ),
        queries = arrayOf(
            intArrayOf(1, 2, 2),
            intArrayOf(2, 2, 2),
            intArrayOf(4, 3, 2),
            intArrayOf(4, 3, 3),
        ),
    )
}

private fun countPoints(points: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val answers = IntArray(queries.size)

    fun pointInQuery(
        point: Pair<Int, Int>,
        query: IntArray
    ): Boolean {
        val x = point.first - query[0]
        val y = point.second - query[1]
        return (x * x + y * y) <= query[2] * query[2]
    }

    for (i in queries.indices) {
        for (j in points.indices) {
            val point = points[j][0] to points[j][1]

            if (pointInQuery(
                    point = point,
                    query = queries[i]
                )
            ) {
                answers[i] = answers[i] + 1
            }
        }
    }

    return answers
}

//endregion
