package pro647

// https://leetcode.com/problems/palindromic-substrings/
class Solution {
    fun countSubstrings(s: String): Int {
        val isPalindrome = Array(s.length) { BooleanArray(s.length) { false } }

        var answer = s.length
        for (i in s.indices) {
            isPalindrome[i][i] = true
        }

        for (i in 0 until s.length - 1) {
            if (s[i] == s[i + 1]) {
                isPalindrome[i][i + 1] = true
                answer++
            }
        }

        for (length in 3 .. s.length) {
            for (j in 0 .. s.length - length) {
                if (isPalindrome[j + 1][j + length - 2] && s[j] == s[j + length - 1]) {
                    isPalindrome[j][j + length - 1] = true
                    answer++
                }
            }
        }

        return answer
    }
}