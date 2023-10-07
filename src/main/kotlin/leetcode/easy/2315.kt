package leetcode.easy

import java.util.Stack

//region Problem

/**
 * You are given a string `s`, where every two consecutive vertical bars `|` are grouped into a pair.
 * In other words, the 1st and 2nd `|` make a pair, the 3rd and 4th `|` make a pair, and so forth.
 *
 * Return the number of `*` in `s`, excluding the `*` between each pair of `|`.
 */

//endregion

//region Test cases

/**
 * Input: s = "l|*e*et|c**o|*de|"
 * Output: 2
 *
 * Input: s = "iamprogrammer"
 * Output: 0
 */

//endregion

//region Steps to solve

/**
 * 1. Locate a matching pair.
 *    - Keep track of the matches using a Stack.
 * 2. When a pair is found, and we are outside a pair, we can count the asterisks.
 * 3. Return the result.
 */

//endregion

//region Solution

private fun main() {
    countAsterisks(s = "l|*e*et|c**o|*de|")
    countAsterisks(s = "iamprogrammer")
}

private fun countAsterisks(s: String): Int {
    val matchingPairStack: Stack<Char> = Stack()
    var result = 0

    for (char in s) {
        when (char) {
            '|' -> {
                if (matchingPairStack.isEmpty()) {
                    matchingPairStack.push(char)
                } else {
                    matchingPairStack.pop()
                }
            }
            '*' -> {
                if (matchingPairStack.isEmpty()) {
                    result ++
                }
            }
        }
    }

    return result
}

//endregion