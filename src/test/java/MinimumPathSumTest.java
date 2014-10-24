import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinimumPathSumTest {
    private MinimumPathSum solution;

    @Before
    public void init() {
        solution = new MinimumPathSum();
    }

    @Test
    public void test1() {
        int[][] data = new int[][] { { 1, 2 }, { 1, 1 } };
        int path = solution.minPathSum(data);
        Assert.assertEquals(3, path);
    }
}
