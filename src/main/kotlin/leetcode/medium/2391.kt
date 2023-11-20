package leetcode.medium

//region Problem

/**
 * You are given a 0-indexed array of string (garbage) where (garbage[i]) represents the assortment of
 * garbage at the (ith) house. (garbage[i]) consists only of the characters ('M'), ('P') and ('G')
 * representing one unit of metal, paper and glass garbage respectively. Picking up one unit of any
 * type of garbage takes (1) minute.
 *
 * You are also given a 0-indexed integer array (travel) where (travel[i]) is the number of minutes
 * needed to go from house (i) to house (i + 1).
 *
 * There are three garbage trucks in the city, each responsible for picking up one type of garbage. Each
 * garbage truck starts at house (0) and must visit each house in order, however, they do not need to visit
 * every house.
 *
 * Only one garbage truck may be used at any given moment. While one truck is driving or picking up
 * garbage, the other two trucks cannot do anything.
 *
 * Return the minimum number of minutes needed to pick up all the garbage.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - Each house has a time taken to get there, and the trucks must visit each one so long as
 *   there is something to collect, if there is nothing else, they can leave "early".
 * - We need to know at what point the trucks can leave their route (if they join at all).
 * - Using a prefix sum we can work out the time taken at each index.
 * - At each house we can update a "last" seen index of where we last picked up a given garbage type.
 * - We can also keep track of the number of pickups for a given garbage type.
 */

//endregion

//region Solution

private fun main() {
    // Output: 21
    garbageCollection(
        garbage = arrayOf("G", "P", "GP", "GG"),
        travel = intArrayOf(2, 4, 3),
    )
}

private fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
    var timeTaken = 0

    // Key: Garbage type
    // Value: Last picked up at household number : Total pickups for garbage type.
    val garbagePickups = hashMapOf(
        'M' to (0 to 0),
        'P' to (0 to 0),
        'G' to (0 to 0),
    )

    // Create a prefix sum of travel times.
    val travelTimes = IntArray(garbage.size)
    for (i in 1 .. garbage.lastIndex) {
        val previousTravelTime = travelTimes[i - 1]
        val travelTimeToNextHouse = travel[i - 1]

        travelTimes[i] = previousTravelTime + travelTimeToNextHouse
    }

    // Update the number of garbage pickup types and last seen.
    for (household in garbage.indices) {
        val rawGarbageTypes = garbage[household].toCharArray()

        for (garbageType in rawGarbageTypes) {
            val currentCollectionsForType = garbagePickups.getOrDefault(garbageType, 0 to 0).second
            garbagePickups[garbageType] = household to (currentCollectionsForType + 1)
        }
    }

    // Calculate the total time taken.
    for (value in garbagePickups.values) {
        val lastPickupAt = value.first
        val numberOfCollections = value.second

        timeTaken += (numberOfCollections + travelTimes[lastPickupAt])
    }

    return timeTaken
}

//endregion
