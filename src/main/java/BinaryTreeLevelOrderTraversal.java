import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <p>
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * </p>
 * 
 * <p>
 * For example: Given binary tree <font color="red">{3,9,20,#,#,15,7}</font>,
 * 
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * 
 * return its level order traversal as:
 * 
 * <pre>
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * </pre>
 * 
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/binary-tree-level-order-traversal/">Leetcode
 *      Binary Tree Level Order Traversal Problem</a>
 * @author Wei Gao
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<TreeNode> tmp = new ArrayList<>(queue);
                queue.clear();
                List<Integer> r = new ArrayList<>(tmp.size());
                for (TreeNode node : tmp) {
                    r.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                result.add(r);
            }
        }
        return result;
    }
}
