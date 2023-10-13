package leetcode.easy

//region Problem

/**
 * You are given an array of strings `names`, and an array `heights` that consists of distinct positive
 * integers. Both arrays are of length `n`.
 *
 * For each index `i`, `names[i]` and `heights[i]` denote the name and height of the `ith` person.
 *
 * Return `names` sorted in descending order by the people's heights.
 */

//endregion

//region Steps to solve

/**
 * 1. Store the heights in a map:
 *    - key: height
 *    - value: name
 * 2. Sort the map descending by key.
 * 3. Return an array of the values.
 */

//endregion

//region Solution

private fun main() {
    // Output: ["Mary", "Emma", "John"]
    sortPeople(names = arrayOf("Mary", "John", "Emma"), heights = intArrayOf(180, 165, 170))

    // Output: ["Bob", "Alice", "Bob"]
    sortPeople(names = arrayOf("Alice", "Bob", "Bob"), heights = intArrayOf(155, 185, 150))
}

private fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
    return names.withIndex().sortedByDescending { heights[it.index] }.map { it.value }.toTypedArray()
}

//endregion