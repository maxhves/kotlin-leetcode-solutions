package leetcode.easy

//region Problem

/**
 * There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line
 * and the (n - 1)th person is at the back of the line.
 *
 * You are given a 0-indexed integer array tickets of length n where the number of tickets that the ith
 * person would like to buy is tickets[i].
 *
 * Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has
 * to go back to the end of the line (which happens instantaneously) in order to buy more tickets. If a
 * person does not have any tickets left to buy, the person will leave the line.
 *
 * Return the time taken for the person at position k (0-indexed) to finish buying tickets.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: 6
    timeRequiredToBuy(tickets = intArrayOf(2, 3, 2), k = 2)

    // Output: 8
    timeRequiredToBuy(tickets = intArrayOf(5, 1, 1, 1), k = 0)
}

private fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
    var secondsPassed = 0

    while (tickets[k] > 0) {
        // Do a single pass of the line
        for (i in tickets.indices) {
            val ticketer = tickets[i]

            if (ticketer > 0) {
                tickets[i] -= 1
                secondsPassed++

                if (i == k && tickets[k] == 0) {
                    break
                }
            }
        }
    }


    return secondsPassed
}

//endregion
