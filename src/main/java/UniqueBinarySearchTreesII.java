import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Given n, generate all structurally unique <b>BST's</b> (binary search trees)
 * that store values 1...<i>n</i>.
 * </p>
 * <p>
 * For example,<br />
 * Given <i>n</i> = 3, your program should return all 5 unique BST's shown
 * below.
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
 *      href="https://oj.leetcode.com/problems/unique-binary-search-trees-ii/">Leetcode
 *      Unique Binary Search Trees II Problem</a>
 * @author Wei Gao
 *
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int begin, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (end < begin) {
            result.add(null);
            return result;
        }
        if (end == begin) {
            result.add(new TreeNode(begin));
            return result;
        }
        for (int i = begin; i <= end; i++) {
            List<TreeNode> left = generateTrees(begin, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode t = new TreeNode(i);
                    t.left = l;
                    t.right = r;
                    result.add(t);
                }
            }
        }
        return result;
    }
}
