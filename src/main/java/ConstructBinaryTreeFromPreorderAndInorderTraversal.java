/**
 * <p>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * </p>
 * <p>
 * <b>Note:</b><br />
 * You may assume that duplicates do not exist in the tree.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Leetcode
 *      Construct Binary Tree from Preorder and Inorder Traversal Problem</a>
 * @author Wei Gao
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length > 0) {
            return buildTree(preorder, inorder, 0, preorder.length, 0,
                    inorder.length);
        } else {
            return null;
        }
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pb, int pe,
            int ib, int ie) {
        int rv = preorder[pb];
        TreeNode node = new TreeNode(rv);
        int m = ie;
        for (int i = ib; i < ie; i++) {
            if (inorder[i] == rv) {
                m = i;
                break;
            }
        }
        if (m > ib) {
            node.left = buildTree(preorder, inorder, pb + 1, pb + (m - ib) + 1,
                    ib, m);
        }
        if ((m + 1) < ie) {
            node.right = buildTree(preorder, inorder, pb + (m - ib) + 1, pe, ib
                    + (m - ib) + 1, ie);
        }
        return node;
    }
}
