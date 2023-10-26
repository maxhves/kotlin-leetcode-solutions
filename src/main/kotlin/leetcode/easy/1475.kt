package leetcode.easy

//region Problem

/**
 * You are given an integer array (prices) where (prices[i]) is the price of the (ith) item in a shop.
 *
 * There is a special discount for items in the shop If you buy the (ith) item, then you will recieve
 * a discount equivalent to (prices[j]) where (j) is the minimum index such that (j > i) and
 * (prices[j] <= prices[i]). Otherwise, you will not receive discount at all.
 *
 * Return an integer array (answer) where (answer[i]) is the final price you will pay for the (ith) item
 * of the shop, considering the special discount.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - We are looking for the next smallest (or equal) price to our current (price[index]).
 */

//endregion

//region Solution

private fun main() {
    // Output: [4, 2, 4, 2, 3]
    finalPrices(prices = intArrayOf(8, 4, 6, 2, 3))

    // Output: [1, 2, 3, 4, 5]
    finalPrices(prices = intArrayOf(1, 2, 3, 4, 5))

    // Output: [9, 0, 1, 6]
    finalPrices(prices = intArrayOf(10, 1, 1, 6))
}

private fun finalPrices(prices: IntArray): IntArray {
    val result = IntArray(prices.size)

    for (i in 0 .. prices.lastIndex) {
        result[i] = prices[i]
        for (j in i + 1 .. prices.lastIndex) {
            if (prices[j] <= prices[i]) {
                result[i] = prices[i] - prices[j]
                break
            }
        }
    }

    return result
}

//endregion
