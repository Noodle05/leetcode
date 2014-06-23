import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <p>
 * Given a 2D board containing <font color="red">'X'</font> and <font
 * color="red">'O'</font>, capture all regions surrounded by <font
 * color="red">'X'</font>.
 * </p>
 * 
 * <p>
 * A region is captured by flipping all <font color="red">'O'</font>s into <font
 * color="red">'X'</font>s in that surrounded region.
 * </p>
 * 
 * <p>
 * For example,
 * 
 * <pre>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * </pre>
 * 
 * After running your function, the board should be:
 * 
 * <pre>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * </pre>
 * 
 * </p>
 * 
 * @see <a href="https://oj.leetcode.com/problems/surrounded-regions/">Leetcode
 *      Surrounded Regions</a>
 * @author Wei Gao
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length <= 0) {
            return;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                bfs(board, 0, i, queue);
            }
        }
        for (int i = 0; i < col; i++) {
            if (board[row - 1][i] == 'O') {
                bfs(board, row - 1, i, queue);
            }
        }
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0, queue);
            }
        }
        for (int i = 0; i < row; i++) {
            if (board[i][col - 1] == 'O') {
                bfs(board, i, col - 1, queue);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    @SuppressWarnings("unused")
    private void dfs(char[][] board, int row, int col) {
        int N = board.length;
        int M = board[0].length;
        if (row < 0 || row >= N || col < 0 || col >= M)
            return;
        if (board[row][col] != 'O')
            return;
        board[row][col] = 'V';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }

    private void bfs(char[][] board, int i, int j, Queue<Integer> queue) {
        int col = board[0].length;

        fill(board, i, j, queue);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / col;
            int y = cur % col;

            fill(board, x - 1, y, queue);
            fill(board, x + 1, y, queue);
            fill(board, x, y - 1, queue);
            fill(board, x, y + 1, queue);
        }
    }

    private void fill(char[][] board, int i, int j, Queue<Integer> queue) {
        int row = board.length;
        int col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O') {
            return;
        }
        queue.offer(i * col + j);
        board[i][j] = 'P';
    }
}
