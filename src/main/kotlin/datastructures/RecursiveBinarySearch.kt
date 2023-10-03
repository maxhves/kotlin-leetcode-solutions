package datastructures

private fun main() {
    var result = recursiveBinarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), 12)
    println(result)

    result = recursiveBinarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), 6)
    println(result)
}

fun recursiveBinarySearch(list: IntArray, target: Int): Boolean {
    if (list.isEmpty()) {
        return false
    }

    val midpoint = list.size / 2

    return if (list[midpoint] == target) {
        true
    } else {
        if (list[midpoint] < target) {
            recursiveBinarySearch(list.sliceArray(midpoint + 1 until list.size), target)
        } else {
            recursiveBinarySearch(list.sliceArray(0 until midpoint), target)
        }
    }
}