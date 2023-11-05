package leetcode.medium

//region Problem

/**
 * Given an integer array (arr) of distinct integers and an integer (k).
 *
 * A game will be played between the first two elements of the array (i.e. (arr[0]) and (arr[1])). In
 * each round of the game, we compare (arr[0]) with (arr[1]), the larger integer wins and remains at
 * position (0), and the smaller integer moves to the end of the array. The game ends when an integer
 * wins (k) consecutive rounds.
 *
 * Return the integer which will win the game.
 *
 * It is guaranteed that there will be a winner of the game.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We need to find the "integer" that "wins" (k) times.
 *  - We can keep a frequency map of integers.
 *
 * 1. Initialize a HashMap<Int, Int>:
 *     - Key: Int, the winner.
 *     - Value: Int, how many times the Key has won.
 * 2. Initialize an arrayListOf(arr) (currentRound).
 * 3. Initialize a (winner) variable starting at -1.
 * 4. Whilst (winner) is equal to -1:
 *     - Take (currentRound[0]) and compare is to (currentRound[1]).
 *     - If (currentRound[0]) is greater than (currentRound[1]):
 *        - Remove (currentRound[1]) from (currentRound).
 *        - Add it to the end of the array.
 *     - If (currentRound[1]) is greater than (currentRound[0]):
 *       - Remove (currentRound[0]) from (currentRound).
 *       - Add it to the end of the array.
 *     - In each case add the winner to (or increase its value) in the HashMap.
 *     - If the winner's win count is now equal to (k); return its key.
 * 5. This function will run until there is a winner; and we return (winner).
 */

//endregion

//region Solution

private fun main() {
    // Output: 5
    getWinner(arr = intArrayOf(2, 1, 3, 5, 4, 6, 7), k = 2)
}

private fun getWinner(arr: IntArray, k: Int): Int {
    var maxElement = arr[0]
    var count = 0

    for (i in 1 .. arr.lastIndex) {
        val currentElement = arr[i]

        if (maxElement < currentElement) {
            maxElement = currentElement
            count = 0
        }
        count++

        if (count == k) {
            break
        }
    }

    return maxElement
}

//endregion
