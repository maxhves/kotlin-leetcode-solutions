package hackerrank.easy

private fun breakingRecords(scores: Array<Int>): Array<Int> {
    var currentMin = scores[0]
    var currentMax = scores[0]
    val maxMinCount = IntArray(2)

    for (i in 1..scores.lastIndex) {
        val score = scores[i]

        if (score > currentMax) {
            currentMax = score
            maxMinCount[0]++
        } else if (score < currentMin) {
            currentMin = score
            maxMinCount[1]++
        }
    }

    return maxMinCount.toTypedArray()
}

private fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val scores = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = breakingRecords(scores)

    println(result.joinToString(" "))
}
