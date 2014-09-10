import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DistinctSubsequencesTest {
    private DistinctSubsequences solution;

    @Before
    public void init() {
        solution = new DistinctSubsequences();
    }

    @Test
    public void test1() {
        String s = "rabbbit";
        String t = "rabbit";
        Assert.assertEquals(3, solution.numDistinct(s, t));
    }
}
