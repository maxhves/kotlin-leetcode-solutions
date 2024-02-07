package leetcode.medium

//region Problem

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The
 * frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Create a frequency map, and then return the keys in descending order of values.
 */

//endregion

//region Solution

private fun main() {
    // Output: "eert"
    frequencySort(s = "tree")
}

private fun frequencySort(s: String): String {
    val frequencyMap = HashMap<Char, MutableList<Char>>()
    val stringBuilder = StringBuilder()

    for (char in s) {
        val existingChars = frequencyMap.getOrDefault(char, mutableListOf())
        existingChars.add(char)

        frequencyMap[char] = existingChars
    }

    frequencyMap.values.sortedByDescending { it.size }.forEach { item ->
        stringBuilder.append(item.joinToString(""))
    }

    return stringBuilder.toString()
}

//endregion
