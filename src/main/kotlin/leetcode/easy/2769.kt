package leetcode.easy

//region Problem

/**
 * An integer is achievable if it can become equal to `num` after applying the following operation
 * no more than `t` times:
 *
 * - Increase or decrease `x` by `1` and simultaneously increase or decrease `num` by `1`.
 *
 * Return the maximum possible achievable number.
 */

//endregion

//region Sample input

/**Input: num  4, t = 1
 * Output: 6
 *
 * Input: num = 3, t = 2
 * Output: 7
 */

//endregion

//region Solution

fun main() {
    theMaximumAchievableX(num = 4, t = 1)
    theMaximumAchievableX(num = 3, t = 2)
}

private fun theMaximumAchievableX(num: Int, t: Int): Int {
    val achievable = (t * 2) + num

    println("The maximum achievable is: $achievable")
    return achievable
}

//endregion