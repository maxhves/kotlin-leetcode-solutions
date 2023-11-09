package leetcode.easy

//region Problem

/**
 * You are given coordinates, a string that represents the coordinates of a square of the chessboard.
 *
 * Return (true) if the square is white, and (false) if the square is black.
 */

//endregion

//region Steps to solve

/**
 * Steps:
 * 1. Initialize some variables:
 *     - (x): Int, the horizontal coordinate.
 *     - (y): Int, the vertical coordinate.
 * 2. Set (x) to (coordinates[0] - 'a' + 1).
 * 3. Set (y) to (coordinates[1]).
 * 4. Return false if (x) is odd AND (y) is odd.
 */

//endregion

//region Solution

private fun main() {
    // Output: false
    squareIsWhite(coordinates = "a1")
}

private fun squareIsWhite(coordinates: String): Boolean {
    val x = coordinates[0] - 'a' + 1
    val y = coordinates[1].digitToInt()

    val xIsEven = x % 2 == 0
    val yIsEven = y % 2 == 0

    return when {
        xIsEven && yIsEven -> false
        !xIsEven && !yIsEven -> false
        else -> true
    }
}

//endregion
