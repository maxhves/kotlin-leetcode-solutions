package datastructures

private fun main() {
    val numbers = intArrayOf(23, 45, 1, 2, 8, 19, -3, 16, -11, 28)
    val target = 19

    println(linearSearch(numbers, target))
}

/**
 * Search the array and return the index if the item is found.
 * Otherwise, if not found, return -1.
 */
fun linearSearch(array: IntArray, target: Int): Int {
    if (array.isEmpty()) {
        return -1
    }

    // Run a for loop
    for (index in array.indices) {
        // Check for the element in the array
        val element = array[index]

        if (element == target) {
            return index
        }
    }

    // No result found
    return -1
}