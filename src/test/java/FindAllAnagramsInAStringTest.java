import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAStringTest {
    private final FindAllAnagramsInAString solution = new FindAllAnagramsInAString();

    @Test
    public void test() {
        String s = "cbaebabacd";
        String t = "abc";

        List<Integer> expected = Arrays.asList(0, 6);
        List<Integer> actual = solution.findAnagrams(s, t);
        Assert.assertEquals(expected, actual);
    }
}
