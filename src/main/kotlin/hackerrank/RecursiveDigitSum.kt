package hackerrank

fun superDigit(n: String, k: Int): Int {
    // Problem
    // We define super digit of an integer *x* using the following rules;
    // Given an integer, we need to find the super digit of the integer.
    // - If *x* has only 1 digit then it's super digit is *x*
    // - Otherwise the super digit of *x* is equal to the super digit of the sum of the digits of *x*

    // Case
    // Super digit of 9875
    // super_digit(9875) - 9+8+7+5 = 29
    // super_digit(29) - 2 + 9 = 11
    // super_digit(11) - 1 + 1 = 2
    // super_digit(2) - = 2

    // Solution
    var superString = (n.toBigInteger() * k.toBigInteger()).toString()

    while (superString.length != 1) {
        superString = superString.map { it.toString().toInt() }.reduce { x, y -> x + y }.toString()
    }

    return superString.toInt()
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0]

    val k = first_multiple_input[1].toInt()

    val result = superDigit(n, k)

    println(result)
}
