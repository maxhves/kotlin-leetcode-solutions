package hackerrank

private fun countingSort(arr: Array<Int>): Array<Int> {
    // Problem
    // Given a list of integers, count and return the number of times each value appears as an array of integers

    val countedArray = IntArray(100)

    for (i in arr) {
        countedArray[i]++
    }

    return countedArray.toTypedArray()
}

private fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = countingSort(arr)

    println(result.joinToString(" "))
}