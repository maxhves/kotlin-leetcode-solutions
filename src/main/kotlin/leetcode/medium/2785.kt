package leetcode.medium

import java.util.PriorityQueue

//region Problem

/**
 * Given a 0-indexed string (s), permute (s) to get a new string (t) such that:
 * - All consonants remain in their original places. More formally, if there is an index (i) with
 *   (0 <= i < s.length) such that (s[i]) is a consonant, then (t[i] = s[i]).
 * - The vowels must be sorted in the non-decreasing order of their ASCII values. More formally, for pairs
 *   of indices (i), (j) with (0 <= i < j < s.length) such that (s[i]) and (s[j]) are vowels, then (t[i])
 *   must not have a higher ASCII value than (t[j]).
 *
 * Return the resulting string.
 *
 * The vowels are ('a'), ('e'), ('i'), ('o'), and ('u'), and they can appear in lowercase or uppercase.
 * Consonants comprise all letters that are not vowels.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - We need to replace each vowel in the string (actually re-order them) so they are in increasing order.
 * - We could iterate over the original string and place vowels into a sorted structure.
 * - We could place these vowels into a PriorityQueue.
 * - Then we could iterate over the string again and if we hit a vowel, we pop from the queue.
 *
 * Steps:
 * - Initialize a Set of Char, that will contain all possible vowels.
 * - Initialize a PriorityQueue of Char that will hold out located vowels.
 * - Initialize an empty Char array to hold our string characters.
 * - Iterate over the string (s) the first time:
 *   - Place the (char) into the PriorityQueue.
 *   - If the (char) is in our set, place the char in the PriorityQueue.
 * - Iterate over the new char array, if we find a vowel, replace it by the char popped from the queue.
 * - Return char array with joinToString.
 */

//endregion

//region Solution

private fun main() {
    // Output: lEOtcede
    sortVowels(s = "lEetcOde")
}

private val vowelSet = setOf('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u')

private fun sortVowels(s: String): String {
    val charQueue = PriorityQueue<Char>(s.length)
    val result = mutableListOf<Char>()

    for (char in s) {
        result.add(char)

        if (char in vowelSet) {
            charQueue.offer(char)
        }
    }

    for (i in result.indices) {
        val char = result[i]

        if (char in vowelSet) {
            result[i] = charQueue.poll()
        }
    }

    return result.joinToString("")
}

//endregion
