package leetcode.medium

import kotlin.math.min

//region Problem

/**
 * You are given logs for the users' actions on LeetCode, and an integer (k). The logs are represented by
 * a 2D integer array (logs) where each (logs[i] = [ID i, time i]) indicates that the user with (ID i)
 * performed an action at the minute (time i).
 *
 * Multiple users can perform actions simultaneously, and a single user can perform multiple actions in
 * the same minute.
 *
 * THe user active minutes (UAM) for a given user is defined as the number of unique minutes in which the
 * user performed an action on LeetCode. A minute can only be counted once, even if multiple actions occur
 * during it.
 *
 * You are to calculate a 1-indexed array (answer) of size (k) such that, for each (j) (i <= j <= k),
 * (answer[j]) is the number of users whose UAM equals (j).
 *
 * Return the array (answer) as described above.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - The result is 1-indexed meaning that:
 *    - result[0] = UAM 1, result[1] = UAM 2, etc.
 *
 * 1. Create a hashmap where both key and value are of type int:
 *    - This hashmap will function as a frequency map.
 *    - Key: ID of the user.
 *    - Value: A set of active minutes, to keep track of distinct minutes.
 * 2. Iterate over the (logs) array:
 *    - For each log:
 *      - log[0] is the ID and log[1] is the minute.
 *      - If the ID exists in the array; add the minute to the value set.
 *      - If the ID doesn't exist, create a new entry.
 * 3. Iterate over the hashmap:
 *    - For each item:
 *      - Take the size of the value set.
 *      - Increment the resulting array at size - 1.
 * 4. Return the resulting array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [0, 2, 0, 0, 0]
    findingUsersActiveMinutes(
        logs = arrayOf(
            intArrayOf(0, 5),
            intArrayOf(1, 2),
            intArrayOf(0, 2),
            intArrayOf(0, 5),
            intArrayOf(1, 3),
        ),
        k = 5
    )
}

private fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
    val result = IntArray(k)
    val userFrequencyMap = HashMap<Int, HashSet<Int>>()

    for (log in logs) {
        val id = log[0]
        val minute = log[1]

        userFrequencyMap.computeIfAbsent(id) { HashSet() }.add(minute)
    }

    for (entry in userFrequencyMap.entries) {
        val uam = entry.value.count()
        result[uam - 1] += 1
    }

    return result
}

//endregion
