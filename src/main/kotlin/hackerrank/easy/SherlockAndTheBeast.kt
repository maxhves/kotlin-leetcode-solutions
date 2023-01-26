package hackerrank.easy

fun decentNumber(n: Int): Unit {
    // Decent number rules:
    // - It's digits can only be 3's and/or 5's
    // - The number of 3s is divisible by 5
    // - The number of 5s is divisible by 3
    // - It is the largest such number for it's length

    // If it's divisible by 3, then fill it up with 5's
    // "1".repeat(2)
    if (n % 3 == 0) {
        println("5".repeat(n))
    } else {
        for (i in n downTo 1) {
            if (i % 3 == 0 && (n - i) % 5 == 0) {
                // stop and print
                println("5".repeat(i) + "3".repeat(n - i))
                return
            }
        }

        if (n % 5 == 0) {
            println("3".repeat(n))
        } else {
            println("-1")
        }
    }
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        decentNumber(n)
    }
}