/**
 * <p>
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * </p>
 * 
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of <i>s</i>.
 * </p>
 * <p>
 * For example, given s = <font color="red">"aab"</font>,<br />
 * Return <font color="red">1</font> since the palindrome partitioning <font
 * color="red">["aa","b"]</font> could be produced using 1 cut.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/palindrome-partitioning-ii/">Leetcode
 *      Palindrome Partitioning II Problem</a>
 * @author Wei Gao
 */
public class PalindromePartitioningII {
    /**
     * A solution that use O(n^2) complicity and O(n) space.
     * 
     * @param s
     * @return
     */
    public int minCut(String s) {
        int n = s.length();
        int[] cut = new int[n + 1]; // number of cuts for the first k characters
        for (int i = 0; i <= n; i++) {
            cut[i] = i - 1;
        }
        for (int i = 0; i < n; i++) {
            // odd length palindrome
            for (int j = 0; i - j >= 0 && i + j < n
                    && s.charAt(i - j) == s.charAt(i + j); j++) {
                cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j]);
            }
            // even length palindrome
            for (int j = 1; i - j + 1 >= 0 && i + j < n
                    && s.charAt(i - j + 1) == s.charAt(i + j); j++) {
                cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j + 1]);
            }
        }
        return cut[n];
    }
}
