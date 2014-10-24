import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindMinimumInRotatedSortedArrayTest {
    private FindMinimumInRotatedSortedArray solution;

    @Before
    public void init() {
        solution = new FindMinimumInRotatedSortedArray();
    }

    @Test
    public void test1() {
        int[] data = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int actual = solution.findMin(data);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void test2() {
        int[] data = new int[] { 2, 1 };
        int actual = solution.findMin(data);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void test3() {
        int[] data = new int[] { 3, 1, 2 };
        int actual = solution.findMin(data);
        Assert.assertEquals(1, actual);
    }
}
