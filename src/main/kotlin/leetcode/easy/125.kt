package leetcode.easy

//region Problem

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
 * all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters
 * include letters and numbers.
 *
 * Given a string (s), return (true) if it is a palindrome, or (false) otherwise.
 */

//endregion

//region Steps to solve

/**
 * 1. Make sure that we only read alphanumeric characters.
 * 2. Initialize two variable pointers:
 *    - Left: 0.
 *    - Right: s.lastIndex.
 * 3. Run a loop for while left is smaller than right:
 *    - If left and right are alphanumeric:
 *      - Compare if s[left] and s[right] are equal:
 *        - If yes, continue, increase left and decrease right.
 *        - If no, break, this is not a palindrome.
 * 4. If left or right is not alphanumeric:
 *    - Increase left by one (if left).
 *    - Decrease right by one (if right).
 *    - Continue comparison.
 * 5. Return true if we reach this point.
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    isPalindrome(s = "A man, a plan, a canal: Panama")

    // Output: false
    isPalindrome(s = "race a car")

    // Output: true
    isPalindrome(s = " ")
}

private fun isPalindrome(s: String): Boolean {
    if (s.isEmpty()) return true

    var left = 0
    var right = s.lastIndex

    while(left < right) {
        val leftChar = s[left].lowercaseChar()
        val rightChar = s[right].lowercaseChar()

        if (!leftChar.isLetterOrDigit()) {
            left++
        } else if (!rightChar.isLetterOrDigit()) {
            right--
        } else if (leftChar == rightChar) {
            left++
            right--
        } else {
            return false
        }
    }

    return true
}

//endregion
