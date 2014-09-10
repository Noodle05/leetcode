/**
 * <p>
 * Given <i>s1</i>, <i>s2</i>, <i>s3</i>, find whether <i>s3</i> is formed by
 * the interleaving of <i>s1</i> and <i>s2</i>.
 * </p>
 * <p>
 * For example,<br />
 * Given:<br />
 * <i>s1</i> = <font color="red">"aabcc"</font>,<br />
 * <i>s2</i> = <font color="red">"dbbca"</font>,<br />
 * 
 * When <i>s3</i> = <font color="red">"aadbbcbcac"</font>, return true.<br />
 * When <i>s3</i> = <font color="red">"aadbbbaccc"</font>, return false.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/interleaving-string/">Leetcode
 *      Interleaving String Problem</a>
 * @author Wei Gao
 *
 */
public class InterleavingString {
    /**
     * Define the dp[i][j] as if we can use first i characters from s1 and first
     * j characters from s2 to generate the s3 with length i + j, dp[0][0] =
     * true and the answer is dp[n][m]
     * 
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        int n = s1.length();
        int m = s2.length();
        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i > 0) {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i
                            + j - 1));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j]
                            || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i
                                    + j - 1));
                }
            }
        }
        return dp[n][m];
    }
}
