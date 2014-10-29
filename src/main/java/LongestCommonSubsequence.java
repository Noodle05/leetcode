/**
 * Longest Common Subsequence
 * 
 * @author Wei Gao
 * @see <a
 *      href="https://en.wikipedia.org/wiki/Longest_common_subsequence_problem">Wikipedia
 *      Page</a>
 */
public class LongestCommonSubsequence {
    public int lcs(String S, String T) {
        int m = T.length();
        int n = S.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (S.charAt(j - 1) == T.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
