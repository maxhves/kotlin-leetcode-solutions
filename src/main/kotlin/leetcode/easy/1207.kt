package leetcode.easy

//region Problem

/**
 * Given an array of integers arr, return true if the number of occurrences of each value in the array
 * is unique or false otherwise.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We can create a HashMap to contain the frequency of each element in arr.
 * - We can then iterate over the frequency values, adding each element to a set.
 *   - If the value already exists in the set, immediately return false.
 * - Ultimately, return true.
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    uniqueOccurrences(arr = intArrayOf(1, 2, 2, 1, 1, 3))

    // Output: false
    uniqueOccurrences(arr = intArrayOf(1, 2))

    // Output: true
    uniqueOccurrences(arr = intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0))
}

private fun uniqueOccurrences(arr: IntArray): Boolean {
    val elementFrequencies = HashMap<Int, Int>(arr.size)
    val occurrenceCountSet = hashSetOf<Int>()

    for (element in arr) {
        elementFrequencies[element] = elementFrequencies.getOrDefault(element, 0) + 1
    }

    for (value in elementFrequencies.values) {
        if (value in occurrenceCountSet) {
            return false
        } else {
            occurrenceCountSet.add(value)
        }
    }

    return true
}

//endregion
