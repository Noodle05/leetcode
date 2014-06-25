import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PowTest {
    private Pow solution;

    @Before
    public void init() {
        solution = new Pow();
    }

    @Test
    public void test() {
        assertEquals(0.00002D, solution.pow(8.84372, -5), 0.00001D);
    }

}
