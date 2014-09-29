import java.util.Arrays;

/**
 * <p>
 * Given a string <i>s1</i>, we may represent it as a binary tree by
 * partitioning it to two non-empty substrings recursively.
 * </p>
 * 
 * <p>
 * Below is one possible representation of <i>s1</i> = <font
 * color="red">"great"</font>:
 * 
 * <pre>
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * </pre>
 * 
 * To scramble the string, we may choose any non-leaf node and swap its two
 * children.
 * </p>
 * <p>
 * For example, if we choose the node <font color="red">"gr"</font> and swap its
 * two children, it produces a scrambled string <font
 * color="red">"rgeat"</font>.
 * 
 * <pre>
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * </pre>
 * 
 * We say that <font color="red">"rgeat"</font> is a scrambled string of <font
 * color="red">"great"</font>.
 * </p>
 * <p>
 * Similarly, if we continue to swap the children of nodes <font
 * color="red">"eat"</font> and <font color="red">"at"</font>, it produces a
 * scrambled string <font color="red">"rgtae"</font>.
 * 
 * <pre>
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * </pre>
 * 
 * We say that <font color="red">"rgtae"</font> is a scrambled string of <font
 * color="red">"great"</font>.
 * </p>
 * 
 * <p>
 * Given two strings <i>s1</i> and <i>s2</i> of the same length, determine if
 * <i>s2</i> is a scrambled string of <i>s1</i>.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/scramble-string/">LeetCode
 *      Scramble String Problem</a>
 * @author Wei Gao
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        // Dynamic Programing solution
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        int len = s1.length();
        // dp[k][i][j] means s2(j, k) is scramble with s1(i, k)
        boolean dp[][][] = new boolean[len + 1][len][len];
        // Initial len == 1's dp value.
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int k = 2; k <= len; k++) {
            for (int i = 0; i <= len - k; i++) {
                for (int j = 0; j <= len - k; j++) {
                    dp[k][i][j] = false;
                    for (int divlen = 1; divlen < k && !dp[k][i][j]; divlen++) {
                        dp[k][i][j] = (dp[divlen][i][j] && dp[k - divlen][i
                                + divlen][j + divlen])
                                || (dp[divlen][i][j + k - divlen] && dp[k
                                        - divlen][i + divlen][j]);
                    }
                }
            }
        }
        return dp[len][0][0];
    }

    public boolean isScambleForce(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!Arrays.equals(c1, c2))
            return false;
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i),
                            s2.substring(0, s2.length() - i)))
                return true;
        }
        return false;
    }
}
