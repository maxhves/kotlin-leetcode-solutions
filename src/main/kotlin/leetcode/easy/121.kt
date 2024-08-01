package leetcode.easy

//region Problem

/**
 * You are given an array (prices) where (prices[i]) is the price of a given stock on the (ith) day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
 * in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit,
 * return (0).
 */

//endregion

//region Steps to solve

/**
 * - A brute-force solution is to use a nested loop to check the profit from each possible solution.
 * - A more efficient solution is to keep track of the minimum value, and calculate the maximum profit at
 *   each iteration of the array.
 */

//endregion

//region Solution

private fun main() {
    // Output: 5
    maxProfit(prices = intArrayOf(7, 1, 5, 3, 6, 4))
}

private fun maxProfit(prices: IntArray): Int {
    var maximumProfit = 0
    var minimumBuyPrice = prices[0]

    prices.forEach { price ->
        minimumBuyPrice = minOf(minimumBuyPrice, price)
        maximumProfit = maxOf(maximumProfit, price - minimumBuyPrice)
    }

    return maximumProfit
}

//endregion
