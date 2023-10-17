package leetcode.easy

import java.util.*

//region Problem

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine
 * if the input string is valid.
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    isValid(s = "{[]}")

    // Output: true
    isValid(s = "()")

    // Output: true
    isValid(s = "()[]{}")

    // Output: false
    isValid(s = "(]")
}

private fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    val matchMap = mapOf(
        ')' to '(',
        '}' to '{',
        ']' to '[',
    )

    for (char in s) {
        if (stack.isEmpty()) {
            stack.push(char)
        } else {
            if (matchMap.containsKey(char)) {
                if (matchMap[char] == stack.peek()) {
                    stack.pop()
                } else {
                    stack.push(char)
                }
            } else {
                stack.push(char)
            }
        }
    }

    return stack.isEmpty()
}

//endregion