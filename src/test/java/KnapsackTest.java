import org.junit.Assert;
import org.junit.Test;

/**
 * @author Wei Gao
 * @since 2019-01-09
 */
public class KnapsackTest {
    private final Knapsack solution = new Knapsack();

    @Test
    public void test1() {
        int[] wts = {1, 2, 3, 4};
        int[] vals = {100, 100, 400, 300};
        Assert.assertEquals(500, solution.knapsack(wts, vals, 5));
    }

    @Test
    public void test2() {
        int[] wts = {1, 2, 3, 4};
        int[] vals = {100, 100, 400, 300};
        Assert.assertEquals(500, solution.knapsack(wts, vals, 5));
    }
}
