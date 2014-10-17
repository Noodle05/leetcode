import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultiplyStringsTest {
    private MultiplyStrings solution;

    @Before
    public void init() {
        solution = new MultiplyStrings();
    }

    @Test
    public void test1() {
        String expected = "891";
        String actual = solution.multiply("9", "99");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String expected = "56088";
        String actual = solution.multiply("123", "456");
        Assert.assertEquals(expected, actual);
    }
}
