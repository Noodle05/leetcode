import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UniquePathsTest {
    private UniquePaths solution;

    @Before
    public void init() {
        solution = new UniquePaths();
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, solution.uniquePaths(1, 2));
    }
}
