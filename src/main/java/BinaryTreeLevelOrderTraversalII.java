import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * Given a binary tree, return the <i>bottom-up level order</i> traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
 * </p>
 * <p>
 * For example:<br />
 * Given binary tree <font color="red">{3,9,20,#,#,15,7}</font>,
 * 
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * 
 * return its bottom-up level order traversal as:
 * 
 * <pre>
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * </pre>
 * 
 * @see <a href="">Leetcode Binary Tree Level Order Traversal II problem</a>
 * @author Wei Gao
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> stack = new ArrayDeque<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                Queue<TreeNode> nq = new ArrayDeque<>();
                List<Integer> val = new ArrayList<>();
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    val.add(node.val);
                    if (node.left != null) {
                        nq.add(node.left);
                    }
                    if (node.right != null) {
                        nq.add(node.right);
                    }
                }
                stack.push(val);
                queue.addAll(nq);
            }
        }
        
        List<List<Integer>> result = new ArrayList<>(stack.size());
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
