/**
 * Calculate Fibonacci Number
 * 
 * @author Wei Gao
 */
public class FibonacciNumber {
    public int fibonacciNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[][] m0 = { { 1, 0 }, { 0, 1 } };
        int[][] t = { { 1, 1 }, { 1, 0 } };
        int m = n - 1;
        while (m > 0) {
            if (m % 2 > 0) {
                m0 = matrixMultiple(m0, t);
            }
            m /= 2;
            t = matrixMultiple(t, t);
        }
        return m0[0][0];
    }

    private int[][] matrixMultiple(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
}
