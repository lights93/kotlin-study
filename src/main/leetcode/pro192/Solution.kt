package pro192

// https://leetcode.com/problems/number-of-1-bits/
class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        var answer = 0
        var num = n
        while (num != 0) {
            if(num % 2 != 0) {
                answer++
            }
            num = num ushr 1
        }

        return answer
    }
}