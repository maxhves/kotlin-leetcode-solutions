package leetcode.easy

//region Problem

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Using a recursive DFS approach we can calculate the number of ways we can climb to the top of the
 *   staircase.
 * - The dfs function can have the following parameters:
 *   - stepsRemaining: Number of steps we have left.
 *   - stepsToClimb: Number of steps to climb.
 * - We can take care of some base cases:
 *   - If stepsRemaining is smaller than stepsToClimb, we cannot continue so return 0.
 * - In each iteration of the function we can make two choices:
 *   - Either we remove 1 from stepsRemaining.
 *   - Or we remove 2 from stepsRemaining.
 *   - We therefore pass in the stepsToClimb as either 1 or 2.
 * - Ultimately we can return the dfs function.
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    climbStairs(n = 44)

    // Output: 3
    climbStairs(n = 3)
}

private fun climbStairs(n: Int): Int {
    val cache = HashMap<Pair<Int, Int>, Int>()

    fun dfs(stepsRemaining: Int, stepsToClimb: Int): Int {
        if (stepsRemaining < stepsToClimb) {
            return 0
        }

        if (cache.containsKey(stepsRemaining to stepsToClimb)) {
            return cache.getOrDefault(stepsRemaining to stepsToClimb, 0)
        }

        val oneStep = dfs(stepsRemaining - stepsToClimb, 1)
        val twoSteps = dfs(stepsRemaining - stepsToClimb, 2)

        val result = (if (stepsRemaining - stepsToClimb == 0) 1 else 0) + oneStep + twoSteps
        cache[stepsRemaining to stepsToClimb] = result

        return result
    }

    val oneStep = dfs(n, 1)
    val twoSteps = dfs(n, 2)

    return oneStep + twoSteps
}

//endregion
