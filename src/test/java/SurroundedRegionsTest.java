import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SurroundedRegionsTest {
    private SurroundedRegions solution;

    @Before
    public void init() {
        solution = new SurroundedRegions();
    }

    @Test
    public void test1() {
        char[][] source = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };
        char[][] result = { { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' },
                { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'X', 'X' } };
        solution.solve(source);
        assertArrayEquals(result, source);
    }

    @Test
    public void test2() {
        char[][] source = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'O', 'X' } };
        char[][] result = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'O', 'X' } };
        solution.solve(source);
        assertArrayEquals(result, source);
    }
}
