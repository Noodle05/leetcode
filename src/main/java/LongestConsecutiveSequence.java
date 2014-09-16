import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * </p>
 * 
 * <p>
 * For example,<br />
 * Given <font color="red">[100, 4, 200, 1, 3, 2]</font>,<br />
 * The longest consecutive elements sequence is <font color="red">[1, 2, 3,
 * 4]</font>. Return its length: <font color="red">4</font>.
 * </p>
 * 
 * <p>
 * Your algorithm should run in O(n) complexity.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/longest-consecutive-sequence/">Leetcode
 *      Longest Consecutive Sequence Problem</a>
 * @author Wei Gao
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i])) {
                continue;
            }
            int low = num[i], upp = num[i];
            if (map.containsKey(num[i] - 1)) {
                low = map.get(num[i] - 1);
            }
            if (map.containsKey(num[i] + 1)) {
                upp = map.get(num[i] + 1);
            }
            longest = Math.max(longest, (upp - low) + 1);
            map.put(num[i], num[i]);
            map.put(low, upp);
            map.put(upp, low);
        }
        return longest;
    }
}
