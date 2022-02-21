package pro986

// https://leetcode.com/problems/interval-list-intersections/
class Solution {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        var firstIdx = 0
        var secondIdx = 0

        val answer = mutableListOf<IntArray>()
        while (firstIdx < firstList.size && secondIdx < secondList.size) {
            val first = firstList[firstIdx]
            val second = secondList[secondIdx]

            val lowerMax = maxOf(first[0], second[0])
            val higherMin = minOf(first[1], second[1])

            if (lowerMax <= higherMin) {
                answer.add(intArrayOf(lowerMax, higherMin))
            }

            if (first[1] < second[1]) {
                firstIdx++
            } else if (first[1] > second[1]) {
                secondIdx++
            } else {
                firstIdx++
                secondIdx++
            }
        }

        return answer.toTypedArray()
    }
}