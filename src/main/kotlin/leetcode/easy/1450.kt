package leetcode.easy

//region Problem

/**
 * Given two integer arrays (startTime) and (endTime) and given an integer (queryTime).
 *
 * The (ith) student started doing their homework at the time (startTime[i]) and finished it at time
 * (endTime[i]).
 *
 * Return the number of students doing their homework at time (queryTime). More formally, return the
 * number of students where (queryTime) lays in the interval ([startTime[i], endTime[i]]) inclusive.
 */

//endregion

//region Steps to solve

/**
 * 1. startTime and endTime are of equal length, therefore, we can iterate over both at the same time:
 * 2. For each "pair" we can check the following:
 *    - Is the startTime equal to queryTime?
 *      - Yes: increase result count.
 *      - No: continue to next condition.
 *    - Is the endTime greater than the queryTime?
 *      - Yes: increase the result count.
 * 4. Return the eventual count.
 */

//endregion

//region Solution

private fun main() {
    // Output: 1
    busyStudent(
        startTime = intArrayOf(1, 2, 3),
        endTime = intArrayOf(3, 2, 7),
        queryTime = 4,
    )

    // Output: 1
    busyStudent(
        startTime = intArrayOf(4),
        endTime = intArrayOf(4),
        queryTime = 4,
    )
}

private fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
    var busyStudents = 0

    for (i in startTime.indices) {
        val studentStartTime = startTime[i]
        val studentEndTime = endTime[i]

        if (queryTime in studentStartTime..studentEndTime) {
            busyStudents++
        }
    }

    return busyStudents
}

//endregion
