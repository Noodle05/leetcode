import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * <p>
 * Given two words (<i>start</i> and <i>end</i>), and a dictionary, find the
 * length of shortest transformation sequence from <i>start</i> to <i>end</i>,
 * such that:
 * 
 * 
 * <ol>
 * <li>Only one letter can be changed at a time</li>
 * <li>Each intermediate word must exist in the dictionary</li>
 * </ol>
 * </p>
 * <p>
 * For example,<br />
 * 
 * Given:<br />
 * <i>start</i> = <font color="red">"hit"</font><br />
 * <i>end</i> = <font color="red">"cog"</font><br />
 * <i>dict</i> = <font color="red">["hot","dot","dog","lot","log"]</font><br />
 * As one shortest transformation is <font color="red">"hit" -> "hot" -> "dot"
 * -> "dog" -> "cog"</font>,<br />
 * return its length <font color="red">5</font>.
 * </p>
 * <p>
 * Note:
 * <ul>
 * <li>Return 0 if there is no such transformation sequence.</li>
 * <li>All words have the same length.</li>
 * <li>All words contain only lowercase alphabetic characters.</li>
 * </ul>
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/word-ladder/">Leetcode Word
 *      Ladder Problem</a>
 * @author Wei Gao
 */
public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        Queue<Integer> steps = new ArrayDeque<>();

        int n = start.length();
        visited.add(start);
        queue.add(start);
        steps.add(1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = steps.poll();
            char[] wordChar = word.toCharArray();

            for (int i = 0; i < n; i++) {
                char saved = wordChar[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != saved) {
                        wordChar[i] = c;
                        String str = new String(wordChar);
                        if (str.equals(end)) {
                            return step + 1;
                        }
                        if (dict.contains(str) && !visited.contains(str)) {
                            visited.add(str);
                            queue.add(str);
                            steps.add(step + 1);
                        }
                    }
                }
                wordChar[i] = saved;
            }
        }
        return 0;
    }
}
