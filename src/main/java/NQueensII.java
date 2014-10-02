/**
 * <p>
 * Follow up for N-Queens problem.
 * </p>
 * 
 * <p>
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 * </p>
 * <p>
 * <img src="http://www.leetcode.com/wp-content/uploads/2012/03/8-queens.png" />
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/n-queens-ii/">Leetcode
 *      N-Queens II Problem</a>
 * @author Wei Gao
 */
public class NQueensII {
    /** 
     * backtrace program using bit-wise operation to speed up calculation.
     * 'limit' is all '1's.
     * 'h'  is the bits all the queens vertically projected on a row. If h==limit, then it's done, answer++.
     * 'r'   is the bits all the queens anti-diagonally projected on a row.
     * 'l'   is the bits all the queens diagonally projected on a row.
     * h|r|l  is all the occupied bits. Then pos = limit & (~(h|r|l)) is all the free positions.
     * p = pos & (-pos)  gives the right most '1'. pos -= p means we will place a queen on this bit 
     *                             represented by p.
     * 'h+p'  means one more queue vertically projected on next row.
     * '(r+p)<<1'  means one more queue anti-diagonally projected on next row. Because we are
     *                   moving to next row and the projection is skew from right to left, we have to 
     *                   shift left one position after moved to next row.
     * '(l+p)>>1'  means one more queue diagonally projected on next row. Because we are 
     *                  moving to next row and the projection is skew from left to right, we have to 
     *                  shift right one position after moved to next row.
     */
    public int totalNQueens(int n) {
        int limit = (1<<n) - 1;
        return dfs(0, 0, 0, 0, limit);
    }
    
    private int dfs(int h, int r, int l, int ans, int limit) {
        if (h == limit) {
            return ans + 1;
        }
        int pos = limit & (~(h|r|l));
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p;
            ans = dfs(h+p, (r+p)<<1, (l+p)>>1, ans, limit);
        }
        return ans;
    }
}
