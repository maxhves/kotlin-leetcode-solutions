package datastructures

private fun main() {
    val numbers = intArrayOf(-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22)
    val target = 22
    val answer = orderAgnosticBinarySearch(numbers, target)

    println(answer)
}

fun orderAgnosticBinarySearch(array: IntArray, target: Int): Int {
    var start = 0
    var end = array.lastIndex

    // Find whether array is sorted in ascending or descending order
    val ascendingOrder: Boolean = array[start] < array[end]

    while (start <= end) {
        val midpoint = start + (end - start) / 2

        if (array[midpoint] == target) {
            return midpoint
        }

        if (ascendingOrder) {
            if (target < array[midpoint]) {
                end = midpoint - 1
            } else {
                start = midpoint + 1
            }
        } else {
            if (target > array[midpoint]) {
                end = midpoint - 1
            } else {
                start = midpoint + 1
            }
        }
    }

    return -1
}