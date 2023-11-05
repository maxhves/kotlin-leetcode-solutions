package leetcode.medium

//region Problem

/**
 * You are given a string (s) and an integer (k). You can choose any character of the string and change
 * it to any other uppercase English character. You can perform this operation at most (k) times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing
 * the above operations.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We should replace a differing character to get the longest possible substring length.
 *  - The different characters can be at most (k).
 *  - So this means we can have a substring of same characters + an extra (k).
 *  - We could find out what is the longest substring of repeated characters, and take that character.
 *
 * 1. Create a HashMap of type Char, Int to store our window.
 * 2. Initialize some variables:
 *     - left: our pointer to indicate the current start of our window.
 *     - longestSubstring: store the longest currently seen substring.
 * 3. Iterate over the string (s), and for each iteration:
 *     - Place the visited element into our HashMap.
 *     - Evaluate the current state of the HashMap:
 *        - What is the most frequent item in the HashMap; get the max value.
 *        - How many other elements are there other than the most frequent; window size minus max value.
 *        - If the number of "other" elements is smaller than or equal to (k):
 *           - We can update our (longestSubstring) variable (if it is longer).
 *        - If the number of "other" elements exceeds (k):
 *           - We need to make our window smaller to accommodate for new elements.
 *           - While the "other" count is still greater than (k):
 *              - Remove items from the HashMap, this is what our (left) pointer is attached to.
 * 4. Ultimately, return the (longestSubstring) variable.
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    characterReplacement(s = "ABAB", k = 2)

    // Output: 4
    characterReplacement(s = "AABABBA", k = 1)
}

private fun characterReplacement(s: String, k: Int): Int {
    val charFrequencyMap = HashMap<Char, Int>(26)
    var longestValidSubstring = 0
    var maxFrequency = 0
    var left = 0

    for (right in 0..s.lastIndex) {
        val currentChar = s[right]

        charFrequencyMap[currentChar] = charFrequencyMap.getOrDefault(currentChar, 0) + 1

        maxFrequency = maxOf(charFrequencyMap[s[right]] ?: 0, maxFrequency)
        while ((right - left + 1) - maxFrequency > k) {
            charFrequencyMap[s[left]] = charFrequencyMap.getOrDefault(s[left], 1) - 1
            left++
        }
        longestValidSubstring = maxOf(longestValidSubstring, right - left + 1)
    }

    return longestValidSubstring
}

//endregion
