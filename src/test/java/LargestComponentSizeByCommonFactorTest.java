import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LargestComponentSizeByCommonFactorTest {
    private static final LargestComponentSizeByCommonFactor solution = new LargestComponentSizeByCommonFactor();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{new int[] {4, 6, 15, 35}, 4}});
    }

    @Parameterized.Parameter
    public int[] input;
    @Parameterized.Parameter(1)
    public int expected;

    @Test
    public void test() {
        int actual = solution.largestComponentSize(input);
        Assert.assertEquals(expected, actual);
    }
}
