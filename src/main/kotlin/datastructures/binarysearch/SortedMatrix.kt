package datastructures.binarysearch

private fun main() {
    val array = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )

    println(search(array, 9).joinToString())
}

private fun search(matrix: Array<IntArray>, target: Int): IntArray {
    var rows = matrix.size
    var columns = matrix[0].size

    if (rows == 1) {
        return binarySearch(matrix, 0, 0, columns - 1, target)
    }

    var rowStart = 0
    var rowEnd = rows - 1
    var columnMidpoint = columns / 2

    while (rowStart < rowEnd - 1) {
        val midpoint = rowStart + (rowEnd - rowStart) / 2

        if (matrix[midpoint][columnMidpoint] == target) {
            return intArrayOf(midpoint, columnMidpoint)
        }
        if (matrix[midpoint][columnMidpoint] < target) {
            rowStart = midpoint
        } else {
            rowEnd = midpoint
        }
    }

    // Now we have only two rows.
    // Check if the midpoints in the rows are equal to target
    if (matrix[rowStart][columnMidpoint] == target) {
        return intArrayOf(rowStart, columnMidpoint)
    }

    if (matrix[rowEnd][columnMidpoint] == target) {
        return intArrayOf(rowEnd, columnMidpoint)
    }

    // Search in first half
    if (target <= matrix[rowStart][columnMidpoint - 1]) {
        return binarySearch(matrix, rowStart, 0, columnMidpoint - 1, target)
    }

    // Search in second half
    if (target >= matrix[rowStart][columnMidpoint + 1] && target <= matrix[rowStart][columns - 1]) {
        return binarySearch(matrix, rowStart, columnMidpoint + 1, columns - 1, target)
    }

    // Search in third half
    if (target <= matrix[rowStart + 1][columnMidpoint - 1]) {
        return binarySearch(matrix, rowStart + 1, 0, columnMidpoint - 1, target)
    } else {
        return binarySearch(matrix, rowStart + 1, columnMidpoint + 1, columns - 1, target)
    }
}

private fun binarySearch(
    matrix: Array<IntArray>,
    row: Int,
    columnStart: Int,
    columnEnd: Int,
    target: Int,
): IntArray {
    var columnStartIndex = columnStart
    var columnEndIndex = columnEnd

    while (columnStartIndex <= columnEndIndex) {
        val midpoint = columnStartIndex + (columnEndIndex - columnStartIndex) / 2

        if (matrix[row][midpoint] == target) {
            return intArrayOf(row, midpoint)
        }
        if (matrix[row][midpoint] < target) {
            columnStartIndex = midpoint + 1
        } else {
            columnEndIndex = midpoint - 1
        }
    }

    return intArrayOf(-1, -1)
}