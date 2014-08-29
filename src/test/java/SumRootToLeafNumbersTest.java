import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SumRootToLeafNumbersTest {
    private SumRootToLeafNumbers solution;

    @Before
    public void init() {
        solution = new SumRootToLeafNumbers();
    }

    @Test
    public void test1() {
        TreeNode node = Utils.readTreeNode("0, 1, 3");
        Assert.assertEquals(4, solution.sumNumbers(node));
    }
}
