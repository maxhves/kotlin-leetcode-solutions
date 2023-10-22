package leetcode.medium

import java.util.*

//region Problem

/**
 * There are n cars going to the same destination along a one-lane road. The destination is target
 * miles away.
 *
 * You are given two integer array position and speed, both of length n, where position[i] is the
 * position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
 *
 * A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper
 * at the same speed. The faster car will slow down to match the slower car's speed. The distance between
 * these two cars is ignored (i.e., they are assumed to have the same position).
 *
 * A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a
 * single car is also a car fleet.
 *
 * If a car catches up to a car fleet right at the destination point, it will still be considered as
 * one car fleet.
 *
 * Return the number of car fleets that will arrive at the destination.
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    carFleet(target = 12, position = intArrayOf(10, 8, 0, 5, 3), speed = intArrayOf(2, 4, 1, 1, 3))

    // Output: 1
    carFleet(target = 10, position = intArrayOf(3), speed = intArrayOf(3))

    // Output: 1
    carFleet(target = 100, position = intArrayOf(0, 2, 4), speed = intArrayOf(4, 2, 1))
}

private fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
    val positionSpeedPairs = position.zip(speed).sortedByDescending { it.first }
    val carStack = Stack<Double>()

    for (car in positionSpeedPairs) {
        val timeToReachTarget = (target - car.first.toDouble()) / car.second.toDouble()

        if (carStack.isEmpty() || timeToReachTarget > carStack.peek()) {
            carStack.push(timeToReachTarget)
        }
    }

    return carStack.size
}

//endregion
