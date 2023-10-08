package leetcode.easy

//region Problem

/**
 * There are `n` seats and `n` students in a room. You are given an array `seats` of length `n` where
 * `seats[i]` is the position of the `ith` seat. You are also given the array `students` of length `n`,
 * where `students[j]` is the position of the `jth` student.
 *
 * You may perform the following move any number of times:
 *   - Increase or decrease the position of the `ith` student by `1` (i.e., moving the `ith` student
 *     from position `x` to `x + 1` or `x - 1`)
 *
 * Return the minimum number of moves required to move each student to a seat such that no two students
 * are in the same seat.
 */

//endregion

//region Test cases

/**
 * Input: seats = [3,1,5], students = [2,7,4]
 * Output: 4
 *
 * Input: seats = [4,1,5,9], students = [1,3,2,6]
 * Output: 7
 */

//endregion

//region Steps to solve

/**
 * 1. Sort both seats and students.
 * 2. Compare arrays
 *    - Absolute difference between seat[i] and student[i]
 * 3. Add the difference to the moves counter.
 * 4. Return moves.
 */

//endregion

//region Solution

private fun main() {
    minMovesToSeat(seats = intArrayOf(3, 1, 5), students = intArrayOf(2, 7, 4))
    minMovesToSeat(seats = intArrayOf(4, 1, 5, 9), students = intArrayOf(1, 3, 2, 6))
}

private fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
    seats.sort()
    students.sort()

    var moves = 0

    for (i in students.indices) {
        val seat = seats[i]
        val student = students[i]

        moves += Math.abs(seat - student)
    }

    return moves
}

//endregion