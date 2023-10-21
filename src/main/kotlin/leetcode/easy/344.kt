package leetcode.easy

//region Problem

/**
 * Write a function that reverses a string. The input string is given as an array of characters (s).
 *
 * You must do this by modifying the input array in-place with (O(n)) extra memory.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the array.
 * 2. Take (s[i]) and s[s.lastIndex - i]):
 *    - Set them to each other (swap them).
 *    - Keep going until i == s.lastIndex - i.
 */

//endregion

//region Solution

private fun main() {
    // Output: ['o','l','l','e','h']
    reverseString(s = charArrayOf('h', 'e', 'l', 'l', 'o'))

    // Output: ['h','a','n','n','a','H']
    reverseString(s = charArrayOf('H', 'a', 'n', 'n', 'a', 'h'))
}

private fun reverseString(s: CharArray) {
    var start = 0
    var end = s.lastIndex

    while (start < end) {
        val temp = s[start]
        s[start] = s[end]
        s[end] = temp

        start++
        end--
    }
}

//endregion
