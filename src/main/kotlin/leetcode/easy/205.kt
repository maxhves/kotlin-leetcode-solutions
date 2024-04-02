package leetcode.easy

//region Problem

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order
 * of characters. No two characters may map to the same character, but a character may map to itself.
 */

//endregion

//region Steps to solve

/**
 * Steps:
 * - Create a frequency hash map.
 * - Compare if they are equal or not.
 */

//endregion

//region Solution

private fun main() {
    // Output: false
    isIsomorphic(s = "bbbaaaba", t = "aaabbbba")

    // Output: true
    isIsomorphic(s = "egg", t = "add")

    // Output: false
    isIsomorphic(s = "foo", t = "bar")

    // Output: true
    isIsomorphic(s = "paper", t = "title")
}

private fun isIsomorphic(s: String, t: String): Boolean {
    val sToT = hashMapOf<Char, Char>()
    val tToS = hashMapOf<Char, Char>()

    for (i in s.indices) {
        val sChar = s[i]
        val tChar = t[i]

        if (sToT.containsKey(sChar) && sToT[sChar] != tChar ||
            tToS.containsKey(tChar) && tToS[tChar] != sChar
        ) {
            return false
        }

        sToT[sChar] = tChar
        tToS[tChar] = sChar
    }

    return true
}

//endregion
