import java.util.ArrayList;

/**
 * 
 */

/**
 * @author weigao
 *
 */
public class SpiralMatrix {
  public ArrayList<Integer> spiralOrder(int[][] matrix) {
    ArrayList<Integer> result = new ArrayList<>();
    if (matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }
    int top = 0;
    int left = 0;
    int bottom = matrix.length - 1;
    int right = matrix[0].length - 1;
    // 0: left -> right, 1: top -> bottom, 2: right -> left; 3: bottom -> top
    int direction = 0;
    int xCur = left;
    int yCur = top;
    while (bottom >= top && right >= left) {
      result.add(matrix[yCur][xCur]);
      switch (direction) {
      case 0:
        if (xCur < right) {
          xCur++;
        } else {
          top++;
          yCur++;
          direction = 1;
        }
        break;
      case 1:
        if (yCur < bottom) {
          yCur++;
        } else {
          right--;
          xCur--;
          direction = 2;
        }
        break;
      case 2:
        if (xCur > left) {
          xCur--;
        } else {
          bottom--;
          yCur--;
          direction = 3;
        }
        break;
      case 3:
        if (yCur > top) {
          yCur--;
        } else {
          left++;
          xCur++;
          direction = 0;
        }
      }
    }
    return result;
  }
}