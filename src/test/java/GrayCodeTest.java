import java.util.Arrays;
import java.util.List;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

public class GrayCodeTest {
    private GrayCode solution;

    @Before
    public void init() {
        solution = new GrayCode();
    }

    @Test
    public void test1() {
        List<Integer> expected = Arrays.asList(0, 1, 3, 2);
        List<Integer> actual = solution.grayCode(2);
        ListAssert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        List<Integer> expected = Arrays.asList(0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14,
                10, 11, 9, 8);
        List<Integer> actual = solution.grayCode(4);
        ListAssert.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        List<Integer> expected = Arrays.asList(0, 1, 3, 2, 6, 7, 5, 4);
        List<Integer> actual = solution.grayCode(3);
        ListAssert.assertEquals(expected, actual);
    }

}
