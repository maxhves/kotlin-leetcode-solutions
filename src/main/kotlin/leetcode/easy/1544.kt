package leetcode.easy

import java.util.*

//region Problem

/**
 * Given a string s of lower and upper case English letters.
 *
 * A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
 * - 0 <= i <= s.length - 2
 * - s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
 *
 * To make the string good, you can choose two adjacent characters that make the string bad and remove
 * them. You can keep doing this until the string becomes good.
 *
 * Return the string after making it good. The answer is guaranteed to be unique under the given
 * constraints.
 *
 * Notice that an empty string is also good.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * -
 */

//endregion

//region Solution

private fun main() {
    // Output: "leetcode"
    makeGood(s = "leEeetcode")

    // Output: ""
    makeGood(s = "abBAcC")
}

private fun makeGood(s: String): String {
    val stack = Stack<Char>()

    for (i in s.indices) {
        val char = s[i]

        if (stack.isEmpty()) {
            stack.push(char)
        } else {
            val previousChar = stack.peek()

            if (
                previousChar.equals(char, true) &&
                (char.isUpperCase() && previousChar.isLowerCase() || previousChar.isUpperCase() && char.isLowerCase())
            ) {
                stack.pop()
            } else {
                stack.push(char)
            }
        }
    }

    return stack.joinToString("")
}

//endregion
