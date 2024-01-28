package leetcode.hard

//region Problem

/**
 * Given a matrix and a target, return the number of non-empty sub-matrices that sum to target.
 *
 * A sub-matrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <=x2 and y1 <= y <= y2.
 *
 * Two sub-matrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they ave some coordinate
 * that is different: for example, if x1 != x1'.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    numSubMatrixSumTarget(
        matrix = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 1, 0),
        ),
        target = 0,
    )
}

private fun numSubMatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
    val h = matrix.size
    val w = matrix[0].size
    val dp = Array(h){ r -> IntArray(w){ matrix[r][it]}}

    for (r in 1 until h) {
        dp[r][0] += dp[r - 1][0]
    }

    for (c in 1 until w) {
        dp[0][c] += dp[0][c - 1]
    }

    for (r in 1 until h) {
        for (c in 1 until w) {
            dp[r][c] += dp[r - 1][c] + dp[r][c - 1] - dp[r - 1][c - 1]
        }
    }

    var result = 0

    for (r in 0 until h) {
        for (c in 0 until w) {
            for (i in 1 .. r + 1) {
                for (j in 1 .. c + 1) {
                    var curr = dp[r][c]
                    if (r >= i) curr -= dp[r - i][c]
                    if (c >= j) curr -= dp[r][c - j]
                    if (r >= i && c >= j) curr += dp[r - i][c - j]
                    if (curr == target) result += 1
                }
            }
        }
    }

    return result
}

//endregion
