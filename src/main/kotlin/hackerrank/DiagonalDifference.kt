package hackerrank

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    // Problem
    // Given a square matrix
    // - Calculate the absolute difference between the sums of its diagonals
    //
    // Return the sum

    // Case
    // 1 2 3
    // 4 5 6
    // 7 8 9
    // Left -> Right: 1 + 5 + 9 = 15
    // Right -> Left: 3 + 5 + 9 = 17
    // 17 - 15 = 2

    // Thoughts
    // - It's a square
    // - Each array (LR/RL) has the same length as a row
    // - Get the outermost
    //     - Next array get outermost + 1 index
    //     - Keep going until you reach the length we need
    // - Repeat for other outermost (maybe we can reverse the array?)
    // - Take larger number and minus the smaller
    // - Bingo

    // 1 2 3 4
    // 2 3 4 5
    // 3 4 5 6
    // 4 5 6 7

    // Basic solution
    var leftRightSum = 0
    var rightLeftSum = 0

    for (i in arr.indices) {
        leftRightSum += arr[i][i]
        rightLeftSum += arr[i][arr.lastIndex - i]
    }

    return if (leftRightSum > rightLeftSum) leftRightSum - rightLeftSum else rightLeftSum - leftRightSum

    // Time complexity: O(n)
    // Space complexity: O(1)
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

    for (i in 0 until n) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = diagonalDifference(arr)

    println(result)
}