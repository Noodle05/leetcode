/**
 * <p>There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.</p>
 *
 * <p>The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example,costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.</p>
 *
 * <p>Note:<br />
 * All costs are positive integers.</p>
 */
public class PaintHouse {
    public int minCost(int[][] cost) {
        int length = cost.length;
        int k = cost[0].length;
        int[][] dp = new int[length][k];

        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < k; j ++) {
                if (i == 0) {
                    dp[i][j] = cost[i][j];
                    continue;
                }
                int c = Integer.MAX_VALUE;
                for (int l = 0; l < k; l ++) {
                    if (l == j) {
                        continue;
                    }
                    c = Math.min(c, cost[i][l]);
                }
                dp[i][j] = dp[i - 1][j] + c;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < k; i ++) {
            result = Math.min(result, dp[length - 1][i]);
        }
        return result;
    }
}
