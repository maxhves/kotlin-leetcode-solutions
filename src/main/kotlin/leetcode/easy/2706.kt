package leetcode.easy

//region Problem

/**
 * You are given an integer array (prices) representing the prices of various chocolates in a store.
 * You are also given a single integer (money), which represents your initial amount of money.
 *
 * You must buy exactly two chocolates in such a way that you still have some non-negative leftover
 * money. You would like to minimize the sum of the prices of the two chocolates you buy.
 *
 * Return the amount of money you will have leftover after buying the two chocolates If there is no way
 * for you to buy two chocolates without ending up in debt, return (money). Note that the leftover
 * must be non-negative.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Find the cheapest and second-cheapest items in the (prices) array.
 * - Minus these two prices from (money).
 * - If the leftover money is negative, return money else return the resulting sum.
 */

//endregion

//region Solution

private fun main() {
    // Output: 0
    buyChoco(
        prices = intArrayOf(1, 2, 2),
        money = 3,
    )
}

private fun buyChoco(prices: IntArray, money: Int): Int {
    var cheapestChocolate = Int.MAX_VALUE
    var secondCheapestChocolate = Int.MAX_VALUE

    for (price in prices) {
        if (price <= cheapestChocolate) {
            secondCheapestChocolate = cheapestChocolate
            cheapestChocolate = price
        } else if (price < secondCheapestChocolate) {
            secondCheapestChocolate = price
        }
    }

    val leftoverMoney = money - cheapestChocolate - secondCheapestChocolate
    return if (leftoverMoney < 0) money else leftoverMoney
}

//endregion
