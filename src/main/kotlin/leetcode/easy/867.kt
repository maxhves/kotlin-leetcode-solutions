package leetcode.easy

//region Problem

/**
 * Given a 2D integer array (matrix), return the transpose of (matrix).
 *
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row
 * and column indices.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - All the row indices should now become column indices and vice versa.
 *
 * Steps
 * - Initialize a new matrix (transposedMatrix).
 * - Iterate over the columns in (matrix).
 * - Initialize a new IntArray (row) set to (matrix.size).
 * - Iterate over the (rows) in (matrix)
 * - For each index in the (row) add the element to (row).
 * - After the inner loop, add (row) to (transposedMatrix).
 * - Ultimately return (transposedMatrix).
 */

//endregion

//region Solution

private fun main() {
    transpose(
        matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6)
        )
    )
}

private fun transpose(matrix: Array<IntArray>): Array<IntArray> {
    val transposedMatrix = mutableListOf<IntArray>()

    for (i in 0 .. matrix[0].lastIndex) {
        val row = IntArray(matrix.size)

        for (j in 0 .. matrix.lastIndex) {
            row[j] = matrix[j][i]
        }

        transposedMatrix.add(row)
    }

    return transposedMatrix.toTypedArray()
}

//endregion
