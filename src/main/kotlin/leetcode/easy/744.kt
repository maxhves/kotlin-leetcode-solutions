package leetcode.easy

//region Problem

/**
 * You are given an array of characters `letters` that is sorted in non-decreasing
 * order, and a character `target`. There are at least two different characters in
 * `letters`.
 *
 * Return the smallest character in `letters` that is lexicographically greater than
 * `target`. If such a character does not exist, return the first character in `letters`.
 */

//endregion

//region Test cases

/**
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 *
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 *
 * Input: letters = ["x","x","y","y"], target = "z"
 * Output: "x"
 */

//endregion

//region Solution

private fun main() {
    nextGreatestLetter(letters = charArrayOf('c', 'f', 'j'), target = 'a')
}

private fun nextGreatestLetter(letters: CharArray, target: Char): Char {
    var start = 0
    var end = letters.lastIndex

    while (start <= end) {
        val midpoint = start + (end - start) / 2

        if (target < letters[midpoint]) {
            end = midpoint - 1
        } else {
            start = midpoint + 1
        }
    }

    return letters[start % letters.size]
}

//endregion