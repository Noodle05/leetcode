/**
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * </p>
 * 
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * </p>
 * 
 * @see <a
 *      href="https://oj.leetcode.com/problems/balanced-binary-tree/">Leetcode
 *      Balanced Binary Tree Problem</a>
 * @author Wei Gao
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root != null) {
            BalanceInfo info = internalIsBalanced(root);
            return info.balanced;
        } else {
            return true;
        }
    }

    private BalanceInfo internalIsBalanced(TreeNode node) {
        BalanceInfo lInfo, rInfo;
        if (node.left != null) {
            lInfo = internalIsBalanced(node.left);
        } else {
            lInfo = new BalanceInfo(0, true);
        }
        if (node.right != null) {
            rInfo = internalIsBalanced(node.right);
        } else {
            rInfo = new BalanceInfo(0, true);
        }
        if (!lInfo.balanced || !rInfo.balanced
                || Math.abs(lInfo.depth - rInfo.depth) > 1) {
            return new BalanceInfo(0, false);
        } else {
            return new BalanceInfo(lInfo.depth > rInfo.depth ? lInfo.depth + 1
                    : rInfo.depth + 1, true);
        }
    }

    private static class BalanceInfo {
        int depth;
        boolean balanced;

        BalanceInfo(int depth, boolean balanced) {
            this.depth = depth;
            this.balanced = balanced;
        }
    }
}
