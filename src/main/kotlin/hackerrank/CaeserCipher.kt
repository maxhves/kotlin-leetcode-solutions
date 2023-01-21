package hackerrank

fun caesarCipher(s: String, k: Int): String {
    // s - the input string
    // k - the alphabet rotation factor
    val sanitizedFactor = k % 26
    val alphabet =  "abcdefghijklmnopqrstuvwxyz"
    val rotatedAlphabet = alphabet.slice(sanitizedFactor..alphabet.lastIndex) + alphabet.slice(0 until sanitizedFactor)
    var encryptedString = ""

    for (char in s) {
        var encryptedChar = '-'

        if (char in 'a'..'z' || char in 'A'..'Z') {
            encryptedChar = rotatedAlphabet[alphabet.indexOf(char.toLowerCase())]

            if (char.isUpperCase()) {
                encryptedChar = encryptedChar.toUpperCase()
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