import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/maximal-rectangle/">Leetcode
 *      Maximal Rectangle proglem</a>
 * @author Wei Gao
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int cLen = matrix[0].length; // column length
        int rLen = matrix.length; // row length
        // height array
        int[] h = new int[cLen + 1];
        h[cLen] = 0;
        int max = 0;

        for (int row = 0; row < rLen; row++) {
            Deque<Integer> s = new ArrayDeque<>();
            for (int i = 0; i < cLen + 1; i++) {
                if (i < cLen)
                    if (matrix[row][i] == '1')
                        h[i] += 1;
                    else
                        h[i] = 0;

                if (s.isEmpty() || h[s.peek()] <= h[i])
                    s.push(i);
                else {
                    while (!s.isEmpty() && h[i] < h[s.peek()]) {
                        int top = s.pop();
                        int area = h[top]
                                * (s.isEmpty() ? i : (i - s.peek() - 1));
                        if (area > max)
                            max = area;
                    }
                    s.push(i);
                }
            }
        }
        return max;
    }
}
