package pro354

class Solution {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        envelopes.sortWith(compareBy<IntArray> {it[0]}.thenBy {-it[1]})

        val dp = IntArray(envelopes.size)
        var len = 0
        for (envelope in envelopes) {
            var idx = dp.binarySearch(envelope[1], 0, len)
            if(idx < 0) {
                idx = -(idx + 1)
            }
            dp[idx] = envelope[1]
            if(idx == len) {
                len++
            }
        }

        return len
    }
}