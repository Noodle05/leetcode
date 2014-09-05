import java.util.Arrays;
import java.util.List;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

public class PascalsTriangleIITest {
    private PascalsTriangleII solution;

    @Before
    public void init() {
        solution = new PascalsTriangleII();
    }

    @Test
    public void test1() {
        List<Integer> expected = Arrays.asList(1, 3, 3, 1);
        List<Integer> actual = solution.getRow(3);
        ListAssert.assertEquals(expected, actual);
    }
}
