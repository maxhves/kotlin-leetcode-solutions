package leetcode.medium

import java.util.ArrayDeque

//region Problem

/**
 * Given the array 'queries' of positive integers between '1' and 'm', you have to process all 'queries[i]'
 * (from 'i=0' to 'i=queries.length-1') according to the following rules:
 * - In the beginning, you have the permutation 'P=[1,2,3,...,m]'.
 * - For the current 'i', find the position of 'queries[i]' in the permutation 'P' (indexing from 0) and then move
 *   this at the beginning of the permutation 'P'. Notice that the position of 'queries[i]' in 'P' is the result
 *   for 'queries[i]'.
 *
 * Return an array containing the result for the given 'queries'.
 */

//endregion

//region Steps to solve

/**
 * - Duplicate the 'queries' array, and use a dat structure that allows for quick insertion at the front and quick
 *   removal in the middle.
 * - The array should be filled from 1 to 'm'.
 * - Iterate from 0 to the last index of 'queries'.
 * - For each iteration, get the value that is at index 'i' in 'queries'.
 * - Use this value as an index to now take the value located at index of value in the 'permutation' array.
 * - Remove this item from the 'permutation' array and place it at the front of the 'permutation' array.
 * - Store this value in a result/answer array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [2, 1, 2, 1]
    processQueries(queries = intArrayOf(3, 1, 2, 1), m = 5)

    // Output: [3, 1, 2, 0]
    processQueries(queries = intArrayOf(4, 1, 2, 2), m = 4)

    // Output: [6, 5, 0, 7, 5]
    processQueries(queries = intArrayOf(7, 5, 5, 8, 3), m = 8)
}

private fun processQueries(queries: IntArray, m: Int): IntArray {
    val permutation = ArrayDeque(elements = (1..m).toList())
    val result = mutableListOf<Int>()

    for (i in queries.indices) {
        // Get the value in queries at this index
        val queryValueAtIndex = queries[i]

        // Get the index position of queryValueAtIndex in the permutation
        // We need to search for the index of the value.
        val permutationIndexOfQueryValue = permutation.indexOf(queryValueAtIndex)

        // Add permutation index to result array
        result.add(permutationIndexOfQueryValue)

        // Remove the permutation index from the array and insert at the beginning
        val permutationValueToMove = permutation[permutationIndexOfQueryValue]
        permutation.removeAt(permutationIndexOfQueryValue)
        permutation.addFirst(permutationValueToMove)
    }

    return result.toIntArray()
}

//endregion
