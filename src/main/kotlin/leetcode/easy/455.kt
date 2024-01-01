package leetcode.easy

//region Problem

/**
 * Assume you are an awesome parent and want to give your children some cookies. But, you should
 * give each child at most one cookie.
 *
 * Each child (i) has a greed factor (g[i]), which is the minimum size of a cookie that the child
 * will be content with; and each cookie (j) has a size (s[j]). If (s[i] >= g[i]), we can assign the
 * cookie (j) to the child (i), and the child (i) will be content. Your goal is to maximize the number
 * of your content children and output the maximum number.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - ...
 */

//endregion

//region Solution

private fun main() {
    // Output: 1
    findContentChildren(
        g = intArrayOf(1, 2, 3),
        s = intArrayOf(1, 1),
    )
}

private fun findContentChildren(g: IntArray, s: IntArray): Int {
    g.sort()
    s.sort()

    var i = 0
    var j = 0

    while (i < g.size) {
        while (j < s.size && g[i] > s[j]) {
            j += 1
        }

        if (j < s.size) {
            i += 1
            j += 1
        } else {
            break
        }
    }

    return i
}

//endregion
