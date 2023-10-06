package datastructures.binarysearch

private fun main() {
    val array = arrayOf(
        intArrayOf(10, 20, 30, 40),
        intArrayOf(15, 25, 35, 45),
        intArrayOf(28, 29, 37, 49),
        intArrayOf(33, 34, 38, 50),
    )
    println(search(matrix = array, target = 37).joinToString())
}

private fun search(matrix: Array<IntArray>, target: Int): IntArray {
    var row = 0
    var column = matrix.lastIndex

    while (row < matrix.size && column >= 0) {
        if (matrix[row][column] == target) {
            return intArrayOf(row, column)
        }
        if (matrix[row][column] < target) {
            row++
        } else {
            column--
        }
    }

    return intArrayOf(-1, -1)
}