package hackerrank.medium

import java.math.BigInteger

fun extraLongFactorials(n: Int): Unit {
    var factorial: BigInteger = BigInteger.ZERO

    for (i in n downTo 1) {
        factorial *= i.toBigInteger()
    }

    println(factorial)
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    extraLongFactorials(n)
}