package hackerrank.easy

import kotlin.math.abs

// Initial attempt
private fun minimumAbsoluteDifference(arr: Array<Int>): Int {
    // 5
    // 1 -3 71 68 17

    // -3 1 17 68 71
    val sorted = arr.sortedArray()
    var min = abs(sorted[0] - sorted[1])
    var previous = sorted[0]

    for (i in 1 .. sorted.lastIndex) {
        val currentMin = abs(previous - sorted[i])

        if (currentMin < min) {
            min = currentMin
        }
        previous = sorted[i]
    }

    return min
}

private fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = minimumAbsoluteDifference(arr)

    println(result)
}