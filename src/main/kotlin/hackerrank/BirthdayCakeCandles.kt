package hackerrank

private fun birthdayCakeCandles(candles: Array<Int>): Int {
    // Take max
    val tallest = candles.max()

    // Count the instances
    return candles.count { it == tallest }
}

private fun main(args: Array<String>) {
    val candlesCount = readLine()!!.trim().toInt()

    val candles = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = birthdayCakeCandles(candles)

    println(result)
}