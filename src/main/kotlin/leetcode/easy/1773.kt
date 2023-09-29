package leetcode.easy

//region Problem

/**
 * You are given an array `items`, where each `items[i] = [type^i, color^i, name^i]` describes the
 * type, color and name of the `ith` item. You are also given a rule represented by two strings`
 * `ruleKey` and `ruleValue`.
 *
 * The `ith` item is said to match the rule if one of the following is true:
 *   - `ruleKey == "type"` and `ruleValue == type^i`.
 *   - `ruleKey == "color"` and `ruleValue == color^i`.
 *   - `ruleKey == "name"` and `ruleValue == name^i`.
 *
 *   Return the number of items that match the given rule.
 */

//endregion

//region Test cases

/**
 * Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * Output: 1
 */

//endregion

//region Solution

private fun main() {
    countMatches(
        items = listOf(
            listOf("phone", "blue", "pixel"),
            listOf("computer", "silver", "lenovo"),
            listOf("phone", "gold", "iphone"),
        ),
        ruleKey = "color",
        ruleValue = "silver",
    )
}

fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
    val ruleKeyToIndex = mapOf("type" to 0, "color" to 1, "name" to 2)
    val indexToMatch = ruleKeyToIndex[ruleKey] ?: 0

    return items.count { it[indexToMatch] == ruleValue }
}

//endregion