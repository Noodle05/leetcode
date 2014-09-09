import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SearchForARangeTest {
    private SearchForARange solution;

    @Before
    public void init() {
        solution = new SearchForARange();
    }

    @Test
    public void test1() {
        int[] data = new int[] { 5, 7, 7, 8, 8, 10 };
        int[] expected = new int[] { 3, 4 };
        int[] actual = solution.searchRange(data, 8);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] data = new int[] { 1 };
        int[] expected = new int[] { -1, -1 };
        int[] actual = solution.searchRange(data, 0);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] data = new int[] { 2, 2 };
        int[] expected = new int[] { -1, -1 };
        int[] actual = solution.searchRange(data, -1);
        Assert.assertArrayEquals(expected, actual);
    }
}
