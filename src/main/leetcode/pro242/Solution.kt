package pro242

// https://leetcode.com/problems/valid-anagram/
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val map1 = s.groupingBy { it }.eachCount()
        val map2 = t.groupingBy { it }.eachCount()

        if (map1.size != map2.size) {
            return false
        }

        map1.forEach { (key, value) ->
            if (value != map2.getOrDefault(key, -1)) {
                return false
            }
        }

        return true
    }
}