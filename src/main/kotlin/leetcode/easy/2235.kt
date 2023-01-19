package leetcode.easy

fun main(args: Array<String>) {
    sum(12, 5)
    sum(-10, 4)
}

private fun sum(num1: Int, num2: Int): Int {
    // Problem
    // Given two integers, return the sum of the two integers
    val sum = num1 + num2

    println("Num1: $num1, Num2: $num2")
    println(sum)

    return sum
}