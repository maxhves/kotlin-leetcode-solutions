package hackerrank

import java.util.TreeSet

// Initial solution
private fun noPrefix(words: Array<String>): Unit {
    // Check if a word is a prefix of another word
    // If so then it is a BAD SET
    // If no word is a prefix of no other word then GOOD SET

    // Thoughts
    // For each word check if that word is a prefix of any other word
    // Keep going until all words are checked
    // This is a basic solution

    for (i in words.indices) {
        val iWord = words[i]

        // We now have *i* word
        // We should check if it is a prefix of any other word

        // Another loop to check words again
        for (j in words.indices) {
            val jWord = words[j]

            // Don't check the same word against each other
            if (i != j) {
                if (jWord.contains(iWord)) {
                    println("BAD SET")
                    println(jWord)
                    return
                }
            }
        }

        // If we complete then no word was found to be a prefix
        println("GOOD SET")
    }
}

// Better solution
private fun noPrefix2(words: Array<String>): Unit {
    // Create a tree set and add first word
    val wordTree = TreeSet<String>()
    val firstWord = words[0]
    wordTree.add(firstWord)

    // For each word (after the first)
    for (i in 1 until words.size) {
        val word = words[i]

        // If the tree set contains the word it's a bad set
        if (wordTree.contains(word)) {
            println("BAD SET")
            println(word)
            return
        } else {
            // Otherwise add the word now
            wordTree.add(word)
        }

        // Get the least element in the tree that is greater than word
        wordTree.higher(word)?.let {
            if (it.startsWith(word) || word.startsWith(it)) {
                println("BAD SET")
                println(word)
                return
            }
        }

        // Get the greatest element that is less than the word
        wordTree.lower(word)?.let {
            if (it.startsWith(word) || word.startsWith(it)) {
                println("BAD SET")
                println(word)
                return
            }
        }
    }

    println("GOOD SET")
}

private fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val words = Array<String>(n, { "" })
    for (i in 0 until n) {
        val wordsItem = readLine()!!
        words[i] = wordsItem
    }

    noPrefix(words)
}