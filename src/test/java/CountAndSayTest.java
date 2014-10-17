import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountAndSayTest {
    private CountAndSay solution;

    @Before
    public void init() {
        solution = new CountAndSay();
    }

    @Test
    public void test1() {
        Assert.assertEquals("11", solution.countAndSay(2));
    }

    @Test
    public void test2() {
        Assert.assertEquals("1211", solution.countAndSay(4));
    }
}
