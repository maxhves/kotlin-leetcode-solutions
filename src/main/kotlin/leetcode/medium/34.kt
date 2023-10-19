package leetcode.medium

//region Problem


//endregion

//region Test cases


//endregion

//region Solution

private fun main() {

}

private fun searchRange(nums: IntArray, target: Int): IntArray {
    val answer = intArrayOf(-1, -1)

    val start = getIndexOfTarget(nums, target, true)
    val end = getIndexOfTarget(nums, target, false)

    answer[0] = start
    answer[1] = end

    return answer
}

private fun getIndexOfTarget(nums: IntArray, target: Int, findStartIndex: Boolean): Int {
    var answer = -1
    var start = 0
    var end = nums.lastIndex

    while (start <= end) {
        val midpoint = start + (end - start) / 2

        if (target < nums[midpoint]) {
            end = midpoint - 1
        } else if (target > nums[midpoint]) {
            start = midpoint + 1
        } else {
            // Potential answer is found
            answer = midpoint

            if (findStartIndex) {
                end = midpoint - 1
            } else {
                start = midpoint + 1
            }
        }
    }

    return answer
}

//endregion