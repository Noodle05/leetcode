import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SymmetricTreeTest {
    private SymmetricTree solution;

    @Before
    public void init() {
        solution = new SymmetricTree();
    }

    @Test
    public void test1() {
        TreeNode root = Utils.readTreeNode("1,#,2");
        Assert.assertFalse(solution.isSymmetric(root));
    }

    @Test
    public void test2() {
        TreeNode root = Utils.readTreeNode("2,3,3,#,5,5,4");
        Assert.assertFalse(solution.isSymmetric(root));
    }

    @Test
    public void test3() {
        TreeNode root = Utils.readTreeNode("9,-42,-42,#,76,76,#,#,13,#,13");
        Assert.assertFalse(solution.isSymmetric(root));
    }
}
