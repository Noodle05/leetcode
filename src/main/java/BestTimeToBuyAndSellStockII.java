/**
 * <p>
 * Say you have an array for which the <i>i</i><sup>th</sup> element is the
 * price of a given stock on day <i>i</i>.
 * </p>
 * 
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">Leetcode
 *      Best Time to Buy and Sell Stock II Problem</a>
 * @author Wei Gao
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int max = 0;

        if (prices.length > 0) {
            int b = 0;
            boolean bought = false;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    if (!bought) {
                        b = i - 1;
                        bought = true;
                    }
                } else if (prices[i] < prices[i - 1]) {
                    if (bought) {
                        max += prices[i - 1] - prices[b];
                        bought = false;
                    }
                }
            }
            if (bought) {
                max += prices[prices.length - 1] - prices[b];
            }
        }
        return max;
    }
}
