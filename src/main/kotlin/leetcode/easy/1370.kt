package leetcode.easy

//region Problem

/**
 * You are given a string (s). Reorder the string using the following algorithm:
 *  1. Pick the smallest character from (s) and append it to the result.
 *  2. Pick the smallest character from (s) which is greater than the last appended character to the
 *     result and append it.
 *  3. Repeat step 2. until you cannot pick more characters.
 *  4. Pick the largest character from (s) and append it to the result.
 *  5. Pick the largest character from (s) which is smaller than the last appended character to the result
 *     and append it.
 *  6. Repeat step 5. until you cannot pick more characters.
 *  7. Repeat the steps 1 to 6 until you pick all characters from (s).
 *
 * In each step, if the smallest or the largest character appears more than once you can choose any
 * occurrence and append it to the result.
 *
 * Return the result string after sorting (s) with this algorithm.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  -
 *
 * 1. Sort the array, in place.
 * 2. Create a HashMap of items:
 *     - Key: Char.
 *     - Value: Int.
 * 3. Iterate over the string (s).
 * 4. For each character:
 *    - If the key (char) does not exist:
 *       - Insert a new entry; (char, 1).
 *    - If the key (char) does exist:
 *       - Increment the value at key (char).
 * 5. Create a loop that will iterate from 1 to (s.length).
 * 6. Follow the required reordering pattern, keeping track of which direction we just added.
 */

//endregion

//region Solution

private fun main() {
    // Output: "abccbaabccba"
    sortString(s = "aaaabbbbcccc")
}

private fun sortString(s: String): String {
    val charFreqArray = IntArray(26)

    for (char in s) {
        charFreqArray[char - 'a']++
    }

    val result = StringBuilder()
    var count = s.length

    while (count > 0) {
        for (i in 0 until 26) {
            if (charFreqArray[i] > 0) {
                result.append('a' + i)
                charFreqArray[i]--
                count--
            }
        }

        for (i in 25 downTo 0) {
            if (charFreqArray[i] > 0) {
                result.append('a' + i)
                charFreqArray[i]--
                count--
            }
        }
    }

    return result.toString()
}

//endregion
