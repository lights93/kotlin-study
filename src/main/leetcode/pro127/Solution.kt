package pro127

// TLE...
class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if(!wordList.contains(endWord)) {
            return 0
        }

        var result = Int.MAX_VALUE

        val map = mutableMapOf<String, MutableSet<String>>()
        val dp = mutableMapOf<String, Int>()

        fun getDiff(startWord: String, temp: String): Int {
            var diff = 0

            for (i in startWord.indices) {
                if (startWord[i] != temp[i]) {
                    diff++
                }
                if (diff > 1) {
                    break
                }
            }
            return diff
        }

        fun solve(startWord: String, remain: MutableSet<String>, sum: Int) {
            println("$startWord, $sum")

            if(endWord == startWord) {
                result = minOf(result, sum)
                println("$result")

                return
            }

            if(dp.containsKey(startWord) && sum >= dp[startWord]!!) {
                return
            }


            dp[startWord] = sum

            for (temp in remain) {
                if(map.getOrDefault(startWord, mutableSetOf()).contains(temp)) {
                    solve(temp, (remain - temp).toMutableSet(), sum + 1)
                    continue
                }

                if(getDiff(startWord, temp) == 1) {
                    map.putIfAbsent(startWord, mutableSetOf())
                    map[startWord]!!.add(temp)

                    map.putIfAbsent(temp, mutableSetOf())
                    map[temp]!!.add(startWord)

                    solve(temp, (remain - temp).toMutableSet(), sum + 1)
                }
            }
        }

        solve(beginWord, wordList.toMutableSet(), 1)

        if(result == Int.MAX_VALUE) {
            return 0
        }
        return result
    }
}