package leetcode.medium

//region Problem

/**
 * There is an integer array (nums) that consists of (n) unique elements, but you have forgotten it.
 * However, you do remember every pair of adjacent elements in (nums).
 *
 * You are given a 2D integer array (adjacentPairs) of size (n - 1) where each (adjacentPairs[i] =
 * [u i, v i]) indicates that the elements (u i) and (v i) are adjacent in (nums).
 *
 * It is guaranteed that every adjacent pair of elements (nums[i]) and (nums[i + 1]) will exist in
 * (adjacentPairs), either as ([nums[i], nums[i + 1]]) or ([nums[i + 1], nums[i]]). The pairs can appear
 * in any order.
 *
 * Return the original array (nums). If there are multiple solutions, return any of them.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - We need build an array of integers based on an array of pairs.
 * - The pairs describe the positioning of each element.
 * - These elements could be described in any order.
 * - This is much like a flat structure of a binary tree.
 * - If we find the first element of the flat array, we can keep searching for next items until the end.
 *
 * Steps:
 * 1. Initialize a hash map to store an element and what elements it is touching.
 *    - This will also behave as a frequency map.
 *    - Only related to one item means that we are at the start or the end.
 * 2. Iterate over the (adjacentPairs) array; and for each:
 *    - If (pair[0]) is not present, add it and add (pair[1]) in its list of touching elements.
 *    - If (pair[1]) is not present, add it and add (pair[0]) in its list of touching elements.
 * 3. Initialize a new mutable list (nums) and add an element from the hash map that has only one
 *    touching element in its value list.
 * 4. Iterate while (nums) is not equal to (adjacentPairs.size + 1):
 *    - Get the last element to be added to (nums).
 *    - Get the entry for the element key in the hash map.
 *    - Take one of the items in its touching elements.
 *    - Add it to (nums).
 *    - Remove references to these items in the hash map.
 * 5. Ultimately return (nums).
 */

//endregion

//region Solution

private fun main() {
    // Output: [1, 2, 3, 4]
    restoreArray(
        adjacentPairs = arrayOf(
            intArrayOf(2, 1),
            intArrayOf(3, 4),
            intArrayOf(3, 2)
        ),
    )

    // Output: [-2,4,1,-3]
    restoreArray(
        adjacentPairs = arrayOf(
            intArrayOf(4, -2),
            intArrayOf(1, 4),
            intArrayOf(-3, 1)
        ),
    )

    // Output: [100000,-100000]
    restoreArray(
        adjacentPairs = arrayOf(
            intArrayOf(100000, -100000),
        ),
    )
}

private fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
    val occurrences = mutableMapOf<Int, MutableList<Int>>()

    // Build the occurrences map
    for (pair in adjacentPairs) {
        occurrences.computeIfAbsent(pair[0]) { mutableListOf() }.add(pair[1])
        occurrences.computeIfAbsent(pair[1]) { mutableListOf() }.add(pair[0])
    }

    // Find the first element
    val firstNum = occurrences.entries.first { it.value.size == 1 }.key
    val nums = mutableListOf(firstNum)

    // Reconstruct the array
    while (nums.size < adjacentPairs.size + 1) {
        val currentNum = nums.last()
        val nextNum = occurrences[currentNum]!!.first()

        nums.add(nextNum)

        // Mark the used pair as visited
        occurrences[currentNum]!!.remove(nextNum)
        occurrences[nextNum]!!.remove(currentNum)
    }

    return nums.toIntArray()
}

//endregion
