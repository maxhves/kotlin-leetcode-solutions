package leetcode.easy

import java.util.*

//region Problem

/**
 * Balanced strings are those that have an equal quantity of `L` and `R` characters.
 *
 * Given a balanced string `s`, split it into some number of substrings such that:
 * - Each substring is balanced.
 *
 * return the maximum number of balanced strings you can obtain.
 */

//endregion

//region Test cases

/**
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 *
 * Input: s = "RLRRRLLRLL"
 * Output: 2
 */

//endregion

//region Solution

private fun main() {
    balancedStringSplitAlternative(s = "RLRRLLRLRL")
    balancedStringSplitAlternative(s = "RLRRRLLRLL")
}

fun balancedStringSplit(s: String): Int {
    var validSubstringCount = 0
    val stack = Stack<Char>()

    for (i in s.indices) {
        val currentChar = s[i]

        if (stack.isEmpty()) {
            stack.push(s[i])
        } else {
            if (currentChar == stack.peek()) {
                stack.push(currentChar)
            } else {
                stack.pop()
                if (stack.isEmpty()) {
                    validSubstringCount++
                }
            }
        }
    }

    return validSubstringCount
}

fun balancedStringSplitAlternative(s: String): Int {
    var rCounter = 0
    var lCounter = 0
    var validSubstring = 0

    for (i in s.indices)  {
        val char = s[i]

        if (char == 'R') {
            rCounter++
        } else {
            lCounter++
        }

        if (rCounter == lCounter) {
            validSubstring++
        }
    }

    return validSubstring
}

//endregion