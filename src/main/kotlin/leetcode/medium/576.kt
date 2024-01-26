package leetcode.medium

//region Problem

/**
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn].
 * You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the
 * grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
 *
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the
 * ball out of the grid boundary. Since the answer can be very large, return it in modulo 10^9 + 7.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - So this should be a DFS recursive solution, whereby we have some choices:
 *   - Increase the column by 1.
 *   - OR
 *   - Increase the row by 1.
 *   - OR
 *   - Decrease the column by 1.
 *   - OR
 *   - Decrease the row by 1.
 * - We need to check if it is possible to move the ball out of the boundary before we reach the
 *   maximum number of allowed moves.
 */

//endregion

//region Solution

private fun main() {
    // Output: 6
    findPaths(
        m = 2,
        n = 2,
        maxMove = 2,
        startRow = 0,
        startColumn = 0,
    )

    // Output: ?
    findPaths(
        m = 8,
        n = 50,
        maxMove = 23,
        startRow = 5,
        startColumn = 26,
    )
}

// m rows
// n columns

private fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
    val modulo = 1_000_000_007
    val memo = Array(m) { Array(n) { IntArray(maxMove + 1) { -1 } } }

    fun dfs(row: Int, column: Int, movesLeft: Int): Int {
        // Check if out of bounds; if yes, and moves are left, it's a valid path
        if (row < 0 || row >= m || column < 0 || column >= n) {
            return if (movesLeft >= 0) 1 else 0
        }

        // If no moves are left, return 0 as it's not a valid path
        if (movesLeft == 0) {
            return 0
        }

        // Use memoization to save previously calculated paths
        if (memo[row][column][movesLeft] != -1) {
            return memo[row][column][movesLeft]
        }

        var paths = 0

        // Calculate paths in all four directions
        paths = (paths + dfs(row + 1, column, movesLeft - 1)) % modulo
        paths = (paths + dfs(row - 1, column, movesLeft - 1)) % modulo
        paths = (paths + dfs(row, column + 1, movesLeft - 1)) % modulo
        paths = (paths + dfs(row, column - 1, movesLeft - 1)) % modulo

        memo[row][column][movesLeft] = paths
        return paths
    }

    return dfs(startRow, startColumn, maxMove)
}

//endregion
