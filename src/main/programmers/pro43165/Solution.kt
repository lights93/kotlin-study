package pro43165

// https://programmers.co.kr/learn/courses/30/lessons/43165
class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        return solve(numbers, target, 0, 0)
    }

    private fun solve(numbers: IntArray, target: Int, idx: Int, sum: Int): Int {
        if(idx >= numbers.size) {
            if(target == sum) {
                return 1
            }
            return 0
        }

        var tempSum = 0

        tempSum += solve(numbers, target, idx + 1, sum + numbers[idx])
        tempSum += solve(numbers, target, idx + 1, sum - numbers[idx])

        return tempSum
    }
}