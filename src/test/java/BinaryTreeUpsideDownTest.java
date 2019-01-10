import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeUpsideDownTest {
    private final BinaryTreeUpsideDown solution = new BinaryTreeUpsideDown();

    @Test
    public void test1() {
        TreeNode root = Utils.readTreeNode("1,2,3,4,5");
        TreeNode expected = Utils.readTreeNode("4,5,2,#,#,3,1");
        TreeNode actual = solution.upsideDownBinaryTree(root);

        Assert.assertEquals(expected, actual);
    }
}
