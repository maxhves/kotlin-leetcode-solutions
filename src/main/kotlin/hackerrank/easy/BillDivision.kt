package hackerrank.easy

fun bonAppetit(bill: Array<Int>, k: Int, b: Int): Unit {
    val bCharged = bill.reduceIndexed { index, acc, i -> if (index != k) acc + i else acc } / 2
    println(if (bCharged == b) "Bon Appetit" else b - bCharged)
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val bill = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val b = readLine()!!.trim().toInt()

    bonAppetit(bill, k, b)
}