package pro60060

// https://programmers.co.kr/learn/courses/30/lessons/60060
class Solution {
    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        val allCounts = queries
            .filter { it[0] == '?' && it[it.lastIndex] == '?' }
            .associate { Pair(it.length, 0) }
            .toMutableMap()

        val reversed = queries
            .filter { it[0] == '?' && it[it.lastIndex] != '?' }
            .associate { Pair(it.reversed(), 0) }
            .toMutableMap()

        val firsts = queries
            .filter { it[0] != '?' && it[it.lastIndex] == '?' }
            .associateWith { 0 }
            .toMutableMap()

        val firstSet = mutableSetOf<String>()
        for (key in firsts.keys) {
            val temp = StringBuilder()
            for (c in key) {
                temp.append(c)
                firstSet.add(temp.toString())
            }
        }

        for (word in words) {
            if (allCounts.contains(word.length)) {
                allCounts[word.length] = allCounts.getOrDefault(word.length, 0) + 1
            }

             firsts.filterKeys { it.length == word.length }
                .filterKeys { k ->
                    val temp = k.substring(0, k.indexOfFirst { it == '?' })
                    word.substring(0, temp.length) == temp
                }
                 .forEach { firsts[it.key] = it.value + 1 }

            reversed.filterKeys { it.length == word.length }
                .filterKeys { k ->
                    val temp = k.substring(0, k.indexOfFirst { it == '?' })
                    word.reversed().substring(0, temp.length) == temp
                }
                .forEach { reversed[it.key] = it.value + 1 }
        }

        val answer = IntArray(queries.size)
        for ((index, query) in queries.withIndex()) {
            if(firsts.contains(query)) {
                answer[index] = firsts[query]!!
                continue
            }

            if(reversed.contains(query.reversed())) {
                answer[index] = reversed[query.reversed()]!!
                continue
            }

            answer[index] = allCounts.getOrDefault(query.length, 0)
        }

        return answer
    }
}