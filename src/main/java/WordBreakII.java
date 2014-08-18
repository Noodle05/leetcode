import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * Given a string <i>s</i> and a dictionary of words <i>dict</i>, add spaces in
 * <i>s</i> to construct a sentence where each word is a valid dictionary word.
 * </p>
 * 
 * <p>
 * Return all such possible sentences.
 * </p>
 * <p>
 * For example, given<br />
 * s = <font color="red">"catsanddog"</font>,<br />
 * dict = <font color="red">["cat", "cats", "and", "sand", "dog"]</font>.<br />
 * 
 * A solution is <font color="red">["cats and dog", "cat sand dog"]</font>.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/word-break-ii/">Leetcode Word
 *      Break II Problem</a>
 * @author Wei Gao
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<>();

        if (s != null && !s.isEmpty()) {
            Map<Integer, List<String>> map = new HashMap<>();
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i + 1; j < s.length() + 1; j ++) {
                    String t = s.substring(i, j);
                    if (dict.contains(t)) {
                        List<String> r = map.get(i);
                        if (r == null) {
                            r = new ArrayList<>();
                        }
                        if (j < s.length()) {
                            List<String> r1 = map.get(j);
                            if (r1 != null) {
                                for (String tt : r1) {
                                    r.add(t + " " + tt);
                                }
                            }
                        } else {
                            r.add(t);
                        }
                        map.put(i, r);
                    }
                }
            }
            if (map.get(0) != null) {
                result = map.get(0);
            }
        }

        return result;
    }
}
