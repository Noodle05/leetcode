import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestValidParenthesesTest {
    private LongestValidParentheses solution;

    @Before
    public void init() {
        solution = new LongestValidParentheses();
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, solution.longestValidParentheses("()"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, solution.longestValidParentheses("()(()"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(4, solution.longestValidParentheses("()()"));
    }
}
