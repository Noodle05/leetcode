/**
 * <p>Given two sparse matrices A and B, return the result of AB.</p>
 *
 * <p>You may assume that A's column number is equal to B's row number.</p>
 *
 * <p>Example:<br />
 * <pre>
 * A = [
 *   [ 1, 0, 0],
 *   [-1, 0, 3]
 * ]
 *
 * B = [
 *   [ 7, 0, 0 ],
 *   [ 0, 0, 0 ],
 *   [ 0, 0, 1 ]
 * ]
 *
 *
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                   | 0 0 1 |</pre></p>
 * ---------------------
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];

        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[0].length; j ++) {
                if (A[i][j] == 0)
                    continue;
                for(int k = 0; k < B[0].length; k ++) {
                    C[i][k] += A[i][j] * B[j][k];
                }
            }
        }

        return C;
    }
}
