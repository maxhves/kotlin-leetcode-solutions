package leetcode.medium

//region Problem

/**
 * A trie or prefix tree is a tree data structure used to efficiently store and retrieve keys in a
 * dataset of strings. There are various applications of this data structure, such as autocomplete and
 * spellchecker.
 *
 * Implement the Trie class:
 * - (Trie()) initializes the trie object.
 * - (void insert(String word)) inserts the string (word) into the trie.
 * - (boolean search(String word)) returns (true) if the string (word) is in the trie, and (false)
 *   otherwise.
 * - (boolean startsWith(String prefix)) returns (true) if there is a previously inserted string (word)
 *   that has the prefix (prefix), and (false) otherwise.
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    val trie = Trie()
    trie.insert("apple")

    val t = ""
}

private class Trie() {
    private class TrieNode {
        val children: HashMap<Char, TrieNode> = HashMap(26)
        var isWord: Boolean = false
    }

    private val root = TrieNode()

    fun insert(word: String) {
        var currentNode = root

        for (char in word) {
            if (char !in currentNode.children) {
                currentNode.children[char] = TrieNode()
            }
            currentNode = currentNode.children.getOrDefault(char, TrieNode())
        }

        currentNode.isWord = true
    }

    fun search(word: String): Boolean {
        var currentNode = root

        for (char in word) {
            if (char !in currentNode.children) {
                return false
            }
            currentNode = currentNode.children.getOrDefault(char, TrieNode())
        }

        return currentNode.isWord
    }

    fun startsWith(prefix: String): Boolean {
        var currentNode = root

        for (char in prefix) {
            if (char !in currentNode.children) {
                return false
            }
            currentNode = currentNode.children.getOrDefault(char, TrieNode())
        }

        return true
    }
}

//endregion
