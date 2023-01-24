package hackerrank

fun noPrefix(words: Array<String>): Unit {
    // Check if a word is a prefix of another word
    // If so then it is a BAD SET
    // If no word is a prefix of no other word then GOOD SET

    // Thoughts
    // For each word check if that word is a prefix of any other word
    // Keep going until all words are checked
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val words = Array<String>(n, { "" })
    for (i in 0 until n) {
        val wordsItem = readLine()!!
        words[i] = wordsItem
    }

    noPrefix(words)
}