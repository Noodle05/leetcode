import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * Given a binary tree, flatten it to a linked list in-place.
 * </p>
 * 
 * <p>
 * For example,<br />
 * Given
 * 
 * <pre>
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * </pre>
 * 
 * The flattened tree should look like:
 * 
 * <pre>
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * </pre>
 * 
 * </p>
 * <p>
 * <b>Hints:</b><br />
 * If you notice carefully in the flattened tree, each node's right child points
 * to the next node of a pre-order traversal.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/">Leetcode
 *      Flatten Binary Tree to Linked List Problem</a>
 * @author Wei Gao
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        TreeNode current = root;
        while (current != null) {
            if (current.right != null) {
                stack.push(current.right);
                current.right = null;
            }
            if (current.left != null) {
                current.right = current.left;
                current.left = null;
                current = current.right;
            } else {
                if (!stack.isEmpty()) {
                    current.right = stack.pop();
                    current = current.right;
                } else {
                    current = null;
                }
            }
        }
    }
}
