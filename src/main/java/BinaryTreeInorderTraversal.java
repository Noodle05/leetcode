import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * return <font color="red">[1,3,2]</font>.
 * </p>
 * 
 * <p>
 * <b>Note:</b> Recursive solution is trivial, could you do it iteratively?
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/binary-tree-inorder-traversal/">Leetcode
 *      Binary Tree Inorder Traversal Problem</a>
 * @author Wei Gao
 */
public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
