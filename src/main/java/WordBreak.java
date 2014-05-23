import java.util.Set;

/**
 * 
 */

/**
 * <p>
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * </p>
 * 
 * <p>
 * For example, given<br />
 * s = <font color="red">"leetcode"</font>,<br />
 * dict = <font color="red">["leet", "code"]</font>.<br />
 * <br />
 * Return true because <font color="red">"leetcode"</font> can be segmented as
 * <font color="red">"leet code"</font>.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/word-break/">Leetcode Word
 *      Break Problem</a>
 * @author Wei Gao
 */
public class WordBreak {
  public boolean wordBreak(String s, Set<String> dict) {
    int len = s.length();
    boolean[] dp = new boolean[len + 1];
    dp[len] = true;

    for (int i = len - 1; i >= 0; i--) {
      for (int j = i; j < len; j++) {
        String str = s.substring(i, j + 1);
        if (dict.contains(str) && dp[j + 1]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[0];
  }
}
