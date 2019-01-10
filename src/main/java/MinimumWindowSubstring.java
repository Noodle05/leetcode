import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * </p>
 * 
 * <p>
 * For example,<br />
 * <b>S</b> = <font color="red">"ADOBECODEBANC"</font><br />
 * <b>T</b> = <font color="red">"ABC"</font><br />
 * Minimum window is <font color="red">"BANC"</font>.
 * </p>
 * 
 * <p>
 * <b>Note:</b><br />
 * If there is no such window in S that covers all characters in T, return the
 * emtpy string <font color="red">""</font>.<br />
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/minimum-window-substring/">Leetcode
 *      Minimum Window Substring Problem</a>
 * @author Wei Gao
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, offset = -1, len = Integer.MAX_VALUE;
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int counter = map.size();

        while (end < s.length()) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    counter --;
                }
            }
            end ++;

            while (counter == 0) {
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter ++;
                    }
                }
                if ((end - begin) < len) {
                    len = end - begin;
                    offset = begin;
                }
                begin ++;
            }
        }
        if (offset >= 0) {
            return s.substring(offset, offset + len);
        } else {
            return "";
        }
    }
}
