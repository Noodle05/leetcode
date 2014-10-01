/**
 * <p>
 * You are given an <i>n</i> x <i>n</i> 2D matrix representing an image.
 * </p>
 * 
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * </p>
 * 
 * <p>
 * Follow up:<br />
 * Could you do this in-place?
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/rotate-image/">Leetcode Rotate
 *      Image Problem</a>
 * @author Wei Gao
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int h = n / 2;
        int m = n - 1;
        for (int i = 0; i < h; i++) {
            for (int j = i; j < (m - i); j++) {
                int tmp = matrix[m - j][i];
                matrix[m - j][i] = matrix[m - i][m - j];
                matrix[m - i][m - j] = matrix[j][m - i];
                matrix[j][m - i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}
