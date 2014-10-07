/**
 * <p>
 * Given an integer <i>n</i>, generate a square matrix filled with elements from
 * 1 to <i>n<sup>2</sup></i> in spiral order.
 * </p>
 * 
 * <p>
 * For example,<br />
 * Given <i>n</i> = <font color="red">3</font>,<br />
 * 
 * You should return the following matrix:
 * 
 * <pre>
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * </pre>
 * 
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/spiral-matrix-ii/">Leetcode
 *      Spiral Matrix II Problem</a>
 * @author Wei Gao
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0, top = 0, right = n - 1, bottom = n - 1;
        int x = 0, y = 0, direction = 0;
        int val = 1;
        while ((left <= right) && (top <= bottom)) {
            result[x][y] = val++;
            switch (direction) {
            case 0:
                y++;
                if (y > right) {
                    x++;
                    y--;
                    top++;
                    direction = 1;
                }
                break;
            case 1:
                x++;
                if (x > bottom) {
                    x--;
                    y--;
                    right--;
                    direction = 2;
                }
                break;
            case 2:
                y--;
                if (y < left) {
                    x--;
                    y++;
                    bottom--;
                    direction = 3;
                }
                break;
            case 3:
                x--;
                if (x < top) {
                    x++;
                    y++;
                    left++;
                    direction = 0;
                }
                break;
            }
        }
        return result;
    }
}
