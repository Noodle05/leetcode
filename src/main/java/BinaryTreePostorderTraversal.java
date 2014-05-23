import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 
 */

/**
 * <p>
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * </p>
 * 
 * <p>
 * For example:<br />
 * Given binary tree <font color="red">{1,#,2,3}</font>,
 * 
 * <pre>
 *    1
 *     \
 *      2
 *     /
 *    3
 * </pre>
 * 
 * return <font color="red">[3,2,1]</font>.
 * </p>
 * 
 * <p>
 * <b>Note:</b> Recursive solution is trivial, could you do it iteratively?
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/binary-tree-postorder-traversal/">Leetcode
 *      Binary Tree Postorder Traversal Problem</a>
 * @author Wei Gao
 */
public class BinaryTreePostorderTraversal {
  public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode lastVisitedNode = null;
    TreeNode node = root;
    while (!stack.isEmpty() || node != null) {
      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        TreeNode peekNode = stack.peek();
        if (peekNode.right != null && lastVisitedNode != peekNode.right) {
          node = peekNode.right;
        } else {
          stack.pop();
          result.add(peekNode.val);
          lastVisitedNode = peekNode;
        }
      }
    }
    return result;
  }
}
