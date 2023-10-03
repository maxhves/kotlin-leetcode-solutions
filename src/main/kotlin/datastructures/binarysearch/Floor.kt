package datastructures.binarysearch

private fun main() {
    val numbers = intArrayOf(2, 3, 5, 9, 14, 16, 18)
    val target = 15
    val answer = floorOfTarget(numbers, target)

    println(answer)
}

/**
 * Return the largest element that is smaller than or equal to target.
 */
fun floorOfTarget(array: IntArray, target: Int): Int {
    if (target < array[0]) {
        return -1
    }

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

    return array[end]
}