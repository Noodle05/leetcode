import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GenerateParentheseTest {
    private GenerateParentheses solution;

    @Before
    public void init() {
        solution = new GenerateParentheses();
    }

    @Test
    public void test1() {
        List<String> expected = Arrays.asList("((()))", "(())()", "()(())",
                "(()())", "()()()");
        List<String> result = solution.generateParenthesis(3);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {
        List<String> expected = Arrays.asList("(((())))", "((()()))",
                "((())())", "((()))()", "(()(()))", "(()()())", "(()())()",
                "(())(())", "(())()()", "()((()))", "()(()())", "()(())()",
                "()()(())", "()()()()");
        List<String> result = solution.generateParenthesis(4);
        assertEquals(expected, result);
    }
}
