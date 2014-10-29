/**
 * <p>
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * </p>
 * 
 * <p>
 * Recover the tree without changing its structure.
 * </p>
 * 
 * <p>
 * <b>Note:</b><br />
 * A solution using O(<i>n</i>) space is pretty straight forward. Could you
 * devise a constant space solution?
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/recover-binary-search-tree/">Leetcode
 *      Recover Binary Search Tree Problem</a>
 * @author Wei Gao
 */
public class RecoverBinarySearchTree {
    /**
     * <p>
     * Use Morris Travel to in order travel a binary tree.
     * </p>
     * </p>Using Morris Traversal, we can traverse the tree without using stack
     * and recursion. The idea of Morris Traversal is based on Threaded Binary
     * Tree. In this traversal, we first create links to Inorder successor and
     * print the data using these links, and finally revert the changes to
     * restore original tree.</p>
     * 
     * <pre>
     * 1. Initialize current as root
     * 2. While current is not NULL
     *    If current does not have left child
     *       a) Print current’s data
     *       b) Go to the right, i.e., current = current->right
     *    Else
     *       a) Make current as right child of the rightmost node in current's left subtree
     *       b) Go to this left child, i.e., current = current->left
     * </pre>
     * <p>
     * Although the tree is modified through the traversal, it is reverted back
     * to its original shape after the completion. Unlike Stack based traversal,
     * no extra space is required for this traversal
     * </p>
     * 
     * @see <a
     *      href="http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/">GeeksforGeeks
     *      Morris Travel</a>
     * @param root
     */
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        TreeNode ptr, pred, current;
        TreeNode pred1, cur1, cur2;

        current = root;
        ptr = pred = null;
        pred1 = cur1 = cur2 = null;

        while (current != null) {
            if (current.left == null) {
                // Processing current;
                pred = current;
                current = current.right;
            } else {
                // Find the inorder predecessor of current
                ptr = current.left;
                while (ptr.right != null && ptr.right != current)
                    ptr = ptr.right;
                // Make current as right child of its inorder predecessor
                if (ptr.right == null) {
                    ptr.right = current;
                    current = current.left;
                } else {
                    // Revert the changes made in if part to restore the
                    // original tree i.e., fix the right child of predecessor
                    ptr.right = null;
                    pred = current;
                    current = current.right;
                }
            }
            if (pred != null && current != null && pred.val > current.val) {
                if (pred1 == null) {
                    pred1 = pred;
                    cur1 = current;
                } else {
                    cur2 = current;
                }
            }
        }

        int tmp;
        if (pred1 != null && cur2 != null) {
            tmp = pred1.val;
            pred1.val = cur2.val;
            cur2.val = tmp;
        } else {
            tmp = pred1.val;
            pred1.val = cur1.val;
            cur1.val = tmp;
        }
    }
}
