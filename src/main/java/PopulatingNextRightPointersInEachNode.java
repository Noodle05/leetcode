/**
 * 
 */

/**
 * <p>
 * Given a binary tree
 * 
 * <pre>
 *     struct TreeLinkNode {
 *       TreeLinkNode *left;
 *       TreeLinkNode *right;
 *       TreeLinkNode *next;
 *     }
 * </pre>
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to <font
 * color="red">NULL</font>.<br />
 * <br />
 * Initially, all next pointers are set to <font color="red">NULL</font>.
 * </p>
 * 
 * <p>
 * <b>Note:</b>
 * 
 * <ul>
 * <li>You may only use constant extra space.</li>
 * <li>You may assume that it is a perfect binary tree (ie, all leaves are at
 * the same level, and every parent has two children).</li>
 * </ul>
 * <p>
 * For example, Given the following perfect binary tree,
 * 
 * <pre>
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * </pre>
 * 
 * After calling your function, the tree should look like:
 * 
 * <pre>
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 * </pre>
 * 
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/">Leetcode
 *      Populating Next Right Pointer in Each Node Problem</a>
 * @author Wei Gao
 *
 */
public class PopulatingNextRightPointersInEachNode {
  public void connect(TreeLinkNode root) {
    TreeLinkNode current = root;
    TreeLinkNode currentParent = null;
    while (current != null) {
      TreeLinkNode node = current;
      TreeLinkNode parent = currentParent;
      while (node != null && node.left != null) {
        node.left.next = node.right;
        if (parent != null) {
          if (parent.right != node) {
            node.right.next = parent.right.left;
          } else if (parent.next != null) {
            node.right.next = parent.next.left.left;
          }
          node = node.next;
          if (parent.right != node) {
            parent = parent.next;
          }
        } else {
          node = null;
        }
      }
      currentParent = current;
      current = currentParent.left;
    }
    /**
     * Recursive solution
     * 
     * <pre>
     * if (root == null || root.left == null || root.right == null) {
     *   return;
     * }
     * if (root.next != null) {
     *   root.right.next = root.next.left;
     * }
     * root.left.next = root.right;
     * connect(root.left);
     * connect(root.right);
     * </pre>
     */
  }
}
