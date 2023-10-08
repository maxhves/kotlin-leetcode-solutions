package leetcode.easy

//region Problem

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of
 * dots and dashes, as follows:
 *  - `a` maps to `.-`,
 *  - `b` maps to `-...`,
 *  - `c` maps to `-.-.`, and so on.
 *
 * Given an array of strings `words` where each word can be written as a concatenation of the Morse code
 * of each letter.
 *  - For example, `cab` can be written as `-.-..--...`, which is the concatenation of `-.-.`, `.-` and
 *    `-...`. We will call such a concatenation the transformation of a word.
 *
 * Return the number of different transformations among all words we have.
 */

//endregion

//region Test cases

/**
 * Input: words = ["gin","zen","gig","msg"]
 * Output: 2
 *
 * Input: words = ["a"]
 * Output: 1
 */

//endregion

//region Steps to solve

/**
 * 1. Convert each word to Morse Code.
 * 2. Place strings into a Hash Map.
 *  - The transformation will act as the key.
 * 3. Return number of elements in the Hash Map.
 *
 * More efficient and readable solution:
 * 1. Loop through the words array.
 * 2. Map each word to its morse code counterpart.
 *   - Join the chars to a string.
 * 3. Return the distinct count.
 */

//endregion

//region Solution

private fun main() {
    uniqueMorseRepresentations(words = arrayOf("gin", "zen", "gig", "msg"))
}

private fun uniqueMorseRepresentations(words: Array<String>): Int {
    val morseCodeCharArray = arrayOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")

    return words.map { word ->
        word.map { morseCodeCharArray[it.code - 'a'.code] }.joinToString("")
    }.distinct().count()
}

//endregion