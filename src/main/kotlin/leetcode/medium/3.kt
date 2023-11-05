package leetcode.medium

//region Problem

/**
 * Given a string (s), find the length of the longest substring without repeating characters.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We need to keep track of the current sub-array window.
 *  - We need to use a variable size sliding window solution.
 *
 * 1. Initialize a (HashSet) of type (Char).
 * 2. Create a (left) pointer; at value (0).
 * 3. Create a (longestSubstring) variable.
 * 4. Iterate over the string (s).
 * 5. For each (char) in (s):
 *    - Create a while loop; whilst the current char s in our (HashSet):
 *       - Remove the (left) char from the set.
 *       - Increase the (left) pointer.
 *    - Add the current char to our set.
 *    - Do a max comparison between the current window size and the longest so far.
 * 6. Ultimately return the (longestSubstring) property.
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    lengthOfLongestSubstring(s = "aab")

    // Output: 3
    lengthOfLongestSubstring(s = "abcabcbb")

    // Output: 1
    lengthOfLongestSubstring(s = "bbbbb")

    // Output: 3
    lengthOfLongestSubstring(s = "pwwkew")
}

private fun lengthOfLongestSubstring(s: String): Int {
    val charSet = HashSet<Char>(s.length)
    var left = 0
    var longestSubstring = 0

    for (right in 0 .. s.lastIndex) {
        while (s[right] in charSet) {
            charSet.remove(s[left])
            left++
        }

        charSet.add(s[right])
        longestSubstring = maxOf(longestSubstring, right - left + 1)
    }

    return longestSubstring
}

//endregion
