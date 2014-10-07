import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivideTwoIntegersTest {
    private DivideTwoIntegers solution;

    @Before
    public void init() {
        solution = new DivideTwoIntegers();
    }

    @Test
    public void test1() {
        int expected = 3;
        int actual = solution.divde(18, 5);
        Assert.assertEquals(expected, actual);
    }
}
