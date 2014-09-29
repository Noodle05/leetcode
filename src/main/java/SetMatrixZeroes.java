/**
 * <p>
 * Given a <i>m</i> x <i>n</i> matrix, if an element is 0, set its entire row
 * and column to 0. Do it in place.
 * </p>
 * 
 * <p>
 * <b>Follow up:</b><br />
 * Did you use extra space?<br />
 * A straight forward solution using O(<i>m</i><i>n</i>) space is probably a bad
 * idea.<br />
 * A simple improvement uses O(<i>m</i> + <i>n</i>) space, but still not the
 * best solution.<br />
 * Could you devise a constant space solution?
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/set-matrix-zeroes/">Leetcode
 *      Set Matrix Zeroes</a>
 * @author Wei Gao
 */
public class SetMatrixZeroes {
    public void setZeros(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean rowZero = false;
        boolean colZero = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        rowZero = true;
                    }
                    if (j == 0) {
                        colZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowZero) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
