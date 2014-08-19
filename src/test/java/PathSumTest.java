import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PathSumTest {
    private PathSum solution;

    @Before
    public void init() {
        solution = new PathSum();
    }

    @Test
    public void test1() {
        TreeNode root = Utils.readTreeNode("1");
        Assert.assertFalse(solution.hasPathSum(root, 0));
    }

    @Test
    public void test2() {
        TreeNode root = Utils.readTreeNode("1");
        Assert.assertTrue(solution.hasPathSum(root, 1));
    }

    @Test
    public void test3() {
        TreeNode root = Utils.readTreeNode("1,2");
        Assert.assertFalse(solution.hasPathSum(root, 1));
    }

    @Test
    public void test4() {
        TreeNode root = Utils.readTreeNode("1,2");
        Assert.assertFalse(solution.hasPathSum(root, 2));
    }

    @Test
    public void test5() {
        TreeNode root = Utils.readTreeNode("1,2");
        Assert.assertTrue(solution.hasPathSum(root, 3));
    }
}
