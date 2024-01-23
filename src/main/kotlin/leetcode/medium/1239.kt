package leetcode.medium

//region Problem

/**
 * You are given an array of strings arr. A string s is formed by the concatenation of a subsequence
 * of arr that has unique characters.
 *
 * Return the maximum possible length of s.
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements
 * without changing the order of the remaining elements.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We will have to know about every combination of substrings.
 * - We could use a DFS solution whereby we either include the next element, or we don't.
 */

//endregion

//region Solution

private fun main() {
    // Output: 16
    maxLength(arr = listOf("ab", "ba", "cd", "dc", "ef", "fe", "gh", "hg", "ij", "ji", "kl", "lk", "mn", "nm", "op", "po"))

    // Output: 0
    maxLength(arr = listOf("aa", "bb"))

    // Output: 4
    maxLength(arr = listOf("un", "iq", "ue"))

    // Output: 6
    maxLength(arr = listOf("cha", "r", "act", "ers"))
}

private fun maxLength(arr: List<String>): Int {
    val charSet = HashSet<Char>()

    // For each character in the given string s
    // Check if the character exists in itself OR in the given set
    fun overlap(set: HashSet<Char>, s: String): Boolean {
        val previous = HashSet<Char>()

        for (char in s) {
            if (char in set || char in previous) {
                return true
            }
            previous.add(char)
        }
        return false
    }

    fun backtrack(index: Int): Int {
        // If the index is out of bounds, return the current size of the set.
        if (index > arr.lastIndex) {
            return charSet.size
        }

        // Result starts at 0
        var result = 0

        // Does the string contain repeating characters OR does it contain characters in our current
        // set we are building.
        // If not, more checks
        if (!overlap(charSet, arr[index])) {
            // For each char in the current string
            // Add it's char to our tracked set
            for (char in arr[index]) {
                charSet.add(char)
            }
            // Recursively call to the next index, for the next string.
            result = backtrack(index + 1)

            // Now remove the current string chars from the tracked set.
            for (char in arr[index]) {
                charSet.remove(char)
            }
        }

        // Return a recursive call to a max of the current result and the next index.
        return maxOf(result, backtrack(index + 1))
    }

    return backtrack(0)
}

//endregion
