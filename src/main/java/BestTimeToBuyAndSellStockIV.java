/**
 * <p>Say you have an array for which the i<sup>th</sup> element is the price of a given stock on day i.</p>
 *
 * <p>Design an algorithm to find the maximum profit. You may complete at most k transactions.</p>
 *
 * <p><b>Note:</b><br />
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).</p>
 *
 * <p><b>Example 1:</b>
 * <pre>
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.</pre></p>
 * <p><b>Example 2:</b>
 * <pre>
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.</pre></p>
 */
public class BestTimeToBuyAndSellStockIV {
    /**
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions.
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        if (k >= n/2) {
            int maxPro = 0;
            for (int i = 1; i < n; i ++) {
                if (prices[i] > prices[i - 1])
                    maxPro += prices[i] - prices[i - 1];
            }
            return maxPro;
        }

        // dp[i][j] means the most profit till jth day with most i transactions
        // dp[i][j] = max(don't sell, sell on day j)
        // dont sell: dp[i][j] = dp[i][j - 1] because still i transactions
        // sell on day jth: dp[i][j] = prices[j] - prices[t] + dp[i - 1][t] for (t = [1 to j - 1])
        // use variable buyMax to keep track of largest (- prices[t] + dp[i - 1][t])
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i ++) {
            int buyMax = dp[i - 1][0] - prices[0];
            System.out.print(String.format("dp[%02d][00]=%02d,max=%03d", i, 0, buyMax));
            for (int j = 1; j < n; j ++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + buyMax);
                buyMax = Math.max(buyMax, dp[i - 1][j] - prices[j]);
                System.out.print(String.format(",db[%02d][%02d]=%02d,max=%03d", i, j, dp[i][j], buyMax));
            }
            System.out.println();
        }
        return dp[k][n - 1];
    }
}
