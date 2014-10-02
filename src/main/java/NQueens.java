import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * The <i>n</i>-queens puzzle is the problem of placing <i>n</i> queens on an
 * <i>n</i>×<i>n</i> chessboard such that no two queens attack each other.
 * </p>
 * 
 * <p>
 * <img src="http://www.leetcode.com/wp-content/uploads/2012/03/8-queens.png" />
 * </p>
 * 
 * <p>
 * Given an integer <i>n</i>, return all distinct solutions to the
 * <i>n</i>-queens puzzle.
 * </p>
 * 
 * <p>
 * Each solution contains a distinct board configuration of the <i>n</i>-queens'
 * placement, where <font color="red">'Q'</font> and <font
 * color="red">'.'</font> both indicate a queen and an empty space respectively.
 * </p>
 * 
 * <p>
 * For example,<br />
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * <pre>
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * </pre>
 * 
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/n-queens/">Leetcode N-Queens
 *      Problem</a>
 * @author Wei Gao
 *
 */
public class NQueens {
    public List<String[]> solveNQueens(int n) {
        int[] x = new int[n];
        List<String[]> result = new ArrayList<>();
        solveNQueens(n, 0, x, result);
        return result;
    }

    private void solveNQueens(int size, int level, int[] x,
            List<String[]> result) {
        for (int i = 0; i < size; i++) {
            if (!check(i, level, size, x)) {
                x[level] = i;
                if (level < (size - 1)) {
                    solveNQueens(size, level + 1, x, result);
                } else {
                    String[] str = new String[size];
                    for (int l = 0; l < x.length; l++) {
                        StringBuilder sb = new StringBuilder();
                        for (int k = 0; k < size; k++) {
                            if (k == x[l]) {
                                sb.append('Q');
                            } else {
                                sb.append('.');
                            }
                        }
                        str[l] = sb.toString();
                    }
                    result.add(str);
                }
            }
        }
    }

    /**
     * The key to check if two queens on same diagonal is: |x1 - x2| = |y1 - y2|
     * 
     * @param x
     * @param y
     * @param size
     * @param data
     * @return
     */
    private boolean check(int x, int y, int size, int[] data) {
        for (int i = 0; i < y; i++) {
            if ((data[i] == x || Math.abs(data[i] - x) == Math.abs(y - i))) {
                return true;
            }
        }
        return false;
    }
}
