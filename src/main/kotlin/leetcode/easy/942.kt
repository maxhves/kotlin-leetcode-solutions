package leetcode.easy

//region Problem

/**
 * A permutation (perm) of (n + 1) integers of all the integers in the range ([0, n]) can be represented
 * as a string (s) of length (n) where:
 *  - (s[i] == 'I') if (perm[i] < perm[i + 1]) and
 *  - (s[i] == 'D') if (perm[i] > perm[i + 1])
 *
 *  Given a string (s), reconstruct the permutation (perm) and return it. If there are multiple valid
 *  permutations perm, return any of them.
 */

//endregion

//region Steps to solve

/**
 * 1. Keep track of a max number (array size + 1).
 * 2. Keep track of a min number (0).
 * 3. Iterate over the string, by char:
 *    - If it is an 'I' then push 0.
 *    - Subsequent 'I's will push + 1.
 *    - If it is a 'D' push (array size + 1).
 *    - Subsequent 'D's  will push - 1.
 * 4. Return the resulting array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [0,4,1,3,2]
    diStringMatch(s = "IDID")

    // Output: [3,2,0,1]
    diStringMatch(s = "DDI")
}

private fun diStringMatch(s: String): IntArray {
    val n = s.length
    val result = IntArray(n + 1)

    var incrementer = 0
    var decrementer = n

    for (i in 0 until n) {
        when (s[i]) {
            'I' -> result[i] = incrementer++
            'D' -> result[i] = decrementer--
        }
    }

    result[n] = incrementer

    return result
}

//endregion
