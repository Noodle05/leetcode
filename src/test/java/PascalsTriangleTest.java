import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

public class PascalsTriangleTest {
    private PascalsTriangle solution;

    @Before
    public void init() {
        solution = new PascalsTriangle();
    }

    @Test
    public void test1() {
        List<List<Integer>> expected = new ArrayList<>(5);
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(1, 1));
        expected.add(Arrays.asList(1, 2, 1));
        expected.add(Arrays.asList(1, 3, 3, 1));
        expected.add(Arrays.asList(1, 4, 6, 4, 1));
        List<List<Integer>> actual = solution.generate(5);
        ListAssert.assertEquals(expected, actual);
    }
}
