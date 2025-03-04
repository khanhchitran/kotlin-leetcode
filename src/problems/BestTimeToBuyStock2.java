package problems;

public class BestTimeToBuyStock2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit +=  prices[i] - prices[i - 1];
        }
        return maxProfit;
    }
}
