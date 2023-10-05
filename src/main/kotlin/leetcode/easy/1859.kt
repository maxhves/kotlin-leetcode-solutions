package leetcode.easy

//region Problem

/**
 * A sentence is a list of words that are separated by a single space with no leading or trailing
 * spaces. Each word consists of lowercase and uppercase English letters.
 *
 * A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging
 * the words in the sentence.
 *  - For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 this1" or
 *  "is2 sentence4 This1 a3".
 *
 *  Given a shuffled sentence `s` containing no more than `9` words, reconstruct and return the original
 *  sentence.
 */

//endregion

//region Test cases

/**
 * Input: s = "is2 sentence4 This1 a3"
 * Output: "This is a sentence"
 *
 * Input: s = "Myself2 Me1 I4 and3"
 * Output: "My Myself and I"
 */

//endregion

//region Steps to solve

/**
 * 1. Extract individual words by splitting on spaces ' '.
 * 2. Check last char to discover sort.
 * 3. Build result string in correct order.
 */

//endregion

//region Solution

private fun main() {
    println(sortSentenceOptimized(s = "is2 sentence4 This1 a3"))
}

/**
 * Initial attempt: Doesn't appear to be optimal.
 *
 * Runtime: 175ms (beats 32.56%).
 * Memory: 39.66mb (beats 9.30%).
 */
fun sortSentence(s: String): String {
    val wordArray = s.split(' ').sortedBy { it.last() }
    return wordArray.joinToString(separator = " ") { it.dropLast(1) }
}

/**
 * Optimization attempt: Seems okay.
 *
 * Runtime: 145ms (beats 97.67%).
 * Memory: 37.68mb (beats 69.77%).
 */
fun sortSentenceOptimized(s: String): String {
    val wordArray = s.split(" ").associate { it.last().digitToInt() to it.dropLast(1) }
    return wordArray.toSortedMap().values.joinToString(" ")
}

//endregion