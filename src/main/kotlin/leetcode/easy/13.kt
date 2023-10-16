package leetcode.easy

//region Problem

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *     Symbol   Value
 *     I        1
 *     V        5
 *     X        10
 *     L        50
 *     C        100
 *     D        500
 *     M        1000
 *
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII,
 * which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for
 * four is not IIII. Instead, the number four is written as IV. Because the one is before the five we
 * subtract it making four. The same principle applies ot the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 *  - I can be placed before V (5) and X (10) to make 4 and 9.
 *  - X can be placed before L (50) and C (100) to make 40 and 99.
 *  - C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 *  Given a roman numeral, convert it to an integer.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the string.
 * 2. Exchange each char for a numerical value:
 *    - If it is an I before a V or X then replace both with a 4 or 9 respectively.
 *    - If it is an X before an L or C then replace both with a 40 or 99 respectively.
 *    - If it is a C before a D or M then replace both with a 400 and 900 respectively.
 * 3. Return the resulting value.
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    romanToInt(s = "III")

    // Output: 58
    romanToInt(s = "LVIII")

    // Output: 1994
    romanToInt(s = "MCMXCIV")
}

private fun romanToInt(s: String): Int {
    var result = 0
    val numeralMap = mapOf(
        '0' to 0,
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000,
    )

    val subtractionMap = mapOf(
        "IV" to 4,
        "IX" to 9,
        "XL" to 40,
        "XC" to 90,
        "CD" to 400,
        "CM" to 900,
    )

    for (i in s.indices) {
        val previousChar = if (i == 0) '0' else s[i - 1]
        val char = s[i]

        if (subtractionMap.containsKey("$previousChar$char")) {
            result -= numeralMap[previousChar] ?: 0
            result += subtractionMap["$previousChar$char"] ?: 0
        } else {
            result += numeralMap[char] ?: 0
        }
    }

    return result
}

//endregion