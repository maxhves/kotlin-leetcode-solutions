package leetcode.medium

//region Problem

/**
 * You are playing a video game where you are defending your city from a group of (m) monsters. You are
 * given a 0-indexed integer array (dist) of size (n), where (dist[i]) is the initial distance in kilometers
 * of the (ith) monster from the city.
 *
 * The monsters walk toward the city at a constant speed. The speed of each monster is given to you in an
 * integer array (speed) of size (n), where (speed[i]) is the speed of the (ith) monster in kilometers per
 * minute.
 *
 * You have a weapon that, once fully charged, can eliminate a single monster. However, the weapon takes
 * one minute to charge. The weapon is fully charged at the very start.
 *
 * You lose when any monster reaches your city. If a monster reaches the city at the exact moment the
 * weapon is fully charged, it counts as a loss, and the game ends before you can use your weapon.
 *
 * Return the maximum number of monsters that you can eliminate before you lose, or (n) if you can
 * eliminate all the monsters before they reach the city.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - Each minute that ticks, we can eliminate a single monster.
 *  - This is providing that the monster has still not reached the city.
 *  - The monster has a distance from the city and a speed.
 *  - Each minute will act like an iteration in a loop.
 *  - Limited to the number of monsters because we can eliminate one per minute.
 *  - For i in 0 upTo n (the number of monsters).
 *     - Eliminate a monster.
 *     - Decrement the monsters distance to the city by its speed.
 *     - If the monsters distance exceeds or is equal to 0:
 *        - We lose.
 *     - Else if we complete the loop, we have won.
 *
 * 1. Initialize some variables:
 *     - (eliminationCount): Int at 0.
 * 2. Iterate from 0 upTo (dists.lasIndex):
 *     - Increment (eliminationCount).
 *     - Set the min value index of (dists) to 0. (we eliminate the monster).
 *     - Iterate over the (dists) array:
 *        - If an item greater than 0, decrement it by its (speed) counterpart.
 *        - If when decrementing the value will be less than or equal to 0:
 *           - We lose.
 *        - Otherwise continue with the decrement.
 * 3. Ultimately if we've made it this far, return (eliminationCount).
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    eliminateMaximum(
        dist = intArrayOf(1, 3, 4),
        speed = intArrayOf(1, 1, 1),
    )

    // Output: 1
    eliminateMaximum(
        dist = intArrayOf(3, 2, 4),
        speed = intArrayOf(5, 3, 2)
    )

    // Output: 1
    eliminateMaximum(
        dist = intArrayOf(1, 1, 2, 3),
        speed = intArrayOf(1, 1, 1, 1),
    )
}

private fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
    val monsterCount = dist.size
    val timesToArrive = DoubleArray(monsterCount)

    for (i in 0 until monsterCount) {
        timesToArrive[i] = dist[i].toDouble() / speed[i]
    }

    timesToArrive.sort()

    for (i in 0 until monsterCount) {
        if (i.toDouble() >= timesToArrive[i]) {
            return i
        }
    }

    return monsterCount
}

//endregion
