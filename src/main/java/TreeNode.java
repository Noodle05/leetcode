/**
 * @author Wei Gao
 *
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof TreeNode)) {
            return false;
        }
        final TreeNode obj = (TreeNode) other;
        if (val != obj.val) {
            return false;
        }
        if (left == null) {
            if (obj.left != null) {
                return false;
            }
        } else if (!left.equals(obj.left)) {
            return false;
        }
        if (right == null) {
            if (obj.right != null) {
                return false;
            }
        } else if (!right.equals(obj.right)) {
            return false;
        }
        return true;
    }
}
