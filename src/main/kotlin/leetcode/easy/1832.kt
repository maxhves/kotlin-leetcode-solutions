package leetcode.easy

//region Problem

/**
 * A pangram is a sentence where every letter of the English alphabet appears
 * at least once.
 *
 * Given a string `sentence` containing only lowercase English letters, return `true`
 * if `sentence` is a pangram, or `false` otherwise.
 */

//endregion

//region Test cases

/**
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 *
 * Input: sentence = "leetcode"
 * Output: false
 */

//endregion

//region Steps to solve

/**
 * 1. Recurse through the entire sentence.
 * 2. Add characters into a map.
 * 3. Return map size == 26.
 *
 * a. If the string < 26 we can automatically reject.
 */

//endregion

//region Solution

private fun main() {
    println(checkIfPangram(sentence = "thequickbrownfoxjumpsoverthelazydog"))
    println(checkIfPangram(sentence = "leetcode"))
}

/**
 * Initial solution: Decent performance
 *
 * Runtime: 133ms (beats 95.08%).
 * Memory: 34.37mb (beats 72.13%).
 */
fun checkIfPangram(sentence: String): Boolean {
    if (sentence.length < 26) {
        return false
    }

    val charHashMap = hashMapOf<Char, Char>()

    for (char in sentence) {
        if (!charHashMap.contains(char)) {
            charHashMap[char] = char
        }
    }

    return charHashMap.size == 26
}

/**
 * Very interesting alternative trick.
 */
fun checkIfPangramAlternative(sentence: String): Boolean {
    return sentence.toSet().size == 26
}

//endregion