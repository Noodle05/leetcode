import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Given n, how many structurally unique <b>BST's</b> (binary search trees) that
 * store values 1...<i>n</i>?
 * </p>
 * <p>
 * For example,<br />
 * Given <i>n</i> = 3, there are a total of 5 unique BST's.
 * 
 * <pre>
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * </pre>
 * 
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/unique-binary-search-trees/">Leetcode
 *      Unique Binary Search Trees Problem</a>
 * @author Wei Gao
 *
 */
public class UniqueBinarySearchTree {
    public int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return numTrees(n, map);
    }

    private int numTrees(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int numTrees = 0;
        for (int i = 1; i <= n; i++) {
            numTrees += numTrees(i - 1) * numTrees(n - i);
        }
        map.put(n, numTrees);
        return numTrees;
    }
}
