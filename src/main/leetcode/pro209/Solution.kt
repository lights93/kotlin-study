package pro209

// https://leetcode.com/problems/minimum-size-subarray-sum/
class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var right = 0
        var answer = Int.MAX_VALUE
        var sum = nums[0]

        while (right < nums.size) {
            when {
                sum < target -> {
                    right++
                    if (right < nums.size) {
                        sum += nums[right]
                    }
                }
                sum == target -> {
                    answer = minOf(answer, right - left + 1)
                    if (answer == 1) {
                        return answer
                    }
                    sum -= nums[left++]
                    right++
                    if (right < nums.size) {
                        sum += nums[right]
                    }
                }
                else -> {
                    answer = minOf(answer, right - left + 1)
                    if (answer == 1) {
                        return answer
                    }
                    sum -= nums[left++]
                }
            }
        }

        if (answer == Int.MAX_VALUE) {
            return 0
        }

        return answer
    }
}