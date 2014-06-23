import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JumpGameTest {
    private JumpGame solution;

    @Before
    public void init() {
        solution = new JumpGame();
    }

    @Test
    public void test1() {
        int[] A = new int[] { 2, 3, 1, 1, 4 };
        boolean canReach = solution.canJump(A);
        assertTrue(canReach);
    }

    @Test
    public void test2() {
        int[] A = new int[] { 3, 2, 1, 0, 4 };
        boolean canReach = solution.canJump(A);
        assertFalse(canReach);
    }

    @Test
    public void test3() {
        int[] A = new int[] { 4, 2, 2, 2, 0, 2, 0, 10 };
        boolean canReach = solution.canJump(A);
        assertTrue(canReach);
    }
}
