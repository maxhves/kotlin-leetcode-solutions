package leetcode.easy


//region Problem

/**
 * There are `n` employees in a company, numbered from `0` to `n - 1` Each employee `i` has worked for
 * `hours[i]` hours in the company.
 *
 * The company requires each employee to work for at least `target` hours.
 *
 * You are given a 0-indexed array of non-negative integers `hours` of length `n` and a non-negative integer
 * `target`
 *
 * Return the integer denoting the number of employees who worked at least `target` hours.
 */

//endregion

//region Test cases

/**
 * Input: hours = [0,1,2,3,4], target = 2
 * Output: 3
 *
 * Input: hours = [5,1,4,2,2], target = 6
 * Output: 0
 */

//endregion

//region Solution

private fun main() {
    numberOfEmployeesWhoMetTarget(hours = intArrayOf(0, 1, 2, 3, 4), target = 2)
    numberOfEmployeesWhoMetTarget(hours = intArrayOf(5, 1, 4, 2, 2), target = 6)
}

fun numberOfEmployeesWhoMetTarget(hours: IntArray, target: Int): Int {
    val validEmployees = hours.count { it >= target }

    println("Number of employees with valid worked hours: $validEmployees")
    return validEmployees
}

//endregion