import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * </p>
 * 
 * <p>
 * For example, this binary tree is symmetric:
 * 
 * <pre>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * </pre>
 * 
 * But the following is not:
 * 
 * <pre>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * </pre>
 * 
 * </p>
 * <p>
 * <b>Note:</b><br />
 * Bonus points if you could solve it both recursively and iteratively.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/symmetric-tree/">Leetcode
 *      Symmertric Tree problem</a>
 * @author Wei Gao
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> leftStack = new ArrayDeque<>();
        Deque<TreeNode> rightStack = new ArrayDeque<>();
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        leftStack.push(root.left);
        rightStack.push(root.right);
        while (!leftStack.isEmpty()) {
            TreeNode left = leftStack.pop();
            TreeNode right = rightStack.pop();
            if (left.val != right.val) {
                return false;
            }
            if (left.left != null || right.right != null) {
                if (left.left == null || right.right == null) {
                    return false;
                } else {
                    leftStack.push(left.left);
                    rightStack.push(right.right);
                }
            }
            if (left.right != null || right.left != null) {
                if (left.right == null || right.left == null) {
                    return false;
                } else {
                    leftStack.push(left.right);
                    rightStack.push(right.left);
                }
            }
        }
        return true;
    }
}
