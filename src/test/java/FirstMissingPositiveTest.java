import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FirstMissingPositiveTest {
    private FirstMissingPositive solution;

    @Before
    public void init() {
        solution = new FirstMissingPositive();
    }

    @Test
    public void test1() {
        int[] A = {};
        Assert.assertEquals(1, solution.firstMissingPositive(A));
    }

    @Test
    public void test2() {
        int[] A = { 0 };
        Assert.assertEquals(1, solution.firstMissingPositive(A));
    }

    @Test
    public void test3() {
        int[] A = { 1 };
        Assert.assertEquals(2, solution.firstMissingPositive(A));
    }

    @Test
    public void test4() {
        int[] A = { 1, 2, 0 };
        Assert.assertEquals(3, solution.firstMissingPositive(A));
    }

    @Test
    public void test5() {
        int[] A = { 3, 4, -1, 1 };
        Assert.assertEquals(2, solution.firstMissingPositive(A));
    }

    @Test
    public void test6() {
        int[] A = { 1, 1 };
        Assert.assertEquals(2, solution.firstMissingPositive(A));
    }
}
