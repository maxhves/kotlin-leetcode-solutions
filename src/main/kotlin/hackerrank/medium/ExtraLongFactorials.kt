package hackerrank.medium

import java.math.BigInteger

private fun extraLongFactorials(n: Int): Unit {
    var factorial: BigInteger = BigInteger.ZERO

    for (i in n downTo 1) {
        factorial *= i.toBigInteger()
    }

    println(factorial)
}

private fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    extraLongFactorials(n)
}