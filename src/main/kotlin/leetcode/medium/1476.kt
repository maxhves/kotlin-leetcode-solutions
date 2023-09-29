package leetcode.medium


//region Problem

/**
 * Implement the class `SubrectangleQueries` which receives a `rows x cols` rectangle as a matrix
 * of integers in the constructor and supports two methods:
 * - `updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 *     - Updates all values with `newValue` in the subrectangle whose upper left coordinate is `(row1,col1)`
 *     and bottom right coordinate is `(row2,col2)`.
 * - `getValue(int row, int col)`
 *     - Returns the current value of the coordinate `(row,col)` from the rectangle.
 */

//endregion

//region Test cases

/**
 * Input: ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
 * [[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
 * Output: [null,1,null,5,5,null,10,5]
 *
 * Input: ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue"]
 * [[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
 * Output: [null,1,null,100,100,null,20]
 */

//endregion

//region Solution

private fun main() {
    val subrectangleQueries = SubrectangleQueries(
        rectangle = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(4, 3, 4),
            intArrayOf(3, 2, 1),
            intArrayOf(1, 1, 1),
        )
    )
    println(subrectangleQueries.getValue(0, 2))

    subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5)
    println(subrectangleQueries.getValue(0, 2))
    println(subrectangleQueries.getValue(3, 1))

    subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10)
    println(subrectangleQueries.getValue(3, 1))
    println(subrectangleQueries.getValue(0, 2))
}

class SubrectangleQueries(val rectangle: Array<IntArray>) {
    fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
        for (row  in 0 until rectangle.size) {
            if (row in row1..row2) {
                for (cell in 0 until rectangle[row].size) {
                    if (cell in col1..col2) {
                        rectangle[row][cell] = newValue
                    }
                }
            }
        }
    }

    fun getValue(row: Int, col: Int): Int {
        return rectangle[row][col]
    }
}

//endregion