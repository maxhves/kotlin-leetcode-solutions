package datastructures.sorting

private fun main() {
    val testArray = intArrayOf(5, 4, 3, 2, 1)
    bubble(array = testArray)

    print(testArray.joinToString())
}

private fun bubble(array: IntArray) {
    var swapped = false

    // Run the steps n - 1 times
    for (i in array.indices) {
        // For each step, max item will come at the last respective index
        for (j in 1 until array.size - i) {
            if (array[j] < array[j - 1]) {
                // Swap elements
                val tempElement = array[j]
                array[j] = array[j - 1]
                array[j - 1] = tempElement

                swapped = true
            }
        }

        if (!swapped) break
    }
}