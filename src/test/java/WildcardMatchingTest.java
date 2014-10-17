import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WildcardMatchingTest {
    private WildcardMatching solution;

    @Before
    public void init() {
        solution = new WildcardMatching();
    }

    @Test
    public void test1() {
        Assert.assertFalse(solution.isMatch("aa", "a"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(solution.isMatch("aa", "aa"));
    }

    @Test
    public void test3() {
        Assert.assertFalse(solution.isMatch("aaa", "a"));
    }

    @Test
    public void test4() {
        Assert.assertTrue(solution.isMatch("aa", "*"));
    }

    @Test
    public void test5() {
        Assert.assertTrue(solution.isMatch("aa", "a*"));
    }

    @Test
    public void test6() {
        Assert.assertTrue(solution.isMatch("aa", "?*"));
    }

    @Test
    public void test7() {
        Assert.assertFalse(solution.isMatch("aab", "c*a*b"));
    }

    @Test
    public void test8() {
        Assert.assertFalse(solution.isMatch("b", "*?*?"));
    }

    @Test
    public void test9() {
        Assert.assertTrue(solution.isMatch("hi", "*?"));
    }

    @Test
    public void test10() {
        Assert.assertTrue(solution.isMatch("", "*"));
    }

    @Test
    public void test11() {
        Assert.assertTrue(solution.isMatch("abcdefghijklmnopqrst", "*d*s?"));
    }
}
