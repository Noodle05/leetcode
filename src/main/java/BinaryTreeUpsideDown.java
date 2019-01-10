/**
 * <p>Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.</p>
 * <p><b>For example:</b><br \>
 * Given a binary tree {1,2,3,4,5},
 * <pre>
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * </pre>
 * return the root of the binary tree [4,5,2,#,#,3,1].
 * <pre>
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 * </pre></p>
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null)
            return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
