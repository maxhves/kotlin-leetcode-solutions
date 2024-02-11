package leetcode.hard

//region Problem

/**
 * You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents
 * the number of cherries that you can collect from the (i, j) cell.
 *
 * You have two robots that can collect cherries for you:
 * - Robot #1 is located in the top-left corner (0, 0), and
 * - Robot #2 is located in the top-right corner (0, cols - 1).
 *
 * Return the maximum number of cherries collected using both robots by following the rules below:
 * - From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
 * - When any robot passes through a cell, it picks up all cherries, and the cell becomes an empty cell.
 * - When both robots stay in the same cell, only one takes the cherries.
 * - Both robots cannot move outside the gird at any moment.
 * - Both robots should reach the bottom row in grid.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We can either move
 *   - Directly down
 *   - Diagonally down left
 *   - Diagonally down right
 * - We never want to let the robots cross into each others paths.
 * - We don't need to keep track of individual rows, since they always move together in the same row.
 * - We just need to keep track of the column.
 */

//endregion

//region Solution

private fun main() {
    // Output: 24
    cherryPickup(
        grid = arrayOf(
            intArrayOf(3, 1, 1),
            intArrayOf(2, 5, 1),
            intArrayOf(1, 5, 5),
            intArrayOf(2, 1, 1),
        )
    )
}

private fun cherryPickup(grid: Array<IntArray>): Int {
    data class CacheKey(
        val row: Int,
        val robot1Column: Int,
        val robot2Column: Int,
    )
    val cache = HashMap<CacheKey, Int>()

    fun dfs(row: Int, robot1Column: Int, robot2Column: Int): Int {
        val key = CacheKey(row, robot1Column, robot2Column)

        if (cache.containsKey(key)) {
            return cache.getOrDefault(key, 0)
        }

        if (
            robot1Column == robot2Column ||
            minOf(robot1Column, robot2Column) < 0 ||
            maxOf(robot1Column, robot2Column) > grid[0].lastIndex
        ) {
            return 0
        }

        if (row == grid.lastIndex) {
            return grid[row][robot1Column] + grid[row][robot2Column]
        }

        var result = 0

        for (column1Delta in -1..1) {
            for (column2Delta in -1..1) {
                result = maxOf(
                    result,
                    dfs(row + 1, robot1Column + column1Delta, robot2Column + column2Delta)
                )
            }
        }

        cache[key] = result + (grid[row][robot1Column] + grid[row][robot2Column])

        return cache.getOrDefault(key, 0)
    }

    return dfs(0, 0, grid[0].lastIndex)
}

//endregion
