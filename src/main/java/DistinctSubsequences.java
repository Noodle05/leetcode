
/**
 * <p>
 * Given a string <b>S</b> and a string <b>T</b>, count the number of distinct
 * subsequences of <b>T</b> in <b>S</b>.
 * </p>
 * 
 * <p>
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, <font
 * color="red">"ACE"</font> is a subsequence of <font color="red">"ABCDE"</font>
 * while <font color="red">"AEC"</font> is not).
 * </p>
 * <p>
 * Here is an example:<br />
 * <b>S</b> = <font color="red">"rabbbit"</font>, <b>T</b> = <font
 * color="red">"rabbit"</font><br />
 * 
 * Return <font color="red">3</font>.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/distinct-subsequences/">Leetcode
 *      Distinct Subsequences Problem</a>
 * @author Wei Gao
 *
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        int m = T.length();
        int n = S.length();

        if (m > n)
            return 0;
        int[] path = new int[m + 1];
        path[0] = 1;
        for (int j = 1; j <= n; j++) {
            for (int i = m; i >= 1; i--) {
                path[i] = path[i]
                        + (T.charAt(i - 1) == S.charAt(j - 1) ? path[i - 1] : 0);
            }
        }

        return path[m];
    }
}
