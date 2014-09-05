import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ReverseWordsInAStringTest {
    private ReverseWordsInAString solution;

    @Before
    public void init() {
        solution = new ReverseWordsInAString();
    }

    @Test
    public void testOriginal() {
        String s = "the sky is blue";
        String t = solution.reverseWords(s);
        assertEquals("blue is sky the", t);
    }

    @Test
    public void test1() {
        String s = "a";
        String t = solution.reverseWords(s);
        assertEquals("a", t);
    }
}
