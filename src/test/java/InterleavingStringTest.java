import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InterleavingStringTest {
    private InterleavingString solution;

    @Before
    public void init() {
        solution = new InterleavingString();
    }

    @Test
    public void test1() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        Assert.assertTrue(solution.isInterleave(s1, s2, s3));
    }

    @Test
    public void test2() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        Assert.assertFalse(solution.isInterleave(s1, s2, s3));
    }
}
