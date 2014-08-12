/**
 * <p>
 * Say you have an array for which the <i>i</i><sup>th</sup> element is the
 * price of a given stock on day <i>i</i>.
 * </p>
 * 
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most
 * <i>two</i> transactions.
 * </p>
 * 
 * <p>
 * <b>Note:</b><br />
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/">Leetcode
 *      Best Time to Buy and Sell Stock III Problem</a>
 * @author Wei Gao
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int minLR = prices[0];
        int maxRL = prices[prices.length - 1];
        int[] dpLR = new int[prices.length];
        int[] dpRL = new int[prices.length];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minLR)
                minLR = prices[i];
            dpLR[i] = Math.max(dpLR[i - 1], prices[i] - minLR);
        }

        for (int i = prices.length - 2; i > -1; i--) {
            if (prices[i] > maxRL)
                maxRL = prices[i];
            dpRL[i] = Math.max(dpRL[i + 1], maxRL - prices[i]);
        }

        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, dpLR[i] + dpRL[i]);
        }

        return max;
    }
}
