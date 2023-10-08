package leetcode.easy

//region Problem

/**
 * Given a square matrix `mat`, return the sum of the matrix diagonals.
 *
 * Only include the sum of all the elements on the primary diagonal and all the elements on the
 * secondary diagonal that are not part of the primary diagonal.
 */

//endregion

//region Test cases

/**
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 25
 *
 * Input: mat = [[1,1,1,1,],[1,1,1,1],[1,1,1,1],[1,1,1,1]]
 * Output: 8
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the matrix.
 * 2. Sum up primary array.
 *    - matrix[i+i][j+j]
 * 3. Sum up secondary array.
 * 4. The diagonals intersect if matrix row length is odd.
 *    - Minus the middle element from total sum.
 * 5. Return the total sum
 */

//endregion

//region Solution

private fun main() {
    diagonalSum(
        mat = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
        )
    )
    diagonalSum(
        mat = arrayOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
        )
    )
    diagonalSum(
        mat = arrayOf(
            intArrayOf(7, 3, 1, 9),
            intArrayOf(3, 4, 6, 9),
            intArrayOf(6, 9, 6, 6),
            intArrayOf(9, 5, 8, 5),
        )
    )
}

private fun diagonalSum(mat: Array<IntArray>): Int {
    var sum = 0
    val size = mat.size

    for (i in mat.indices) {
        sum += mat[i][i]
        sum += mat[i][mat.lastIndex - i]
    }

    if (size % 2 != 0) {
        val midpoint = size / 2
        sum -= mat[midpoint][midpoint]
    }

    return sum
}

//endregion