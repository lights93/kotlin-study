package pro17

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class Solution {
    fun letterCombinations(digits: String): List<String> {
        val map = mapOf(
                '2' to listOf('a', 'b', 'c'),
                '3' to listOf('d', 'e', 'f'),
                '4' to listOf('g', 'h', 'i'),
                '5' to listOf('j', 'k', 'l'),
                '6' to listOf('m', 'n', 'o'),
                '7' to listOf('p', 'q', 'r', 's'),
                '8' to listOf('t', 'u', 'v'),
                '9' to listOf('w', 'x', 'y', 'z')
        )

        if (digits.isEmpty()) {
            return emptyList()
        }

        return solve(digits, map, 0, StringBuilder())
    }

    private fun solve(digits: String, map: Map<Char, List<Char>>, idx: Int, current: StringBuilder): List<String> {
        val result = mutableListOf<String>()

        if (idx >= digits.length) {
            result.add(current.toString())
            return result
        }

        val chars = map[digits[idx]]

        for (c in chars!!) {
            current.append(c)
            result.addAll(solve(digits, map, idx + 1, current))
            current.deleteCharAt(current.lastIndex)
        }

        return result
    }
}