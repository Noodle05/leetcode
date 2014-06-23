/**
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * </p>
 * <p>
 * Assume a BST is defined as follows:
 * <ul>
 * <li>The left subtree of a node contains only nodes with keys less than the
 * node's key.</li>
 * <li>The right subtree of a node contains only nodes with keys greater than
 * the node's key.</li>
 * <li>Both the left and right subtrees must also be binary search trees.</li>
 * </ul>
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/validate-binary-search-tree/">Leetcode
 *      Validate Binary Search Tree Problem</a>
 * @author Wei Gao
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int leftBound, int rightBound) {
        if (root == null) {
            return true;
        }
        if (root.val <= leftBound || root.val >= rightBound) {
            return false;
        }
        if (root.left != null) {
            if (!isValidBST(root.left, leftBound, root.val)) {
                return false;
            }
        }
        if (root.right != null) {
            if (!isValidBST(root.right, root.val, rightBound)) {
                return false;
            }
        }
        return true;
    }
}
