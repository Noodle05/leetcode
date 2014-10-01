import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RotateImageTest {
    private RotateImage solution = new RotateImage();

    @Before
    public void init() {
        solution = new RotateImage();
    }

    @Test
    public void test1() {
        int[][] expected = new int[][] { { 3, 1 }, { 4, 2 } };
        int[][] actual = new int[][] { { 1, 2 }, { 3, 4 } };
        solution.rotate(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] expected = new int[][] { { 13, 9, 5, 1 }, { 14, 10, 6, 2 },
                { 15, 11, 7, 3 }, { 16, 12, 8, 4 } };
        int[][] actual = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        solution.rotate(actual);
        Assert.assertArrayEquals(expected, actual);
    }
}
