/**
 * <p>
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * </p>
 * <p>
 * <b>Note:</b><br />
 * You may assume that duplicates do not exist in the tree.
 * </p>
 * 
 * @see <a hre=
 *      "https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/"
 *      >Leetcode Construct Binary Tree from Inorder and Postorder Traversal
 *      Problem</a>
 * @author Wei Gao
 */
public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length > 0) {
            return buildTree(inorder, postorder, 0, inorder.length, 0,
                    postorder.length);
        } else {
            return null;
        }
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int ib, int ie,
            int pb, int pe) {
        int rv = postorder[pe - 1];
        TreeNode node = new TreeNode(rv);
        int m = ie;
        for (int i = ib; i < ie; i++) {
            if (inorder[i] == rv) {
                m = i;
                break;
            }
        }
        if (m > ib) {
            node.left = buildTree(inorder, postorder, ib, m, pb, pb + (m - ib));
        }
        if ((m + 1) < ie) {
            node.right = buildTree(inorder, postorder, ib + (m - ib) + 1, ie,
                    pb + (m - ib), pe - 1);
        }
        return node;
    }
}
