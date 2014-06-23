import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CandyTest {
    private Candy solution;

    @Before
    public void init() {
        solution = new Candy();
    }

    @Test
    public void test1() {
        int[] ratings = { 2, 1 };
        int candies = solution.candy(ratings);
        assertEquals(3, candies);
    }

    @Test
    public void test2() {
        int[] ratings = { 1, 2, 2 };
        int candies = solution.candy(ratings);
        assertEquals(4, candies);
    }
}
