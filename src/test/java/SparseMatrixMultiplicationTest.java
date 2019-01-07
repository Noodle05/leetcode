import org.junit.Assert;
import org.junit.Test;

public class SparseMatrixMultiplicationTest {
    private SparseMatrixMultiplication solution = new SparseMatrixMultiplication();

    @Test
    public void test1() {
        int[][] A = {{1, 0, 0}, {-1, 0, 3}};
        int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};

        int[][] expected = {{7, 0, 0}, {-7, 0, 3}};
        int[][] actual = solution.multiply(A, B);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] A = {{1, 0, 1}, {-1, 0, 3}};
        int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 2, 1}};

        int[][] expected = {{7, 2, 1}, {-7, 6, 3}};
        int[][] actual = solution.multiply(A, B);
        Assert.assertArrayEquals(expected, actual);
    }
}
