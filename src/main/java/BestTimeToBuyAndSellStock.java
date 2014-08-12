/**
 * <p>
 * Say you have an array for which the <i>i</i><sup>th</sup> element is the
 * price of a given stock on day <i>i</i>.
 * </p>
 * 
 * <p>
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/">Leetcode
 *      Best Time to Buy and Sell Stock Problem</a>
 * @author Wei Gao
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;

        if (prices.length > 0) {
            int b = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < b) {
                    b = i;
                } else if (prices[i] - b > max) {
                    max = prices[i] - b;
                }
            }
        }

        return max;
    }
}
