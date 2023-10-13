package leetcode.easy

//region Problem

/**
 * You are given a 0-indexed array `words` consisting of distinct strings.
 *
 * The string `words[i]` can be paired with the string `words[j]` if:
 *  - The string `words[i]` is equal to the reversed string of `words[j]`.
 *  - `0 <= i < j < words.length`.
 *
 *  Return the maximum number of pairs that can be formed from the array `words`.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the array of words:
 *    - Use an outer loop, i.
 *    - Use an inner loop, j.
 * 2. Compare inner and outer loops:
 *    - If strings exactly match, increase pair count.
 *    - If strings match in reverse, increase pair count.
 * 3. Return the pair count.
 *
 * Improved version:
 * 1. Create a HashSet<String>().
 * 2. Iterate over the words array.
 * 3. Check if the hashset contains the word:
 *    - If yes, increment the pair count.
 *    - If no, add the word to the hashset.
 * 4. Return the pair count.
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    maximumNumberOfStringPairs(words = arrayOf("cd", "ac", "dc", "ca", "zz"))

    // Output: 1
    maximumNumberOfStringPairs(words = arrayOf("ab", "ba", "cc"))

    // Output: 0
    maximumNumberOfStringPairs(words = arrayOf("aa", "ab"))
}

private fun maximumNumberOfStringPairs(words: Array<String>): Int {
    val hashSet = HashSet<String>()
    var pairs = 0

    for (word in words) {
        if (hashSet.contains(word) || hashSet.contains(word.reversed())) {
            pairs++
        } else {
            hashSet.add(word)
        }
    }

    return pairs
}

//endregion