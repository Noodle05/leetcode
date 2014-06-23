import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * <p>
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * </p>
 * 
 * <p>
 * For example: Given binary tree <font color="red">{1,#,2,3}</font>,
 * 
 * <pre>
 *    1
 *     \
 *      2
 *     /
 *    3
 * </pre>
 * 
 * return <font color="red">[1,2,3]</font>.
 * </p>
 * 
 * <p>
 * <b>Note:</b> Recursive solution is trivial, could you do it iteratively?
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/binary-tree-preorder-traversal/">Leetcode
 *      Binary Tree Preorder Traversal</a>
 * @author Wei Gao
 */
public class BinaryTreePreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return result;
    }
}
