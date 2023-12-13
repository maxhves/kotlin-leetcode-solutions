package leetcode.easy

//region Problem

/**
 * Given an (m x n) binary matrix (mat), return the number of special positions in (mat).
 *
 * A position (i, j) is called special if (mat[i][j] == 1) and all other elements in row (i) and column
 * (j) are (0). The rows and columns are 0-indexed.
 */

//endregion

//region Steps to solve

/**
 * ..
 */

//endregion

//region Solution

private fun main() {
    // Output: 1
    numSpecial(
        mat = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 0, 0),
        )
    )
}

private fun numSpecial(mat: Array<IntArray>): Int {
    val rows = mat.size
    val columns = mat[0].size

    val rowOnesCount = IntArray(rows)
    val columnOnesCount = IntArray(columns)

    var specialPositions = 0

    for (row in 0  until rows) {
        for (column in 0  until columns) {
            if (mat[row][column] == 1) {
                rowOnesCount[row]++
                columnOnesCount[column]++
            }
        }
    }

    for (row in 0 until rows) {
        for (column in 0 until columns) {
            val element = mat[row][column]

            if (element == 1) {
                if (rowOnesCount[row] == 1 && columnOnesCount[column] == 1) {
                    specialPositions++
                }
            }
        }
    }

    return specialPositions
}

//endregion
