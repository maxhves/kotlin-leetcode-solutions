package leetcode.easy

//region Problem

/**
 * Your laptop keyboard is fault, and whenever you type a character `i` on it, it reverses the string that
 * you have written. Typing other characters works as expected.
 *
 * You are given a 0-indexed string `s`, and you type each character of `s using your faulty keyboard.
 *
 * Return the final string that will be present on your laptop screen.
 */

//endregion

//region Test cases

/**
 * Input: s = "string"
 * Output: "rtsng"
 *
 * Input: "poiinter"
 * Output: "ponter"
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the string.
 * 2. Add each char to a string.
 * 3. When an `i` is found reverse the string so far.
 * 4. Return the result string.
 */

//endregion

//region Solution

private fun main() {
    finalString(s = "string")
    finalString(s = "poiinter")
}

private fun finalString(s: String): String {
    var result = ""

    for (char in s) {
        if (char == 'i') {
            result = result.reversed()
        } else {
            result += char
        }
    }

    return result
}

//endregion