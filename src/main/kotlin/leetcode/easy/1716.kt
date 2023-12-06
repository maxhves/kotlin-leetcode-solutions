package leetcode.easy

//region Problem

/**
 * Hercy wants to save money for his first car. He puts money in the LeetCode bank every day.
 *
 * He starts by putting in ($1) on Monday, the first day. Every day from Tuesday to Sunday, he will put
 * ($1) more than the day before. On every subsequent Monday, he will put in ($1) more than the previous
 * Monday.
 *
 * Given (n), return the total amount of money he will have in the LeetCode bank at the end of the (nth)
 * day.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - Each week we increase the daily saving by ($1).
 */

//endregion

//region Solution

private fun main() {

}

private fun totalMoney(n: Int): Int {
    val daysInWeek = 7
    val singleWeekSum = daysInWeek * (1 + daysInWeek) / 2
    val weeks = n / daysInWeek
    val extraDays = n % daysInWeek

    val totalWeeksSum = singleWeekSum * weeks
    val extraSavings = daysInWeek * weeks * (weeks - 1) / 2
    val extraDaysSum = extraDays * (extraDays + 1) / 2
    val remainingWeek = weeks * extraDays

    return totalWeeksSum + extraSavings + extraDaysSum + remainingWeek
}

//endregion
