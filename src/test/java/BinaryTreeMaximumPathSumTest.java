import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeMaximumPathSumTest {
    private BinaryTreeMaximumPathSum solution;

    @Before
    public void init() {
        solution = new BinaryTreeMaximumPathSum();
    }

    @Test
    public void test1() {
        TreeNode root = Utils.readTreeNode("1,2,3");
        Assert.assertEquals(6, solution.maxPathSum(root));
    }
}
