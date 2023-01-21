package hackerrank

fun caesarCipher(s: String, k: Int): String {
    // s - the input string
    // k - the alphabet rotation factor
    val alphabet =  "abcdefghijklmnopqrstuvwxyz"
    val rotatedAlphabet = alphabet.slice(k..alphabet.lastIndex) + alphabet.slice(0 until k)

    // val adjustedIndex = k % 26

    var encryptedString = ""

    for (char in s.lowercase()) {
        var encryptedChar = '-'

        if (char.isLetter()) {
            encryptedChar = rotatedAlphabet[alphabet.indexOf(char.lowercaseChar())]

            if (char.isUpperCase()) {
                 encryptedChar = encryptedChar.uppercaseChar()
            }
        } else {
            encryptedChar = char
        }

        encryptedString += encryptedChar
    }

    return encryptedString
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val s = readLine()!!

    val k = readLine()!!.trim().toInt()

    val result = caesarCipher(s, k)

    println(result)
}