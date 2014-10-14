import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junitx.framework.ListAssert;

public class PermutationsTest {
    private Permutations solution;

    @Before
    public void init() {
        solution = new Permutations();
    }

    @Test
    public void test1() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 1));
        expected.add(Arrays.asList(1, 0));
        List<List<Integer>> actual = solution.permute(new int[] { 0, 1 });
        ListAssert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 2, 3));
        expected.add(Arrays.asList(1, 3, 2));
        expected.add(Arrays.asList(2, 1, 3));
        expected.add(Arrays.asList(2, 3, 1));
        expected.add(Arrays.asList(3, 1, 2));
        expected.add(Arrays.asList(3, 2, 1));
        List<List<Integer>> actual = solution.permute(new int[] { 1, 2, 3 });
        ListAssert.assertEquals(expected, actual);
    }
}
