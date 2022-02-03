package pro121

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var max = prices[prices.size - 1]
        var result = 0

        (prices.size - 1 downTo 0).forEach {
            result = maxOf(result, max - prices[it])
            max = maxOf(max, prices[it])
        }

        return result
    }
}