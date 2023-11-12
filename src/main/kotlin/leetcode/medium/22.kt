package leetcode.medium

import java.util.*

//region Problem

/**
 * Given (n) pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - We could use a Stack structure, but how?
 * - We are given a number of how many pairs of parentheses we must generate combinations for.
 * - Well formed parentheses are parentheses that have a matching start and end.
 * - We can only add closing parentheses whilst the number of closed parentheses is smaller than the
 *   open ones.
 *
 * Steps:
 * -
 */

//endregion

//region Solution

private fun main() {
    // Output: ["((()))","(()())","(())()","()(())","()()()"]
    generateParenthesis(n = 3)

    // Output: ["()"]
    generateParenthesis(n = 1)
}

private fun generateParenthesis(n: Int): List<String> {
    val stack = Stack<String>()
    val result = mutableListOf<String>()

    fun backtrack(openCount: Int, closedCount: Int) {
        if (openCount == n && closedCount == n) {
            result.add(stack.joinToString(""))
            return
        }

        if (openCount < n) {
            stack.add("(")
            backtrack(openCount + 1, closedCount)
            stack.pop()
        }

        if (closedCount < openCount) {
            stack.add(")")
            backtrack(openCount, closedCount + 1)
            stack.pop()
        }
    }

    backtrack(0, 0)

    return result
}

//endregion
