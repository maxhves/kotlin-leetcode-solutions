package leetcode.easy

import java.util.*

//region Problem

/**
 * A valid parentheses string is either empty `""`, `"(" + A + ")"`, or `A + B`, where `A` and `B`
 * are valid parentheses strings, and `+` represents string concatenation.
 *  - For example, `""`, `"()"`, `"(())()"` and `(()(()))"` are all valid parentheses strings.
 *
 * A valid parentheses string `s` is primitive if it is nonempty, and there does not exist a way to split
 * it into `s = A + B`, with `A` and `B` nonempty valid parentheses strings.
 *
 * Given a valid parentheses string `s` consider it's primitive decomposition: `s = P1 + P2 + ... + PK`
 * where `Pi` are primitive valid parentheses strings.
 *
 * Return `s` after removing the outermost parentheses of ever primitive string in the primitive
 * decomposition of `s`.
 */

//endregion

//region Test cases

/**
 * Input: s = "(()())(())"
 * Output: "()()()"
 *
 * Input: s = "(()())(())(()(()))"
 * Output: "()()()()(())"
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the string.
 * 2. Remove same parentheses that are next to each other.
 * 3. Return the resulting string.
 */

//endregion

//region Solution

private fun main() {
    println(removeOuterParentheses(s = "(()())(())"))
    println(removeOuterParentheses(s = "(()())(())(()(()))"))
}

private fun removeOuterParentheses(s: String): String {
    val result = StringBuilder()
    var balance = 0

    for (char in s) {
        if (char == '(' && balance++ > 0) {
            result.append(char)
        }

        if (char == ')' && balance-- > 1) {
            result.append(char)
        }
    }

    return result.toString()
}

//endregion