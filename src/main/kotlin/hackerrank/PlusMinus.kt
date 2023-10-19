package hackerrank

private fun plusMinus(arr: Array<Int>): Unit {
    // Write your code here

    // Print the following lines
    // 1. Proportion of positive integers
    // 2. Proportion of negative integers
    // 3. Proportion of zeros

    // Basic solution
    var positiveCount: Double = 0.0
    var negativeCount: Double = 0.0
    var zeroCount: Double = 0.0

    for (integer in arr) {
        when {
            integer == 0 -> zeroCount++
            integer < 0 -> negativeCount++
            integer > 0 -> positiveCount++
        }
    }

    val arraySize = arr.size
    val formatArg = "%.6f"

    println(formatArg.format(positiveCount / arraySize))
    println(formatArg.format(negativeCount / arraySize))
    println(formatArg.format(zeroCount / arraySize))
}

private fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    plusMinus(arr)
}