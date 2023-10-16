package leetcode.medium

//region Problem

/**
 * Determine if a `9 x 9` Sudoku board is valid. Only the filled cells need to be validated according to the
 * following rules:
 *
 *  1. Each row must contain the digits `1-9` without repetition.
 *  2. Each column must contain the digits `1-9` without repetition.
 *  3. Each of the nine `3 x 3` sub-boxes of the grid must contain the digits `1-9` without repetition.
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    isValidSudoku(
        board = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
        ),
    )

    // Output: false
}

private fun isValidSudoku(board: Array<CharArray>): Boolean {
    /**
     * Initialise 3 arrays, that store sets of chars.
     * We track:
     *  - Rows.
     *  - Columns.
     *  - Sub boxes.
     */
    val rows = Array(9) { mutableSetOf<Char>() }
    val columns = Array(9) { mutableSetOf<Char>() }
    val subBoxes = Array(9) { mutableSetOf<Char>() }

    /**
     * Iterate over the rows and columns with a nested for loop configuration.
     */
    for (row in 0..board.lastIndex) {
        for (column in 0..board.lastIndex) {
            /**
             * We can skip empty elements, denoted by a punctuation mark.
             */
            if (board[row][column] != '.') {
                /**
                 * To get the sub box index for this given element we:
                 *  - Divide the row by 3.
                 *  - Divide the column by 3.
                 *  - Multiply this result by 3.
                 */
                val subBoxIndex = row / 3 * 3 + column / 3

                /**
                 * Verify the current element does not already exist in:
                 *  - The rows set.
                 *  - The columns set.
                 *  - The sub box set.
                 *
                 *  If any given number already exists in the set then the sudoku board is not
                 *  valid, since each number can only appear once in each of the conditions.
                 */
                if (!rows[row].add(board[row][column])
                    || !columns[column].add(board[row][column])
                    || !subBoxes[subBoxIndex].add(board[row][column])
                ) {
                    return false
                }
            }
        }
    }

    return true
}

//endregion