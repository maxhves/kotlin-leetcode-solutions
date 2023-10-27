package leetcode.easy

//region Problem

/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 *  - For example, (128) is a self-dividing number because (128 % 1 == 0), (128 % 2 == 0) and (128 % 8 == 0).
 *
 * A self-dividing number is not allowed to contain the digit zero.
 *
 * Given two integers (left) and (right) return a list of all the self-dividing numbers in the range
 * ([left, right]).
 */

//endregion

//region Steps to solve

/**
 * 1. Create a loop from (left) up to (right).
 * 2. For each number in the iteration:
 *    - Create a loop to split out all the digits in the number:
 *      - Divide the original number by its digits.
 *      - If it is divisible by all digits then add it to the result list.
 * 3. Continue this loop to the end.
 * 4. Return the resulting array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
    selfDividingNumbers(left = 1, right = 22)

    // Output: [48, 55, 66, 77]
    selfDividingNumbers(left = 47, right = 85)
}

private fun selfDividingNumbers(left: Int, right: Int): List<Int> {
    val result = ArrayList<Int>()

    for (i in left..right) {
        var tempNumber = i
        var selfDividing = true

        while (tempNumber > 0) {
            val remainder = tempNumber % 10
            tempNumber /= 10

            if (remainder == 0 || i % remainder != 0) {
                selfDividing = false
                break
            }
        }

        if (selfDividing) {
            result.add(i)
        }
    }

    return result
}

//endregion
