import org.junit.Assert;
import org.junit.Test;

/**
 * @author Wei Gao
 * @since 2019-01-09
 */
public class ShortestPalindromeTest {
    private final ShortestPalindrome solution = new ShortestPalindrome();

    @Test
    public void test1() {
        Assert.assertEquals("abcdefedcba", solution.shortestPalindrome("cdefedcba"));
    }
}
