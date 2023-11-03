package leetcode.easy

//region Problem

/**
 * Given a string (s) consisting of lowercase English letters, return the first letter to appear twice.
 *
 * Note:
 *  - A letter (a) appears twice before another letter (b) if the second occurrence of (a) is before the
 *    second occurrence of (b).
 *  - (s) will contain at least one letter that appears twice.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We need to know if a given letter appears twice before another letter appears twice.
 *
 * 1. Create a set of integers.
 * 2. Iterate over the string (s).
 * 3. For each character (char):
 *     - If the (set) contains (char):
 *        - Return (char).
 *     - Otherwise, add (char) to the (set).
 * 4. We shouldn't reach this point but if so, return anything.
 */

//endregion

//region Solution

private fun main() {
    // Output: "c"
    repeatedCharacter(s = "abccbaacz")

    // Output: "d"
    repeatedCharacter(s = "abcdd")
}

private fun repeatedCharacter(s: String): Char {
    val charsSeen = HashSet<Char>(s.length)

    for (char in s) {
        if (charsSeen.contains(char)) {
            return char
        } else {
            charsSeen.add(char)
        }
    }

    return 'z'
}

//endregion
