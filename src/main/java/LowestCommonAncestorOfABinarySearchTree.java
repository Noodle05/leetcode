public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode l = p.val > q.val ? q : p;
        TreeNode r = p.val < q.val ? q : p;

        if (l.val <= root.val && r.val >= root.val)
            return root;
        if (l.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        if (r.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        return null;
    }
}
