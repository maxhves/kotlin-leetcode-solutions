package leetcode.easy

//region Problem

/**
 * An image smoother is a filter of the size (3 x 3) that can be applied to each cell of an image by
 * rounding down the average of the cell and the eight surrounding cells (i.e. the average of the nine
 * cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do
 * not consider it in the average (i.e. the average of the four cells in the red smoother).
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Iterate over every cell.
 * - For each cell:
 *   - Iterate from the current row -/+ 1 and the column -/+ 1.
 *   - If the cell is in the original matrix array; add it to a list of elements.
 * - Calculate the average for the matching elements.
 * - Add the average to a resulting matrix.
 * - Return the resulting matrix.
 */

//endregion

//region Solution

private fun main() {
    imageSmoother(
        img = arrayOf(
            intArrayOf(2, 3, 4),
            intArrayOf(5, 6, 7),
            intArrayOf(8, 9, 10),
            intArrayOf(11, 12, 13),
            intArrayOf(14, 15, 16),
        )
    )
}

private fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
    val rows = img.lastIndex
    val columns = img[0].lastIndex
    val smoothenedImage = Array(rows + 1) { IntArray(columns + 1) }
    val elements = mutableListOf<Int>()

    fun getAverageForCell(row: Int, column: Int): Int {
        elements.clear()

        for (i in row - 1 .. row + 1) {
            for (j in column - 1 .. column + 1) {
                if (i in 0..rows && j in 0..columns) {
                    elements.add(img[i][j])
                }
            }
        }

        return elements.fold(0) { acc, i -> acc + i } / elements.size
    }

    for (row in 0..rows) {
        for (column in 0..columns) {
            smoothenedImage[row][column] = getAverageForCell(row, column)
        }
    }

    return smoothenedImage
}

//endregion
