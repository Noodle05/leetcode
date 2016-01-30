import org.junit.Assert;
import org.junit.Test;

public class MaximumGapTest {
    private MaximumGap solution = new MaximumGap();

    @Test
    public void test1() {
        int[] input = new int[] { 2, 99999999 };
        int max = solution.maximumGap(input);
        Assert.assertEquals(99999999 - 2, max);
    }

    @Test
    public void test2() {
        int[] input = new int[] { 1, 10000000 };
        int max = solution.maximumGap(input);
        Assert.assertEquals(10000000 - 1, max);
    }
}
