import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

public class CombinationSumTest {
    private CombinationSum solution;

    @Before
    public void init() {
        solution = new CombinationSum();
    }

    @Test
    public void test1() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1));
        List<List<Integer>> actual = solution
                .combinationSum(new int[] { 1 }, 1);
        ListAssert.assertEquals(expected, actual);
    }
}
