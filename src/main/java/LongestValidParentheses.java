import java.util.Arrays;

/**
 * <p>
 * Given a string containing just the characters <font color="red">'('</font>
 * and <font color="red">')'</font>, find the length of the longest valid
 * (well-formed) parentheses substring.
 * </p>
 * 
 * <p>
 * For <font color="red">"(()"</font>, the longest valid parentheses substring
 * is <font color="red">"()"</font>, which has length = 2.
 * </p>
 * 
 * <p>
 * Another example is <font color="red">")()())"</font>, where the longest valid
 * parentheses substring is <font color="red">"()()"</font>, which has length =
 * 4.
 * </p>
 * 
 * @author Wei Gao
 * @see <a
 *      href="https://oj.leetcode.com/problems/longest-valid-parentheses/">Leetcode
 *      Longest Valid Parentheses Problem</a>
 */
public class LongestValidParentheses {
    /**
     * <pre>
     * The main idea is as follows: I construct a array longest[], for any
     * longest[i], it stores the longest length of valid parentheses which is
     * end at i.
     * </pre>
     * 
     * And the DP idea is:<br />
     * 
     * <pre>
     * If s[i] is '(', set longest[i] to 0,because any string end with '(' cannot be a valid one.
     * Else if s[i] is ')'
     *   If s[i-1] is '(', longest[i] = longest[i-2] + 2
     *   Else if s[i-1] is ')' and s[i-longest[i-1]-1] == '(', longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]
     * </pre>
     * 
     * For example, input "()(())", at i = 5, longest array is [0,2,0,0,2,0],
     * longest[5] = longest[4] + 2 + longest[1] = 6.
     * 
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        char[] chs = s.toCharArray();
        int[] longest = new int[chs.length];
        Arrays.fill(longest, 0);
        int max = 0;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] == ')') {
                if (chs[i - 1] == '(') {
                    longest[i] = (i - 2) >= 0 ? (longest[i - 2] + 2) : 2;
                    max = max > longest[i] ? max : longest[i];
                } else {
                    if (i - longest[i - 1] - 1 >= 0
                            && chs[i - longest[i - 1] - 1] == '(') {
                        longest[i] = longest[i - 1]
                                + 2
                                + ((i - longest[i - 1] - 2 >= 0) ? longest[i
                                        - longest[i - 1] - 2] : 0);
                        max = max > longest[i] ? max : longest[i];
                    }
                }
            }
        }
        return max;
    }
}
