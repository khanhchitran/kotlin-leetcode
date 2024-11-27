package problems

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 *
 */

class Leetcode122 {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0

        for(price in prices) {
            if(price < minPrice){
                minPrice = price
            } else {
                val profit = price - minPrice
                maxProfit = maxOf(maxProfit, profit)
            }
        }
        return maxProfit
    }
}
