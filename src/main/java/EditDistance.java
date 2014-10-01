/**
 * <p>
 * Given two words <i>word1</i> and <i>word2</i>, find the minimum number of
 * steps required to convert <i>word1</i> to <i>word2</i>. (each operation is
 * counted as 1 step.)
 * </p>
 * 
 * <p>
 * You have the following 3 operations permitted on a word:
 * 
 * <ul>
 * <li>Insert a character</li>
 * <li>Delete a character</li>
 * <li>Replace a character</li>
 * </ul>
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/edit-distance/">Leetcode Edit
 *      Distance Problem</a>
 * @see <a href="http://web.stanford.edu/class/cs124/lec/med.pdf">A good
 *      document about minimum edit distance algorithem</a>
 * @author Wei Gao
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int dp[][] = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int t;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    t = dp[i - 1][j - 1];
                } else {
                    t = dp[i - 1][j - 1] + 2;
                }
                t = t < dp[i - 1][j] + 1 ? t : dp[i - 1][j] + 1;
                t = t < dp[i][j - 1] + 1 ? t : dp[i][j - 1] + 1;
                dp[i][j] = t;
            }
        }

        return dp[len1][len2];
    }
}
