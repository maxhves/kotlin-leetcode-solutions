package leetcode.easy

//region Problem

/**
 * There are `n` rings and each ring is either red green or blue. The rings are distributed across
 * ten rods labeled from `0` to `9`.
 *
 * You are given a string `rings` of length `2n` that describes the `n` rings that are placed onto the rods.
 * Every two characters in `rings` forms a color-position pair that is used to describe each ring where:
 *  - The first character of the `ith` pair denotes the `ith` ring's color (`R`, `G`, `B`).
 *  - The second character of the `ith` pair denotes the rod that the `ith` ring is placed on (`0`, to `9`).
 *
 *  For example `"R3G2B1"` describes `n == 3` rings: a red ring placed onto the rod labeled 3, a green
 *  ring placed onto the rod labeled 2, and a blue ring placed onto the rod labeled 1.
 *
 *  Return the number of rods that have all three colors of rings on them.
 */

//endregion

//region Steps to solve

/**
 * 1. Split after every R/G/B char.
 * 2. Store in HashMap.
 *    - The key will be the rod.
 * 3. Return how many keys contain R, G and B.
 */

//endregion

//region Solution

private fun main() {
    // Output: 1
    countPoints(rings = "B0B6G0R6R0R6G9")

    // Output 1
    countPoints(rings = "B0R0G0R9R0B0G0")

    // Output: 0
    countPoints(rings = "G4")
}

private fun countPoints(rings: String): Int {
    val rodHashMap = HashMap<Int, CharArray>()

    for (i in 1..rings.lastIndex step 2) {
        val color = rings[i - 1]
        val rod = rings[i].digitToInt()

        val existingElement = rodHashMap.getOrDefault(rod, charArrayOf())
        if (existingElement.isNotEmpty()) {
            if (!existingElement.contains(color)) {
                rodHashMap[rod] = existingElement + color
            }
        } else {
            rodHashMap[rod] = charArrayOf(color)
        }
    }

    return rodHashMap.count { it.value.size == 3 }
}

//endregion