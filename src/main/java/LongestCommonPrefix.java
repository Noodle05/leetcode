/**
 * <p>
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/longest-common-prefix/">Leetcode
 *      Longest Common Prefix problem</a>
 * @author Wei Gao
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
