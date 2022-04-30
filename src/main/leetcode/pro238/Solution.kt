package pro238

// https://leetcode.com/problems/product-of-array-except-self/
class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        if (nums.filter { it == 0 }.size > 1) {
            return IntArray(nums.size) { 0 }
        }

        val zeroIndex = nums.indexOfFirst { it == 0 }
        if(zeroIndex != -1) {
            val answer = IntArray(nums.size) { 0 }
            val product = nums.filter { it != 0 }.reduce { acc, i ->  acc * i }
            answer[zeroIndex] = product
            return answer
        }

        var multiple = 1
        val result = nums.map {
            multiple *= it
            multiple
        }.toIntArray()

        multiple = 1
        for(i in 0 until nums.size - 1) {
            result[nums.size - i - 1] = result[nums.size - i - 2] * multiple
            multiple *= nums[nums.size - i - 1]
        }

        result[0] = multiple
        return result
    }
}