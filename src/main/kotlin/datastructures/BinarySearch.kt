package datastructures

private fun main() {
    val result = binarySearch(list = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), target = 8)
    println(result)
}

fun binarySearch(list: IntArray, target: Int): Int? {
    var first = 0
    var last = list.lastIndex

    while (first <= last) {
        val midpoint: Int = (first + last) / 2

        if (list[midpoint] == target) {
            return midpoint
        } else if (list[midpoint] < target) {
            first = midpoint + 1
        } else {
            last = midpoint - 1
        }
    }

    return null
}