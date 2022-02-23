package pro438

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.length < p.length) {
            return listOf()
        }
        val countMap = p.groupingBy { c -> c }
            .eachCount()

        val mutableMap = mutableMapOf<Char, Int>()

        for (i in 0 until p.length - 1) {
            mutableMap[s[i]] = mutableMap.getOrDefault(s[i], 0) + 1
        }

        val answer = mutableListOf<Int>()
        for (i in p.length - 1 until s.length) {
            mutableMap[s[i]] = mutableMap.getOrDefault(s[i], 0) + 1
            if (mutableMap == countMap) {
                answer.add(i - p.length + 1)
            }

            mutableMap[s[i - p.length + 1]] = mutableMap.getOrDefault(s[i - p.length + 1], 0) - 1
            if (mutableMap[s[i - p.length + 1]] == 0) {
                mutableMap.remove(s[i - p.length + 1])
            }
        }

        return answer
    }

}