import java.util.Arrays;

/**
 * @author Wei Gao
 * @since 2019-01-10
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int amt = coins[i]; amt < dp.length; amt++) {
                int tmp = dp[amt - coins[i]] == -1 ? -1 : dp[amt - coins[i]] + 1;
                if (dp[amt] == -1) {
                    dp[amt] = tmp;
                } else if (tmp != -1) {
                    dp[amt] = Math.min(dp[amt], tmp);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
