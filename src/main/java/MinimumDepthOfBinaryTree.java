/**
 * <p
 * .Given a binary tree, find its minimum depth.
 * </p>
 * 
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/">Leetcode
 *      Minimum Depth of Binary Tree Problem</a>
 * @author Wei Gao
 *
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int result = Integer.MAX_VALUE;
        if (root.left != null) {
            result = Math.min(result, minDepth(root.left) + 1);
        }
        if (root.right != null) {
            result = Math.min(result, minDepth(root.right) + 1);
        }
        return result;
    }
}
