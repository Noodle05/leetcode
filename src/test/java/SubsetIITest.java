import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

public class SubsetIITest {
    private SubsetsII solution;

    @Before
    public void init() {
        solution = new SubsetsII();
    }

    @Test
    public void test1() {
        int[] num = new int[] { 1, 2, 2 };
        List<List<Integer>> expected = new ArrayList<>(5);
        expected.add(Collections.emptyList());
        expected.add(Arrays.asList(2));
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(1, 2, 2));
        expected.add(Arrays.asList(2, 2));
        expected.add(Arrays.asList(1, 2));
        List<List<Integer>> actual = solution.subsetsWithDup(num);
        ListAssert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] num = new int[] { 1, 1, 2, 2 };
        List<List<Integer>> expected = new ArrayList<>(5);
        expected.add(Collections.emptyList());
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(1, 1));
        expected.add(Arrays.asList(1, 1, 2));
        expected.add(Arrays.asList(1, 1, 2, 2));
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(1, 2, 2));
        expected.add(Arrays.asList(2));
        expected.add(Arrays.asList(2, 2));
        List<List<Integer>> actual = solution.subsetsWithDup(num);
        ListAssert.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] num = new int[] { 1, 1, 1, 2, 2 };
        List<List<Integer>> expected = new ArrayList<>(5);
        expected.add(Collections.emptyList());
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(1, 1));
        expected.add(Arrays.asList(1, 1, 2));
        expected.add(Arrays.asList(1, 1, 2, 2));
        expected.add(Arrays.asList(1, 1, 1));
        expected.add(Arrays.asList(1, 1, 1, 2));
        expected.add(Arrays.asList(1, 1, 1, 2, 2));
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(1, 2, 2));
        expected.add(Arrays.asList(2));
        expected.add(Arrays.asList(2, 2));
        List<List<Integer>> actual = solution.subsetsWithDup(num);
        ListAssert.assertEquals(expected, actual);
    }
}
