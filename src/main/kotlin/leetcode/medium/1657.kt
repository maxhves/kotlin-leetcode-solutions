package leetcode.medium

//region Problem

/**
 * Two strings are considered close if you can attain one from the other using the following operations:
 * - Operation 1: Swap any two existing characters.
 *   - For example, (a -b- cd -e-) -> (a -e- cd -b-).
 * - Operation 2: Transform every occurrence of one existing character into another existing character,
 *   and do the same with the other character.
 *   - For example, (-aa- b -abb-) -> (-bb- c -baa-), all a's turn into b's, and all b's turn into a's.
 *
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, (word1) and (word2), return true if (word1) and (word2) are close, and false
 * otherwise.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Operation 1: Is irrelevant, because the words are always close if we have the same frequency
 *   of characters in both strings.
 * - Operation 2: Providing we have the same characters, we can sort the frequency and check if they
 *   match, as we can guarantee that swapping one character for another is possible.
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    closeStrings(word1 = "abc", word2 = "bca")

    // Output: false
    closeStrings(word1 = "a", word2 = "aa")

    // Output: true
    closeStrings(word1 = "cabbba", word2 = "abbccc")
}

private fun closeStrings(word1: String, word2: String): Boolean {
    if (word1.length != word2.length) {
        return false
    }

    val word1CharFrequency = HashMap<Char, Int>(26)
    val word2CharFrequency = HashMap<Char, Int>(26)

    for (i in word1.indices) {
        word1CharFrequency[word1[i]] = word1CharFrequency.getOrDefault(word1[i], 0) + 1
        word2CharFrequency[word2[i]] = word2CharFrequency.getOrDefault(word2[i], 0) + 1
    }

    if (word1CharFrequency.keys != word2CharFrequency.keys) {
        return false
    }

    val word1SortedFrequency = word1CharFrequency.values.sorted()
    val word2SortedFrequency = word2CharFrequency.values.sorted()

    return word1SortedFrequency == word2SortedFrequency
}

//endregion
