import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * Follow up for problem "<i>Populating Next Right Pointers in Each Node</i>".
 * </p>
 * 
 * <p>
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 * </p>
 * 
 * <p>
 * <b>Note:</b>
 * 
 * <ul>
 * <li>You may only use constant extra space.</li>
 * </ul>
 * </p>
 * <p>
 * For example,<br />
 * Given the following binary tree,
 * 
 * <pre>
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * </pre>
 * 
 * After calling your function, the tree should look like:
 * 
 * <pre>
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 * </pre>
 * 
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/">Leetcode
 *      Populating Next Right Pointers In Each Node II Problem</a>
 * @author Wei Gao
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeLinkNode> list = new ArrayList<>(queue);
            queue.clear();
            Iterator<TreeLinkNode> ite = list.iterator();
            TreeLinkNode p = null;
            while (ite.hasNext()) {
                TreeLinkNode n = ite.next();
                if (n.left != null) {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
                if (p != null) {
                    p.next = n;
                }
                p = n;
            }
        }
    }
}
