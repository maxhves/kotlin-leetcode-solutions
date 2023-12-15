package leetcode.easy

//region Problem

/**
 * You are given the array (paths), where (paths[i] = [cityA i, cityB i]) means that there exists a
 * direct path going from (cityA i) to (cityB i). Return the destination city, that is, the city
 * without any path outgoing to another city.
 *
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be
 * exactly one destination city.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialize a HashSet<String> (fromCities).
 * - Iterate over (paths) array.
 *   - For each 'from' city (path[0]) add it to the (fromCities) set.
 * - Iterate over the (paths) array again.
 *   - For each 'destination' city (path[1]):
 *     - If the city does not exist in (fromCities), it is our target; return the city.
 * - Ultimately if we didn't find a city, simply return an empty string.
 */

//endregion

//region Solution

private fun main() {
    // Output: "Sao Paulo"
    destCity(
        paths = listOf(
            listOf("London", "New York"),
            listOf("New York", "Lima"),
            listOf("Lima", "Sao Paulo"),
        )
    )
}

private fun destCity(paths: List<List<String>>): String {
    val fromCities = HashSet<String>()

    for (path in paths) {
        fromCities.add(path[0])
    }

    for (path in paths) {
        if (path[1] !in fromCities) {
            return path[1]
        }
    }

    return ""
}

//endregion
