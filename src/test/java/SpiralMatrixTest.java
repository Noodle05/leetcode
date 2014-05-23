import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SpiralMatrixTest {
  private SpiralMatrix solution;

  @Before
  public void init() {
    solution = new SpiralMatrix();
  }

  @Test
  public void test1() {
    int[][] matrix = { { 1, 2 } };
    ArrayList<Integer> result = solution.spiralOrder(matrix);
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2));
    assertEquals(expected, result);
  }

  @Test
  public void test2() {
    int[][] matrix = { { 1 }, { 2 } };
    ArrayList<Integer> result = solution.spiralOrder(matrix);
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2));
    assertEquals(expected, result);
  }

  @Test
  public void test3() {
    int[][] matrix = { { 1, 2 }, { 3, 4 } };
    ArrayList<Integer> result = solution.spiralOrder(matrix);
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 4, 3));
    assertEquals(expected, result);
  }

  @Test
  public void test4() {
    int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
        { 13, 14, 15, 16 } };
    ArrayList<Integer> result = solution.spiralOrder(matrix);
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8,
        12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10));
    assertEquals(expected, result);
  }
}
