import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ValidNumberTest {
    private ValidNumber solution;
    
    @Before
    public void init() {
        solution = new ValidNumber();
    }
    
    @Test
    public void test1() {
        Assert.assertTrue(solution.isNumber("3"));
    }
    
    @Test
    public void test2() {
        Assert.assertFalse(solution.isNumber(" "));
    }
    
    @Test
    public void test3() {
        Assert.assertTrue(solution.isNumber("2e0"));
    }
}
