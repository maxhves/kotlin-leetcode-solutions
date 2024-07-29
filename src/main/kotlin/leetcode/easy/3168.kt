package leetcode.easy

import java.util.Stack

//region Problem

/**
 * You are given a string 's'. Simulate events at each second 'i':
 * - If 's[i] == 'E'', a person enters the waiting room and takes oen of the charis in it.
 * - If 's[i] == 'L'', a person leaves the waiting room, freeing up a chair.
 *
 * Return the minimum number of chairs needed so that a chair is available for every person who enters the
 * waiting room given that it is initially empty.
 */

//endregion

//region Steps to solve

/**
 * - Iterate over each char.
 * - If the char is an 'E', push this to a stack.
 * - Else pop from the stack.
 * - Keep track of the maxiumum stack size.
 * - Return the maximum stack size value.
 */

//endregion

//region Solution

private fun main() {
    // Output: 7
    minimumChairs(s = "EEEEEEE")

    // Output: 2
    minimumChairs(s = "ELELEEL")
}

private fun minimumChairs(s: String): Int {
    val chairStack = Stack<Char>()
    var minimumChairsRequired = 0

    for (char in s) {
        if (char == 'E') {
            chairStack.push(char)
        } else {
            chairStack.pop()
        }

        minimumChairsRequired = maxOf(minimumChairsRequired, chairStack.size)
    }

    return minimumChairsRequired
}

//endregion
