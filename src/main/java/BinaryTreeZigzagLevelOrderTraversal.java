import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * Given a binary tree, return the <i>zigzag</i> level order traversal of its
 * nodes' values. (ie, from left to right, then right to left for the next level
 * and alternate between).
 * </p>
 * 
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
 * return its zigzag level order traversal as:
 * 
 * <pre>
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * </pre>
 * 
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">Leetcode
 *      Binary Tree Zigzag Level Order Traversal Problem</a>
 * @author Wei Gao
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root != null) {
            queue.offer(root);
        }

        boolean order = false;
        while (!queue.isEmpty()) {
            Queue<TreeNode> nq = new ArrayDeque<>();
            LinkedList<Integer> val = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (order) {
                    val.addFirst(node.val);
                } else {
                    val.addLast(node.val);
                }
                if (node.left != null) {
                    nq.offer(node.left);
                }
                if (node.right != null) {
                    nq.offer(node.right);
                }
            }
            result.add(val);
            queue.addAll(nq);
            order = !order;
        }

        return result;
    }
}
