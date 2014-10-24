import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImplementstrStrTest {
    private ImplementstrStr solution;

    @Before
    public void init() {
        solution = new ImplementstrStr();
    }

    @Test
    public void testPartialMatchTable1() {
        int[] expecteds = new int[] { -1, 0, 0, 0, 0, 1, 2 };
        String s = "ABCDABD";
        int[] actuals = solution.parialMatchTable(s.toCharArray());
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testPartialMatchTable2() {
        int[] expecteds = new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0,
                0, 0, 0, 1, 2, 3, 0, 0, 0, 0, 0 };
        String s = "PARTICIPATE IN PARACHUTE";
        int[] actuals = solution.parialMatchTable(s.toCharArray());
        Assert.assertArrayEquals(expecteds, actuals);
    }
}
