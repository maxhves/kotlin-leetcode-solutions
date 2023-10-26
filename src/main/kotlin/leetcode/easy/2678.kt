package leetcode.easy

//region Problem

/**
 * You are given a 0-indexed array of strings (details). Each element of (details) provides information
 * about a given passenger compressed into a string of length (15). THe system is such that:
 *  - The first ten characters consist of the phone number of passengers.
 *  - The next character denotes the gender of the person.
 *  - The following two characters are used to indicate the age of the person.
 *  - The last two characters determine the seat allotted to that person.
 *
 * Return the number of passengers who are strictly more than 60 years old.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - The age of the person will be placed in index (11) and (12).
 *
 * 1. Take the details array.
 * 2. For each item:
 *    - Take index (11) and (12).
 *    - Convert these digits into a integer value.
 *    - Check if the integer value is greater than 60.
 *    - If so, increase our result count.
 * 3. Return the resulting count.
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    countSeniors(
        details = arrayOf(
            "7868190130M7522",
            "5303914400F9211",
            "9273338290F4010",
        ),
    )

    // Output: 0
}

private fun countSeniors(details: Array<String>): Int {
    return details.count { "${it[11]}${it[12]}".toInt() > 60 }
}

//endregion
