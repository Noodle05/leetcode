
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaxPointsOnALineTest {
    private MaxPointsOnALine solution;

    @Before
    public void init() {
        solution = new MaxPointsOnALine();
    }

    @Test
    public void test23() {
        Point[] points = new Point[] { new Point(1, 1), new Point(1, 1),
                new Point(2, 3) };
        assertEquals(3, solution.maxPoints(points));
    }

    @Test
    public void test2() {
        Point[] points = new Point[] { new Point(0, 0), new Point(0, 0) };
        assertEquals(2, solution.maxPoints(points));
    }

    @Test
    public void test22() {
        Point[] points = new Point[] { new Point(2, 3), new Point(3, 3),
                new Point(-5, 3) };
        assertEquals(3, solution.maxPoints(points));
    }
}
