package leetcode.easy

import java.util.*

//region Problem

/**
 * You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you
 * start with an empty record.
 *
 * You are given a list of strings (operations), where (operations[i]) is the (ith) operation you must
 * apply to the record and is one of the following:
 *
 *  - An integer (x): Record a new score of (x).
 *  - A plus (+): Record a new score that is the sum of the previous two scores.
 *  - ('D'): Record a new score that is the double of the previous score.
 *  - ('C'): Invalidate the previous score, removing it from the record.
 *
 * Return the sum of all the scores on the record after applying all the operations.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We are starting from 0.
 *  - Stack?
 *
 *  1. Initialize a new Stack of type integer.
 *  2. Iterate over the (operations) array:
 *     - 'X' -> push the integer.
 *     - '+' -> pop previous two, sum them, push result.
 *     - 'D' -> peek, double, push.
 *     - 'C' -> pop.
 *  3. Return the resulting score.
 */

//endregion

//region Solution

private fun main() {
    // Output: 30
    calPoints(operations = arrayOf("5", "2", "C", "D", "+"))

    // Output: 27
    calPoints(operations = arrayOf("5", "-2", "4", "C", "D", "9", "+", "+"))

    // Output: 0
    calPoints(operations = arrayOf("1", "C"))
}

private fun calPoints(operations: Array<String>): Int {
    val pointsStack = Stack<Int>()
    var score = 0

    for (operation in operations) {
        when (operation) {
            "D" -> {
                val newScore = pointsStack.peek() * 2
                score += newScore
                pointsStack.push(newScore)
            }
            "C" -> {
                val scoreToRemove = pointsStack.pop()
                score -= scoreToRemove
            }
            "+" -> {
                val first = pointsStack.pop()
                val second = pointsStack.pop()
                val newScore = first + second

                pointsStack.push(second)
                pointsStack.push(first)
                pointsStack.push(newScore)

                score += newScore
            }
            else -> {
                val newScore = operation.toIntOrNull() ?: 0
                pointsStack.push(newScore)
                score += newScore
            }
        }
    }

    return score
}

//endregion
