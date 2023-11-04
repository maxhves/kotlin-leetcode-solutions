package leetcode.medium

//region Problem

/**
 * Design a time-based key-value data structure that can store multiple values for the same key
 * at different time stamps and retrieve the key's value at a certain timestamp.
 *
 * Implement the (TimeMap) class:
 *  - (TimeMap()) initializes the object of the data structure.
 *  - (void set(String key, String value, int timestamp) Stores the key (key) with the value (value)
 *    at the given time (timestamp).
 *  - (String get(String key, int timestamp)) Returns a value such that (set) was called previously,
 *    with (timestamp_prev <= timestamp). If there are multiple such values, it returns the value
 *    associated with the largest (timestamp_prev). If there are no values, it returns ("").
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We should do a binary search based on the (timestamp) variable.
 *  - We need to store a key, with that contains a value at a given timestamp.
 *  - Could this be a HashMap:
 *     - Key: String.
 *     - Value: List<Pair<String, Int>> (value to timestamp).
 */

//endregion

//region Solution

private fun main() {
    val timeMap = TimeMap()
    timeMap.set("foo", "bar", 1)
    timeMap.get("foo", 1)
    timeMap.get("foo", 3)
}

private class TimeMap() {
    private val store = HashMap<String, MutableList<Pair<String, Int>>>()

    fun set(key: String, value: String, timestamp: Int) {
        store.getOrPut(key) { mutableListOf() }.add(value to timestamp)
    }

    fun get(key: String, timestamp: Int): String {
        if (!store.containsKey(key)) {
            return ""
        } else {
            val pairs = store[key]!!
            val match = binarySearch(pairs, timestamp)

            if (match < 0) {
                return ""
            } else {
                return pairs[match].first
            }
        }
    }

    private fun binarySearch(pairs: List<Pair<String, Int>>, target: Int): Int {
        var left = 0
        var right = pairs.lastIndex

        while (left <= right) {
            val midpoint = (left + right) / 2
            val midpointPair = pairs[midpoint]

            if (target > midpointPair.second) {
                left = midpoint + 1
            } else if (target < midpointPair.second) {
                right = midpoint - 1
            } else {
                return midpoint
            }
        }

        return right
    }
}

//endregion
