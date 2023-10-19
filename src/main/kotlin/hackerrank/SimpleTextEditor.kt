package hackerrank

import java.util.*

private class Editor {
    private val textStack = Stack<String>()

    fun append(text: String) {
        if (textStack.isEmpty()) {
            textStack.push(text)
        } else {
            textStack.push(getCurrentText().plus(text))
        }
    }

    fun deleteLast(number: Int) {
        textStack.push(getCurrentText().dropLast(number))
    }

    fun getChar(position: Int): Char {
        val currentText = getCurrentText()
        return currentText[(position - 1) % currentText.length]
    }

    fun undoLastOperation() {
        textStack.pop()
    }

    private fun getCurrentText(): String {
        return textStack.peek()
    }
}

private fun main(args: Array<String>) {
    // 4 operations
    // - Append string W to the end of S
    // - Delete the last k character S
    // - Print the Kth character of S
    // - Undo the last (not previously undone) operation of type 1 or 2
    //   reverting S to the state it was in prior to that operation
    val editor = Editor()
    val numOfOperations = readLine()!!.trim().toInt()

    for (lineCount in 1..numOfOperations) {
        val line = readLine()!!.trim()

        when (line[0]) {
            '1' -> {
                editor.append(line.removeRange(0, 1).trim())
            }
            '2' -> {
                editor.deleteLast(line.removeRange(0, 1).trim().toInt())
            }
            '3' -> {
                println(editor.getChar(line.removeRange(0, 1).trim().toInt()))
            }
            '4' -> {
                editor.undoLastOperation()
            }
        }
    }
}