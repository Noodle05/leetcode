import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinimumNumberOfCoinsTest {
    private MinimumNumberOfCoins solution;

    @Before
    public void init() {
        solution = new MinimumNumberOfCoins();
    }

    @Test
    public void test1() {
        int actual = solution.minimumCoins(new int[] { 1, 3, 5 }, 11);
        Assert.assertEquals(3, actual);
    }
}
