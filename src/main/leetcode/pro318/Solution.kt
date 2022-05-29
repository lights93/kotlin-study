package pro318

class Solution {
    fun maxProduct(words: Array<String>): Int {
        val sets = Array<Set<Char>>(words.size) { emptySet() }

        var max = 0
        for (index in words.indices) {
            sets[index] = words[index].chars().toArray().asList().map { it.toChar() }.toSet()
            for (j in 0 until index) {
                if (sets[j].any { sets[index].contains(it) }) {
                    continue
                }
                max = maxOf(max, words[index].length * words[j].length)
            }
        }

        return max
    }
}