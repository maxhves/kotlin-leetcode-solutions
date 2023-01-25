package hackerrank.medium

import java.util.*

fun organizingContainers(container: Array<Array<Int>>): String {
    // Number of balls in each container
    val containerSizes = IntArray(container.size)

    // Count of each type
    val typesInEachContainer = IntArray(container.size)

    // For each container
    for ((i, c) in container.withIndex()) {

        // For each type that is in the container
        for (j in c.indices) {
            // Ball of that type is whatever item we've come to
            val ballCount = c[j]

            // Container size keeps track of how many balls can be held
            containerSizes[i] += ballCount

            // Types keeps track of how many of each ball type is present
            typesInEachContainer[j] += ballCount
        }
    }

    // Sort them, so we can compare if each contain can hold each type
    containerSizes.sort()
    typesInEachContainer.sort()

    for (i in containerSizes.indices) {
        if (containerSizes[i] != typesInEachContainer[i]) {
            return "Impossible"
        }
    }

    return "Possible"
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val n = readLine()!!.trim().toInt()

        val container = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

        for (i in 0 until n) {
            container[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
        }

        val result = organizingContainers(container)

        println(result)
    }
}