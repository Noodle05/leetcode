import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SingleNumberIITest {
    private SingleNumberII solution;

    @Before
    public void init() {
        solution = new SingleNumberII();
    }

    @Test
    public void test() {
        assertEquals(10, solution.singleNumber(new int[] {5, 9, 5, 5, 9, 10, 9}));
    }
}
