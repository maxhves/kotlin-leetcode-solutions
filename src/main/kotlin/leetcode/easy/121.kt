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
 * Considerations:
 *  - We need to find the smallest number and the largest number afterward.
 *
 * 1. Initialize a pointer (left) which will be 0.
 * 2. Create a loop to iterate over the (prices) array.
 * 3. For each element:
 *     - If the current element is smaller than our current minimum, then it is our new minimum.
 *     - We now need to calculate the profit for each position afterward.
 *     - If the profit for the next position is greater than our current profit then it becomes are profit.
 * 3. Ultimately return the best profit so far.
 */

//endregion

//region Solution

private fun main() {
    // Output: 5
    maxProfit(prices = intArrayOf(7, 1, 5, 3, 6, 4))
}

private fun maxProfit(prices: IntArray): Int {
    var lowestStockPrice = Int.MAX_VALUE
    var bestProfit = 0

    for (i in 0 .. prices.lastIndex) {
        val element = prices[i]

        lowestStockPrice = minOf(element, lowestStockPrice)
        bestProfit = maxOf(bestProfit, element - lowestStockPrice)
    }

    return bestProfit
}

//endregion
