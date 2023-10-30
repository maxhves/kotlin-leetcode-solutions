package leetcode.easy

//region Problem

/**
 * You are given a 0-indexed array of string (words) and two integers (left) and (right).
 *
 * A string is called a vowel string if it starts with a vowel character and ends with a vowel character
 * where vowel characters are ('a'), ('e'), ('i'), ('o') and ('u').
 *
 * Return the number of vowel strings (words[i]) where (i) belongs to the inclusive range ([left, right]).
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We must only check words who are in the inclusive range ([left, right]).
 *  - Therefore we must only iterate through words at (left) index to (right) index.
 *
 * 1. Iterate over the (words) array.
 * 2. For each (word) in the index range (left) to (right);
 *     - Check the first and last characters in the word:
 *        - If they are both vowels, increase our result count.
 * 3. Return the resulting count.
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    vowelStrings(
        words = arrayOf("are", "amy", "u"),
        left = 0,
        right = 2,
    )

    // Output: 3
    vowelStrings(
        words = arrayOf("hey", "aeo", "mu", "ooo", "artro"),
        left = 1,
        right = 4,
    )
}

private fun vowelStrings(words: Array<String>, left: Int, right: Int): Int {
    var vowelStringCount = 0
    val vowelSet = setOf('a', 'e', 'i', 'o', 'u')

    for (i in left .. right) {
        val word = words[i]
        if (word[0] in vowelSet && word[word.lastIndex] in vowelSet) {
            vowelStringCount++
        }
    }

    return vowelStringCount
}

//endregion
