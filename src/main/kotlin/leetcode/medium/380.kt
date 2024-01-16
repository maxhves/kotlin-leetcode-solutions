package leetcode.medium

import kotlin.random.Random

//region Problem

/**
 * Implement the RandomizedSet class:
 * - RandomizedSet() Initializes the RandomizedSet object.
 * - bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was
 *   not present, false otherwise.
 * - bool remove(int val) Removes an item val from the set if present. Returns true if the item was
 *   present, false otherwise.
 * - int getRandom() Returns a random element from the current set of elements (it's guaranteed that at
 *   least one element exists when this method is called). Each element must have the same probability
 *   of being returned.
 *
 * You must implement the functions of the class such that each function works in average O(1) time
 * complexity.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Using a HashMap, we can simply add and remove as necessary.
 * - For retrieving at random, we can get a random number for the size of the array, and then return
 *   the item at the randomised index.
 */

//endregion

//region Solution

private fun main() {
    // ...
}

private class RadomizedSet() {
    private val hashMap = HashMap<Int, Int>()
    private val keys = ArrayList<Int>()

    fun insert(`val`: Int): Boolean {
        return if (hashMap.containsKey(`val`)) {
            false
        } else {
            hashMap[`val`] = `val`
            keys.add(`val`)
            true
        }
    }

    fun remove(`val`: Int): Boolean {
        return if (hashMap.containsKey(`val`)) {
            hashMap.remove(`val`)
            keys.remove(`val`)
            true
        } else {
            false
        }
    }

    fun getRandom(): Int {
        return hashMap.getOrDefault(keys.random(), 0)
    }
}

//endregion
