/**
 * <p>
 * Given a <i>m</i> x <i>n</i> grid filled with non-negative numbers, find a
 * path from top left to bottom right which <i>minimizes</i> the sum of all
 * numbers along its path.
 * </p>
 * 
 * <p>
 * <b>Note:</b> You can only move either down or right at any point in time.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/minimum-path-sum/">Leetcode
 *      Minimum Path Sum Problem</a>
 * @author Wei Gao
 *
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(grid[i][j] + dp[i - 1][j], grid[i][j]
                        + dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
