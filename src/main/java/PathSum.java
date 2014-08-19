import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * </p>
 * <p>
 * For example:<br />
 * Given the below binary tree and <font color="red">sum = 22</font>,
 * 
 * <pre>
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * </pre>
 * 
 * return true, as there exist a root-to-leaf path <font
 * color="red">5->4->11->2</font> which sum is 22.
 * </p>
 * 
 * @author Wei Gao
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        Deque<Integer> stack = new ArrayDeque<>();
        if (root != null) {
            return hasPathSum(root, sum, stack);
        } else {
            return false;
        }
    }

    private boolean hasPathSum(TreeNode root, int sum, Deque<Integer> stack) {
        int val = root.val;
        if (!stack.isEmpty()) {
            val += stack.peek();
        }
        if (root.left == null && root.right == null) {
            if (val == sum) {
                return true;
            } else {
                return false;
            }
        } else {
            stack.push(val);
            if (root.left != null && hasPathSum(root.left, sum, stack)) {
                return true;
            }
            if (root.right != null && hasPathSum(root.right, sum, stack)) {
                return true;
            }
            stack.pop();
            return false;
        }
    }
}
