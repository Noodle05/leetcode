import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

public class CombinationSumIITest {
    private CombinationSumII solution;

    @Before
    public void init() {
        solution = new CombinationSumII();
    }

    @Test
    public void test1() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 7));
        expected.add(Arrays.asList(1, 2, 5));
        expected.add(Arrays.asList(2, 6));
        expected.add(Arrays.asList(1, 1, 6));
        List<List<Integer>> actual = solution.combinationSum2(new int[] { 10,
                1, 2, 7, 6, 1, 5 }, 8);
        ListAssert.assertEquals(expected, actual);
    }
}
