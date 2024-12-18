package problems;

public class Leetcode188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }

        // If k >= n / 2, we can make as many transactions as we want.
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // DP table
        int[][] dp = new int[k + 1][n];

        // Loop through the number of transactions
        for (int t = 1; t <= k; t++) {
            int maxProfitUpToYesterday = -prices[0];
            for (int d = 1; d < n; d++) {
                // Either we skip the transaction today or sell the stock today
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxProfitUpToYesterday);
                // Update maxProfitUpToYesterday for the current transaction
                maxProfitUpToYesterday = Math.max(maxProfitUpToYesterday, dp[t - 1][d] - prices[d]);
            }
        }

        return dp[k][n - 1];
    }
}
