package leetcode.easy

//region Problem

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does
 * not exist, return -1.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: 0
    firstUniqChar(s = "leetcode")
}

private fun firstUniqChar(s: String): Int {
    // Character to index to frequency
    val characterSet = mutableMapOf<Char, Pair<Int, Int>>()

    for (i in s.indices) {
        val char = s[i]
        val existingPair = characterSet.getOrDefault(char, 0 to 0)

        characterSet[char] = i to existingPair.second + 1
    }

    return characterSet.values.firstOrNull { it.second == 1 }?.first ?: -1
}

//endregion
