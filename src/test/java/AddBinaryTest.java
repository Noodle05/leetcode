import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddBinaryTest {
    private AddBinary solution;

    @Before
    public void init() {
        solution = new AddBinary();
    }

    @Test
    public void test1() {
        String actual = solution.addBinary("1010", "1011");
        Assert.assertEquals("10101", actual);
    }

    @Test
    public void test2() {
        String actual = solution.addBinary("11", "1");
        Assert.assertEquals("100", actual);
    }
}
