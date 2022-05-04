package pro1679

class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val map = HashMap<Int, Int>()

        var answer = 0
        for (num in nums) {
            val diff = k - num
            val cnt = map.getOrDefault(diff, 0)
            if(cnt > 0) {
                answer++
                map[diff] = cnt - 1
            } else {
                map[num] = map.getOrDefault(num, 0) + 1
            }
        }

        return answer
    }
}