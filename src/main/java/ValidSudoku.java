/**
 * <p>
 * Determine if a Sudoku is valid, according to: <a
 * href="http://sudoku.com.au/TheRules.aspx">Sudoku Puzzles - The Rules</a>.
 * </p>
 * 
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character <font color="red">'.'</font>.
 * </p>
 * 
 * <p>
 * <img src=
 * "http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png"
 * /><br />
 * A partially filled sudoku which is valid.
 * </p>
 * 
 * <p>
 * <b>Note:</b><br />
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the
 * filled cells need to be validated.
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/valid-sudoku/">Leetcode Valid
 *      Sudoku Problem</a>
 * @author Wei Gao
 *
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int row = 0;
            int col = 0;
            int sqr = 0;
            for (int j = 0; j < 9; j++) {
                int a = board[i][j] - '0';
                int b = board[j][i] - '0';
                int c = board[3 * (i % 3) + j / 3][3 * (i / 3) + j % 3] - '0';
                if (a > 0 && a < 10) {
                    if (((row >> a) & 0x01) != 0) {
                        return false;
                    } else {
                        row |= 1 << a;
                    }
                }
                if (b > 0 && b < 10) {
                    if (((col >> b) & 0x01) != 0) {
                        return false;
                    } else {
                        col |= 1 << b;
                    }
                }
                if (c > 0 && c < 10) {
                    if (((sqr >> c) & 0x01) != 0) {
                        return false;
                    } else {
                        sqr |= 1 << c;
                    }
                }
            }
        }
        return true;
    }
}
