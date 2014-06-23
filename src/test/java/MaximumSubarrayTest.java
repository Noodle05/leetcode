import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MaximumSubarrayTest {
    private MaximumSubarray solution;

    @Before
    public void init() {
        solution = new MaximumSubarray();
    }

    @Test
    public void test1() {
        int[] data = new int[] { 1, 2 };
        int max = solution.maxSubArray(data);
        assertEquals(3, max);
    }

    @Test
    public void test5() {
        int[] data = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int max = solution.maxSubArray(data);
        assertEquals(6, max);
    }
}
