package pro1342

class Solution {
    fun numberOfSteps(num: Int): Int {
        if(num == 0) {
            return 0
        }
        var n = num
        var answer = -1
        while (n > 0) {
            if (n and 1 == 1) {
                answer+=2
            } else {
                answer++
            }
            n = n ushr 1
        }

        return answer
    }
}