package leetcode.easy

//region Problem

/**
 * You are given a string (s) of even length. Split this string into halves of equal lengths and let (a)
 * be the first half and (b) be the second half.
 *
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I',
 * 'O', 'U'). Notice that (s) contains uppercase and lowercase letters.
 *
 * Return (true) if (a) and (b) are alike. Otherwise return (false).
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialize a set with vowels in it.
 * - Find the midpoint (start + end) / 2.
 * - Initialize two variables (aVowels) and (bVowels).
 * - Iterate over the string (s):
 *   - We need to check if the character is in the vowel set.
 *   - If we are before the midpoint, increment (aVowels) by 1.
 *   - Else, increment (bVowels) by 1.
 * - Ultimately return whether (aVowels) and (bVowels) are correct.
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    halvesAreAlike(s = "book")

    // Output: false
    halvesAreAlike(s = "textbook")
}

private fun halvesAreAlike(s: String): Boolean {
    val vowels = hashSetOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    val midpoint = (0 + s.length) / 2
    var aVowelCount = 0
    var bVowelCount = 0

    for (i in s.indices) {
        if (s[i] in vowels) {
            if (i + 1 <= midpoint) {
                aVowelCount++
            } else {
                bVowelCount++
            }
        }
    }

    return aVowelCount == bVowelCount
}

//endregion
