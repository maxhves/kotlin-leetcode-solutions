package hackerrank.easy

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    // Create an array of 0 - 100
    // Increment index of sock type
    val sockPairArray = IntArray(101)
    var pairCount = 0

    ar.toSet()

    for (i in 0 until n) {
        val sockType = ar[i]
        sockPairArray[sockType]++

        if (sockPairArray[sockType] % 2 == 0) {
            pairCount++
        }
    }

    return pairCount
}

// Improved solution
fun sockMerchant2(n: Int, ar: Array<Int>): Int {
    val set = HashSet<Int>()
    var pairs = 0

    for (i in 0 until n) {
        if (!set.contains(ar[i])) {
            set.add(ar[i])
        } else {
            pairs++
            set.remove(ar[i])
        }
    }

    return pairs
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val ar = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}