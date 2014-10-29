import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestCommonSubsequenceTest {
    private LongestCommonSubsequence solution;

    @Before
    public void init() {
        solution = new LongestCommonSubsequence();
    }

    @Test
    public void test1() {
        int actual = solution.lcs("ABCDGH", "AEDFHR");
        Assert.assertEquals(3, actual);
    }

    @Test
    public void test2() {
        int actual = solution.lcs("AGGTAB", "GXTXAYB");
        Assert.assertEquals(4, actual);
    }
}
