import org.junit.Assert;
import org.junit.Test;

public class LowestCommonAncestorOfABinarySearchTreeTest {
    private final LowestCommonAncestorOfABinarySearchTree solution = new LowestCommonAncestorOfABinarySearchTree();

    @Test
    public void test1() {
        TreeNode root = Utils.readTreeNode("6, 2, 8, 0, 4, 7, 9, #, #, 3, 5");

        TreeNode actual = solution.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        Assert.assertNotNull(actual);
        Assert.assertEquals(2, actual.val);
    }
}
