import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindMinimumInRotatedSortedArrayIITest {
    private FindMinimumInRotatedSortedArrayII solution;

    @Before
    public void init() {
        solution = new FindMinimumInRotatedSortedArrayII();
    }

    @Test
    public void test1() {
        int actual = solution.findMin(new int[] { 1, 3, 3 });
        Assert.assertEquals(1, actual);
    }
}
