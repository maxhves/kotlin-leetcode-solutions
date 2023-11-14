package leetcode.medium

//region Problem

/**
 * Given a string (s), return the number of unique palindromes of length three that are a subsequence of
 * (s).
 *
 * Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
 *
 * A palindrome is a string that reads the same forwards and backwards.
 *
 * A subsequence of a string is a new string generated from the original string with some characters
 * (can be none) deleted without changing the relative order of the remaining characters.
 * - For examples, ("ace") is a subsequence of ("abcde").
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - We are to find subsequences that are palindromes, they can be in any order and from any part of the
 *   string.
 * - The characters however, must be in relative order, we cannot change them around.
 * - The middle character can be any character.
 * - The left and right character must be the same.
 *
 * Steps:
 * -
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    countPalindromicSubsequence(s = "aabca")
}

private fun countPalindromicSubsequence(s: String): Int {
    val result = HashSet<Pair<Char, Char>>()
    val left = HashSet<Char>()
    val right = HashMap<Char, Int>()

    for (i in s.indices) {
        val char = s[i]
        right[char] = right.getOrDefault(char, 0) + 1
    }

    for (i in s.indices) {
        val char = s[i]

        right[char] = right[char]!! - 1

        if (right[char] == 0) {
            right.remove(char)
        }

        for (j in 0 until 26) {
            val alphabetChar = 'a' + j

            if (alphabetChar in left && alphabetChar in right) {
                result.add(char to alphabetChar)
            }
        }

        left.add(char)
    }

    return result.size
}

//endregion
