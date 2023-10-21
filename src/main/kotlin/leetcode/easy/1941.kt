package leetcode.easy

//region Problem

/**
 * Given a string (s), return (true) if (s) is a good string, or (false) otherwise.
 *
 * A string (s) is good if all the characters that appear in (s) have the same number of occurrences
 * (i.e., the same frequency).
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the chars in (s).
 * 2. Store each char in a HashMap<Char, Int>.
 * 3. Return if all values are the same (the frequency will be the same).
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    areOccurrencesEqual(s = "abacbc")

    // Output: false
    areOccurrencesEqual(s = "aaabb")
}

private fun areOccurrencesEqual(s: String): Boolean {
    val frequencyMap = HashMap<Char, Int>(s.length)

    for (c in s) {
        if (!frequencyMap.containsKey(c)) {
            frequencyMap[c] = 1
        } else {
            frequencyMap[c] = frequencyMap[c]!! + 1
        }
    }

    val default = frequencyMap[s[0]]
    for (element in frequencyMap.values) {
        if (element != default) return false
    }

    return true
}

//endregion
