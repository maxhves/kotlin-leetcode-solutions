package leetcode.medium

//region Problem

/**
 * Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.
 *
 * An anagram is a word of phrase formed by rearranging the letters of a different word or phrase, typically
 * using all the original letters exactly once.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the list of anagrams.
 * 2. For each anagram:
 *    - Sort the string.
 *    - Place the string in a HashMap:
 *      - Key: sorted string.
 *      - Value: intArrayOf(string.index).
 * 3. Return a list of the hashmap values mapped from index to original anagram value.
 */

//endregion

//region Solution

private fun main() {
    // Output: [["dgggggggggg"],["ddddddddddg"]]
    groupAnagrams(strs = arrayOf("ddddddddddg", "dgggggggggg"))

    // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    groupAnagrams(strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))

    // Output: [[""]]
    groupAnagrams(strs = arrayOf(""))

    // Output: [["a"]]
    groupAnagrams(strs = arrayOf("a"))
}

private fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val anagramHashMap = HashMap<String, IntArray>()

    for (i in strs.indices) {
        val element = strs[i].toMutableList()
        element.sort()
        val sortedString = element.joinToString("")

        if (anagramHashMap.containsKey(sortedString)) {
            val existingElement = anagramHashMap[sortedString]!!
            anagramHashMap[sortedString] = existingElement + i
        } else {
            anagramHashMap[sortedString] = intArrayOf(i)
        }
    }

    return anagramHashMap.map { i -> i.value.map { j -> strs[j] } }
}

private fun groupAnagramImproved(strs: Array<String>): List<List<String>> {
    val anagramGroupMap = mutableMapOf<String, MutableList<String>>()

    strs.forEach { anagram ->
        val key = String(anagram.toCharArray().sortedArray())

        if (!anagramGroupMap.contains(key)) {
            anagramGroupMap[key] = mutableListOf()
        }

        anagramGroupMap[key]?.add(anagram)
    }

    return anagramGroupMap.map { it.value }
}

//endregion