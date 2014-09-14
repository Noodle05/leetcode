import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

public class FourSumTest {
    private FourSum solution;

    @Before
    public void init() {
        this.solution = new FourSum();
    }

    @Test
    public void test1() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1, 0, 0, 1));
        expected.add(Arrays.asList(-2, -1, 1, 2));
        expected.add(Arrays.asList(-2, 0, 0, 2));
        List<List<Integer>> actual = solution.fourSum(new int[] { 1, 0, -1, 0,
                -2, 2 }, 0);
        ListAssert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-3, -2, 2, 3));
        expected.add(Arrays.asList(-3, -1, 1, 3));
        expected.add(Arrays.asList(-3, 0, 0, 3));
        expected.add(Arrays.asList(-3, 0, 1, 2));
        expected.add(Arrays.asList(-2, -1, 0, 3));
        expected.add(Arrays.asList(-2, -1, 1, 2));
        expected.add(Arrays.asList(-2, 0, 0, 2));
        expected.add(Arrays.asList(-1, 0, 0, 1));
        List<List<Integer>> actual = solution.fourSum(new int[] { -3, -2, -1,
                0, 0, 1, 2, 3 }, 0);
        ListAssert.assertEquals(expected, actual);
    }
}
