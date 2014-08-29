import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * Given a binary tree containing digits from <font color="red">0-9</font> only,
 * each root-to-leaf path could represent a number.
 * </p>
 * 
 * <p>
 * An example is the root-to-leaf path <font color="red">1->2->3</font> which
 * represents the number <font color="red">123</font>.
 * </p>
 * 
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * </p>
 * 
 * <p>
 * <p>
 * For example,
 * 
 * <pre>
 *     1
 *    / \
 *   2   3
 * </pre>
 * 
 * </p>
 * <p>
 * The root-to-leaf path <font color="red">1->2</font> represents the number
 * <font color="red">12</font>.
 * </p>
 * <p>
 * The root-to-leaf path <font color="red">1->3</font> represents the number
 * <font color="red">13</font>.
 * </p>
 * 
 * <p>
 * Return the sum = 12 + 13 = <font color="red">25</font>.
 * </p>
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/">Leetcode
 *      Sum Root to Leaf Numbers Problem</a>
 * @author Wei Gao
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int result = 0;
        if (root != null) {
            Deque<Integer> dataStack = new ArrayDeque<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode node = root;
            TreeNode lastVisited = null;
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    int t = dataStack.isEmpty() ? 0 : dataStack.peek();
                    t = t * 10 + node.val;
                    if (node.left == null && node.right == null) {
                        result += t;
                    }
                    stack.push(node);
                    dataStack.push(t);
                    node = node.left;
                } else {
                    TreeNode peek = stack.peek();
                    if (peek.right != null && peek.right != lastVisited) {
                        node = peek.right;
                    } else {
                        stack.pop();
                        dataStack.pop();
                        lastVisited = peek;
                    }
                }
            }
        }
        return result;
    }
}
