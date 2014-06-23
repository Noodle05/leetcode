import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class WordBreakTest {
    private WordBreak solution;

    @Before
    public void init() {
        solution = new WordBreak();
    }

    @Test
    public void test() {
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        boolean result = solution.wordBreak("leetcode", dict);
        assertTrue(result);
    }
}
