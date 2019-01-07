import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinimumWindowSubstringTest {
    private MinimumWindowSubstring solution;

    @Before
    public void init() {
        solution = new MinimumWindowSubstring();
    }

    @Test
    public void test1() {
        String expected = "BANC";
        String actual = solution.minWindow2("ADOBECODEBANC", "ABC");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String expected = "";
        String actual = solution.minWindow("a", "aa");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String expected = "b";
        String actual = solution.minWindow("ab", "b");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String expected = "ba";
        String actual = solution.minWindow("bba", "ba");
        Assert.assertEquals(expected, actual);
    }
}
