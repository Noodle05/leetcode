import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrappingRainWaterTest {
    private TrappingRainWater solution;

    @Before
    public void init() {
        solution = new TrappingRainWater();
    }

    @Test
    public void test1() {
        int[] A = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        Assert.assertEquals(6, solution.trap(A));
    }
}
