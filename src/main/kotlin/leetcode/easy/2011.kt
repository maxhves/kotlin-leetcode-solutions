package leetcode.easy

private fun main(args: Array<String>) {
    finalValueAfterOperations(arrayOf("--X", "X++", "X++"))
}

private fun finalValueAfterOperations(operations: Array<String>): Int {
    // Problem
    // Programming language with only 4 operations and one variable X
    // - ++X and X++ increments the value of the variable X by 1
    // - --X and X-- decrements the value of the variable X by 1
    // Initially the value of X is 0
    // Take an array of strings *operations* containing a list of operations and return the final value of X after
    // performing the given list of operations

    println(operations.contentToString())

    var x = 0

    for (operation in operations) {
        when (operation) {
            "++X",
            "X++" -> x++
            "--X",
            "X--" -> x--
        }
    }

    println(x)

    return x
}