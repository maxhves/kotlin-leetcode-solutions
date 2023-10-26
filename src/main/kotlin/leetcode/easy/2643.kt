package leetcode.easy

//region Problem

/**
 * Given a (m x n) binary matrix (mat), find the 0-indexed position of the row that contains the maximum
 * count of ones, and the number of ones in that row.
 *
 * In case there are multiple rows that have the maximum count of ones, the row with the smallest row number
 * should be selected.
 *
 * Return an array containing the index of the row and the number of ones in it.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the rows in the array.
 * 2. Iterate over the columns in the rows.
 * 3. For each row:
 *    - Count the number of ones in the row.
 *    - Store the answer in a pair array.
 * 4. Return the pair with the highest one count, OR if there are multiple rows, then the one with the
 *    lowest index.
 */

//endregion

//region Solution

private fun main() {
    // Output: [0, 1]
    rowAndMaximumOnes(mat = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)))

    // Output: [1, 2]
    rowAndMaximumOnes(mat = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 1)))

    // Output: [1, 2]
    rowAndMaximumOnes(mat = arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(0, 0)))
}

private fun rowAndMaximumOnes(mat: Array<IntArray>): IntArray {
    var result = Int.MIN_VALUE to Int.MIN_VALUE

    for (i in 0 .. mat.lastIndex) {
        var ones = 0

        for (j in 0 .. mat[i].lastIndex) {
            if (mat[i][j] == 1) {
                ones++
            }
        }

        if (ones > result.second) {
            result = i to ones
        }
    }

    return intArrayOf(result.first, result.second)
}

//endregion
