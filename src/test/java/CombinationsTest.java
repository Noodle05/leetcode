import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

public class CombinationsTest {
    private Combinations solution;

    @Before
    public void init() {
        solution = new Combinations();
    }

    @Test
    public void test1() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(1, 3));
        expected.add(Arrays.asList(1, 4));
        expected.add(Arrays.asList(2, 3));
        expected.add(Arrays.asList(2, 4));
        expected.add(Arrays.asList(3, 4));
        List<List<Integer>> actual = solution.combine(4, 2);

        ListAssert.assertEquals(expected, actual);
    }
}
