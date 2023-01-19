package leetcode.easy

fun main(args: Array<String>) {
    convertTemperature(36.50)
}

private fun convertTemperature(celsius: Double): DoubleArray {
    // Problem
    // Non-negative floating point number, rounded to 2 decimal places
    // ans = [Kelvin, Fahrenheit] must be 5 decimal places
    // Kelvin = Celsius + 273.15
    // Fahrenheit = Celsius * 1.80 + 32.00

    println(celsius)

    val kelvin = celsius + 273.15
    val fahrenheit = (celsius * 1.80) + 32.00

    println(kelvin)
    println(fahrenheit)

    return doubleArrayOf(kelvin, fahrenheit)
}
