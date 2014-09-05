import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * <p>
 * Given two words (<i>start</i> and <i>end</i>), and a dictionary, find all
 * shortest transformation sequence(s) from <i>start</i> to <i>end</i>, such
 * that:
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
 * Return
 * 
 * <pre>
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 * </pre>
 * 
 * </p>
 * <p>
 * <b>Note:</b>
 * <ul>
 * <li>All words have the same length.</li>
 * <li>All words contain only lowercase alphabetic characters.</li>
 * </ul>
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/word-ladder-ii/">Leetcode Word
 *      Ladder II Problem</a>
 * @author Wei Gao
 */
public class WordLadderII {
    /*
     * Graph of example: |--- dot --- dog ---| hit --- hot -- | | | |--- cog
     * |--- lot --- log ---|
     * 
     * backward adjacent list: hit => null hot => hit dot => hot lot => hot dog
     * => dot log => lot cog => dot -- log
     */
    public List<List<String>> findLadders(String start, String end,
            Set<String> dict) {
        // <String, Queue> contaion all the adjacent words that is discover in
        // its previous level
        Map<String, Queue<String>> adjMap = new HashMap<>();
        int currLen = 0;
        boolean found = false;
        List<List<String>> r = new ArrayList<>(); // results
        Queue<String> queue = new LinkedList<>(); // queue for BFS
        Set<String> unVisited = new HashSet<>(dict); // unvisited words
        Set<String> visitedThisLev = new HashSet<>(); // check words
                                                      // visited during
                                                      // same level
        unVisited.add(end);

        queue.offer(start);
        int currLev = 1;
        int nextLev = 0;

        for (String word : unVisited) {
            adjMap.put(word, new LinkedList<>());
        }
        unVisited.remove(start);

        // BFS
        while (!queue.isEmpty()) {
            String currLadder = queue.poll();
            // for all unvisited words that are one character change from
            // current word
            for (String nextLadder : getNextLadder(currLadder, unVisited)) {
                if (visitedThisLev.add(nextLadder)) {
                    nextLev++;
                    queue.offer(nextLadder);
                }
                adjMap.get(nextLadder).offer(currLadder);
                if (nextLadder.equals(end) && !found) {
                    found = true;
                    currLen += 2;
                }
            }

            if (--currLev == 0) {
                if (found)
                    break;
                unVisited.removeAll(visitedThisLev);
                currLev = nextLev;
                nextLev = 0;
                currLen++;
            }
        }

        if (found) {
            Deque<String> p = new ArrayDeque<>();
            p.addFirst(end);
            getLadders(start, end, p, r, adjMap, currLen);
        }

        return r;
    }

    // get all unvisited words that are one character change from current word
    private List<String> getNextLadder(String currLadder, Set<String> unVisited) {
        List<String> nextLadders = new ArrayList<>();
        StringBuilder replace = new StringBuilder(currLadder);
        for (int i = 0; i < currLadder.length(); i++) {
            char old = replace.charAt(i);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                replace.setCharAt(i, ch);
                String replaced = replace.toString();
                if (ch != currLadder.charAt(i) && unVisited.contains(replaced)) {
                    nextLadders.add(replaced);
                }
            }
            replace.setCharAt(i, old);
        }
        return nextLadders;
    }

    // DFS to get all possible path from start to end
    private void getLadders(String start, String currLadder, Deque<String> p,
            List<List<String>> solu, Map<String, Queue<String>> adjMap, int len) {
        if (currLadder.equals(start)) {
            solu.add(new ArrayList<>(p));
        } else if (len > 0) {
            Queue<String> adjs = adjMap.get(currLadder);
            for (String lad : adjs) {
                p.addFirst(lad);
                getLadders(start, lad, p, solu, adjMap, len - 1);
                p.removeFirst();
            }
        }
    }
}
