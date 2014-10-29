import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * </p>
 * 
 * @author Wei Gao
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int max = 1;
        int begin = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(chs[0], 0);
        for (int i = 1; i < chs.length; i++) {
            if (map.containsKey(chs[i]) && map.get(chs[i]) >= begin
                    && map.get(chs[i]) <= i) {
                max = max > (i - begin) ? max : (i - begin);
                begin = map.get(chs[i]) + 1;
            }
            map.put(chs[i], i);
        }
        max = max > (chs.length - begin) ? max : (chs.length - begin);
        return max;
    }
}
