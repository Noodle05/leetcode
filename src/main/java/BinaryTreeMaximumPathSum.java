import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Given a binary tree, find the maximum path sum.
 * </p>
 * 
 * <p>
 * The path may start and end at any node in the tree.
 * </p>
 * 
 * <p>
 * For example:<br />
 * Given the below binary tree,
 * 
 * <pre>
 *        1
 *       / \
 *      2   3
 * </pre>
 * 
 * Return <font color="red">6</font>.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/">Leetcode
 *      Binary Tree Maximum Path Sum Problem</a>
 * @author Wei Gao
 */
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> maxs = new ArrayList<>();
        maxPathSum(root, maxs);
        int max = Integer.MIN_VALUE;
        for (int m : maxs) {
            if (m > max) {
                max = m;
            }
        }
        return max;
    }

    private int maxPathSum(TreeNode root, List<Integer> maxs) {
        int left = root.left == null ? 0 : maxPathSum(root.left, maxs);
        int right = root.right == null ? 0 : maxPathSum(root.right, maxs);
        int m = Math.max(Math.max(root.val, left + root.val + right),
                Math.max(left + root.val, right + root.val));
        maxs.add(m);
        m = Math.max(Math.max(root.val, left + root.val), right + root.val);
        return m;
    }
}
