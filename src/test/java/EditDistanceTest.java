import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EditDistanceTest {
    private EditDistance solution;

    @Before
    public void init() {
        solution = new EditDistance();
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, solution.minDistance("a", "a"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(8, solution.minDistance("INTE*NTION", "*EXECUTION"));
    }
}
