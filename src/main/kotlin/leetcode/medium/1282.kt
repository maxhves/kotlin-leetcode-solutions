package leetcode.medium

//region Problem

/**
 * There are `n` people that are split into some unknown number of groups. Each person is labeled with a
 * unique ID from `0` to `n - 1`.
 *
 * You are given an integer array `groupSizes`, where `groupSizes[i]` is the size of the group that person `i`
 * is in. For example, if `groupSizes[1] = 3`, then person `1` must be in a group of size `3`.
 *
 * Return a list of groups such that each person `i` is in a group of size `groupSizes[i]`.
 *
 * Each person should appear in exactly one group, and every person must be in a group. If there are multiple
 * answers, return any of them. It is guaranteed that there will be at least one valid solution for the given input.
 */

//endregion

//region Test cases

/**
 * Input: groupSizes = [3,3,3,3,3,1,3]
 * Output: [[5], [0,1,2], [3,4,6]]
 *
 * Input: groupSizes = [2,1,3,3,3,2]
 * Output: [[1], [0,5], [2,3,4]]
 */

//endregion

//region Solution

private fun main() {
    groupThePeople(groupSizes = intArrayOf(3, 3, 3, 3, 3, 1, 3))
    groupThePeople(groupSizes = intArrayOf(2, 1, 3, 3, 3, 2))
}

/**
 * Initial solution.
 */
fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
    val hashMap = HashMap<Int, MutableList<Int>>(groupSizes.size)
    val groupedGroups = mutableListOf<List<Int>>()

    for (i in groupSizes.indices) {
        val currentId = groupSizes[i]

        val existingList = hashMap.getOrDefault(currentId, mutableListOf())
        existingList.add(i)

        hashMap[currentId] = existingList
    }

    for (entry in hashMap) {
        val listSize = entry.key

        if (entry.value.size <= listSize) {
            groupedGroups.add(entry.value)
        } else {
            var newList = mutableListOf<Int>()

            for (i in 0 until entry.value.size) {
                newList.add(entry.value[i])

                if (newList.size == listSize) {
                    groupedGroups.add(newList)
                    newList = mutableListOf()
                }
            }
        }
    }

    return groupedGroups
}

/**
 * Better solution.
 */
fun groupThePeopleBetter(groupSizes: IntArray): List<List<Int>> {
    val map = HashMap<Int, ArrayList<Int>>()
    val result = ArrayList<List<Int>>()

    for (i in groupSizes.indices) {
        val groupSize = groupSizes[i]

        val group = map.getOrDefault(groupSize, ArrayList())
        group.add(i)
        map[groupSize] = group

        if (group.size == groupSize) {
            result.add(group)
            map.remove(groupSize)
        }
    }

    return result
}

//endregion