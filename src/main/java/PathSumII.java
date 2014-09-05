import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * </p>
 * 
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
 *          /  \    / \
 *         7    2  5   1
 * </pre>
 * 
 * return
 * 
 * <pre>
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * </pre>
 * 
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/path-sum-ii/">Leetcode Path
 *      Sum II Problem</a>
 * @author Wei Gao
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root != null) {
            pathSum(root, stack, sum, 0, result);
        }

        return result;
    }

    private void pathSum(TreeNode node, Deque<TreeNode> stack, int sum,
            int currentSum, List<List<Integer>> result) {
        int s = currentSum + node.val;
        if (node.left == null && node.right == null) {
            if (sum == s) {
                List<Integer> ns = new ArrayList<>(stack.size() + 1);
                Iterator<TreeNode> ite = stack.descendingIterator();
                while (ite.hasNext()) {
                    ns.add(ite.next().val);
                }
                ns.add(node.val);
                result.add(ns);
            }
        } else {
            stack.push(node);
            if (node.left != null) {
                pathSum(node.left, stack, sum, s, result);
            }
            if (node.right != null) {
                pathSum(node.right, stack, sum, s, result);
            }
            stack.pop();
        }
    }
}
