package leetcode.medium

import kotlin.math.abs

//region Problem

/**
 * You are given four integers (sx), (sy), (fx), (fy), and a non-negative integer (t).
 *
 * In an infinite 2D grid, you start at the cell (sx sy). Each second, you must move to any of its adjacent
 * cells.
 *
 * Return (true) if you can reach cell (fx, fy) after exactly (t) seconds, or (false) otherwise.
 *
 * A cell's adjacent cells are the 8 cells around it that share at least one corner with it. You can visit
 * the same cell several times.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - To move to a certain coordinate we can in a basic way move (i) spaces horizontally, and (j)
 *    spaces vertically.
 *  - We can furthermore optimize the vertical path by moving diagonally.
 *  - Let's calculate how many spaces we need to move horizontally and vertically:
 *     - (2, 4) to (7, 7)
 *     - From (x, 2) to (x, 7) is 5 spaces.
 *     - From (y, 4) to (y, 7) is 3.
 *     - We can however, diagonally move to shorten the path:
 *        - Should use Chebyshev distance.
 *        - (max(y2 - y1, x2 - x1)).
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    isReachableAtTime(
        sx = 2,
        sy = 4,
        fx = 7,
        fy = 7,
        t = 6
    )

    // Output: false
    isReachableAtTime(
        sx = 3,
        sy = 1,
        fx = 7,
        fy = 3,
        t = 3
    )

    // Output: false
    isReachableAtTime(
        sx = 1,
        sy = 2,
        fx = 1,
        fy = 2,
        t = 1
    )
}

private fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
    if (sx == fx && sy == fy) {
        return t != 1
    }

    val chebyshevDistance = maxOf(abs(fy - sy), abs(fx - sx))
    return chebyshevDistance <= t
}

//endregion
