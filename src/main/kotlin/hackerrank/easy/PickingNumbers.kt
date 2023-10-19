package hackerrank.easy

private fun pickingNumbers(a: Array<Int>): Int {
    // Find the longest sub-array where the absolute difference
    // between any two elements is <= 1
    a.sort()
    val subArraySizes = IntArray(a.size)

    for ((i, x) in a.withIndex()) {
        for (j in i..a.lastIndex) {
            if (a[j] <= (x + 1)) {
                subArraySizes[i]++
            } else {
                break
            }
        }
    }

    return subArraySizes.max()
}

private fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = pickingNumbers(a)

    println(result)
}