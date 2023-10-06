package leetcode.easy

//region Problem

/**
 * You are given an `n x n` integer matrix `grid`.
 *
 * Generate an integer matrix `maxLocal` of size `(n - 2) x (n - 2)` such that:
 *  - `maxLocal[i][j]` is equal to the largest value of the `3 x 3` matrix in the grid centered around
 *    `i + 1` and column `j + 1`.
 *
 * In other words, we want to find the largest value in every contiguous `3 x 3` matrix in grid.
 *
 * Return the generated matrix.
 */

//endregion

//region Test cases

/**
 * Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
 * Output: [[9,9],[8,6]]
 *
 * Input: grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
 * Output: [[2,2,2],[2,2,2],[2,2,2]]
 */

//endregion

//region Steps to solve

/**
 * 1. Locate the grid area
 *  - Grid size minus 2
 * 2. Search for largest number in each grid.
 * 3. Store values in list.
 * 4. Chunk list into matrix array.
 */

//endregion

//region Solution

private fun main() {
    val result = largestLocal(
        grid = arrayOf(
            intArrayOf(9, 9, 8, 1),
            intArrayOf(5, 6, 2, 6),
            intArrayOf(8, 2, 6, 4),
            intArrayOf(6, 2, 2, 2),
        )
    )

    val debugLine = result
}

private fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
    val gridSize = grid.size
    val searchRadius = gridSize - 2
    val resultArray = Array(searchRadius) { IntArray(searchRadius) }

    for (i in 0 until searchRadius) {
        for (j in 0 until searchRadius) {
            resultArray[i][j] = (0 until 3).flatMap { row ->
                (0 until 3).map { col ->
                    grid[i + row][j + col]
                }
            }.maxOrNull() ?: 0
        }
    }

    return resultArray
}

//endregion