package hackerrank

import java.text.SimpleDateFormat

// Initial solution
private fun timeConversion(s: String): String {
    // Problem
    // Given a 12-hour AM/PM format convert it to military (24-hour) time

    // Basic solution
    val isAm = (s[s.lastIndex - 1] == 'A')

    var convertedString = s
    val hours = convertedString.take(2).toInt()

    if ((isAm && hours == 12) || (!isAm && hours != 12)) {
        var militaryHours = (hours + 12).toString()

        if (militaryHours == "24") {
            militaryHours = "00"
        }

        convertedString = convertedString.replaceRange(0..1, militaryHours)
    }

    return convertedString.dropLast(2)
}

// Better solution
private fun timeConversion2(s: String): String {
    val inputFormat = SimpleDateFormat("hh:mm:ss a")
    val outputFormat = SimpleDateFormat("HH:mm:ss")
    return outputFormat.format(inputFormat.parse(s))
}

private fun main(args: Array<String>) {
    val s = readLine()!!

    val result = timeConversion2(s)

    println(result)
}