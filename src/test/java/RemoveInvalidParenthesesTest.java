import junitx.framework.ListAssert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RemoveInvalidParenthesesTest {
    private final RemoveInvalidParentheses solution = new RemoveInvalidParentheses();

    @Test
    public void test1() {
        String s = "()())()";
        List<String> expected = Arrays.asList("()()()", "(())()");

        ListAssert.assertEquals(expected, solution.removeInvalidParentheses(s));
    }

    @Test
    public void test2() {
        String s = "(a)())()";
        List<String> expected = Arrays.asList("(a)()()", "(a())()");

        ListAssert.assertEquals(expected, solution.removeInvalidParentheses(s));
    }

    @Test
    public void test3() {
        String s = ")(";
        List<String> expected = Arrays.asList("");

        ListAssert.assertEquals(expected, solution.removeInvalidParentheses(s));
    }

    @Test
    public void test4() {
        String s = "(()()))()))(";
        List<String> expected = Arrays.asList("");

        ListAssert.assertEquals(expected, solution.removeInvalidParentheses(s));
    }
}
