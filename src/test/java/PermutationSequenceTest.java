import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PermutationSequenceTest {
    private PermutationSequence solution;

    @Before
    public void init() {
        solution = new PermutationSequence();
    }

    @Test
    public void test1() {
        String expected = "1";
        String actual = solution.getPermutation(1, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String expected = "12";
        String actual = solution.getPermutation(2, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String expected = "312";
        String actual = solution.getPermutation(3, 5);
        Assert.assertEquals(expected, actual);
    }
}
