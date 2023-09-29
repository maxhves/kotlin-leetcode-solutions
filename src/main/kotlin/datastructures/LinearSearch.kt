package datastructures

private fun main() {
    val result = linearSearch(listOf("One", "Two", "Three"), "Two")
    println(result)
}

/**
 * Returns the index position of the target if found, else null.
 */
fun linearSearch(list: List<String>, target: String): Int? {
    for (i in list.indices) {
        if (list[i] == target) {
            return i
        }
    }
    return null
}