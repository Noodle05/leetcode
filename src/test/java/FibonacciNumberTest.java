import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FibonacciNumberTest {
    private FibonacciNumber solution;
    
    @Before
    public void init() {
        solution = new FibonacciNumber();
    }
    
    @Test
    public void test() {
        assertEquals(1, solution.fibonacciNumber(1));
    }
    
    @Test
    public void test2() {
        assertEquals(1, solution.fibonacciNumber(2));
    }
    
    @Test
    public void test3() {
        assertEquals(13, solution.fibonacciNumber(7));
    }
    
    @Test
    public void test4() {
        assertEquals(144, solution.fibonacciNumber(12));
    }
}
