package leetcode.medium

//region Problem

/**
 * Given an array f integers arr and an integer k. Find the least number of unique integers after
 * removing exactly k elements.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Count the frequency of each element.
 * - Sort the frequencies.
 * - Remove the last k items.
 * - Count the number of unique items left.
 */

//endregion

//region Solution

private fun main() {
    // Output: 1
    findLeastNumberOfUniqueInts(arr = intArrayOf(5, 5, 4), k = 1)

    // Output: 2
    findLeastNumberOfUniqueInts(arr = intArrayOf(4, 3, 1, 1, 3, 3, 2), k = 3)
}

private fun findLeastNumberOfUniqueInts(arr: IntArray, k: Int): Int {
    val elementFrequencies = HashMap<Int, Int>()
    val requiredElements = arr.size - k

    if (requiredElements == 0) {
        return 0
    }

    for (element in arr) {
        val currentFrequency = elementFrequencies.getOrDefault(element, 0)
        elementFrequencies[element] = currentFrequency + 1
    }

    val sortedValues = elementFrequencies.values.sortedDescending()
    var result = 0
    var currentElementCount = 0

    for (value in sortedValues) {
        result++
        currentElementCount += value

        if (currentElementCount >= requiredElements) {
            break
        }
    }

    return result
}

//endregion
