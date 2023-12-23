package leetcode.easy

//region Problem

/**
 * Given a string (path), where (path[i] = 'N'), ('S'), ('E') or ('W'), each representing moving one
 * unit north, south, east or west, respectively. You start at the origin (0, 0) on a 2D plane and walk
 * on the path specified by (path).
 *
 * Return (true) if the path crosses itself at any point, that is, if at any time you are on a location
 * you have previously visited. Return (false) otherwise.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialize two variables:
 *   - (x), set to 0.
 *   - (y), set to 0.
 *   - (coordSet), set to a set of Pair<Int, Int>.
 * - Iterate over the string (path) and for each character (char):
 *   - If (char) is equal to:
 *     - ('N'); decrease (y) by 1.
 *     - ('E'); increase (x) by 1.
 *     - ('S'); increase (y) by 1.
 *     - ('W'); decrease (x) by 1.
 *   - After each movement, check if we have crossed our existing path:
 *     - Check if new (x) and (y) coordinate pair exist in (coordSet).
 *     - If it exists; return (true) now.
 *     - Add (x to y) into (coordSet).
 * - Ultimately, return (false).
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    isPathCrossing(path = "NESWW")
}

private fun isPathCrossing(path: String): Boolean {
    var x = 0
    var y = 0
    val coordinateSet: MutableSet<Pair<Int, Int>> = mutableSetOf(x to y)

    for (move in path) {
        when (move) {
            'N' -> y--
            'E' -> x++
            'S' -> y++
            'W' -> x--
        }

        val newCoordinate = x to y

        if (newCoordinate in coordinateSet) {
            return true
        }

        coordinateSet.add(newCoordinate)
    }

    return false
}

//endregion
