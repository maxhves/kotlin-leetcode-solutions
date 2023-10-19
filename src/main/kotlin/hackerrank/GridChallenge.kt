package hackerrank

private fun gridChallenge(grid: Array<String>): String {
    // Problem
    // Given a square grid of characters in the range ascii[a-z]
    // - Rearrange elements of each row alphabetically, ascending
    // - Determine if the columns are also ascending alphabetical order top to bottom
    // Return YES if they are and NO if they are not

    // Thoughts
    // Loop rows, always sort() them
    // Loop columns, check if alphabetical, break if not
    // Can we loop all of this at the same time?
    // When looping keep track of each array and compare the next, as soon as it doesn't continue alphabetically,
    // return NO else keep going and return YES

    // Solution
    val charMatrix = grid.map { it.toCharArray() }
    val tempStore = CharArray(charMatrix[0].size)

    // For each row in the array
    for (i in charMatrix.indices) {
        charMatrix[i].sort()

        // For each char in the row
        for (j in charMatrix[i].indices) {
            val comparativeChar = tempStore[j]

            if (charMatrix[i][j] < comparativeChar) {
                return "NO"
            }

            tempStore[j] = charMatrix[i][j]
        }
    }

    return "YES"
}

private fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val grid = Array<String>(n, { "" })
        for (i in 0 until n) {
            val gridItem = readLine()!!
            grid[i] = gridItem
        }

        val result = gridChallenge(grid)

        println(result)
    }
}