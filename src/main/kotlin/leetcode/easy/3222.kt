package leetcode.easy

//region Problem

/**
 * You are given two positive integers 'x' and 'y', denoting the number of coins with values 75 and 10 respectively.
 *
 * Alice and Bob are playing a game. Each turn, starting with Alice, the player must pick up coins with a total value
 * of 115. If the player is unable to do so, they lose the game.
 *
 * Return the name of the player who wins the game if both players play optimally.
 */

//endregion

//region Steps to solve

/**
 * - Keep track of the number of 'x' coins, 'y' coins and the coin sum total.
 * - Create a loop whilst the coin total sum is greater than 115.
 * - Each iteration we make an optimal turn by prioritizing the 75 coins and then the 10 coins.
 * - If we are able to create 115, then we add 1 to a 'numberOfTurns' property.
 * - Return "Alice" if the number of turns are odd, else "Bob".
 */

//endregion

//region Solution

private fun main() {
    // Output: "Alice"
    losingPlayer(x = 1, y = 4)

    // Output: "Alice"
    losingPlayer(x = 2, y = 7)

    // Output: "Bob"
    losingPlayer(x = 4, y = 11)
}

private const val MIN_COINS_VALUE_10 = 4
private const val MIN_COINS_VALUE_75 = 1
private val PLAYERS = arrayOf("Bob", "Alice")

private fun losingPlayer(x: Int, y: Int): String {
    val maxCompleteTurnsValue75 = x / MIN_COINS_VALUE_75
    val maxCompleteTurnsValue10 = y / MIN_COINS_VALUE_10
    val numberOfTurns = minOf(maxCompleteTurnsValue75, maxCompleteTurnsValue10)

    return PLAYERS[numberOfTurns % 2]
}

//endregion
