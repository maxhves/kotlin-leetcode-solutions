package hackerrank.medium

import java.util.*

fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
    // Get list of unique items (no duplicates)
    val scores = ranked.distinct()

    // Create a map
    val newScores = player.map {
        // Search the existing scores for the new score
        val result = scores.binarySearch(it, reverseOrder())

        // If we don't find the score then -1 from the result
        // Else if we find it then + 1
        // -1 is a higher score and +1 is a lower score
        if (result < 0) -result else result + 1
    }

    return newScores.toTypedArray()
}

fun main(args: Array<String>) {
    val rankedCount = readLine()!!.trim().toInt()

    val ranked = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val playerCount = readLine()!!.trim().toInt()

    val player = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = climbingLeaderboard(ranked, player)

    println(result.joinToString("\n"))
}