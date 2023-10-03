package datastructures

private fun main() {
    val numbers = intArrayOf(-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22)
    val target = 22
    val answer = binarySearch(numbers, target)

    println(answer)
}

/**
 * Return the index of [target] else return -1 if not found.
 */
fun binarySearch(array: IntArray, target: Int): Int {
    var start = 0
    var end = array.lastIndex

    while (start <= end) {
        // Find the middle element
        // This could be larger than the maximum integer size.
        // val midpoint = (start + end) / 2
        val midpoint = start + (end - start) / 2

        if (target < array[midpoint]) {
            end = midpoint - 1
        } else if (target > array[midpoint]) {
            start = midpoint + 1
        } else {
            return midpoint
        }
    }

    return -1
}