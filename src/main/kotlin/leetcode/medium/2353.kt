package leetcode.medium

import java.util.*
import kotlin.collections.HashMap

//region Problem

/**
 * Design a food rating system that can do the following:
 * - Modify the rating of a food item listed in the system.
 * - Return the highest-rated food item for a type of cuisine in the system.
 *
 * Implement the (FoodRatings) class:
 * - (FoodRatings(String[] foods, String[] cuisines, int[] ratings) initializes the system. The food
 *   items are described by (foods), (cuisines) and (ratings), all of which have a length of (n).
 *   - (foods[i]) is the name of the (i th) food.
 *   - (cuisines[i]) is the type of cuisine of the (i th) food.
 *   - (ratings[i]) is the initial rating of the (i th) food.
 * - (void changeRating(String food, int newRating)) changes the rating of the food item with the name
 *   food.
 * - (String highestRated(String cuisine)) returns the name of the food item that has the highest rating
 *   fod the given type of (cuisine). If there is a tie, return the item with the lexicographically
 *   smaller name.
 *
 * Note that a string (x) is lexicographically smaller than string (y) if (x) comes before (y) in
 * dictionary order, that is, either (x) is a prefix of (y) or if (i) is the first position such that
 * (x[i] != y[i]) then (x[i]) comes before (y[i]) in alphabetic order.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We need three HashMaps:
 *   - (foodToCuisine) to map food to a cuisine type.
 *   - (foodToRating) to map food to a rating.
 *   - (cuisineToRatingToFood) to map cuisine to a rating and food.
 * - We need a custom comparator for a type Pair, to sort it first by its rating then by food.
 */

//endregion

//region Solution

private fun main() {
    FoodRatings(
        foods = arrayOf("kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"),
        cuisines = arrayOf("korean", "japanese", "japanese", "greek", "japanese", "korean"),
        ratings = intArrayOf(9, 12, 8, 15, 14, 7),
    )
}

private class FoodRatings(
    foods: Array<String>,
    cuisines: Array<String>,
    ratings: IntArray,
) {
    private val pairComparator = compareByDescending { it: Pair<Int, String> ->
        it.first
    }.thenComparing { it: Pair<Int, String> ->
        it.second
    }

    val foodToCuisine = HashMap<String, String>()
    val foodToRating = HashMap<String, Int>()
    val cuisineToRatingToFood = HashMap<String, SortedSet<Pair<Int, String>>>()

    init {
        for (i in 0..foods.lastIndex) {
            val food = foods[i]
            val cuisine = cuisines[i]
            val rating = ratings[i]

            val ratingToFood = cuisineToRatingToFood.getOrDefault(cuisine, sortedSetOf(pairComparator))
            ratingToFood.add(rating to food)

            cuisineToRatingToFood[cuisine] = ratingToFood
            foodToCuisine[food] = cuisine
            foodToRating[food] = rating
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val cuisine = foodToCuisine.getOrDefault(food, "")
        val rating = foodToRating.getOrDefault(food, 0)

        val currentRatingToFood = cuisineToRatingToFood.getOrDefault(cuisine, sortedSetOf(pairComparator))

        currentRatingToFood -= rating to food
        currentRatingToFood += newRating to food
        foodToRating[food] = newRating
    }

    fun highestRated(cuisine: String): String {
        return cuisineToRatingToFood
            .getOrDefault(cuisine, sortedSetOf(pairComparator))
            .first().second
    }
}

//endregion
