package leetcode.medium

//region Problem

/**
 * You want to water n plants in your garden with a watering can. The plants are arranged in a row and
 * are labeled from 0 to n - 1 from left to right where the ith plant is located at x = i. There is a
 * river at x = -1 that you can refill your watering can at.
 *
 * Each plan needs a specific amount of water. You will water the plants in the following way:
 * - Water the plants in order from left to right.
 * - After watering the current plant, if you do not have enough water to completely water the next
 *   plant, return to the river to fully refill the watering can.
 * - You cannot refill the watering can early.
 *
 * You are initially at the river (i.e., x = -1). It takes one step to move one unit on the x-axis.
 *
 * Given a 0-indexed integer array plants of n integers, where plants[i] is the amount of water the ith
 * plant needs, and an integer capacity representing the watering can capacity, return the number of
 * steps needed to water all the plants.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We can simply iterate over the array of plants.
 * - Check if we can water the next plant.
 *   - If we can, continue.
 *   - If we cannot, go back and fill the watering can (distance from 0 * 2).
 * - Minus the current water needed.
 * - Keep track of how much water is in the watering can.
 * - Keep track of the number of steps we have made.
 * - Ultimately, return the total number of steps.
 */

//endregion

//region Solution

private fun main() {
    // Output: 14
    wateringPlans(
        plants = intArrayOf(2, 2, 3, 3),
        capacity = 5,
    )
}

private fun wateringPlans(plants: IntArray, capacity: Int): Int {
    var totalSteps = 0
    var waterInCan = capacity

    for (i in plants.indices) {
        val plantWaterDemand = plants[i]
        val nextPlantWaterDemand = if (i == plants.lastIndex) 0 else plants[i + 1]

        // Take care of current plant.
        totalSteps++
        waterInCan -= plantWaterDemand

        // Can we do the next plant?
        if (waterInCan < nextPlantWaterDemand) {
            totalSteps += ((i + 1) * 2)
            waterInCan = capacity
        }
    }

    return totalSteps
}

//endregion
