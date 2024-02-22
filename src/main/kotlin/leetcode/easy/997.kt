package leetcode.easy

//region Problem

/**
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is
 * secretly the town judge.
 *
 * If the town judge exists, then:
 * 1. The town judge trusts nobody.
 * 2. Everybody (except from the town judge) trusts the town judge.
 * 3. There is exactly one person that satisfies properties 1 and 2.
 *
 * You are given an array trust where trust[i] = [a i, b i] representing that the person labeled a i
 * trusts the person labeled b i. If a trust relationship does not exist in trust array, then such a
 * trust relationship does not exist.
 *
 * Return the label of the town judge if the town judge exists and can be identified, or return -1
 * otherwise.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We need to find a number that has no link to another number.
 * - Each number from 1 to n should have a link to another number (this shows there is trust).
 * - If there is a number with no links, then they are the judge, since the judge trusts no one.
 * - Perhaps we can iterate over the trust array and indicate which elements have a trust relationship
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    findJudge(
        n = 3,
        trust = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
        ),
    )
}

private fun findJudge(n: Int, trust: Array<IntArray>): Int {
    val trustFrequencies = IntArray(n + 1) { 0 }

    for ((from, to) in trust) {
        trustFrequencies[from]--
        trustFrequencies[to]++
    }

    for (i in 1..n) {
        if (trustFrequencies[i] == n - 1) {
            return i
        }
    }

    return -1
}

//endregion
