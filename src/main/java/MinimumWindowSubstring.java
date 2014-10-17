import java.util.ArrayDeque;
import java.util.Deque;
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
    /**
     * <p>
     * <b>O(n) Solution</b>
     * </p>
     * 
     * <p>
     * The method I used was to map the characters and how many are in the
     * substring vs how many are needed. If all the values are non-negative,
     * then you can remove characters from the start of the substring until you
     * reach a negative, and if there's a negative, you add to the end of the
     * substring until it is 0 again. You continue this until you've reached the
     * end of S, and then remove characters until you have a negative count for
     * one of the characters.
     * </p>
     * 
     * <p>
     * Going through the example, S="ADOBECODEBANC" and T="ABC". Starting out,
     * the map has the values A=-1, B=-1, C=-1, and has a count of 3 negatives.
     * Adding the first letter increases A to 0, which removes a negative,
     * leaving a count of 2. You can count the others as well, since they will
     * never become negative, resulting in A=0,B=0,C=0,D=1,O=1,E=1 when you add
     * the C. Since the negative count is 0, you start removing characters from
     * the start, which is A, dropping it to -1, and switching back to adding at
     * the end.
     * </p>
     * 
     * <p>
     * You then add to the end until you reach an A again, which results in
     * A=0,B=1,C=0,D=2,E=2,O=2 and a count of 0. Remove from the start until you
     * reach a negative again, which removes D,O,B,E,C, since B's removal only
     * drops it to 0, not a negative. At that point, the substring is "ODEBA"
     * and C = -1. Add to the end until you reach a C and you have "ODEBANC",
     * and remove from the start until you get a negative again, leaving "ANC".
     * You've reached the end of the string and have a negative, so there is no
     * shorter string remaining with all the characters.
     * </p>
     * 
     * <p>
     * You can retrieve the shortest substring by taking the start and end
     * indices of the mapped substring whenever you switch from removing to
     * adding and storing them if they are shorter than the previous shortest.
     * If you never switch from removing to adding, then the result is the empty
     * string.
     * </p>
     * 
     * <p>
     * If S="BANC" and T="ABC", then the result is adding until you reach
     * "BANC", switching to remove, hitting a negative (and therefore copying
     * those lengths at 0 and 3), and attempting to add beyond the end which
     * ends the algorithm with the substring starting at 0 and ending at 3.
     * </p>
     * 
     * <p>
     * As every character gets adding once and removed once or less, it takes 2n
     * steps at most to complete the algorithm, an O(n) solution.
     * </p>
     * 
     * @param S
     * @param T
     * @return
     */
    public String minWindow(String S, String T) {
        if (S.length() == 0 || T.length() == 0 || S.length() < T.length())
            return "";

        int left = T.length(), start = -1, end = S.length();

        Deque<Integer> queue = new ArrayDeque<Integer>();

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!map.containsKey(c))
                continue;

            int n = map.get(c);
            map.put(c, n - 1);
            queue.offer(i);
            if (n > 0)
                left--;

            char head = S.charAt(queue.peek());
            while (map.get(head) < 0) {
                queue.poll();
                map.put(head, map.get(head) + 1);
                head = S.charAt(queue.peek());
            }

            if (left == 0) {
                int new_length = queue.peekLast() - queue.peek() + 1;
                if (new_length < end - start) {
                    start = queue.peek();
                    end = queue.peekLast() + 1;
                }
            }
        }
        if (left == 0)
            return S.substring(start, end);
        else
            return "";
    }
}
