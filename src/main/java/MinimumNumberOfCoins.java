import java.util.HashMap;
import java.util.Map;

/**
 * You are given some denominations of coins in an array (int denom[])and
 * infinite supply of all of them. Given an amount (int amount), find the
 * minimum number of coins required to get the exact amount.
 * 
 * @author Wei Gao
 * @see <a
 *      href="http://tech-queries.blogspot.com/2009/04/minimum-number-of-coins.html">Minimum
 *      Number of Coins Problem</a>
 */
public class MinimumNumberOfCoins {
    public int minimumCoins(int[] denom, int amount) {
        Map<Integer, Integer> map = new HashMap<>();
        return minimumCoins(denom, amount, map);
    }

    private int minimumCoins(int[] denom, int amount, Map<Integer, Integer> map) {
        if (amount == 0) {
            return 0;
        } else if (map.containsKey(amount)) {
            return map.get(amount);
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < denom.length; i++) {
                if (denom[i] <= amount) {
                    int t = minimumCoins(denom, amount - denom[i], map) + 1;
                    min = min < t ? min : t;
                }
            }
            map.put(amount, min);
            return min;
        }
    }
}
