package hackerrank.easy

fun dayOfProgrammer(year: Int): String {
    // 1700 - 2700
    // 256th day of the year
    // 1700 - 1917: julian cal
    // 1919: gregorian cal
    // 1918 feb 14th (32nd day) was the transition

    // Feb has 29 days in a leap year else 28
    // Julian cal leap year is divisible by 4
    // Gregorian cal leap year is divisible by 400 OR divisible by 4 and _not_ divisible by 100

    val dayOfProgrammer = 256
    val nonLeapDays = 243
    val leapDays = 244

    val dayInSeptember = if (year in 1700 until 1917) {
        // Old leap calc
        if (year % 4 == 0) dayOfProgrammer - leapDays else dayOfProgrammer - nonLeapDays
    } else if (year == 1918) {
        26
    } else {
        // New leap calc
        if (year % 400 == 0 || (year % 4  == 0 && year % 100 != 0)) dayOfProgrammer - leapDays else dayOfProgrammer - nonLeapDays
    }

    return "$dayInSeptember.09.$year"
}

fun main(args: Array<String>) {
    val year = readLine()!!.trim().toInt()

    val result = dayOfProgrammer(year)

    println(result)
}