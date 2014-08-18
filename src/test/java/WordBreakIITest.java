import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

public class WordBreakIITest {
    private WordBreakII solution;

    @Before
    public void init() {
        solution = new WordBreakII();
    }

    @Test
    public void test1() {
        String s = "catsanddog";

        Set<String> dict = new HashSet<>(Arrays.asList("cat", "cats", "and",
                "sand", "dog"));
        ListAssert.assertEquals(Arrays.asList("cats and dog", "cat sand dog"),
                solution.wordBreak(s, dict));
    }

    @Test
    public void test2() {
        String s = "a";

        Set<String> dict = new HashSet<>(Arrays.asList("a"));
        ListAssert.assertEquals(Arrays.asList("a"),
                solution.wordBreak(s, dict));
    }
}
