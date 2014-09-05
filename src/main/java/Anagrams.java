import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Given an array of strings, return all groups of strings that are anagrams.
 * </p>
 * 
 * <p>
 * Note: All inputs will be in lower-case.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/anagrams/">Leetcode Anagrams
 *      Problem</a>
 * @author Wei Gao
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String t = new String(chs);
            List<String> l = map.get(t);
            if (l == null) {
                l = new ArrayList<>();
                map.put(t, l);
            }
            l.add(str);
        }
        for (List<String> l : map.values()) {
            if (l.size() > 1) {
                result.addAll(l);
            }
        }
        return result;
    }
}
