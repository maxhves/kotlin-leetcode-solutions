package leetcode.medium

//region Problem

/**
 * Design a data structure that supports adding new words and finding if a string matches any previously
 * added string.
 *
 * Implement the (WordDictionary) class:
 * - (WordDictionary) initializes the object.
 * - (void addMore(word)) adds (word) to the data structure, it can be matched later.
 * - (bool search(word)) returns (true) if there is any string in the data structure that matches (word)
 *   or (false) otherwise. (word) may contain dots ('.') where dots can be matched with any letter.
 */

//endregion

//region Steps to solve

/**
 *
 */

//endregion

//region Solution

private fun main() {
    val wordDictionary = WordDictionary()
    wordDictionary.addWord("bad")
    wordDictionary.addWord("dad")
    wordDictionary.addWord("mad")

    val padResult = wordDictionary.search("pad")
    val badResult = wordDictionary.search("bad")
    val adResult = wordDictionary.search(".ad")
    val bResult = wordDictionary.search("b..")

    val t = "Debug Here"
}

private class WordDictionary() {
    class TrieNode {
        val children: HashMap<Char, TrieNode> = HashMap(26)
        var isWord: Boolean = false
    }

    val root = TrieNode()

    fun addWord(word: String) {
        var currentNode = root

        for (char in word) {
            if (char != '.') {
                if (char !in currentNode.children) {
                    currentNode.children[char] = TrieNode()
                }
                currentNode = currentNode.children.getOrDefault(char, TrieNode())
            }
        }

        currentNode.isWord = true
    }

    fun search(word: String): Boolean {
        fun matchPath(startIndex: Int, node: TrieNode): Boolean {
            var currentNode = node

            for (i in startIndex..word.lastIndex) {
                val char = word[i]

                if (char == '.') {
                    for (child in currentNode.children.values) {
                        val result = matchPath(i + 1, child)
                        if (result) {
                            return true
                        }
                    }
                    return false
                } else {
                    if (char !in currentNode.children) {
                        return false
                    }
                    currentNode = currentNode.children.getOrDefault(char, TrieNode())
                }
            }
            return currentNode.isWord
        }
        return matchPath(0, root)
    }
}

//endregion
