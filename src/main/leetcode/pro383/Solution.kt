package pro383

// https://leetcode.com/problems/ransom-note/
class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val magazines = magazine.groupingBy { it }.eachCount().toMutableMap()

        ransomNote.forEach {
            val cnt = magazines.getOrDefault(it, 0)
            if (cnt == 0) {
                return false
            }

            magazines[it] = cnt - 1
        }

        return true
    }
}