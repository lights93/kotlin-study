package pro216

class Solution {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        return solve(k, n, mutableSetOf(), 1)
    }

    private fun solve(remain: Int, target: Int, used: MutableSet<Int>, start: Int) : List<List<Int>> {
        val answer = mutableListOf<List<Int>>()

        if(remain < 0 || target < 0) {
            return answer
        }

        if(target == 0 && remain == 0) {
            answer.add(used.toList())
            return answer.toList()
        }

        (start .. 9)
            .filter { !used.contains(it) }
            .forEach {
                used.add(it)
                answer.addAll(solve(remain - 1, target - it, used, it + 1))
                used.remove(it)
            }

        return answer
    }
}