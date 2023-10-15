package leetcode.easy

//region Problem

/**
 * Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.
 *
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */

//endregion

//region Steps to solve

/**
 * 1. Create a HashMap<Int, Char> of s.
 * 2. Iterate over t.
 * 3. Check if t[i] exists in hash map:
 *    - If yes, continue.
 *    - If no, return false.
 * 4. If we reach here, return true.
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    isAnagram(s = "anagram", t = "nagaram")

    // Output: false
    isAnagram(s = "rat", t = "car")

    // Output: false
    isAnagram(s = "ab", t = "a")
}

private fun isAnagram(s: String, t: String): Boolean {
    val sSorted = s.withIndex().associate { it.index to it.value }.values.sorted()
    val tSorted = t.withIndex().associate { it.index to it.value }.values.sorted()
    return sSorted == tSorted
}

//endregion