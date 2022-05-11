package pro1641

class Solution {
    fun countVowelStrings(n: Int): Int {
        val nums = arrayOf(1, 1, 1, 1, 1)
        repeat(n - 1) {
            var sum = nums.sum()
            (4 downTo 0).forEach {
                val temp = nums[it]
                nums[it] = sum
                sum -= temp
            }
        }

        return nums.sum()
    }
}