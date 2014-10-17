import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NextPermutationTest {
    private NextPermutation solution;

    @Before
    public void init() {
        solution = new NextPermutation();
    }

    @Test
    public void test1() {
        int[] expecteds = new int[] { 2, 1 };
        int[] actuals = new int[] { 1, 2 };
        solution.nextPermutation(actuals);
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test2() {
        int[] expecteds = new int[] { 1, 3, 2 };
        int[] actuals = new int[] { 1, 2, 3 };
        solution.nextPermutation(actuals);
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test3() {
        int[] expecteds = new int[] { 1, 2, 3 };
        int[] actuals = new int[] { 3, 2, 1 };
        solution.nextPermutation(actuals);
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test4() {
        int[] expecteds = new int[] { 4,8,8,9,3,4,6,7,7,8 };
        int[] actuals = new int[] { 4,8,8,8,9,7,7,6,4,3 };
        solution.nextPermutation(actuals);
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test5() {
        int[] expecteds = new int[] { 2,2,4,0,1,4,0,2,4 };
        int[] actuals = new int[] { 2,2,4,0,1,2,4,4,0 };
        solution.nextPermutation(actuals);
        Assert.assertArrayEquals(expecteds, actuals);
    }
}
