package leetcode.easy

//region Problem

/**
 * You are given a string 's' and an integer 'k'. Encrypt the string using the following algorithm:
 * - For each character 'c' in 's', replace 'c' with the 'kth' character after 'c' in the string (in a cyclic
 * manner).
 *
 * Return the encrypted string.
 */

//endregion

//region Steps to solve

/**
 * - Create a char array of 's'.
 * - Iterate over each index in 's and apply the replacement condition.
 */

//endregion

//region Solution

private fun main() {
    // Output: "tdar"
    getEncryptedString(s = "dart", k = 3)

    // Output: "aaa"
    getEncryptedString(s = "aaa", k = 1)
}

private fun getEncryptedString(s: String, k: Int): String {
    val sChars = s.toCharArray()
    val stringSize = s.length

    for (i in s.indices) {
        val indexToReplace = (i + k) % stringSize
        val swappingElement = s[indexToReplace]

        sChars[i] = swappingElement
    }

    return sChars.joinToString("")
}

//endregion
