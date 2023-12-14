package leetcode.medium

//region Problem

/**
 * You are given a 0-indexed (m x n) binary matrix (grid).
 *
 * A 0-indexed (m x n) difference matrix (diff) is created with the following procedure:
 * - Let the number of ones in the (i th) row be (onesRow i).
 * - Let the number of ones in the (j th) column be (onesCol j).
 * - Let the number of zeros in the (i th) row be (zerosRow i).
 * - Let the number of zeros in the (j th) column be (zerosCol j).
 * - (diff[i][j] = (onesRow i) + (onesCol j) - (zerosRow i) - (zerosCol j)).
 */

//endregion

//region Steps to solve

/**
 * Using the following example:
 * - Input: [[0, 1, 1], [1, 0, 1], [0, 0, 1]]
 * - (diff[0][0]):
 *   - 1s in row - 2
 *   - 1s in column - 1
 *   - 0s in row - 1
 *   - 0s in column - 2
 *   - Result:
 *     - 2 + 1 - 1 - 2
 *     - 0
 *
 * Steps
 * - Initialize the following variables:
 *   - (rows) set to (grid.size).
 *   - (columns) set to (grid[0].size).
 *   - (diff) set to ArrayList<IntArray>.
 *   - (onesInRow) set to IntArray(rows).
 *   - (onesInColumn) set to IntArray(columns).
 *   - (zerosInRow) set to IntArray(rows).
 *   - (zerosInColumn) set to IntArray(column).
 * - Iterate over (grid) and build up the one/zero counts.
 * - Iterate over (grid) again and build the diff grid:
 *   - diff[i][j] = onesInRow[i] + onesInColumn[j] - zerosInRow[i] - zerosInColumn[j]
 * - Return (diff).
 */

//endregion

//region Solution

private fun main() {
    // Output: [[0, 0, 4], [0, 0, 4], [-2, -2, 2]]
    onesMinusZeros(
        grid = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 1),
        ),
    )
}

private fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
    val rows = grid.size
    val columns = grid[0].size

    val countInRow = IntArray(rows)
    val countInColumn = IntArray(columns)

    for (row in 0 until rows) {
        for (column in 0 until columns) {
            val delta = if (grid[row][column] == 0) -1 else 1
            countInRow[row] += delta
            countInColumn[column] += delta
        }
    }

    return Array(rows) { row ->
        IntArray(columns) { column ->
            countInRow[row] + countInColumn[column]
        }
    }
}

//endregion
