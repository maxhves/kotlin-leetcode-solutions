package leetcode.medium

import java.util.PriorityQueue

//region Problem

/**
 * Design a system that manages the reservation state of (n) seats that are numbered from (1) to (n).
 *
 * Implement the (SeatManager) class:
 *  - (SeatManager(int n)) initializes a (SeatManager) object that will manage (n) seats numbered from (1)
 *    to (n). All seats are initially available.
 *  - (int reserve()) Fetches the smallest-numbered unreserved seat, reserves it, and return it's number.
 *  - (void unreserve(int seatNumber)) Un-reserves the seat with the given (seatNumber).
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We could store the seat reservations in a simple IntArray.
 *  - For un-reserving we can simply get the element at (n - 1) and set it to 0.
 *  - For reserving a seat, we need a way to efficiently find the smallest seat number.
 *  - We could use a PriorityQueue.
 */

//endregion

//region Solution

private fun main() {
    val seatManager = SeatManager(n = 5)
    seatManager.reserve()
    seatManager.reserve()
    seatManager.unreserve(seatNumber = 2)
    seatManager.reserve()
    seatManager.reserve()
    seatManager.reserve()
    seatManager.reserve()
    seatManager.unreserve(seatNumber = 5)
}

private class SeatManager(n: Int) {
    val seats = PriorityQueue<Int>()
    var minimumSeat = 1

    fun reserve(): Int {
        return if (seats.size == 0) minimumSeat++ else seats.poll()
    }

    fun unreserve(seatNumber: Int) {
        seats.offer(seatNumber)
    }
}

//endregion
