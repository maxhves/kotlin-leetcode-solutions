package hackerrank.easy

import kotlin.math.roundToInt

fun repeatedString(s: String, n: Long): Long {
    // aba
    // aba aba aba a
    val fullLengths = (n / s.length)
    val leftOver = (n % s.length).toInt()

    val fullLengthCount = s.count { it == 'a' }
    val leftOverCount = s.take(leftOver).count { it == 'a' }

    return (fullLengthCount * fullLengths) + leftOverCount
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val n = readLine()!!.trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}