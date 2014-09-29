import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetMatrixZeroesTest {
    private SetMatrixZeroes solution;

    @Before
    public void init() {
        solution = new SetMatrixZeroes();
    }

    @Test
    public void test1() {
        int[][] expected = new int[][] { new int[] { 0, 0, 0 } };
        int[][] actual = new int[][] { new int[] { 1, 0, 3 } };
        solution.setZeros(actual);
        Assert.assertArrayEquals(expected, actual);
    }
}
