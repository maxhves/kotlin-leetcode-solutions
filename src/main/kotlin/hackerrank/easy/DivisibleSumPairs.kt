package hackerrank.easy

fun divisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
    // Determine the number of pairs in *ar* that are divisible by *k*
    // - i < j
    // - ar[i] + ar[j]

    // 1 3 2 6 1 2
    // 1 1 2 2 3 6
    ar.sort()

    var pairs = 0

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if ((ar[i] + ar[j]) % k == 0) {
                pairs++
            }
        }
    }

    return pairs
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val ar = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = divisibleSumPairs(n, k, ar)

    println(result)
}