import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

public class SubstringWithConcatenationOfAllWordsTest {
    private SubstringWithConcatenationOfAllWords solution;

    @Before
    public void init() {
        solution = new SubstringWithConcatenationOfAllWords();
    }

    @Test
    public void test1() {
        List<Integer> expected = Collections.emptyList();
        List<Integer> actual = solution.findSubstring("aaabbbc", new String[] {
                "a", "a", "b", "b", "c" });
        ListAssert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        List<Integer> expected = Arrays.asList(0, 2, 4);
        List<Integer> actual = solution.findSubstring("abababab", new String[] {
                "a", "b", "a" });
        ListAssert.assertEquals(expected, actual);
    }
}
