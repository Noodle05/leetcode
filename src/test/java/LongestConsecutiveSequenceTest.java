import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestConsecutiveSequenceTest {
    private LongestConsecutiveSequence solution;

    @Before
    public void init() {
        solution = new LongestConsecutiveSequence();
    }

    @Test
    public void test1() {
        int[] num = new int[] { 100, 4, 200, 1, 3, 2 };
        Assert.assertEquals(4, solution.longestConsecutive(num));
    }

    @Test
    public void test2() {
        int[] num = new int[] { 1, 2, 0, 1 };
        Assert.assertEquals(3, solution.longestConsecutive(num));
    }

    @Test
    public void test3() {
        int[] num = new int[] { 100, 4, 200, 1, 3, 2, 5 };
        Assert.assertEquals(5, solution.longestConsecutive(num));
    }
}
