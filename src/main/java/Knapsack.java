/**
 * @author Wei Gao
 * @since 2018-12-10
 */
public class Knapsack {
    public int knapsack(int[] wt, int[] val, int weigth) {
        int[][] dp = new int[weigth][val.length + 1];

        for (int i = 0; i < weigth; i ++) {
            for (int j = 1; j <= val.length; j ++) {
                if (wt[j - 1] <= i) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - wt[j - 1]][j] + val[j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[weigth - 1][val.length];
    }
}
