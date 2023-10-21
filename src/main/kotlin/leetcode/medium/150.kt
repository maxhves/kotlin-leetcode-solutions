package leetcode.medium

import java.util.*

//region Problem

/**
 * You are given an array of strings (tokens) that represents an arithmetic expression in a Reverse Polish
 * Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *  - The valid operators are (+), (-), (*) and (/).
 *  - Each operand may be an integer or another expression.
 *  - The division between two integers always truncates toward 0.
 *  - There will not be any division by zero.
 *  - The input represents a valid arithmetic expression in a reverse polish notation.
 *  - The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */

//endregion

//region Steps to solve

/**
 * 1. Add Each digit to a stack.
 * 2. When we reach a non-digit, then apply the operation to the last two items in the stack.
 * 3. Keep repeating this procedure until the end.
 * 4. Return the final result.
 */

//endregion

//region Solution

private fun main() {
    // Output: 9
    evalRPN(tokens = arrayOf("2", "1", "+", "3", "*"))

    // Output: 6
    evalRPN(tokens = arrayOf("4", "13", "5", "/", "+"))
}

private fun evalRPN(tokens: Array<String>): Int {
    val stack = Stack<Int>()

    fun getItemsForOperation(): Pair<Int, Int> {
        return stack.pop() to stack.pop()
    }

    for (token in tokens) {
        when (token) {
            "+" -> {
                val items = getItemsForOperation()
                stack.push(items.second + items.first)
            }
            "-" -> {
                val items = getItemsForOperation()
                stack.push(items.second - items.first)
            }
            "*" -> {
                val items = getItemsForOperation()
                stack.push(items.second * items.first)
            }
            "/" -> {
                val items = getItemsForOperation()
                stack.push(items.second / items.first)
            }
            else -> {
                stack.push(token.toInt())
            }
        }
    }

    return stack.peek()
}

//endregion
