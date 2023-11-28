package leetcode.hard

//region Problem

/**
 * Along a long library corridor, there is a line of seats and decorative plants. You are given a
 * 0-indexed string (corridor) of length (n) consisting of letters ('S') and ('P') where each ('S')
 * represents a seat and each ('P') represents a plant.
 *
 * One room divider has already been installed to the left of index (0), and another to the right of
 * index (n - 1). Additional room dividers can be installed. For each position between (i - 1) and (i)
 * (1 <= i <= n - 1), at most one divider can be installed.
 *
 * Divide the corridor into non-overlapping sections, where each section has exactly two seats with any
 * number of plants. There may be multiple ways to perform the division. Two ways are different if there
 * is a position with a room divider installed in the first way but not in the second way.
 *
 * Return the number of ways to divide the corridor. Since the answer may be very large, return it
 * modulo (10^9 + 7). If there is no way, return (0).
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - We can place a divider in between the current position and the previous position.
 * - We can only ever install one single divider, no more.
 * - Each section must have exactly two seats.
 *   - Two seats on each side of the divider we place.
 * - Any number of plants can be present on either side of the divider.
 * - We can count how many sections there are in the array.
 * - We can also count how many plants are between the sections.
 * - For example, two plants between the segments means three dividers could have been placed.
 * - If there aren't two seats, we can return 0.
 * - If there are exactly and only two seats, we can return 1.
 */

//endregion

//region Solution

private fun main() {
    // Output: 8
    numberOfWays(corridor = "SSPSSPSSSPPSPSPPS")

    // Output: 3
    numberOfWays(corridor = "SSPPSPS")
}

private fun numberOfWays(corridor: String): Int {
    var seatsCount = 0
    var ways = 1
    var plantsBetweenSeats = 0

    for (furniture in corridor) {
        if (furniture == 'S') {
            seatsCount++
            if (seatsCount > 2 && seatsCount % 2 == 0) {
                ways *= plantsBetweenSeats + 1
                plantsBetweenSeats = 0
            }
        } else if (seatsCount >= 2 && seatsCount % 2 == 1) {
            plantsBetweenSeats++
        }
    }

    return if (seatsCount < 2 || seatsCount % 2 != 0) 0 else ways
}

//endregion
