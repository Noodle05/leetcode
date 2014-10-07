import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpiralMatrixIITest {
    private SpiralMatrixII solution;

    @Before
    public void init() {
        solution = new SpiralMatrixII();
    }

    @Test
    public void test1() {
        int[][] expected = new int[][] { { 1, 2 }, { 4, 3 } };
        int[][] actual = solution.generateMatrix(2);
        Assert.assertArrayEquals(expected, actual);
    }
}
